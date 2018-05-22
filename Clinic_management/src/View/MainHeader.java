package view;

import util.$;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class MainHeader extends JPanel {
    public MainHeader(){
        setSize($.pnlHeaderWidth, $.pnlHeaderHeight);
        setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        
        setLayout(new CardLayout());
    }
}
