package view.contents;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AccountantMain extends JPanel {
    public AccountantMain() {
        
        this.setBorder(BorderFactory.createEmptyBorder(5,0,10,10));
        JPanel pnlMain = new AccountantPnl();
        
        JScrollPane  sclMain = new JScrollPane();
        sclMain.setViewportView(pnlMain);
        this.setLayout(new BorderLayout());
//        this.add(pnlHeader,BorderLayout.NORTH);
        this.add(pnlMain,BorderLayout.CENTER);
        
        
        
    }
}
