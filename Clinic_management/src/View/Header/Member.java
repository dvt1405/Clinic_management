package View.Header;

import Utils.$;
import Utils.Helper;
import dao.UserDAO;
import entity.User;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class Member extends JPanel {
    private final User user = (User) new UserDAO().findById($.idUser);
    private final JLabel lblHello = new JLabel();
    private final JLabel lblNotice = new JLabel();
    private final JButton btnLogout = new JButton();

    private void setEvent(){
        btnLogout.addActionListener((ActionEvent ae) -> {
            new UserDAO().logout();
        });
    }
    
    public Member(){
        setSize($.pnlHeader.getWidth(), $.pnlHeader.getHeight());
        setBackground(Color.LIGHT_GRAY);
        
        lblHello.setText("Chào "+ user.getFullName());
        btnLogout.setText("Đăng xuất");
        Helper.setBorderBtn(btnLogout);
        
        setEvent();
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHello)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogout)))
                .addContainerGap()
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(lblHello)))
                    .addComponent(btnLogout))
                .addContainerGap()
        );
    }
}
