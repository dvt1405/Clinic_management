package View.Content;

import Utils.$;
import Utils.Helper;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReceptionistMain extends JPanel {
    public Receptionist recep = new Receptionist();
    public ReceptionistMain() {
        this.setBorder(BorderFactory.createEmptyBorder(5,0,10,10));
        
        JButton btn1 = new JButton("Chức năng tiếp nhận");
        Helper.setBorderBtn(btn1);
        btn1.addActionListener((ActionEvent ae) -> {
            Helper.openLoading();
            Helper.pushCard($.pnlContent, recep);
            Helper.closeLoading();
        });
        
        JButton btn2 = new JButton("Chức năng thanh toán");
        Helper.setBorderBtn(btn2);
        btn2.addActionListener((ActionEvent ae) -> {
            Helper.openLoading();
            Helper.pushCard($.pnlContent, new Receptionist_Pay());
            Helper.closeLoading();
        });
        
        this.add(btn1);
        this.add(btn2);
    }
}
