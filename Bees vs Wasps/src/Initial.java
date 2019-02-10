import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Initial {
	public static void main(String args[])
	{
	    JFrame initial = new JFrame("Hive Wars.");
	    
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
        
        
	}
}
