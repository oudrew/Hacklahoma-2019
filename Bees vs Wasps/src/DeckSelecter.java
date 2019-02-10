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
        
        JPanel cardPanel = new JPanel(new GridLayout(10, 3));
        cardPanel.setPreferredSize(new Dimension(700, 700));
        
        
        HashMap<Integer, Card> beeCards = CardList.makeBeeCards();
        for (int i = 0; i < beeCards.size(); i ++)
        {
            cardPanel.add(new CardPanel(beeCards.get(i)));
        }
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 1));
        JButton done = new JButton("Done");
        done.setFont(font);
        done.setPreferredSize(new Dimension(100, 100));
        bottomPanel.add(done);
                        
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        ActionListener doneListener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(false);
              }
              
        };
        done.addActionListener(doneListener);
    }

}
