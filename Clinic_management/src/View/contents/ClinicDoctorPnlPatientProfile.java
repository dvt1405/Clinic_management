package view.contents;

import util.Helper;
import dao.MedicineDataDAO;
import dao.PatientDAO;
import dao.PatientProfileDAO;
import dao.RoomQueueDAO;
import dao.TestingDataDAO;
import dao.UsedMedicineDAO;
import dao.UsedTestingDAO;
import entity.MedicineData;
import entity.Patient;
import entity.PatientProfile;
import entity.RoomQueue;
import entity.TestingData;
import entity.UsedMedicine;
import entity.UsedTesting;
import entity.iEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import util.$;

public class ClinicDoctorPnlPatientProfile extends javax.swing.JPanel {

    private final Patient patient;
    private final int roomId;
    private final List<iEntity> listDataTesting = new TestingDataDAO().fetchAll();
    private final List<iEntity> listDataMedicine = new MedicineDataDAO().fetchAll();
    private Object[][] dataTblSelectedTesting;
    private Object[][] dataTblSelectedMedicine;
    private final ArrayList listIdSelectedMedicine = new ArrayList<>();
    private final String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    private PatientProfile patientProfile = new PatientProfile();
    private final boolean isNewProfile;
    private List<iEntity> listUsedTesting;
    private List<iEntity> listUsedMedicine;

    public ClinicDoctorPnlPatientProfile(Patient patient, int roomId) {
        this.patient = patient;
        this.roomId = roomId;
        List<iEntity> findPatientProfile = new PatientProfileDAO().fetch("tblPatientId = " + this.patient.getId() + " and "
                + "examinationDate = '" + currentDate + "';");
        if (findPatientProfile != null && findPatientProfile.size() == 1) {
            patientProfile = (PatientProfile) findPatientProfile.get(0);
            isNewProfile = false;
        } else {
            isNewProfile = true;
        }
        initComponents();
    }

    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        lblPatientDob = new javax.swing.JLabel();
        lblPatientGender = new javax.swing.JLabel();
        lblPatientAddress = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPatientIsHealthInsuranceCardNumber = new javax.swing.JLabel();
        lblPatienIdentityCardNumber = new javax.swing.JLabel();
        lblPatientHealthInsuranceCardNumber = new javax.swing.JLabel();
        lblPatientNameValue = new javax.swing.JLabel();
        lblPatientDobValue = new javax.swing.JLabel();
        lblPatientGenderValue = new javax.swing.JLabel();
        lblPatientAddressValue = new javax.swing.JLabel();
        lblPatientIdentityCardNumberValue = new javax.swing.JLabel();
        lblPatientHasHealthInsuranceCardNumberValue = new javax.swing.JLabel();
        lblPatientHealthInsuranceCardNumberValue = new javax.swing.JLabel();
        lblFillClinicResults = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtClinicResults = new javax.swing.JTextArea();
        lblSelectedTesting = new javax.swing.JLabel();
        lblDataTesting = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTesting = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlistDataTesting = new javax.swing.JList<>();
        lblSelectedMedicine = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMedicine = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jlistDataMedicine = new javax.swing.JList<>();
        lblDataMedicine = new javax.swing.JLabel();
        btnSaveProfile = new javax.swing.JButton();
        btnCallNextPatient = new javax.swing.JButton();
        btnBackToList = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        tfPrice = new javax.swing.JTextField();

        if (isNewProfile) {
            lblTitle.setText("THÊM MỚI HỒ SƠ BỆNH NHÂN");
        } else {
            lblTitle.setText("CẬP NHẬT HỒ SƠ BỆNH NHÂN");
        }
        lblPatientName.setText("Bệnh nhân:");
        lblPatientDob.setText("Ngày sinh:");
        lblPatientGender.setText("Giới tính:");
        lblPatientAddress.setText("Địa chỉ:");
        lblPatientIsHealthInsuranceCardNumber.setText("Bảo hiểm y tế:");
        lblPatienIdentityCardNumber.setText("Số CMND:");
        lblPatientHealthInsuranceCardNumber.setText("Mã số BHYT:");

        lblPatientNameValue.setText(patient.getFullName());
        lblPatientDobValue.setText(patient.getDob().toString());
        lblPatientGenderValue.setText(patient.getGender());
        lblPatientAddressValue.setText(patient.getAddress());
        lblPatientIdentityCardNumberValue.setText(patient.getIndentityCardNumber());
        lblPatientHasHealthInsuranceCardNumberValue.setText((patient.getHealthInsuranceCardNumber().equals("") ? "Không" : "Có"));
        lblPatientHealthInsuranceCardNumberValue.setText(patient.getHealthInsuranceCardNumber());

