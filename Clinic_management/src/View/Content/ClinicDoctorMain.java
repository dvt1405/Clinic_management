package View.Content;

import Utils.Helper;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ClinicDoctorMain extends JPanel {
    public ClinicDoctorMain() {
        this.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        
        Helper.setBreakCum("Main");
        Helper.pushBreakCum("Chức năng khám bệnh");
        JPanel pnlHeader = new View.BreakCums();
        
        JPanel pnlMain = new ClinicDoctorPnl1();
                
        JScrollPane pnlSclMain = new JScrollPane();
        pnlSclMain.setViewportView(pnlMain);
        
        this.setLayout(new BorderLayout());
        this.add(pnlHeader, BorderLayout.NORTH);
        this.add(pnlSclMain, BorderLayout.CENTER);
    }
}
