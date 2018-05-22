package util;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import repository.IDB;
import repository.MysqlDBDeploy;

public class Helper {
    public static void setCursorBtn(JButton btn){
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
    public static void setBorderBtn(JButton btn){
        setCursorBtn(btn);
        
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(9,9,9,9)));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                        BorderFactory.createLineBorder(Color.GRAY, 1)),
                    BorderFactory.createEmptyBorder(8,8,8,8)));
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.GRAY, 1),
                    BorderFactory.createEmptyBorder(9,9,9,9)));
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
    public static void setBorderSelectedBtn(JButton btn){
        List<JButton> listBtns = new LinkedList();
        listBtns.add(btn);
        setBorderBtn(listBtns, btn);
    }
    public static void setBorderBtn(List<JButton> listBtns, JButton btn){
        Color colorSelecting = new Color(70,60,70);
        
        for(JButton b : listBtns){
            b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(9,9,9,9)));

            b.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    b.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                            BorderFactory.createLineBorder(Color.GRAY, 1)),
                        BorderFactory.createEmptyBorder(8,8,8,8)));
                    b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });

            b.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    b.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 1),
                        BorderFactory.createEmptyBorder(9,9,9,9)));
                    b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
        }
        
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(colorSelecting, 2),
            BorderFactory.createEmptyBorder(8,8,8,8)));
        
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(colorSelecting, 2),
                    BorderFactory.createEmptyBorder(8,8,8,8)));
            }
        });
        
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(colorSelecting, 2),
                    BorderFactory.createEmptyBorder(8,8,8,8)));
            }
        });
    }
    
    public static void setBreakCum(String str){
        $.breakCums.clear();
        $.breakCums.add(str);
    }
    public static void pushBreakCum(String str){
        $.breakCums.add(str);
    }
    public static void popBreakCum(){
        $.breakCums.pop();
        popCard($.pnlContent);
    }
    public static void popBreakCum(int i){
        popCard($.pnlContent, i);
        while(i-- > 0)
            $.breakCums.pop();
    }
    
    public static void setCard(Container root, Container child){
        getStackCard(root).clear();
        getStackCard(root).add(child);
        root.removeAll();
        root.add(child);
        CardLayout card = (CardLayout)root.getLayout();
        card.last(root);
    }
    public static void pushCard(Container root, Container child){
        getStackCard(root).add(child);
        root.add(child);
        CardLayout card = (CardLayout)root.getLayout();
        card.last(root);
    }
    public static void popCard(Container root){
        root.remove(getStackCard(root).peek());
        getStackCard(root).pop();
        CardLayout card = (CardLayout)root.getLayout();
        card.last(root);
    }
    public static void popCard(Container root, int i){
        while(i-- > 0){
            root.remove(getStackCard(root).peek());
            getStackCard(root).pop();
        }
        CardLayout card = (CardLayout)root.getLayout();
        card.last(root);
    }
    private static Stack<Container> getStackCard(Container root){
        Stack<Container> st = null;
        if(root.equals($.pnlHeader))
            st = $.stPnlHeader;
        else if(root.equals($.pnlContent))
            st = $.stPnlContent;
        return st;
    }
    
    public static void openLoading(){
        if($.threadLoading == null || !$.threadLoading.isAlive()){
            // Dùng chung $.main JFrame sẽ bị xung đột Component
            // Phải chờ $.main xử lý xong add Component thì glassPane của $.main mới được giải phóng
            // -> Sử dụng draw trực tiếp
            Graphics g = $.main.getGraphics();
            g.setColor(new Color(0,0,0,50));
            g.fillRect(10, $.pnlHeaderHeight + 30, $.pnlContentWidth - 20, $.pnlContentHeight - 10);
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
            g.drawString("LOADING ...", 10 + ($.pnlContentWidth - 30)/2 - 50, $.pnlHeaderHeight + 60 + ($.pnlContentHeight - 80)/2 - 50);
        }
        else
            $.threadLoading.stop();     // trường hợp đang openLoading có thêm một openLoading nữa chạy
        
        $.threadLoading = new Thread(){
            @Override
            public void run() {
                int maxTime = 10;
                for (int i = maxTime; i > 0; i--) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.out);
                    }
                }
                closeLoading();
                dlgNotice("Lỗi", "Có lỗi xảy ra! Vui lòng thử lại.");
            }
        };
        $.threadLoading.start();
    }
    public static void closeLoading(){
        if($.threadLoading != null){
            if($.threadLoading.isAlive()){
                $.main.repaint();   // vẽ lại các component của $.main sau khi bị draw ghi đè lên
                $.threadLoading.stop();
            }
        }
    }
    
    public static void closeTab(JTabbedPane root, int beginIndex){
        for(int i=beginIndex; i<root.getTabCount(); i++){
            root.remove(beginIndex);
        }
        root.setSelectedIndex(beginIndex - 1);
    }
    
    public static String cryptPassword(String oldPassword){
        return md5(md5(md5(oldPassword)));
    }
    private static String md5(String txt){
        try {
            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md5.digest(txt.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void dlgNotice(String title, String message){
        closeLoading();
        JOptionPane.showMessageDialog(null,
            message,
            title,
            JOptionPane.ERROR_MESSAGE);
    }
    public static void dlgNotice(String title, String message, String status){
        closeLoading();
        JOptionPane.showMessageDialog(null,
            message,
            title,
            ("success".equals(status) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE));
    }
    
    public static Date stringToDate(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
    }
    public static String dateToString(Date date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    
    public static String getIcon(String iconString){
        return "./dist/image/"+ iconString;
    }
    public static void setIcon(JFrame fr, String iconString){
        fr.setIconImage(new ImageIcon(getIcon(iconString)).getImage());
    }
    public static void setIcon(JButton btn, String iconString){
        btn.setIcon(new ImageIcon(getIcon(iconString)));
    }
    public static void setIcon(JDialog dlg, String iconString){
        dlg.setIconImage(new ImageIcon(getIcon(iconString)).getImage());
    }
    
    public static IDB getTransactionDB(){
        IDB db = new MysqlDBDeploy();
        db.openConnection();
        try {
            db.getConn().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }
    public static IDB getTransactionDB(IDB db){
        db.openConnection();
        try {
            db.getConn().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }
    
    public static void closeTransactionDB(IDB db){
        try {
            db.getConn().setAutoCommit(true);
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
