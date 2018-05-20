package View.Content;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestingDoctorMain extends JPanel {
    public TestingDoctorMain() {
        this.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        this.add(new JLabel("Testing doctor main"));
    }
}
