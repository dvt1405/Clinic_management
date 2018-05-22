/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.contents;

import util.$;
import util.Helper;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Dezeross
 */
public class DetailTesingFrm extends javax.swing.JFrame {

    public DetailTesingFrm(int id,Date timeStart,Date timeEnd) {
        super("Chi tiết xét nghiệm ");
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Helper.setIcon(this, "logo.png");
        this.setBounds(($.screenSize.width - $.frWidth)/2, ($.screenSize.height - $.frHeight)/2, $.frWidth, $.frHeight);
        this.setFont(new Font("Verdana", Font.BOLD, 12));
        
        

        JPanel pnlMain = new AccountantPnl2( id,timeStart,timeEnd);
        
        JScrollPane  sclMain = new JScrollPane();
        sclMain.setViewportView(pnlMain);
        this.setLayout(new BorderLayout());
//   
        Helper.openLoading();
        this.add(pnlMain,BorderLayout.CENTER);
        Helper.closeLoading();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}