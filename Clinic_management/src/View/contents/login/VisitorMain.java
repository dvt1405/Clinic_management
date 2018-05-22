package view.contents.login;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;

public class VisitorMain extends JTabbedPane {
    public VisitorMain(){
        this.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        this.addTab("Đăng Nhập", new VisitorLogin());
    }
}
