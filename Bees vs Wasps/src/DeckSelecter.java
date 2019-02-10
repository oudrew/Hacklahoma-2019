import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DeckSelecter {

    private static int numSelected = 0;
    
    public static HashMap<Integer, Card> allCards;
    
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
    public static void main(String[] args) 
    {
        allCards = new HashMap<Integer, Card>();
        JFrame frame = new JFrame();
        frame.setBounds(50, 50, 1000, 1000);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.pack();
        
        Font font = new Font(Font.SERIF, Font.PLAIN, 30);
        
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
        
        JPanel cardPanel = new JPanel(new GridLayout(5, 4));
        cardPanel.setPreferredSize(new Dimension(700, 700));
        
        
        HashMap<Integer, Card> beeCards = CardList.makeBeeCards();

        
        for (int i = 0; i <= 9; i ++)
        {
            cardPanel.add(new CardPanel(beeCards.get(i)));
        }
        
        
        HashMap<Integer, Card> neutralCards = CardList.makeNeutralCards();
        
        
        for (int i = 20; i <= 29; i ++)
        {
            cardPanel.add(new CardPanel(neutralCards.get(i)));
        }
        
        
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 1));
        JButton done = new JButton("Done");
        done.setFont(font);
        done.setPreferredSize(new Dimension(100, 100));
        bottomPanel.add(done);
                        
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        JFrame frame2 = new JFrame();
        frame2.setBounds(50, 50, 1000, 1000);
        frame2.setPreferredSize(new Dimension(1000, 1000));
        frame2.getContentPane().setLayout(new BorderLayout());
        frame2.setVisible(false);
        frame2.pack();
        
        ActionListener doneListener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(false);
                for (Integer key : allCards.keySet())
                {
                    System.out.println(allCards.get(key).getName());
                }
                JPanel cardPanel2 = new JPanel(new GridLayout(2, 5));
                
                for (Integer key : allCards.keySet())
                {
                    cardPanel2.add(new CardPanel(allCards.get(key)));
                }
                
                frame2.add(cardPanel2, BorderLayout.CENTER);
                frame2.setVisible(true);
                frame2.revalidate();
              }
        };
        done.addActionListener(doneListener);
    
        
        
        
        JPanel topPanel2 = new JPanel(new GridLayout(2, 1));
        JLabel playerLabel = new JLabel("Player 1");
        playerLabel.setFont(font);
        playerLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel selectCard = new JLabel("Select a card to play");
        selectCard.setFont(font);
        selectCard.setHorizontalAlignment(JLabel.CENTER);
        topPanel2.add(playerLabel);
        topPanel2.add(selectCard);
        frame2.add(topPanel2, BorderLayout.NORTH);
        
        
    
        
    }
}
