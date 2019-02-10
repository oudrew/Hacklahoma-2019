import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardPanel extends JPanel
{
    private JLabel ability;
    private JButton select;
    private boolean isSelected;
    
    public CardPanel(String s)
    {
        isSelected = false;
        Font font = new Font(Font.SERIF, Font.BOLD, 40);
        Font font2 = new Font(Font.SERIF, Font.PLAIN, 30);
        this.setLayout(new GridLayout(2, 1));
        ability = new JLabel(s);
        ability.setFont(font);
        ability.setHorizontalAlignment(JLabel.CENTER);
        ability.setVerticalAlignment(JLabel.CENTER);
        this.add(ability);
        
        select = new JButton("Select card");
        select.setFont(font2);
        this.add(select);
        
        ActionListener selectListener = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                if (DeckSelecter.getSelected() == 10)
                {
                    return;
                }
                Object source = evt.getSource();
                Color color = getBackground();
                color = Color.RED;
                setBackground(color);
                DeckSelecter.increaseSelected();
                repaint();
              }
              
        };
        select.addActionListener(selectListener);
    }
}
