package View.Header;

import Utils.$;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class Visitor extends JPanel {
    public Visitor(){
        setSize($.pnlHeader.getWidth(), $.pnlHeader.getHeight());
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel lblHello = new JLabel("Chào mừng đến với phòng khám HowToPASSnmcnpm.vn!");
        add(lblHello, gbc);
    }
}
