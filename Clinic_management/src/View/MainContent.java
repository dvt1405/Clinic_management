package view;

import util.$;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class MainContent extends JPanel {
    public MainContent(){
        setSize($.pnlContentWidth, $.pnlContentHeight);
        setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        
        setLayout(new CardLayout());
    }
}
