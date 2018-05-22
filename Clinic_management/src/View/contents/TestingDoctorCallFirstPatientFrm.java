/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.contents;

import dao.ClinicTypeDAO;
import dao.PatientDAO;
import dao.RoomDAO;
import dao.RoomQueueDAO;
import entity.ClinicType;
import entity.Patient;
import entity.Room;
import entity.RoomQueue;
import entity.iEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import util.Helper;
import util.$;

/**
 *
 * @author chiendb
 */
public class TestingDoctorCallFirstPatientFrm extends javax.swing.JPanel {

    /**
     * Creates new form TestingDoctorBg1
     */
    
    private final List<iEntity> listClinicType = new ClinicTypeDAO().fetchAll();
    private List<iEntity> listRoom;
    private List<iEntity> listPatient;
    private List<iEntity> listRoomQueue;
    private int roomId;
    
    public TestingDoctorCallFirstPatientFrm() {
        initComponents();
        for (iEntity entity : listClinicType) {
            ClinicType instance = (ClinicType) entity;
            cbSpecialist.addItem(instance.getName());
        }
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
        jLabel2 = new javax.swing.JLabel();
        cbSpecialist = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbRoom = new javax.swing.JComboBox<>();
        btnCallFirstPatient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPatient = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        jLabel1.setText("Chức năng bác sĩ xét nghiệm");

        jLabel2.setText("Khoa");

        cbSpecialist.setName("cbSpecialist"); // NOI18N
        cbSpecialist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSpecialistActionPerformed(evt);
            }
        });

        jLabel3.setText("Phòng");

        cbRoom.setName("cbRoom"); // NOI18N
        cbRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoomActionPerformed(evt);
            }
        });

        btnCallFirstPatient.setText("Call first patient");
        btnCallFirstPatient.setName("btnCallFirstPatient"); // NOI18N
        btnCallFirstPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallFirstPatientActionPerformed(evt);
            }
        });

        tbPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPatient.setName("tbPatient"); // NOI18N
        jScrollPane1.setViewportView(tbPatient);
        tbPatient.getAccessibleContext().setAccessibleName("tbPatient");

        btnBack.setText("Quay lại");
        btnBack.setName("btnBack"); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbSpecialist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(269, 269, 269)
                .addComponent(jLabel3)
                .addGap(85, 85, 85)
                .addComponent(cbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCallFirstPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(242, 242, 242))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbSpecialist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnCallFirstPatient))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        cbSpecialist.getAccessibleContext().setAccessibleName("cbSpecialist");
        cbRoom.getAccessibleContext().setAccessibleName("cbRoom");
        btnCallFirstPatient.getAccessibleContext().setAccessibleName("btnCallFirstPatient");
        btnBack.getAccessibleContext().setAccessibleName("btnBack");
    }// </editor-fold>//GEN-END:initComponents
 
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Helper.openLoading();
        Helper.pushCard($.pnlContent, new DoctorMain());
        Helper.closeLoading();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoomActionPerformed
        // TODO add your handling code here:
        int index = cbRoom.getSelectedIndex();
        Helper.openLoading();
        Room instance = (Room) listRoom.get(index);
        initRoomQueueByRoomId(instance.getId());
        Helper.closeLoading();
    }//GEN-LAST:event_cbRoomActionPerformed

    private void cbSpecialistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSpecialistActionPerformed
        // TODO add your handling code here:
        Helper.openLoading();
        initCbRoomBySpecialistTypeName(cbSpecialist.getSelectedItem().toString());
        Helper.closeLoading();
    }//GEN-LAST:event_cbSpecialistActionPerformed
   
    private void btnCallFirstPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallFirstPatientActionPerformed
        // TODO add your handling code here:
        Helper.openLoading();
        Patient patient = (Patient) listPatient.get(0);
        Helper.pushCard($.pnlContent, new TestingDoctorSaveUsedTestingFrm(patient, this.roomId));

//        After call first patient, remove this patient from queue
        new RoomQueueDAO().delete(listRoomQueue.get(0));
        Helper.closeLoading();
    }//GEN-LAST:event_btnCallFirstPatientActionPerformed

    private void initCbRoomBySpecialistTypeName(String specialistName) {
        listRoom = new RoomDAO().fetch("clinicType = '" + specialistName + "' and type = 'testing';");

        ActionListener[] currentListeners = cbRoom.getActionListeners();
        for (ActionListener listener : currentListeners) {
            cbRoom.removeActionListener(listener);
        }

        cbRoom.removeAllItems();
        for (iEntity entity : listRoom) {
            Room instance = (Room) (entity);
            cbRoom.addItem(instance.getName());
        }
        cbRoom.setSelectedIndex(0);

        Room firstInstance = (Room) listRoom.get(0);
        initRoomQueueByRoomId(firstInstance.getId());

        for (ActionListener listener : currentListeners) {
            cbRoom.addActionListener(listener);
        }
    }
    
    private void initRoomQueueByRoomId(int roomId) {
        this.roomId = roomId;
        listRoomQueue = new RoomQueueDAO().fetch("tblRoomId = " + roomId + " order by registerTime asc;");
        Object[][] tblData = new Object[listRoomQueue.size()][];
        listPatient = new ArrayList<>();
        int i = 0;

        for (iEntity entity : listRoomQueue) {
            RoomQueue rq = (RoomQueue) entity;
            
            iEntity instance = new PatientDAO().findById(rq.getTblPatientId());
            if (instance != null) {
                Patient patient = (Patient) instance;
                listPatient.add(patient);
                tblData[i] = new Object[]{
                    i++,
                    patient.getId(),
                    patient.getFullName(),
                    patient.getDob(),
                    (patient.getHealthInsuranceCardNumber().equals("") ? false : true)
                };
            }
        }
        initDisplay();
        initTblPatientQueue(tblData);
    }
    
    private void initDisplay() {
        if (listPatient != null & !listPatient.isEmpty()) {
            btnCallFirstPatient.setEnabled(true);
        } else {
            btnCallFirstPatient.setEnabled(false);
        }
    }
    
    private void initTblPatientQueue(Object[][] data) {
        final String[] columnNames = new String[]{
            "#", "Mã bệnh nhân", "Tên", "Ngày sinh", "Bảo hiểm y tế"};
        final Class<?>[] columnTypes = new Class<?>[]{
            Integer.class, String.class, String.class, String.class, Boolean.class, JButton.class};

        tbPatient.setModel(new ClinicDoctorBg1TblModel(columnNames, columnTypes, data){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return (rowIndex + 1);
                        
                    default:
                        return data[rowIndex][columnIndex];
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCallFirstPatient;
    private javax.swing.JComboBox<String> cbRoom;
    private javax.swing.JComboBox<String> cbSpecialist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPatient;
    // End of variables declaration//GEN-END:variables
}