        lblFillClinicResults.setText("Nhập kết quả khám lâm sàng");
        txtClinicResults.setColumns(20);
        txtClinicResults.setRows(5);
        txtClinicResults.setText(patientProfile.getClinicResults());
        jScrollPane2.setViewportView(txtClinicResults);

        lblPrice.setText("Nhập tiền khám:");
        tfPrice.setText(String.valueOf(patientProfile.getExaminationPrice()));

        lblSelectedTesting.setText("Chỉ định xét nghiệm");
        initTblSelectedTesting();

        lblDataTesting.setText("Các loại xét nghiệm");
        int i = 0;
        String[] jlistDataTestingValues = new String[listDataTesting.size()];
        for (iEntity entity : listDataTesting) {
            TestingData instance = (TestingData) entity;
            jlistDataTestingValues[i++] = instance.getName();
        }
        jlistDataTesting.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() {
                return jlistDataTestingValues.length;
            }

            public String getElementAt(int i) {
                return jlistDataTestingValues[i];
            }
        });
        jScrollPane4.setViewportView(jlistDataTesting);

        jlistDataTesting.setDragEnabled(true);

        lblSelectedMedicine.setText("Chỉ định thuốc");
        dataTblSelectedMedicine = new Object[][]{};
        initTblSelectedMedicine();

        lblDataMedicine.setText("Các loại thuốc");
        i = 0;
        String[] jlistDataMedicineValues = new String[listDataMedicine.size()];
        for (iEntity entity : listDataMedicine) {
            MedicineData instance = (MedicineData) entity;
            jlistDataMedicineValues[i++] = instance.getName();
        }
        jlistDataMedicine.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() {
                return jlistDataMedicineValues.length;
            }

            public String getElementAt(int i) {
                return jlistDataMedicineValues[i];
            }
        });
        jScrollPane6.setViewportView(jlistDataMedicine);

        jlistDataMedicine.setDragEnabled(true);

        btnSaveProfile.setText("Lưu hồ sơ");
        Helper.setBorderBtn(btnSaveProfile);
        btnSaveProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProfileActionPerformed(evt);
            }
        });

        btnCallNextPatient.setText("Call next patient");
        Helper.setBorderBtn(btnCallNextPatient);
        btnCallNextPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallNextPatientActionPerformed(evt);
            }
        });

        btnBackToList.setText("Back to list");
        Helper.setBorderBtn(btnBackToList);
        btnBackToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblTitle)
                                                        .addComponent(lblFillClinicResults)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(lblPatientAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblPatientDob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblPatientName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblPatientGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(lblPatientNameValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(lblPatientDobValue, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                                                                        .addComponent(lblPatientGenderValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(lblPatientHealthInsuranceCardNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(lblPatientIsHealthInsuranceCardNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                                        .addComponent(lblPatienIdentityCardNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblPatientIdentityCardNumberValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(lblPatientHasHealthInsuranceCardNumberValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(lblPatientHealthInsuranceCardNumberValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                        .addComponent(lblPatientAddressValue, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel8))
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblSelectedTesting))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblDataTesting)
                                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblSelectedMedicine))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblDataMedicine)
                                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblPrice)
                                                .addGap(18, 18, 18)
                                                .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(btnSaveProfile)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCallNextPatient)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnBackToList)))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPatientName)
                                        .addComponent(jLabel8)
                                        .addComponent(lblPatienIdentityCardNumber)
                                        .addComponent(lblPatientNameValue)
                                        .addComponent(lblPatientIdentityCardNumberValue))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPatientDob)
                                        .addComponent(lblPatientIsHealthInsuranceCardNumber)
                                        .addComponent(lblPatientDobValue)
                                        .addComponent(lblPatientHasHealthInsuranceCardNumberValue))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPatientGender)
                                        .addComponent(lblPatientHealthInsuranceCardNumber)
                                        .addComponent(lblPatientGenderValue)
                                        .addComponent(lblPatientHealthInsuranceCardNumberValue))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPatientAddress)
                                        .addComponent(lblPatientAddressValue))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblFillClinicResults)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSelectedTesting)
                                                        .addComponent(lblDataTesting))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSelectedMedicine)
                                                        .addComponent(lblDataMedicine))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblPrice)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSaveProfile)
                                        .addComponent(btnCallNextPatient)
                                        .addComponent(btnBackToList))
                                .addContainerGap(49, Short.MAX_VALUE))
        );
    }

    private boolean saveTblTesting() {
        TableModel tableModel = tblTesting.getModel();
        if (tableModel.getRowCount() > 0) {
            List<iEntity> listUsedTesting = new ArrayList<>();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                int colsCount = tableModel.getColumnCount();
                if (tableModel.getValueAt(i, colsCount - 1).equals("Non-Saved")) {
                    //                        "ID", "Tên xét nghiệm", "Số lượng", "Tổng tiền", "Kết quả", "Status"
                    int idTesting = Integer.valueOf(tableModel.getValueAt(i, 0).toString());
                    int quantity = Integer.valueOf(tableModel.getValueAt(i, 2).toString());
                    float amount = Float.valueOf(tableModel.getValueAt(i, 3).toString());
                    String testResults = tableModel.getValueAt(i, 4).toString();

                    UsedTesting usedTesting = new UsedTesting();
                    usedTesting.setQuantity(quantity);
                    usedTesting.setAmount(amount);
                    usedTesting.setTblTestingDataId(idTesting);
                    usedTesting.setTblPatientProfileId(this.patientProfile.getId());
                    usedTesting.setIsPaid(0);
                    usedTesting.setTestResults(testResults);
                    listUsedTesting.add(usedTesting);
                }
            }
            if (!listUsedTesting.isEmpty()) {
                if (new UsedTestingDAO().add(listUsedTesting)) {
                    initTblSelectedTesting();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean saveTblMedicine() {
        TableModel tableModel = tblMedicine.getModel();
        if (tableModel.getRowCount() > 0) {
            List<iEntity> listUsedMedicine = new ArrayList<>();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                int colsCount = tableModel.getColumnCount();
                if (tableModel.getValueAt(i, colsCount - 1).equals("Non-Saved")) {
                    //                        "ID", "Tên thuốc", "Số lượng", "Tổng tiền", "Status"
                    int idMedicine = Integer.valueOf(tableModel.getValueAt(i, 0).toString());
                    int quantity = Integer.valueOf(tableModel.getValueAt(i, 2).toString());
                    float amount = Float.valueOf(tableModel.getValueAt(i, 3).toString());

                    UsedMedicine usedMedicine = new UsedMedicine();
                    usedMedicine.setQuantity(quantity);
                    usedMedicine.setAmount(amount);
                    usedMedicine.setTblMedicineDataId(idMedicine);
                    usedMedicine.setTblPatientProfileId(this.patientProfile.getId());
                    usedMedicine.setIsPaid(0);
                    listUsedMedicine.add(usedMedicine);
                }
            }
            if (!listUsedMedicine.isEmpty()) {
                if (new UsedMedicineDAO().add(listUsedMedicine)) {
                    initTblSelectedMedicine();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean saveTableData() {
        if (saveTblTesting() && saveTblMedicine()) {
            return true;
        }
        return false;
    }

    private void btnSaveProfileActionPerformed(java.awt.event.ActionEvent evt) {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        List<iEntity> findPatientProfile = new PatientProfileDAO().fetch("tblPatientId = " + this.patient.getId() + " and "
                + "examinationDate = '" + currentDate + "';");
        if (findPatientProfile == null || findPatientProfile.isEmpty()) {
            PatientProfile patientProfile = new PatientProfile();
            patientProfile.setExaminationDate(new Date());
            patientProfile.setExaminationPrice(Float.valueOf(tfPrice.getText()));
            patientProfile.setDoctorId($.idUser);
            patientProfile.setTblPatientId(this.patient.getId());
            patientProfile.setClinicResults(txtClinicResults.getText());

            if (new PatientProfileDAO().add(patientProfile) && saveTableData()) {
                Helper.dlgNotice("Lỗi", "Tạo mới hồ sơ bệnh nhân thành công.");
            } else {
                Helper.dlgNotice("Lỗi", "Tạo mới hồ sơ bệnh nhân không thành công!");
            }
        } else {
            PatientProfile instance = (PatientProfile) findPatientProfile.get(0);
            instance.setExaminationDate(new Date());
            instance.setExaminationPrice(Float.valueOf(tfPrice.getText()));
            instance.setDoctorId($.idUser);
            instance.setTblPatientId(this.patient.getId());
            instance.setClinicResults(txtClinicResults.getText());

            if (new PatientProfileDAO().modify(instance) && saveTableData()) {
                Helper.dlgNotice("Thông báo", "Cập nhật hồ sơ bệnh nhân thành công.");
            } else {
                Helper.dlgNotice("Lỗi", "Cập nhật hồ sơ bệnh nhân không thành công!");
            }
        }
    }

    private void btnCallNextPatientActionPerformed(java.awt.event.ActionEvent evt) {
        List<iEntity> listRoomQueue = new RoomQueueDAO().fetch("tblRoomId = " + this.roomId + " order by registerTime asc limit 1;");
        if (listRoomQueue != null & listRoomQueue.size() == 1) {
            RoomQueue rq = (RoomQueue) listRoomQueue.get(0);

            iEntity instance = new PatientDAO().findById(rq.getTblPatientId());
            if (instance != null) {
                Patient patient = (Patient) instance;
                Helper.openLoading();
                Helper.popBreakCum();
                Helper.pushCard($.pnlContent, new ClinicDoctorBg2(patient, this.roomId));

//                After call first patient, remove this patient from queue
                new RoomQueueDAO().delete(rq);
                Helper.closeLoading();
            } else {
                Helper.dlgNotice("Lỗi", "Có lỗi xảy ra.");
            }
        } else {
            Helper.dlgNotice("Thông báo", "Danh sách bệnh nhân đang chờ hiện trống.");
        }
    }

    private void btnBackToListActionPerformed(java.awt.event.ActionEvent evt) {
        Helper.openLoading();
        Helper.popBreakCum(2);
        Helper.pushCard($.pnlContent, new ClinicDoctorBg1());
        Helper.closeLoading();
    }

    private void initTblSelectedTesting() {
        dataTblSelectedTesting = new Object[][]{};
        listUsedTesting = new UsedTestingDAO().fetch("tblPatientProfileId = " + patientProfile.getId() + ";");
        if (listUsedTesting != null && !listUsedTesting.isEmpty()) {
            dataTblSelectedTesting = new Object[listUsedTesting.size()][];
            int i = 0;
            for (iEntity entity : listUsedTesting) {
                UsedTesting usedTesting = (UsedTesting) entity;
                TestingData testingData = (TestingData) new TestingDataDAO().findById(usedTesting.getTblTestingDataId());
                dataTblSelectedTesting[i++] = new Object[]{
                    testingData.getId(),
                    testingData.getName(),
                    usedTesting.getQuantity(),
                    usedTesting.getAmount(),
                    usedTesting.getTestResults(),
                    (usedTesting.getIsPaid() == 1 ? "Paid" : "Non-Paid") // for specifies with new row will be added by drag drop to save database
                };
            }
        }
        tblTesting.setModel(new javax.swing.table.DefaultTableModel(
                dataTblSelectedTesting,
                new String[]{
                    "ID", "Tên xét nghiệm", "Số lượng", "Tổng tiền", "Kết quả", "Status"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (tblTesting.getModel().getValueAt(rowIndex, 5).equals("Paid") || tblTesting.getModel().getValueAt(rowIndex, 5).equals("Non-Paid")) {
                    return false;
                }
                return canEdit[columnIndex];
            }
        });
        tblTesting.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE && tme.getColumn() == 2) {
                    int quantity = Integer.valueOf(tblTesting.getModel().getValueAt(tme.getFirstRow(), 2).toString());
                    int id = Integer.valueOf(tblTesting.getModel().getValueAt(tme.getFirstRow(), 0).toString());
                    TestingData testingData = (TestingData) new TestingDataDAO().findById(id);
                    tblTesting.getModel().setValueAt(quantity * testingData.getPrice(), tme.getFirstRow(), 3);
                }
            }
        });
        tblTesting.setTransferHandler(new view.contents.ClinicDoctorBg2TblListTransferHandler(tblTesting, listDataTesting) {
            @Override
            public void setDataRow(iEntity entity) {
                TestingData selectedObj = (TestingData) entity;
                int dropRow = tblTesting.getRowCount() - 1;
                tblTesting.setValueAt(selectedObj.getId(), dropRow, 0);
                tblTesting.setValueAt(selectedObj.getName(), dropRow, 1);
                tblTesting.setValueAt(1, dropRow, 2);
                tblTesting.setValueAt(selectedObj.getPrice(), dropRow, 3);
                tblTesting.setValueAt("Non-Saved", dropRow, tblTesting.getColumnCount() - 1);
            }
        });
        jScrollPane3.setViewportView(tblTesting);
        tblTesting.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlistDataTesting.setTransferHandler(new view.contents.ClinicDoctorBg2TblListTransferHandler(tblTesting, listDataTesting));
    }

    private void initTblSelectedMedicine() {
        dataTblSelectedMedicine = new Object[][]{};
        listUsedMedicine = new UsedMedicineDAO().fetch("tblPatientProfileId = " + patientProfile.getId() + ";");
        if (listUsedMedicine != null && !listUsedMedicine.isEmpty()) {
            dataTblSelectedMedicine = new Object[listUsedMedicine.size()][];
            int i = 0;
            for (iEntity entity : listUsedMedicine) {
                UsedMedicine usedMedicine = (UsedMedicine) entity;
                MedicineData testingData = (MedicineData) new MedicineDataDAO().findById(usedMedicine.getTblMedicineDataId());
                dataTblSelectedMedicine[i++] = new Object[]{
                    testingData.getId(),
                    testingData.getName(),
                    usedMedicine.getQuantity(),
                    usedMedicine.getAmount(),
                    (usedMedicine.getIsPaid() == 1 ? "Paid" : "Non-Paid") // for specifies with new row will be added by drag drop to save database
                };
            }
        }
        tblMedicine.setModel(new javax.swing.table.DefaultTableModel(
                dataTblSelectedMedicine,
                new String[]{
                    "ID", "Tên thuốc", "Số lượng", "Tổng tiền", "Status"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (tblMedicine.getModel().getValueAt(rowIndex, 4).equals("Paid") || tblMedicine.getModel().getValueAt(rowIndex, 4).equals("Non-Paid")) {
                    return false;
                }
                return canEdit[columnIndex];
            }
        });
        tblMedicine.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE && tme.getColumn() == 2) {
                    int quantity = Integer.valueOf(tblMedicine.getModel().getValueAt(tme.getFirstRow(), 2).toString());
                    int id = Integer.valueOf(tblMedicine.getModel().getValueAt(tme.getFirstRow(), 0).toString());
                    MedicineData testingData = (MedicineData) new MedicineDataDAO().findById(id);
                    tblMedicine.getModel().setValueAt(quantity * testingData.getPrice(), tme.getFirstRow(), 3);
                }
            }
        });
        tblMedicine.setTransferHandler(new view.contents.ClinicDoctorBg2TblListTransferHandler(tblMedicine, listDataMedicine) {
            @Override
            public void setDataRow(iEntity entity) {
                MedicineData selectedObj = (MedicineData) entity;
                int dropRow = tblMedicine.getRowCount() - 1;
                tblMedicine.setValueAt(selectedObj.getId(), dropRow, 0);
                tblMedicine.setValueAt(selectedObj.getName(), dropRow, 1);
                tblMedicine.setValueAt(1, dropRow, 2);
                tblMedicine.setValueAt(selectedObj.getPrice(), dropRow, 3);
                tblMedicine.setValueAt("Non-Saved", dropRow, tblMedicine.getColumnCount() - 1);
            }
        });
        jScrollPane5.setViewportView(tblMedicine);
        tblMedicine.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlistDataMedicine.setTransferHandler(new view.contents.ClinicDoctorBg2TblListTransferHandler(tblMedicine, listDataMedicine));
    }

    private javax.swing.JButton btnCallNextPatient;
    private javax.swing.JButton btnSaveProfile;
    private javax.swing.JButton btnBackToList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblPatienIdentityCardNumber;
    private javax.swing.JLabel lblPatientHealthInsuranceCardNumber;
    private javax.swing.JLabel lblPatientNameValue;
    private javax.swing.JLabel lblPatientDobValue;
    private javax.swing.JLabel lblPatientGenderValue;
    private javax.swing.JLabel lblPatientAddressValue;
    private javax.swing.JLabel lblPatientIdentityCardNumberValue;
    private javax.swing.JLabel lblPatientHasHealthInsuranceCardNumberValue;
    private javax.swing.JLabel lblPatientHealthInsuranceCardNumberValue;
    private javax.swing.JLabel lblFillClinicResults;
    private javax.swing.JLabel lblSelectedTesting;
    private javax.swing.JLabel lblDataTesting;
    private javax.swing.JLabel lblSelectedMedicine;
    private javax.swing.JLabel lblDataMedicine;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JLabel lblPatientDob;
    private javax.swing.JLabel lblPatientGender;
    private javax.swing.JLabel lblPatientAddress;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblPatientIsHealthInsuranceCardNumber;
    private javax.swing.JList<String> jlistDataTesting;
    private javax.swing.JList<String> jlistDataMedicine;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblTesting;
    private javax.swing.JTable tblMedicine;
    private javax.swing.JTextArea txtClinicResults;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JTextField tfPrice;
}
