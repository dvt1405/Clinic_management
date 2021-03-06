/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.contents;

import util.$;
import util.Helper;
import entity.TestingManagement;
import entity.iEntity;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import repository.DetailTestingMysql;
import repository.TestingManagementMysql;

/**
 *
 * @author Dezeross
 */
public class AccountantPnl extends javax.swing.JPanel  {

    /**
     * Creates new form AccountantPnl
     */
    public AccountantPnl() {
        initComponents();
        amount.setText("0 VNĐ");
        tblTestingManagement.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model= new DefaultTableModel(){ 
                    public boolean isCellEditable(int row, int col) 
                    {return false;} 
                    }; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTestingManagement = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        timeStart = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        btn_thongke = new javax.swing.JButton();
        timeEnd = new javax.swing.JTextField();
        btn_chitiet = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("CHỨC NĂNG THỐNG KÊ XÉT NGHIỆM");

        tblTestingManagement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên xét nghiệm", "Số lần thực hiện", "Doanh thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTestingManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTestingManagementMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTestingManagement);

        jLabel2.setText("Ngày bắt đầu (YYYY-MM-DD) :");

        jLabel3.setText("Ngày kết thúc (YYYY-MM-DD) :");

        timeStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeStartActionPerformed(evt);
            }
        });
        timeStart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timeStartKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Tổng doanh thu từ việc xét nghiệm :");

        amount.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        amount.setText("10,000,000 VNĐ");

        btn_thongke.setText("Thống kê");
        btn_thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkeActionPerformed(evt);
            }
        });

        timeEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeEndActionPerformed(evt);
            }
        });
        timeEnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timeEndKeyPressed(evt);
            }
        });

        btn_chitiet.setText("Xem chi tiết xét nghiệm");
        btn_chitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chitietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(btn_thongke))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_chitiet))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timeStart, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeStart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkeActionPerformed
        btn_thongke();
    }//GEN-LAST:event_btn_thongkeActionPerformed

    private void timeStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeStartActionPerformed
        
    }//GEN-LAST:event_timeStartActionPerformed

    private void timeEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeEndActionPerformed
    
    private void btn_chitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chitietActionPerformed
        int index = tblTestingManagement.getSelectedRow();
        DefaultTableModel tbl = (DefaultTableModel)tblTestingManagement.getModel();
        if (index!=-1) {
           this.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
//           String name = (String)tbl.getValueAt(index,1);
           int ID = (int)tbl.getValueAt(index,0); 
           
           
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                format.setLenient(false);
                Date tStart = format.parse(timeStart.getText());
                Date tEnd = format.parse(timeEnd.getText());
                java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DetailTesingFrm(ID,tStart,tEnd).setVisible(true);
                }
                });
//                DetailTestingMysql detail = new DetailTestingMysql();
//                ArrayList<iEntity> i = (ArrayList<iEntity>) detail.executeSql(tStart, tEnd, ID);
//                System.out.println(i);
//                
            } catch (Exception e) {
                System.out.println("Loi time");
            }
           
        }else{
            JOptionPane.showMessageDialog(this, "Chọn xét nghiệm ?");
        }
    }//GEN-LAST:event_btn_chitietActionPerformed

    private void timeStartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeStartKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) {
                    btn_thongke();

        }
    }//GEN-LAST:event_timeStartKeyPressed

    private void timeEndKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeEndKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) {
                    btn_thongke();

        }
    }//GEN-LAST:event_timeEndKeyPressed

    private void tblTestingManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTestingManagementMouseClicked
        boolean edit = tblTestingManagement.isEditing();
        if (evt.getClickCount()==2) {
            JOptionPane.showMessageDialog(this, "Khong duoc tahy doi");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTestingManagementMouseClicked
    private void btn_thongke(){
        DefaultTableModel tbl = (DefaultTableModel)tblTestingManagement.getModel();
        tbl.setNumRows(0);
        amount.setText("0 VNĐ");
        try {
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            Date tStart = format.parse(timeStart.getText());
            Date tEnd = format.parse(timeEnd.getText());
            if (tEnd.getTime()-tStart.getTime()<0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng thời gian");
            }else{
                Helper.openLoading();
                TestingManagementMysql t = new TestingManagementMysql();
//                System.out.println(t.executeSql(tStart,tEnd));
                ArrayList<iEntity> e = (ArrayList<iEntity>) t.executeSql(tStart, tEnd);
                int index=0;
                for (iEntity entity : e) {
                    TestingManagement tm = (TestingManagement)entity;
                    tbl.addRow(new Object[]{tm.getId(),tm.getName(),tm.getTimes(),tm.getAmount()});
                }
                float Fsum_price = 0;
                for (int i = 0; i < tbl.getRowCount(); i++) {
                    Fsum_price+=(float)tbl.getValueAt(i,3);
                }
                NumberFormat currentLocale = NumberFormat.getInstance();
                String Ssum_price = currentLocale.format(Fsum_price);
                amount.setText(Ssum_price+" VNĐ");
                Helper.closeLoading();
                
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập sai định dạng hoặc thời gian không tồn tại");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JButton btn_chitiet;
    private javax.swing.JButton btn_thongke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTestingManagement;
    private javax.swing.JTextField timeEnd;
    private javax.swing.JTextField timeStart;
    // End of variables declaration//GEN-END:variables
}
