import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardPanel extends JPanel
{
    private JLabel ability;
    private JLabel name;
    private JButton select;
    private boolean isSelected;
    private Card card;
    
    public CardPanel(Card c)
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
        
        topPanel.setBackground(hackGreen);
        
        // JButton formatting
        select = new JButton("Select card");
        select.setBackground(hackDarkGreen);
        select.setForeground(hackYellow);
        select.setFocusPainted(false);
        select.setBorder(BorderFactory.createLineBorder(hackYellow, 5, true));
        select.setFont(font);
        
        
        this.add(select);
        
        ActionListener selectListener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                
                if (driver.getSelected() == 10)
                {
                    return;
                }
                
                JButton source = (JButton) evt.getSource();
                Color color = getBackground();
                color = Color.RED;
                source.setBackground(color);
                driver.increaseSelected();
                if (driver.isP1 == true)
                {
                    driver.cardsP1.put(c.getID(), c);
                }
                else
                {
                    driver.cardsP2.put(c.getID(), c);
                }
                repaint();
              }
              
        };
        select.addActionListener(selectListener);
    }
}
