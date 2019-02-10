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
    
    public static JFrame playCardFrameP1; // So are these
    public static JFrame playCardFrameP2;
    
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
    
    public static void playCard(Card c)
    {
        System.out.println(c.getAbility());
    }
	public static void main(String args[])
	{
	    JFrame initial = new JFrame("Hive Wars.");
	    
        Font font = new Font(Font.SERIF, Font.BOLD, 30);

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
	    
	    // Mid left
	    JPanel midLeft = new JPanel();
	    midLeft.setLayout(new BorderLayout(20, 20));
	    JLabel p1 = new JLabel("Player One");
	    JButton p1_setDeck = new JButton("Set Deck");
	    JPictureBox p1_image = new JPictureBox();					// Player One Picture
	    ImageIcon Bee = new ImageIcon("Images/HoneyNut.jpg");		// Image Object
	    p1_image.setIcon(Bee);									//set JPicBox as Image
	    midLeft.add(BorderLayout.NORTH, p1);
	    midLeft.add(BorderLayout.CENTER, p1_image);
	    midLeft.add(BorderLayout.SOUTH, p1_setDeck);
	    
	    // Mid right
	    JPanel midRight = new JPanel();
	    //midRight.setLayout(new BoxLayout(midRight, BoxLayout.PAGE_AXIS));	// PAGE_AXIS is vertical 
	    midRight.setLayout(new BorderLayout(20, 20));
	    JLabel p2 = new JLabel("Player Two");
	    JButton p2_setDeck = new JButton("Set Deck");
	    JPictureBox p2_image = new JPictureBox();					// Player Two Picture
	    ImageIcon Wasp = new ImageIcon("Images/AntWasp.jpg");		// Image Object
	    p2_image.setIcon(Wasp);									//set JPicBox as Image
	    midRight.add(BorderLayout.NORTH, p2);
	    midRight.add(BorderLayout.CENTER, p2_image);
	    midRight.add(BorderLayout.SOUTH, p2_setDeck);
	    
	    //JPanel mid = new JPanel();
	    //mid.add(midLeft, BorderLayout.WEST);
	    //mid.add(midRight, BorderLayout.EAST);
	    
	    JPanel mid = new JPanel(new GridLayout(1,2));
	    mid.add(midLeft);
	    mid.add(midRight);
	    
	    // adding panels to frame
	    initial.getContentPane().add(BorderLayout.NORTH, top);
	    initial.getContentPane().add(BorderLayout.CENTER, mid);
	    //initial.getContentPane().add(BorderLayout.LINE_START, midLeft);
	    //initial.getContentPane().add(BorderLayout.LINE_END, midRight);
	    
	    
	    // default
	    initial.setVisible(true);
	    initial.pack();
        
	    //These are the hashmaps where all the possible cards are stored
	    cardsP1 = new HashMap<Integer, Card>();
	    cardsP2 = new HashMap<Integer, Card>();
	    
	    //Frame where player 1 will select their deck
        JFrame frameP1 = new JFrame();
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
                        
        frameP1.add(topPanel, BorderLayout.NORTH);
        frameP1.add(cardPanel, BorderLayout.CENTER);
        frameP1.add(bottomPanel, BorderLayout.SOUTH);
        
//=========================================================================================
        //Creates the deck choosing frame for player two
        //This frame is practically identical to the selection frame for player 1
        JFrame frameP2 = new JFrame();
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
                        
        frameP2.add(topPanelP2, BorderLayout.NORTH);
        frameP2.add(cardPanelP2, BorderLayout.CENTER);
        frameP2.add(bottomPanelP2, BorderLayout.SOUTH);
        
//=========================================================================================================
        //This is the frame where players pick which card they want to play
        playCardFrameP1 = new JFrame();
        playCardFrameP1.setBounds(50, 50, 1000, 1000);
        playCardFrameP1.setPreferredSize(new Dimension(1000, 1000));
        playCardFrameP1.getContentPane().setLayout(new BorderLayout());
        playCardFrameP1.setVisible(false);
        playCardFrameP1.pack();
        
        //This is the same frame for player 2
        playCardFrameP2 = new JFrame();
        playCardFrameP2.setBounds(50, 50, 1000, 1000);
        playCardFrameP2.setPreferredSize(new Dimension(1000, 1000));
        playCardFrameP2.getContentPane().setLayout(new BorderLayout());
        playCardFrameP2.setVisible(false);
        playCardFrameP2.pack();
        
        //This checks to see when player 1 is done choosing their deck
        ActionListener doneP1Listener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                
                JPanel playCardPanelP1 = new JPanel(new GridLayout(2, 5));
                
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
        
        
	}
}