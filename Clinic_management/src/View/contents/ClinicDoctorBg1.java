package view.contents;

import util.Helper;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ClinicDoctorBg1 extends JPanel {
    public ClinicDoctorBg1() {
        this.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        
        Helper.setBreakCum("Main");
        Helper.pushBreakCum("Chức năng khám bệnh");
        JPanel pnlHeader = new view.BreakCums();
        
        JPanel pnlMain = null;
        pnlMain = new ClinicDoctorPnlPatientQueue();
        
        JScrollPane pnlSclMain = new JScrollPane();
        pnlSclMain.setViewportView(pnlMain);
        
        this.setLayout(new BorderLayout());
        this.add(pnlHeader, BorderLayout.NORTH);
        this.add(pnlSclMain, BorderLayout.CENTER);
    }
}
