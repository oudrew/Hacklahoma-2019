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
        Font font = new Font(Font.SERIF, Font.BOLD, 20);
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

        
        select = new JButton("Select card");
        select.setFont(font2);
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
