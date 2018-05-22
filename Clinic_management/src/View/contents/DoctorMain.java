package view.contents;

import util.$;
import util.Helper;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DoctorMain extends JPanel {

    public DoctorMain() {
        this.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 10));

        JButton btn1 = new JButton("Chức năng khám bệnh");
        Helper.setBorderBtn(btn1);
        btn1.addActionListener((ActionEvent ae) -> {
            Helper.openLoading();
            Helper.pushCard($.pnlContent, new ClinicDoctorBg1());
            Helper.closeLoading();
        });

        JButton btn2 = new JButton("Chức năng xét nghiệm");
        Helper.setBorderBtn(btn2);
        btn2.addActionListener((ActionEvent ae) -> {
            Helper.openLoading();
            Helper.pushCard($.pnlContent, new TestingDoctorCallFirstPatientFrm());
            Helper.closeLoading();
        });

        this.add(btn1);
        this.add(btn2);
    }
}
