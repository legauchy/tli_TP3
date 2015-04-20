package tp3_tli;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SouthPanel extends JPanel {
    
    private JLabel labelNbElement;
    
    public SouthPanel() {
        super();
        this.setLayout(new BorderLayout());
        
        this.add(createActionButton(), BorderLayout.WEST);
        
        labelNbElement = new JLabel("15 elements", JLabel.CENTER);
        this.add(labelNbElement, BorderLayout.CENTER);
        
        JTextField recherche = new JTextField(20);
        this.add(recherche, BorderLayout.EAST);
        
        this.setVisible(false);
    }

    private JPanel createActionButton() {
        JPanel panel = new JPanel();
        
        JButton plus = new JButton("+");
        JButton random = new JButton("~~>");
        JButton repeat = new JButton("o");
        
        panel.add(plus);
        panel.add(random);
        panel.add(repeat);
        
        return panel;
    }
    
}
