package view.contents;

import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Helper;
import util.$;

public class TestingDoctorMain extends JPanel {
    public TestingDoctorMain() {
        this.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        JButton btn = new JButton("Chức năng xét nghiệm");
        Helper.setBorderBtn(btn);
        btn.addActionListener((ActionEvent ae) -> {
            Helper.openLoading();
            Helper.pushCard($.pnlContent, new TestingDoctorCallFirstPatientFrm());
            Helper.closeLoading();
        });
        this.add(btn);
    }
}
