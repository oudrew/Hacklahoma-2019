import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
public class MainPlay {
	public static void main(String args[])
	{
		// main frame
		JFrame main = new JFrame("Hive Wars.");
	    
		// Dialog_input font is the closest font to terminal I could find
		Font customFont = new Font(Font.DIALOG_INPUT, Font.BOLD, 30);
		//Exact RGB for the 2019 Hacklahoma Green - Taken from Hacklahoma.org
		Color hackGreen = new Color(169, 217, 188);
		
	    // set the size and bounds
		main.setBounds(50, 50, 600, 600);
		main.setPreferredSize(new Dimension(1500, 1000));
	    
	    // outer border
		JPanel outer = new JPanel(new BorderLayout());
		
		// upper grid
		JPanel upper = new JPanel(new GridLayout(1, 2));
		JPanel left = new JPanel(new FlowLayout());		// panel 1, 1
		left.setBackground(hackGreen);
		JPanel right = new JPanel(new FlowLayout());	// panel 1, 2
		right.setBackground(hackGreen);
		
		JLabel p1_hive = new JLabel("Player 1 Hive: ");
		p1_hive.setFont(customFont);
		JLabel p2_hive = new JLabel("Player 2 Hive: ");
		p2_hive.setFont(customFont);
		
		// create the images for each player
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
		
		// card panel
		JPanel card = new JPanel(new FlowLayout());
		card.setBorder(BorderFactory.createLineBorder(Color.black, 15, true));
		JLabel health = new JLabel("Health");
		health.setFont(customFont);
		JLabel damage = new JLabel("Damage");
		damage.setFont(customFont);
		card.add(health);
		card.add(damage);
		
		JPanel leftEmpty = new JPanel();		// place holders
		JPanel rightEmpty = new JPanel();		// place holders
		JPanel bottomEmpty = new JPanel();
		leftEmpty.setBackground(hackGreen);
		rightEmpty.setBackground(hackGreen);
		bottomEmpty.setBackground(hackGreen);
		
		int height = leftEmpty.getHeight();		// define constant height to set custom width
		leftEmpty.setPreferredSize(new Dimension(400, height));
		rightEmpty.setPreferredSize(new Dimension(400, height));

		south.add(BorderLayout.CENTER, card);
		south.add(BorderLayout.WEST, leftEmpty);
		south.add(BorderLayout.EAST, rightEmpty);
		south.add(BorderLayout.SOUTH, bottomEmpty);
		
		main.getContentPane().add(leftPanel, BorderLayout.WEST);
		main.getContentPane().add(rightPanel, BorderLayout.EAST);
		
		
		
		// put into frame
		main.getContentPane().add(BorderLayout.PAGE_START, upper);
		main.getContentPane().add(BorderLayout.CENTER, south);
		
	    // default
		main.setVisible(true);
		main.pack();
	}
}
