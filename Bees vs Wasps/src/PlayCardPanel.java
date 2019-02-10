import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayCardPanel extends JPanel
{
    private JLabel ability;
    private JLabel name;
    private JButton select;
    private boolean isSelected;
    private Card card;
    
    public PlayCardPanel(Card c)
    {
    	// Dialog_input font is the closest font to terminal I could find
     	Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 30);
     	//Exact RGB for the 2019 Hacklahoma Green - Taken from Hacklahoma.org
     	Color hackGreen = new Color(169, 217, 188);
     	Color hackYellow = new Color(255, 213, 138);
	 	Color hackDarkGreen = new Color(0, 138, 136);
    	
        //Font font = new Font(Font.SERIF, Font.BOLD, 20);
        Font font2 = new Font(Font.SERIF, Font.PLAIN, 30);
        this.setLayout(new GridLayout(2, 1));
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        ability = new JLabel(c.getAbility());
        ability.setFont(font);
        ability.setHorizontalAlignment(JLabel.CENTER);
        ability.setVerticalAlignment(JLabel.CENTER);
        name = new JLabel(c.getName() + ",    " + c.getAffiliation());
        name.setFont(font);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(name);
        topPanel.add(ability);
        this.add(topPanel);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //top panel prefs
        topPanel.setBackground(hackGreen);
        topPanel.setFont(font);

        
        select = new JButton("Select card");
        // Select Prefs
        select.setBackground(hackDarkGreen);
        select.setForeground(hackYellow);
        select.setFocusPainted(false);
        select.setBorder(BorderFactory.createLineBorder(hackYellow, 5, true));
        select.setFont(font);
        this.add(select);
        
        ActionListener selectListener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                if (driver.p1Playing == true)
                {
                    driver.p1Playing = false;
                    driver.playCardFrameP1.setVisible(false);
                    driver.playCardFrameP2.setVisible(true);
                    driver.playCardFrameP2.revalidate();
                }
                else
                {
                    driver.p1Playing = true;
                    driver.playCardFrameP2.setVisible(false);
                    driver.playCardFrameP1.setVisible(true);
                    driver.playCardFrameP1.revalidate();
                }
                driver.playCard(c);
            }
              
        };
        select.addActionListener(selectListener);
    }
}
