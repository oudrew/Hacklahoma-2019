import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
public class MainPlay {
	public static void main(String args[])
	{
		JFrame main = new JFrame("Hive Wars.");
	    
	    // set the size and bounds
		main.setBounds(50, 50, 600, 600);
		main.setPreferredSize(new Dimension(1500, 1000));
	    
	    // outer border
		JPanel outer = new JPanel(new BorderLayout());
		
		// upper grid
		JPanel upper = new JPanel(new GridLayout(1, 2));
		JPanel left = new JPanel(new FlowLayout());		// panel 1, 1
		JPanel right = new JPanel(new FlowLayout());	// panel 1, 2
		
		JLabel p1_hive = new JLabel("Player 1 Hive: ");
		JLabel p2_hive = new JLabel("Player 2 Hive: ");
		
		JPictureBox p1_image = new JPictureBox();
		JPictureBox p2_image = new JPictureBox();
	    ImageIcon bee = new ImageIcon("Images/hacklahoma_bee.png");		// Image Object
	    ImageIcon wasp = new ImageIcon("Images/hack_wasp.png");		// Image Object
	    p1_image.setIcon(bee);
	    p2_image.setIcon(wasp);
	    
	    //add to left/right in order for flow layout
	    left.add(p1_image);
	    left.add(p1_hive);
	    right.add(p2_hive);
	    right.add(p2_image);
	    
	    // add left/right to upper in order
	    upper.add(left);
	    upper.add(right);
		
		// south border
		JPanel south = new JPanel(new BorderLayout());
	    
		/*
		 * TitledBorder title;
			title = BorderFactory.createTitledBorder("title");
			jComp8.setBorder(title);

		 */
		
		// card panel
		JPanel card = new JPanel(new FlowLayout());
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Card title");
		card.setBorder(title);
		JLabel health = new JLabel("Health");
		JLabel damage = new JLabel("Damage");
		card.add(health);
		card.add(damage);
		
		// put card into south
		south.add(BorderLayout.CENTER, card);
		
		// put into frame
		main.getContentPane().add(BorderLayout.NORTH, upper);
		main.getContentPane().add(BorderLayout.SOUTH, south);
		
	    // default
		main.setVisible(true);
		main.pack();
	}
}
