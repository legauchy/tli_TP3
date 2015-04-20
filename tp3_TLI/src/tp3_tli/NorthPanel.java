package tp3_tli;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

public class NorthPanel extends JPanel {
    private MediaFrame maframe;
    public NorthPanel(MediaFrame maframe) {
        super();
        this.maframe = maframe;
        this.setLayout(new BorderLayout());
        this.add(createCommandPanel(), BorderLayout.WEST);
        this.add(createInfoPanel(), BorderLayout.CENTER);
    }

    private JPanel createCommandPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JPanel up = new JPanel();
        JButton retour = new JButton("<<<");
        JButton play = new JButton("->");
        JButton avance = new JButton(">>>");
        up.add(retour);
        up.add(play);
        up.add(avance);

        JPanel down = new JPanel();
        JButton precedent = new JButton("|<<");
        JButton stop = new JButton("#");
        JButton suivant = new JButton(">>|");
        down.add(precedent);
        down.add(stop);
        down.add(suivant);

        panel.add(up);
        panel.add(down);

        return panel;
    }

    private JPanel createInfoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JProgressBar progress = new JProgressBar();

        JPanel south = new JPanel();
        south.setLayout(new BorderLayout());
        JSlider son = new JSlider();
        JPanel config = new JPanel();
        JButton configButton = new JButton("||");
        JButton deroule = new JButton("$$$");
        deroule.addActionListener(new NorthPanelActionListener());
        config.add(configButton);
        config.add(deroule);
        south.add(son, BorderLayout.WEST);
        south.add(config, BorderLayout.EAST);

        panel.add(progress, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);

        return panel;
    }
    
    private class NorthPanelActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(maframe.isTableIsShown()){
                maframe.cacherListeEtActions(true);
            } else {
                maframe.afficherListeEtActions(true);
            }
        }
        
    }

}
