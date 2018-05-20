package View.Content;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountantMain extends JPanel {
    public AccountantMain() {
        this.setBorder(BorderFactory.createEmptyBorder(5,0,10,10));
        this.add(new JLabel("Accountant main"));
    }
}
