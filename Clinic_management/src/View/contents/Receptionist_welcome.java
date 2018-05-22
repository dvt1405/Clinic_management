/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.contents;

import util.$;
import util.Helper;
import entity.Patient;
import entity.Room;
import entity.RoomQueue;
import entity.iEntity;
import java.awt.BorderLayout;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tun
 */
public class Receptionist_welcome extends javax.swing.JPanel {

    Patient p;
    List<iEntity> r;
    List<iEntity> rq;
    boolean type = true;

    public Receptionist_welcome() {
        p = new Patient();
        r = new ArrayList<>();
        rq = new ArrayList<>();
        Helper.setBreakCum("Main");
        Helper.pushBreakCum("Chức năng Tiếp nhận");
        Helper.pushBreakCum("Tạo mới");
        JPanel pnlHeader = new view.BreakCums();
        initComponents();
        cbday.setEnabled(false);
        this.addmonth();
        this.addyear();
        this.header.setLayout(new BorderLayout());
        this.header.add(pnlHeader, BorderLayout.NORTH);
    }

    public Receptionist_welcome(Patient p, List<iEntity> r, List<iEntity> rq) {
        this.p = p;
        this.r = r;
        this.rq = rq;
        Helper.setBreakCum("Main");
        Helper.pushBreakCum("Chức năng Tiếp nhận");
        Helper.pushBreakCum("Tạo mới");
        JPanel pnlHeader = new view.BreakCums();
        initComponents();
        cbday.setEnabled(false);
        this.addmonth();
        this.addyear();
        this.txtAdress.setText(p.getAddress());
        this.txtName.setText(p.getFullName());
        if (p.getGender().equalsIgnoreCase("Male")) {
            this.jCheckBox1.setSelected(true);
        } else {
            this.jCheckBox2.setSelected(true);
        }
        this.txtCMND.setText(p.getIndentityCardNumber());
        this.txtBHYT.setText(p.getHealthInsuranceCardNumber());
        this.setEnable(false);
        this.header.setLayout(new BorderLayout());
        this.header.add(pnlHeader, BorderLayout.NORTH);
    }

    public void addmonth() {
        this.cbmonth.removeAllItems();
        for (int i = 1; i < 13; i++) {
            this.cbmonth.addItem(String.valueOf(i));
        }
    }

    public void addday(int d) {
        for (int i = 1; i <= d; i++) {
            this.cbday.addItem(String.valueOf(i));
        }
    }

    public void addyear() {
        this.cbyear.removeAllItems();
        for (int i = 2018; i > 1900; i--) {
            this.cbyear.addItem(String.valueOf(i));
        }
    }

    public Patient getpatient() {
        return this.p;
    }

