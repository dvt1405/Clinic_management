package view.contents.login;

import util.$;
import util.Helper;
import dao.UserDAO;
import entity.User;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

class VisitorLogin extends JScrollPane {
    private final JPanel pnlMain = new JPanel();
    private final JLabel lblAccount = new JLabel();
    private final JTextField tfAccount = new JTextField();
    private final JLabel lblPassword = new JLabel();
    private final JPasswordField pswField = new JPasswordField();
    private final JButton btnLogin = new JButton();
    private final JCheckBox cbxSave = new JCheckBox();
    
    boolean firstValidate(){
        return !(tfAccount.getText().equals("") || pswField.getText().equals(""));
    }
    
    private void loginEvent() throws IOException, ParseException, InterruptedException {
        if(firstValidate()){
            String account = tfAccount.getText();
            Helper.openLoading();
            User user = new UserDAO().findByAccount(account);
            if (user != null) {
                String password = pswField.getText();
                Date now = new Date();
                
                if (new UserDAO().checkLogin(account, password)) {
                    initLogin(user);
                    Helper.closeLoading();
                } else {
                    Helper.closeLoading();
                    Helper.dlgNotice("Lỗi", "Mật khẩu không chính xác!");
                }
            } else {
                Helper.closeLoading();
                Helper.dlgNotice("Lỗi", "Tên tài khoản không tồn tại!");
            }
        } else {
            Helper.dlgNotice("Lỗi", "Vui lòng nhập đầy đủ tên đăng nhâp và mật khẩu!");
        }
    }
    
    private void initLogin(User user){
        $.idUser = user.getId();
        $.typeUser = user.getPosition();
        $.main.initMain();
    }
    
    void setEvent(){
        // nhấn "ENTER" để login
        tfAccount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        loginEvent();
                    } catch (IOException | ParseException | InterruptedException ex) {
                        Logger.getLogger(VisitorLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        pswField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        loginEvent();
                    } catch (IOException | ParseException | InterruptedException ex) {
                        Logger.getLogger(VisitorLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        btnLogin.addActionListener((ActionEvent ae) -> {
            try {
                loginEvent();
            } catch (IOException | ParseException | InterruptedException ex) {
                Logger.getLogger(VisitorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    void setStyle(){
        this.setViewportView(pnlMain);
        
        lblAccount.setText("Tài Khoản:");
        lblPassword.setText("Mật Khẩu:");
        cbxSave.setText("Ghi nhớ đăng nhập");
        btnLogin.setText("Đăng Nhập");

        GroupLayout layout = new GroupLayout(pnlMain);
        pnlMain.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblAccount, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                        .addGap(70)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(tfAccount, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pswField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxSave, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addGap(50)
                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                .addGap(30)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblAccount, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAccount, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cbxSave, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                .addGap(30)
        );
    }
    
    VisitorLogin(){
        setStyle();
        setEvent();
    }
}
