package GUI;

import util.Helper;
import util.$;
import view.MainContent;
import view.MainHeader;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.infonode.gui.laf.InfoNodeLookAndFeel;

public class Main extends JFrame {
    private final String frTitle;
    private final int frFontSize;
    
    public Main(){
        try {
            UIManager.setLookAndFeel(new InfoNodeLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace(System.out);
        }
        frTitle = "Clinic Management";
        frFontSize = 16;
        
        setStyle();
        initMain();
        setVisible(true);
    }
    
    private void setStyle(){
        Helper.setIcon(this, "logo.png");
        setBounds(($.screenSize.width - $.frWidth)/2, ($.screenSize.height - $.frHeight)/2, $.frWidth, $.frHeight);
        setFont(new Font("Verdana", Font.BOLD, frFontSize));
        setTitle(frTitle);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setDefaultLookAndFeelDecorated(true);
        
        $.pnlHeader = new MainHeader();
        $.pnlContent = new MainContent();
        add($.pnlHeader, BorderLayout.NORTH);
        add($.pnlContent, BorderLayout.CENTER);
    }
    
    public void initMain(){
        switch($.typeUser){
            case "doctor":
                Helper.setCard($.pnlContent, new view.contents.DoctorMain());
                Helper.setCard($.pnlHeader, new view.header.Member());
                break;
            case "receptionist":
                Helper.setCard($.pnlContent, new view.contents.ReceptionistMain());
                Helper.setCard($.pnlHeader, new view.header.Member());
                break;
            case "accountant":
                Helper.setCard($.pnlContent, new view.contents.AccountantMain());
                Helper.setCard($.pnlHeader, new view.header.Member());
                break;
            case "visitor": default:
                Helper.setCard($.pnlContent, new view.contents.login.VisitorMain());
                Helper.setCard($.pnlHeader, new view.header.Visitor());
                break;
        }
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            $.main = new Main();
        });
    }
}
