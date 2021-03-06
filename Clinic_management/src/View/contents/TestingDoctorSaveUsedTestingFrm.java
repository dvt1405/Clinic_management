/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.contents;

import dao.PatientProfileDAO;
import dao.TestingDataDAO;
import dao.UsedTestingDAO;
import entity.Patient;
import entity.PatientProfile;
import entity.TestingData;
import entity.UsedTesting;
import entity.iEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import util.$;
import util.Helper;

/**
 *
 * @author chiendb
 */
public class TestingDoctorSaveUsedTestingFrm extends javax.swing.JPanel {

    /**
     * Creates new form TestingDoctorBg2
     */
    
    private final Patient patient;
    private final int roomId;
    private PatientProfile patientProfile = new PatientProfile();
    private UsedTesting usedTesting = new UsedTesting();
    private TestingData testingData = new TestingData();
    private final String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    
    public TestingDoctorSaveUsedTestingFrm(Patient patient, int roomId) {
        this.patient = patient;
        this.roomId = roomId;
        List<iEntity> findPatientProfile = new PatientProfileDAO().fetch("tblPatientId = " + this.patient.getId() + ";");
        patientProfile = (PatientProfile) findPatientProfile.get(0);
        List<iEntity> findUsedTesting = new UsedTestingDAO().findByPatientProfileIdAndRoomId(patientProfile.getId(), this.roomId);
        usedTesting = (UsedTesting) findUsedTesting.get(0);
        testingData = (TestingData) new TestingDataDAO().findById(usedTesting.getTblTestingDataId());
        initComponents();
        
        lblPatientNameValue.setText(this.patient.getFullName());
        lblPatientDobValue.setText(this.patient.getDob().toString());
        lblPatientGenderValue.setText(this.patient.getGender());
        lblPatientAddressValue.setText(this.patient.getAddress());
        lblPatientIdentityCardNumberValue.setText(this.patient.getIndentityCardNumber());
        lblPatientHasHealthInsuranceCardNumberValue.setText((patient.getHealthInsuranceCardNumber().equals("") ? "Không" : "Có"));
        lblPatientHealthInsuranceCardNumberValue.setText(patient.getHealthInsuranceCardNumber());
        lblTestingNameValue.setText(testingData.getName());
        txtTestingResults.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        lblPatientDob = new javax.swing.JLabel();
        lblPatientGender = new javax.swing.JLabel();
        lblPatientAddress = new javax.swing.JLabel();
        lblPatientNameValue = new javax.swing.JLabel();
        lblPatientDobValue = new javax.swing.JLabel();
        lblPatientGenderValue = new javax.swing.JLabel();
        lblPatientAddressValue = new javax.swing.JLabel();
        lblPatienIdentityCardNumber = new javax.swing.JLabel();
        lblPatientIsHealthInsuranceCardNumber = new javax.swing.JLabel();
        lblPatientHealthInsuranceCardNumber = new javax.swing.JLabel();
        lblPatientIdentityCardNumberValue = new javax.swing.JLabel();
        lblPatientHasHealthInsuranceCardNumberValue = new javax.swing.JLabel();
        lblPatientHealthInsuranceCardNumberValue = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTestingResults = new javax.swing.JTextField();
        btnSaveTestResults = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblTestingName = new javax.swing.JLabel();
        lblTestingNameValue = new javax.swing.JLabel();

        lblHeader.setText("Lưu kết quả xét nghiệm");
        lblHeader.setName("lblHeader"); // NOI18N

        lblPatientName.setText("Bệnh nhân:");
        lblPatientName.setName("lblPatientName"); // NOI18N

        lblPatientDob.setText("Ngày sinh:");
        lblPatientDob.setName("lblPatientDob"); // NOI18N

        lblPatientGender.setText("Giới tính:");
        lblPatientGender.setName("lblPatientGender"); // NOI18N

        lblPatientAddress.setText("Địa chỉ:");
        lblPatientAddress.setName("lblPatientAddress"); // NOI18N

        lblPatientNameValue.setText("jLabel6");
        lblPatientNameValue.setName("lblPatientNameValue"); // NOI18N

        lblPatientDobValue.setText("jLabel7");
        lblPatientDobValue.setName("lblPatientDobValue"); // NOI18N

        lblPatientGenderValue.setText("jLabel8");
        lblPatientGenderValue.setName("lblPatientGenderValue"); // NOI18N

        lblPatientAddressValue.setText("jLabel9");
        lblPatientAddressValue.setName("lblPatientAddressValue"); // NOI18N

        lblPatienIdentityCardNumber.setText("Số CMND:");
        lblPatienIdentityCardNumber.setName("lblPatienIdentityCardNumber"); // NOI18N

        lblPatientIsHealthInsuranceCardNumber.setText("BHYT:");
        lblPatientIsHealthInsuranceCardNumber.setName("lblPatientIsHealthInsuranceCardNumber"); // NOI18N

        lblPatientHealthInsuranceCardNumber.setText("Số thẻ BHYT:");
        lblPatientHealthInsuranceCardNumber.setName("lblPatientHealthInsuranceCardNumber"); // NOI18N

        lblPatientIdentityCardNumberValue.setText("jLabel13");
        lblPatientIdentityCardNumberValue.setName("lblPatientIdentityCardNumberValue"); // NOI18N

        lblPatientHasHealthInsuranceCardNumberValue.setText("jLabel14");
        lblPatientHasHealthInsuranceCardNumberValue.setName("lblPatientHasHealthInsuranceCardNumberValue"); // NOI18N

        lblPatientHealthInsuranceCardNumberValue.setText("jLabel15");
        lblPatientHealthInsuranceCardNumberValue.setName("lblPatientHealthInsuranceCardNumberValue"); // NOI18N

        jLabel16.setText("Nhập kết quả xét nghiệm:");

        txtTestingResults.setText("jTextField1");
        txtTestingResults.setName("txtTestingResults"); // NOI18N
        txtTestingResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTestingResultsActionPerformed(evt);
            }
        });

        btnSaveTestResults.setText("Lưu kết quả xét nghiệm");
        btnSaveTestResults.setName("btnSaveTestResults"); // NOI18N
        btnSaveTestResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTestResultsActionPerformed(evt);
            }
        });

        btnBack.setText("Quay lại");
        btnBack.setName("btnBack"); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTestingName.setText("Loại xét nghiệm:");
        lblTestingName.setName("lblTestingName"); // NOI18N

        lblTestingNameValue.setText("jLabel2");
        lblTestingNameValue.setName("lblTestingNameValue"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeader)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPatientName)
                            .addComponent(lblPatientDob)
                            .addComponent(lblPatientGender)
                            .addComponent(lblPatientAddress)
                            .addComponent(lblTestingName))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTestingNameValue)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblPatientAddressValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(lblPatientGenderValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPatientDobValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPatientNameValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPatientIsHealthInsuranceCardNumber)
                                            .addComponent(lblPatientHealthInsuranceCardNumber))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(lblPatientHealthInsuranceCardNumberValue))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblPatientHasHealthInsuranceCardNumberValue))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPatienIdentityCardNumber)
                                        .addGap(80, 80, 80)
                                        .addComponent(lblPatientIdentityCardNumberValue))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSaveTestResults)
                        .addGap(278, 278, 278)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(39, 39, 39)
                        .addComponent(txtTestingResults, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblHeader)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientName)
                    .addComponent(lblPatientNameValue)
                    .addComponent(lblPatienIdentityCardNumber)
                    .addComponent(lblPatientIdentityCardNumberValue))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientDob)
                    .addComponent(lblPatientDobValue)
                    .addComponent(lblPatientIsHealthInsuranceCardNumber)
                    .addComponent(lblPatientHasHealthInsuranceCardNumberValue))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientGender)
                    .addComponent(lblPatientGenderValue)
                    .addComponent(lblPatientHealthInsuranceCardNumber)
                    .addComponent(lblPatientHealthInsuranceCardNumberValue))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientAddress)
                    .addComponent(lblPatientAddressValue))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTestingName)
                    .addComponent(lblTestingNameValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTestingResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveTestResults)
                    .addComponent(btnBack))
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTestingResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTestingResultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTestingResultsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Helper.openLoading();
        Helper.pushCard($.pnlContent, new TestingDoctorCallFirstPatientFrm());
        Helper.closeLoading();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveTestResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTestResultsActionPerformed
        // TODO add your handling code here:
        usedTesting.setTestResults(txtTestingResults.getText());
        boolean Ok = new UsedTestingDAO().modify(usedTesting);
        Helper.openLoading();
        Helper.pushCard($.pnlContent, new TestingDoctorCallFirstPatientFrm());
        Helper.closeLoading();
    }//GEN-LAST:event_btnSaveTestResultsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveTestResults;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblPatienIdentityCardNumber;
    private javax.swing.JLabel lblPatientAddress;
    private javax.swing.JLabel lblPatientAddressValue;
    private javax.swing.JLabel lblPatientDob;
    private javax.swing.JLabel lblPatientDobValue;
    private javax.swing.JLabel lblPatientGender;
    private javax.swing.JLabel lblPatientGenderValue;
    private javax.swing.JLabel lblPatientHasHealthInsuranceCardNumberValue;
    private javax.swing.JLabel lblPatientHealthInsuranceCardNumber;
    private javax.swing.JLabel lblPatientHealthInsuranceCardNumberValue;
    private javax.swing.JLabel lblPatientIdentityCardNumberValue;
    private javax.swing.JLabel lblPatientIsHealthInsuranceCardNumber;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JLabel lblPatientNameValue;
    private javax.swing.JLabel lblTestingName;
    private javax.swing.JLabel lblTestingNameValue;
    private javax.swing.JTextField txtTestingResults;
    // End of variables declaration//GEN-END:variables
}