    public void setEnable(boolean k) {
        this.txtAdress.setEnabled(k);
        this.txtBHYT.setEnabled(k);
        this.txtCMND.setEnabled(k);
        this.txtName.setEnabled(k);
        this.jCheckBox1.setEnabled(k);
        this.jCheckBox2.setEnabled(k);
        this.cbyear.setEnabled(k);
        this.cbmonth.setEnabled(k);
        this.cbday.setEnabled(k);
        this.type = k;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBHYT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        cbday = new javax.swing.JComboBox<>();
        cbmonth = new javax.swing.JComboBox<>();
        cbyear = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();

        jLabel1.setText("Họ và tên");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Số CMND");

        jLabel4.setText("Số tẻ BHYT");

        jLabel5.setText("Giới tính");

        jButton1.setText("Hoàn Tất");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("Nam");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("Nữ");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày sinh");

        cbday.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD" }));
        cbday.setToolTipText("");

        cbmonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MM" }));
        cbmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmonthActionPerformed(evt);
            }
        });

        cbyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YYYY" }));
        cbyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbyearActionPerformed(evt);
            }
        });

        jLabel7.setText("Loại khám ");

        buttonGroup2.add(jCheckBox3);
        jCheckBox3.setText("Răng Miệng");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setText("HIV");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox5);
        jCheckBox5.setText("Khám tổng hợp");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Số phòng"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jLabel8.setText("Địa chỉ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(39, 39, 39)
                                        .addComponent(jCheckBox3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox4)
                                        .addGap(42, 42, 42)
                                        .addComponent(jCheckBox5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(39, 39, 39)
                                        .addComponent(cbyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(cbmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(cbday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                                .addComponent(txtCMND)
                                                .addComponent(txtBHYT)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox2)))
                                .addGap(0, 27, Short.MAX_VALUE))))
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        this.p.setGender("Male");
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void cbmonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmonthActionPerformed
        // TODO add your handling code here:
        if (cbmonth.getSelectedIndex() == 0 || cbmonth.getSelectedIndex() == 2 || cbmonth.getSelectedIndex() == 4
                || cbmonth.getSelectedIndex() == 6 || cbmonth.getSelectedIndex() == 7
                || cbmonth.getSelectedIndex() == 9 || cbmonth.getSelectedIndex() == 11) {
            this.cbday.removeAllItems();
            addday(31);
        } else if (cbmonth.getSelectedIndex() == 1 && Integer.parseInt(this.cbyear.getSelectedItem().toString()) % 4 == 0) {
            this.cbday.removeAllItems();
            addday(29);
        } else if (cbmonth.getSelectedIndex() == 1) {
            this.cbday.removeAllItems();
            addday(28);
        } else {
            this.cbday.removeAllItems();
            addday(30);
        }
        cbday.setEnabled(true);
    }//GEN-LAST:event_cbmonthActionPerformed

    private void cbyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbyearActionPerformed
        // TODO add your handling code here:
        if (cbmonth.getSelectedIndex() == 1) {
            if (Integer.parseInt(this.cbyear.getSelectedItem().toString()) % 4 == 0) {
                this.cbday.removeAllItems();
                addday(29);
                cbday.setEnabled(true);
            } else {
                this.cbday.removeAllItems();
                addday(28);
                cbday.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cbyearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (this.type) {
                if (this.txtName.getText().toString().length() == 0 || this.txtBHYT.getText().toString().length() == 0
                        || this.txtAdress.getText().toString().length() == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                this.p.setFullName(this.txtName.getText().toString());
                this.p.setHealthInsuranceCardNumber(this.txtBHYT.getText().toString());
                this.p.setAddress(this.txtAdress.getText().toString());
                //this.p.setIndentityCardNumber(this.txtCMND.getText().toString());
                Date d = new Date();
                d.setDate(cbday.getSelectedIndex() + 1);
                d.setMonth(cbmonth.getSelectedIndex() + 1);
                d.setYear(2018 - this.cbyear.getSelectedIndex() - 1900);
                this.p.setDob(d);
                new dao.PatientDAO().add(p);
            } else {
                new dao.PatientDAO().modify(p);
            }
            DefaultTableModel d1 = (DefaultTableModel) this.jTable1.getModel();
            Room room = (Room) this.r.get(jTable1.getSelectedRow());
            RoomQueue rq = new RoomQueue();
            rq.setTblRoomId(room.getId());
            rq.setTblPatientId(this.p.getId());
            Timestamp t = new Timestamp(new Date().getTime());
            rq.setRegisterTime(t);
            new dao.RoomQueueDAO().add((iEntity) rq);
            JOptionPane.showMessageDialog(this, "Hoàn Tất!");
            Helper.openLoading();
            Helper.pushCard($.pnlContent, new ReceptionistMain());
            Helper.closeLoading();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Các text không được bỏ trống!");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn giới tính!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        this.p.setGender("Female");
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        r.clear();
        this.r = new dao.RoomDAO().fetch("clinicType = 'Răng Miệng' AND type= 'clinic'");
        DefaultTableModel d1 = (DefaultTableModel) this.jTable1.getModel();
        d1.getDataVector().clear();
        for (iEntity i : r) {
            Room ri = (Room) i;
            d1.addRow(new Object[]{ri.getId(), ri.getName()});
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        this.r.clear();
        this.r = new dao.RoomDAO().fetch("clinicType = 'HIV' AND type= 'clinic'");
        DefaultTableModel d1 = (DefaultTableModel) this.jTable1.getModel();
        d1.getDataVector().clear();
        for (iEntity i : r) {
            Room ri = (Room) i;
            d1.addRow(new Object[]{ri.getId(), ri.getName()});
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
        this.r.clear();
        this.r = new dao.RoomDAO().fetch("clinicType = 'Ung thư' AND type= 'clinic'");
        DefaultTableModel d1 = (DefaultTableModel) this.jTable1.getModel();
        d1.getDataVector().clear();
        for (iEntity i : r) {
            Room ri = (Room) i;
            d1.addRow(new Object[]{ri.getId(), ri.getName()});
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbday;
    private javax.swing.JComboBox<String> cbmonth;
    private javax.swing.JComboBox<String> cbyear;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtBHYT;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
