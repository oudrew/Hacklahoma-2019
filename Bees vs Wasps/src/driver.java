import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class driver 
{
    private static int numSelected = 0;

    public static HashMap<Integer, Card> cardsP1;
    public static HashMap<Integer, Card> cardsP2;

    public static boolean isP1 = true; //these are used by CardPanel and PlayCardPanel
    public static boolean p1Playing = true;
    public static boolean p1Turn = true;
    public static boolean hasPoison = false;

    public static JFrame playCardFrameP1; // So are these
    public static JFrame playCardFrameP2;
    public static JFrame main;
    public static JFrame beesWin;
    public static JFrame waspsWin;
    /*
    public static JLabel beeHealth;
    public static JLabel waspHealth;
    public static JPanel beeHPPanel;
    public static JPanel waspHPPanel;
    */
    public static JPanel leftPanel;
    public static JPanel rightPanel;
    public static JPanel playCardPanelP1;
    public static Font customFont = new Font(Font.DIALOG_INPUT, Font.BOLD, 30);


    public static int beeHP = 20;
    public static int waspHP = 20;

    public static void increaseSelected()
    {
        numSelected ++;
    }

    public static int getSelected()
    {
        return numSelected;
    }

    public static void setSelected()
    {
        numSelected = 0;
    }


    public static void main(String args[])
    {
        JFrame initial = new JFrame("Hive Wars.");
        
        ImageIcon icon = new ImageIcon("Images/Icon.png");
        
        initial.setIconImage(icon.getImage());

        //Font font = new Font(Font.SERIF, Font.BOLD, 30);
        
        // Dialog_input font is the closest font to terminal I could find
     	Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 30);
     	//Exact RGB for the 2019 Hacklahoma Green - Taken from Hacklahoma.org
     	Color hackGreen = new Color(169, 217, 188);
     	Color hackYellow = new Color(255, 213, 138);
	 	Color hackDarkGreen = new Color(0, 138, 136);

        // set the size and bounds
        initial.setBounds(50, 50, 600, 600);
        initial.setPreferredSize(new Dimension(1000, 1000));

        // default close
        initial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set layout
        initial.getContentPane().setLayout(new BorderLayout());

        // top
        JPanel top = new JPanel();
        JLabel title = new JLabel("Hive Wars.");
        title.setFont(font);
        top.add(title);
        top.setBackground(hackGreen);

        // Mid left
        JPanel midLeft = new JPanel();
        midLeft.setBackground(hackGreen);
        midLeft.setLayout(new BorderLayout(20, 20));
        JLabel p1 = new JLabel("Player One");
        p1.setFont(font);
        JButton p1_setDeck = new JButton("Set Deck");
        JLabel p1_image = new JLabel();
        //JPictureBox p1_image = new JPictureBox();					// Player One Picture
        ImageIcon Bee = new ImageIcon("Images/HoneyNut.jpg");		// Image Object
        p1_image.setIcon(Bee);									//set JPicBox as Image
        midLeft.add(BorderLayout.NORTH, p1);
        midLeft.add(BorderLayout.CENTER, p1_image);
        midLeft.add(BorderLayout.SOUTH, p1_setDeck);
        
        // JButton formatting
        p1_setDeck.setBackground(hackDarkGreen);
        p1_setDeck.setForeground(hackYellow);
        p1_setDeck.setFocusPainted(false);
        p1_setDeck.setBorder(BorderFactory.createLineBorder(hackYellow, 5, true));
        p1_setDeck.setFont(font);
        

        // Mid right
        JPanel midRight = new JPanel();
        midRight.setBackground(hackGreen);
        midRight.setLayout(new BorderLayout(20, 20));
        JLabel p2 = new JLabel("Player Two");
        p2.setFont(font);
        JButton p2_setDeck = new JButton("Set Deck");
        JPictureBox p2_image = new JPictureBox();					// Player Two Picture
        ImageIcon Wasp = new ImageIcon("Images/AntWasp.jpg");		// Image Object
        p2_image.setIcon(Wasp);									//set JPicBox as Image
        midRight.add(BorderLayout.NORTH, p2);
        midRight.add(BorderLayout.CENTER, p2_image);
        midRight.add(BorderLayout.SOUTH, p2_setDeck);
        
        // JButton formatting
        p2_setDeck.setBackground(hackDarkGreen);
        p2_setDeck.setForeground(hackYellow);
        p2_setDeck.setFocusPainted(false);
        p2_setDeck.setBorder(BorderFactory.createLineBorder(hackYellow, 5, true));
        p2_setDeck.setFont(font);

        JPanel mid = new JPanel(new GridLayout(1,2));
        mid.add(midLeft);
        mid.add(midRight);

        // adding panels to frame
        initial.getContentPane().add(BorderLayout.NORTH, top);
        initial.getContentPane().add(BorderLayout.CENTER, mid);

        // default
        initial.setVisible(true);
        initial.pack();
        
        /*
         * --------------------------------------------------------------------------------------------------
         * Deck Selector
         * 
         * Player 1
         * --------------------------------------------------------------------------------------------------
         */

        //These are the hashmaps where all the possible cards are stored
        cardsP1 = new HashMap<Integer, Card>();
        cardsP2 = new HashMap<Integer, Card>();

        //Frame where player 1 will select their deck
        JFrame frameP1 = new JFrame();
        
        frameP1.setIconImage(icon.getImage());
        
        frameP1.setBounds(50, 50, 1000, 1000);
        frameP1.setPreferredSize(new Dimension(1000, 1000));
        frameP1.getContentPane().setLayout(new BorderLayout());
        frameP1.setVisible(false);
        frameP1.pack();

        ActionListener setDeckP1Listener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                initial.setVisible(false);
                frameP1.setVisible(true);
            }
        };
        p1_setDeck.addActionListener(setDeckP1Listener);

        //Holds the player name 
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBackground(hackGreen);

        JPanel beesAndNumber = new JPanel(new FlowLayout());
        JLabel playerBees = new JLabel("Bees");
        playerBees.setFont(font);
        playerBees.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(playerBees);

        JLabel selectText = new JLabel("Please select 10 cards");
        selectText.setFont(font);
        selectText.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(selectText);

        //Holds the actual CardPanels
        JPanel cardPanel = new JPanel(new GridLayout(5, 4));
        cardPanel.setPreferredSize(new Dimension(700, 700));
        cardPanel.setBackground(hackGreen);

        //Generates the bee cards from CardList
        HashMap<Integer, Card> beeCards = CardList.makeBeeCards();

        //Populates cardPanel with the bee cards
        for (int i = 0; i <= 9; i ++)
        {
            cardPanel.add(new CardPanel(beeCards.get(i)));
        }

        //Generates neutral cards
        HashMap<Integer, Card> neutralCards = CardList.makeNeutralCards();

        //Populates cardPanel with neutral cards
        for (int i = 20; i <= 29; i ++)
        {
            cardPanel.add(new CardPanel(neutralCards.get(i)));
        }


        //Creates the done button 
        JPanel bottomPanel = new JPanel(new GridLayout(1, 1));
        JButton done = new JButton("Done");
        done.setFont(font);
        done.setPreferredSize(new Dimension(100, 100));
        bottomPanel.add(done);
        // Done button prefs
        done.setBackground(hackDarkGreen);
        done.setForeground(hackYellow);
        done.setFocusPainted(false);
        done.setBorder(BorderFactory.createLineBorder(hackYellow, 5, true));
        done.setFont(font);

        frameP1.add(topPanel, BorderLayout.NORTH);
        frameP1.add(cardPanel, BorderLayout.CENTER);
        frameP1.add(bottomPanel, BorderLayout.SOUTH);

        /*
         * --------------------------------------------------------------------------------------------------
         * Deck Selector
         * 
         * Creates the deck choosing frame for player two
         * This frame is practically identical to the selection frame for player 1
         * --------------------------------------------------------------------------------------------------
         */
        
        JFrame frameP2 = new JFrame();
        frameP2.setIconImage(icon.getImage());
        frameP2.setBounds(50, 50, 1000, 1000);
        frameP2.setPreferredSize(new Dimension(1000, 1000));
        frameP2.getContentPane().setLayout(new BorderLayout());
        frameP2.setVisible(false);
        frameP2.pack();

        ActionListener setDeckP2Listener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                initial.setVisible(false);
                frameP2.setVisible(true);
                isP1 = false;
            }
        };
        p2_setDeck.addActionListener(setDeckP2Listener);

        JPanel topPanelP2 = new JPanel(new GridLayout(2, 1));
        topPanelP2.setBackground(hackGreen);

        JPanel beesAndNumberP2 = new JPanel(new FlowLayout());
        JLabel playerBeesP2 = new JLabel("Wasps");
        playerBeesP2.setFont(font);
        playerBeesP2.setHorizontalAlignment(JLabel.CENTER);
        topPanelP2.add(playerBeesP2);

        JLabel selectTextP2 = new JLabel("Please select 10 cards");
        selectTextP2.setFont(font);
        selectTextP2.setHorizontalAlignment(JLabel.CENTER);
        topPanelP2.add(selectTextP2);

        JPanel cardPanelP2 = new JPanel(new GridLayout(5, 4));
        cardPanelP2.setPreferredSize(new Dimension(700, 700));

        //Generates the cards and populates cardPanelP2
        HashMap<Integer, Card> waspCards = CardList.makeWaspCards();


        for (int i = 10; i <= 19; i ++)
        {
            cardPanelP2.add(new CardPanel(waspCards.get(i)));
        }


        HashMap<Integer, Card> neutralCardsP2 = CardList.makeNeutralCards();


        for (int i = 20; i <= 29; i ++)
        {
            cardPanelP2.add(new CardPanel(neutralCards.get(i)));
        }



        JPanel bottomPanelP2 = new JPanel(new GridLayout(1, 1));
        JButton doneP2 = new JButton("Done");
        doneP2.setFont(font);
        doneP2.setPreferredSize(new Dimension(100, 100));
        bottomPanelP2.add(doneP2);
        
        //Donep2 prefs
        doneP2.setBackground(hackDarkGreen);
        doneP2.setForeground(hackYellow);
        doneP2.setFocusPainted(false);
        doneP2.setBorder(BorderFactory.createLineBorder(hackYellow, 5, true));
        doneP2.setFont(font);

        frameP2.add(topPanelP2, BorderLayout.NORTH);
        frameP2.add(cardPanelP2, BorderLayout.CENTER);
        frameP2.add(bottomPanelP2, BorderLayout.SOUTH);

        /*
         * --------------------------------------------------------------------------------------------------
         * This is the frame where players pick which card they want to play
         * 
         * --------------------------------------------------------------------------------------------------
         */
        playCardFrameP1 = new JFrame();
        playCardFrameP1.setIconImage(icon.getImage());
        playCardFrameP1.setBounds(50, 50, 1000, 1000);
        playCardFrameP1.setPreferredSize(new Dimension(1000, 1000));
        playCardFrameP1.getContentPane().setLayout(new BorderLayout());
        playCardFrameP1.setVisible(false);
        playCardFrameP1.pack();

        /*
         * --------------------------------------------------------------------------------------------------
         * This is the same frame for player 2
         * 
         * --------------------------------------------------------------------------------------------------
         */
        playCardFrameP2 = new JFrame();
        playCardFrameP2.setIconImage(icon.getImage());
        playCardFrameP2.setBounds(50, 50, 1000, 1000);
        playCardFrameP2.setPreferredSize(new Dimension(1000, 1000));
        playCardFrameP2.getContentPane().setLayout(new BorderLayout());
        playCardFrameP2.setVisible(false);
        playCardFrameP2.pack();

        main = new JFrame("Hive Wars.");

        // Dialog_input font is the closest font to terminal I could find
        //Exact RGB for the 2019 Hacklahoma Green - Taken from Hacklahoma.org
        

        // set the size and bounds
        main.setBounds(50, 50, 600, 600);
        main.setPreferredSize(new Dimension(1500, 1000));

        // outer border
        JPanel outer = new JPanel(new BorderLayout());

        // upper grid
        JPanel upper = new JPanel(new GridLayout(1, 2));
        JPanel left = new JPanel(new FlowLayout());     // panel 1, 1
        left.setBackground(hackGreen);
        JPanel right = new JPanel(new FlowLayout());    // panel 1, 2
        right.setBackground(hackGreen);

        JLabel p1_hive = new JLabel("Player 1 Hive: ");
        p1_hive.setFont(customFont);
        JLabel p2_hive = new JLabel("Player 2 Hive: ");
        p2_hive.setFont(customFont);

        // create the images for each player
        //JPictureBox p1_image2 = new JPictureBox();
        //JPictureBox p2_image2 = new JPictureBox();
        JLabel p1_image2 = new JLabel();
        JLabel p2_image2 = new JLabel();
        ImageIcon bee = new ImageIcon("Images/hacklahoma_bee.png");     // Image Object
        ImageIcon wasp = new ImageIcon("Images/Wasp_Small.png");     // Image Object
        p1_image2.setIcon(bee);
        p2_image2.setIcon(wasp);

        /*
        beeHPPanel = new JPanel(new FlowLayout());
        beeHealth = new JLabel(Integer.toString(beeHP));
        beeHealth.setFont(customFont);
        beeHPPanel.add(beeHealth);
        waspHPPanel = new JPanel(new FlowLayout());
        waspHealth = new JLabel(Integer.toString(waspHP));
        waspHealth.setFont(customFont);
        waspHPPanel.add(waspHealth);
        */
        //add to left/right in order for flow layout
        left.add(p1_image2);
        left.add(p1_hive);
        //left.add(beeHPPanel);
        right.add(p2_hive);
        right.add(p2_image2);
        right.setPreferredSize(new Dimension(50, 50));
       // right.add(waspHPPanel);

        // add left/right to upper in order
        upper.add(left);
        upper.add(right);

        // south border
        JPanel south = new JPanel(new BorderLayout());

        // card panel
        JPanel card = new JPanel(new FlowLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.black, 15, true));
        JLabel health = new JLabel("Health");
        health.setFont(customFont);
        JLabel damage = new JLabel("Damage");
        damage.setFont(customFont);
        card.add(health);
        card.add(damage);

        //JPanel leftEmpty = new JPanel();        // place holders
        //JPanel rightEmpty = new JPanel();       // place holders
        JPanel bottomEmpty = new JPanel();
        //leftEmpty.setBackground(hackGreen);
        //rightEmpty.setBackground(hackGreen);
        bottomEmpty.setBackground(hackGreen);

        //int height = leftEmpty.getHeight();     // define constant height to set custom width
        //leftEmpty.setPreferredSize(new Dimension(400, height));
        //rightEmpty.setPreferredSize(new Dimension(400, height));

        south.add(BorderLayout.CENTER, card);
        //south.add(BorderLayout.WEST, leftEmpty);
        //south.add(BorderLayout.EAST, rightEmpty);
        south.add(BorderLayout.SOUTH, bottomEmpty);

        leftPanel = new JPanel(new GridLayout(1, 1));
        // test reformat of left panel
        int height = leftPanel.getHeight();
        leftPanel.setPreferredSize(new Dimension(400, height));
        leftPanel.setBackground(hackGreen);
        //
        JLabel hive1 = new JLabel("Hive: ");
        hive1.setFont(font);
        JLabel hp1 = new JLabel("20");
        hp1.setFont(font);
        hp1.setFont(customFont);
        hp1.setHorizontalAlignment(JLabel.CENTER);
        hp1.setVerticalAlignment(JLabel.CENTER);
        leftPanel.add(hive1);
        leftPanel.add(hp1);
        
        rightPanel = new JPanel(new GridLayout(1, 1));
        //
        rightPanel.setPreferredSize(new Dimension(400, height));
        rightPanel.setBackground(hackGreen);
        //
        JLabel hive2 = new JLabel("Hive: ");
        hive2.setFont(font);
        JLabel hp2 = new JLabel("20");
        hp2.setFont(font);
        hp2.setFont(customFont);
        hp2.setHorizontalAlignment(JLabel.CENTER);
        hp2.setVerticalAlignment(JLabel.CENTER);
        rightPanel.add(hive2);
        rightPanel.add(hp2);


        // put into frame
        main.getContentPane().add(BorderLayout.PAGE_START, upper);
        main.getContentPane().add(BorderLayout.CENTER, south);
        main.getContentPane().add(BorderLayout.WEST, leftPanel);
        main.getContentPane().add(BorderLayout.EAST, rightPanel);

        // default
        main.setVisible(false);
        main.pack();

        //This checks to see when player 1 is done choosing their deck
        ActionListener doneP1Listener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {

                playCardPanelP1 = new JPanel(new GridLayout(2, 5));

                //For every card in their deck, add a PlayCardPanel to playCardPanelP1
                for (Integer key : cardsP1.keySet())
                {
                    playCardPanelP1.add(new PlayCardPanel(cardsP1.get(key)));
                }

                playCardFrameP1.add(playCardPanelP1, BorderLayout.CENTER);
                //Makes the deck selection frame invisible
                frameP1.setVisible(false);
                //Brings the initial page back up
                initial.setVisible(true);
                //sets the value of numSelected to 0
                setSelected();
            }
        };
        done.addActionListener(doneP1Listener);

        //Very similar to the last action listener, except it makes the first card selection frame visible
        ActionListener doneP2Listener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                frameP2.setVisible(false);
                for (Integer key : cardsP2.keySet())
                {
                    System.out.println(cardsP2.get(key).getName());
                }
                JPanel cardPanelP2 = new JPanel(new GridLayout(2, 5));

                for (Integer key : cardsP2.keySet())
                {
                    cardPanelP2.add(new PlayCardPanel(cardsP2.get(key)));
                }

                playCardFrameP2.add(cardPanelP2, BorderLayout.CENTER);
                main.setVisible(true);
                //This is the frame where player 1 will pick their first card
                playCardFrameP1.setVisible(true);
                playCardFrameP1.revalidate();

            }
        };

        doneP2.addActionListener(doneP2Listener);

        //Creates the frame where player 1 picks which card to play
        JPanel topPanel2 = new JPanel(new GridLayout(2, 1));
        JLabel playerLabel = new JLabel("Player 1");
        playerLabel.setFont(font);
        playerLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel selectCard = new JLabel("Select a card to play");
        selectCard.setFont(font);
        selectCard.setHorizontalAlignment(JLabel.CENTER);
        topPanel2.add(playerLabel);
        topPanel2.add(selectCard);
        playCardFrameP1.add(topPanel2, BorderLayout.NORTH);
        //pref
        topPanel2.setBackground(hackGreen);

        //Creates the same frame for player 2
        JPanel topPanel2P2 = new JPanel(new GridLayout(2, 1));
        JLabel playerLabelP2 = new JLabel("Player 2");
        playerLabelP2.setFont(font);
        playerLabelP2.setHorizontalAlignment(JLabel.CENTER);
        JLabel selectCardP2 = new JLabel("Select a card to play");
        selectCardP2.setFont(font);
        selectCardP2.setHorizontalAlignment(JLabel.CENTER);
        topPanel2P2.add(playerLabelP2);
        topPanel2P2.add(selectCardP2);
        playCardFrameP2.add(topPanel2P2, BorderLayout.NORTH);
        //pref
        topPanel2P2.setBackground(hackGreen);
        
        beesWin = new JFrame();
        beesWin.setBounds(50, 50, 1000, 1000);
        beesWin.setPreferredSize(new Dimension(1300, 1300));
        beesWin.getContentPane().setLayout(new GridLayout(1, 1));
        beesWin.setVisible(false);
        beesWin.pack();
        
        Font winFont = new Font(Font.SERIF, Font.BOLD, 50);
        JLabel beeWinText = new JLabel("Bees Win!");
        JLabel lineBee = new JLabel();
        ImageIcon lineBee_Image = new ImageIcon("Images/BeeWline.png");
        lineBee.setIcon(lineBee_Image);
        beeWinText.setFont(winFont);
        beeWinText.setHorizontalAlignment(JLabel.CENTER);
        beeWinText.setVerticalAlignment(JLabel.CENTER);
        JPanel beePanel = new JPanel(new GridLayout(2, 1));
        beePanel.add(lineBee);
        beePanel.add(beeWinText);
        beePanel.setBackground(hackGreen);
        beesWin.add(beePanel);
        beesWin.setIconImage(icon.getImage());
        
        waspsWin = new JFrame();
        waspsWin.setIconImage(icon.getImage());
        waspsWin.setBounds(50, 50, 1000, 1000);
        waspsWin.setPreferredSize(new Dimension(1300, 1500));
        waspsWin.getContentPane().setLayout(new GridLayout(1, 1));
        waspsWin.setVisible(false);
        waspsWin.pack();
        
        JLabel waspWinText = new JLabel("Wasps Win!");
        waspWinText.setFont(winFont);
        waspWinText.setHorizontalAlignment(JLabel.CENTER);
        waspWinText.setVerticalAlignment(JLabel.CENTER);
        JPanel waspPanel = new JPanel(new GridLayout(2, 1));
        JLabel hiveFire = new JLabel();
        ImageIcon hivefire_image = new ImageIcon("Images/HiveFireSmall.png");
        hiveFire.setIcon(hivefire_image);
        waspPanel.add(hiveFire);
        JPanel waspPanel = new JPanel(new GridLayout(1, 1));
        waspPanel.add(waspWinText);
        waspPanel.setBackground(hackGreen);
        waspsWin.add(waspPanel);
        

    }


    public static void playCard(Card c)
    {
    	int beeBuffID = 1;
      
     	Color hackGreen = new Color(169, 217, 188);
    	
      
      System.out.println(c.getAbility());
        if (p1Turn == true)
        {
        	if (hasPoison) {
        		beeHP = beeHP - (c.getDamage() * beeBuffID);
        		beeHP = beeHP + (c.getHealing() * beeBuffID);
        		hasPoison = false;
        		beeBuffID = 1;
        	}
        	
        	else {
        		waspHP = waspHP - (c.getDamage() * beeBuffID);
        		beeHP = beeHP + (c.getHealing() * beeBuffID);
        		beeBuffID = 1;
        	}
        	
        	if ((c.getID() == 6)||(c.getID() == 26)) {
        		beeBuffID = 2;
        	}
        	
            p1Turn = false;
            if (c.getAffiliation() == "Bee")
            {
                cardsP1.remove(c.getID());
                playCardFrameP1.remove(playCardPanelP1);
                playCardPanelP1 = new JPanel(new GridLayout(2, 5));

                //For every card in their deck, add a PlayCardPanel to playCardPanelP1
                for (Integer key : cardsP1.keySet())
                {
                    playCardPanelP1.add(new PlayCardPanel(cardsP1.get(key)));
                }

                playCardFrameP1.add(playCardPanelP1, BorderLayout.CENTER);
                playCardFrameP1.revalidate();
                playCardFrameP1.repaint();
            }
            if (waspHP <= 0)
            {
                beesWin.setVisible(true);
                main.setVisible(false);
                playCardFrameP1.setVisible(false);
                playCardFrameP2.setVisible(false);
            }
            if (beeHP <= 0)
            {
                waspsWin.setVisible(true);
                main.setVisible(false);
                playCardFrameP1.setVisible(false);
                playCardFrameP2.setVisible(false);
            }
            
        }
        else
        {
            beeHP = beeHP - c.getDamage();
            waspHP = waspHP + c.getHealing();
            
            
            if ((c.getModifier() != 0) && (c.getModifier() != 2)) {
            	c.setDamage(c.getDamage() + c.getModifier());
            }
            
            if (c.getModifier() == 2) {
            	c.setDamage(c.getDamage() * 2);
            }
            
            int buffID = 0;
            
            switch (c.getID()) {
		
			case 18:
				buffID = 18;
				break;
				
			case 19:
				buffID = 19;
				break;

			default:
				buffID = 0;
				break;
			}
            
            if (buffID != 0) {
            	if (buffID == 18) {
            		beeHP = beeHP/2;
            	}
            	
            	if (buffID == 19) {
            		hasPoison = true;
            	}
            }
            
            if (c.getID() == 11) {
            	if (c.getDamage() > 10) {
            		c.setDamage(10);
            		c.setModifier(0);
            	}
            }
            
            p1Turn = true;
            if (waspHP <= 0)
            {
                beesWin.setVisible(true);
                main.setVisible(false);
                playCardFrameP1.setVisible(false);
                playCardFrameP2.setVisible(false);
            }
            if (beeHP <= 0)
            {
                waspsWin.setVisible(true);
                main.setVisible(false);
                playCardFrameP1.setVisible(false);
                playCardFrameP2.setVisible(false);
            }
        }
        main.remove(leftPanel);
        main.remove(rightPanel);
        leftPanel = new JPanel(new GridLayout(1, 1));
        rightPanel = new JPanel(new GridLayout(1, 1));
        
        //
        int height = leftPanel.getHeight();
        leftPanel.setPreferredSize(new Dimension(400, height));
        leftPanel.setBackground(hackGreen);
        JLabel hp1 = new JLabel(Integer.toString(beeHP));
        hp1.setFont(customFont);
        hp1.setHorizontalAlignment(JLabel.CENTER);
        hp1.setVerticalAlignment(JLabel.CENTER);
        leftPanel.add(hp1);
        JLabel hp2 = new JLabel(Integer.toString(waspHP));
        hp2.setFont(customFont);
        hp2.setHorizontalAlignment(JLabel.CENTER);
        hp2.setVerticalAlignment(JLabel.CENTER);
        rightPanel.add(hp2);
        
        rightPanel.setPreferredSize(new Dimension(400, height));
        rightPanel.setBackground(hackGreen);
        
        main.getContentPane().add(leftPanel, BorderLayout.WEST);
        main.getContentPane().add(rightPanel, BorderLayout.EAST);
        
        main.revalidate();
        main.repaint();
    }

}