import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class driver {
	public static void main(String args[])
	{
	    JFrame frame = new JFrame();
        frame.setBounds(50, 50, 600, 600);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.pack();
        
        //making a change
	}
}
