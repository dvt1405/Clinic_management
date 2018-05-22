package view.contents;

import util.Helper;
import entity.Patient;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ClinicDoctorBg2 extends JPanel {
    public ClinicDoctorBg2(Patient patient, int roomId) {
        this.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        
        Helper.pushBreakCum("Hồ sơ bệnh nhân");
        JPanel pnlHeader = new view.BreakCums();
        JPanel pnlMain = new ClinicDoctorPnlPatientProfile(patient, roomId);
        
        JScrollPane pnlSclMain = new JScrollPane();
        pnlSclMain.setViewportView(pnlMain);
        
        this.setLayout(new BorderLayout());
        this.add(pnlHeader, BorderLayout.NORTH);
        this.add(pnlSclMain, BorderLayout.CENTER);
    }
}
