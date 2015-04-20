package tp3_tli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class MediaFrame extends JFrame{
    
    private final JPanel globalPanel;
    private SouthPanel southPanel;
    private JTable table;
    private boolean tableIsShown;
    
    public MediaFrame(String title) throws HeadlessException {
        super(title);
        globalPanel = new JPanel(new BorderLayout());
        this.setContentPane(globalPanel);
        this.addComponentListener(new FrameSizeListener());
        
        this.add(new NorthPanel(this),BorderLayout.NORTH);
        southPanel = new SouthPanel();
        this.add(southPanel, BorderLayout.SOUTH);
        
        table = new JTable();
        table.setVisible(false);
        globalPanel.add(table, BorderLayout.CENTER);
        
        this.setMinimumSize(new Dimension(700, 70));
        this.pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public boolean isTableIsShown() {
        return tableIsShown;
    }    
    
    public void afficherListeEtActions(boolean buttonaction) {
        tableIsShown = true;
        this.southPanel.setVisible(true);
        this.table.setVisible(true);
        if(buttonaction) {
            this.setSize(getWidth(), 500);
        }
    }
    
    public void cacherListeEtActions(boolean buttonaction) {
        tableIsShown = false;
        this.southPanel.setVisible(false);
        this.table.setVisible(false);
        if(buttonaction) {
            this.setSize(getWidth(), 70);
        }
    }
    
    
    private class FrameSizeListener extends ComponentAdapter {

        @Override
        public void componentResized(ComponentEvent e) {
            if(getHeight() > 150) {
                afficherListeEtActions(false);
            }
            
            if(getHeight() < 150) {
                cacherListeEtActions(false);
            }
        }
        
    } 
}
