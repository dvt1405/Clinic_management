package view.contents;

import util.$;
import util.Helper;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClinicDoctorPnlPatientQueue extends javax.swing.JPanel {

    private final List<iEntity> listClinicType = new ClinicTypeDAO().fetchAll();
    private List<iEntity> listRoom;
    private List<iEntity> listPatient;
    private List<iEntity> listRoomQueue;
    private int roomId;

    public ClinicDoctorPnlPatientQueue() {
        initComponents();
    }

    private void initComponents() {
        cbxClinicType = new javax.swing.JComboBox<>();
        cbxRoom = new javax.swing.JComboBox<>();
        lblTitle = new javax.swing.JLabel();
        lblSelectClinicType = new javax.swing.JLabel();
        btnCallFirstPatient = new javax.swing.JButton();
        btnCallSelectedPatient = new javax.swing.JButton();
        lblSelectRoom = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientQueue = new javax.swing.JTable();

        for (iEntity entity : listClinicType) {
            ClinicType instance = (ClinicType) entity;
            cbxClinicType.addItem(instance.getName());
        }
        cbxClinicType.setSelectedIndex(0);
        initCbxRoomByClinicTypeName(cbxClinicType.getSelectedItem().toString());

        cbxClinicType.addActionListener((java.awt.event.ActionEvent evt) -> {
            cbxClinicTypeActionPerformed(evt);
        });

        cbxRoom.addActionListener((java.awt.event.ActionEvent evt) -> {
            cbxRoomActionPerformed(evt);
        });

        lblTitle.setText("CHỨC NĂNG BÁC SỸ KHÁM BỆNH");

        lblSelectClinicType.setText("Khoa");

        btnCallFirstPatient.setText("Call first patient");
        Helper.setBorderBtn(btnCallFirstPatient);
        btnCallFirstPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallFirstPatientActionPerformed(evt);
            }
        });

        btnCallSelectedPatient.setText("Call selected patient");
        Helper.setBorderBtn(btnCallSelectedPatient);
        btnCallSelectedPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallSelectedPatientActionPerformed();
            }
        });

        lblSelectRoom.setText("Phòng");

        jScrollPane1.setViewportView(tblPatientQueue);
        tblPatientQueue.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPatientQueue.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                tblPatientQueueRowSelected();
            }
        });
        tblPatientQueue.addMouseListener(new util.tableCustom.TblClickButtonEvent(tblPatientQueue, 5));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(btnCallFirstPatient)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnCallSelectedPatient)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblSelectClinicType)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbxClinicType, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(lblSelectRoom)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbxRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, $.frWidth - 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitle)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSelectClinicType)
                                        .addComponent(cbxClinicType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSelectRoom)
                                        .addComponent(cbxRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCallFirstPatient)
                                        .addComponent(btnCallSelectedPatient))
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, $.pnlContentHeight - 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
    }

    private void callPatientByRowIndex(int index){
        Helper.openLoading();
        Patient patient = (Patient) listPatient.get(index);
        Helper.pushCard($.pnlContent, new ClinicDoctorBg2(patient, this.roomId));

//        After call first patient, remove this patient from queue
        new RoomQueueDAO().delete(listRoomQueue.get(index));
        Helper.closeLoading();
    }
    
    private void btnCallFirstPatientActionPerformed(java.awt.event.ActionEvent evt) {
        callPatientByRowIndex(0);
    }

    private void btnCallSelectedPatientActionPerformed() {
        int index = Integer.max(0, tblPatientQueue.getSelectedRow());
        callPatientByRowIndex(index);
    }

    private void cbxClinicTypeActionPerformed(java.awt.event.ActionEvent evt) {
        Helper.openLoading();
        initCbxRoomByClinicTypeName(cbxClinicType.getSelectedItem().toString());
        Helper.closeLoading();
    }

    private void initCbxRoomByClinicTypeName(String clinicTypeName) {
        listRoom = new RoomDAO().fetch("clinicType = '" + clinicTypeName + "' and type = 'clinic';");

        ActionListener[] currentListeners = cbxRoom.getActionListeners();
        for (ActionListener listener : currentListeners) {
            cbxRoom.removeActionListener(listener);
        }

        cbxRoom.removeAllItems();
        for (iEntity entity : listRoom) {
            Room instance = (Room) (entity);
            cbxRoom.addItem(instance.getName());
        }
        cbxRoom.setSelectedIndex(0);

        Room firstInstance = (Room) listRoom.get(0);
        initRoomQueueByRoomId(firstInstance.getId());

        for (ActionListener listener : currentListeners) {
            cbxRoom.addActionListener(listener);
        }
    }

    private void cbxRoomActionPerformed(java.awt.event.ActionEvent evt) {
        int index = cbxRoom.getSelectedIndex();
        Helper.openLoading();
        Room room = (Room) listRoom.get(index);
        initRoomQueueByRoomId(room.getId());
        Helper.closeLoading();
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
        btnCallSelectedPatient.setEnabled(false);
        btnCallSelectedPatient.revalidate();
        if (listPatient != null & !listPatient.isEmpty()) {
            btnCallFirstPatient.setEnabled(true);
        } else {
            btnCallFirstPatient.setEnabled(false);
        }
    }

    private void initTblPatientQueue(Object[][] data) {
        final String[] columnNames = new String[]{
            "#", "Mã bệnh nhân", "Tên", "Ngày sinh", "Bảo hiểm y tế", "Action"};
        final Class<?>[] columnTypes = new Class<?>[]{
            Integer.class, String.class, String.class, String.class, Boolean.class, JButton.class};

        tblPatientQueue.setModel(new ClinicDoctorBg1TblModel(columnNames, columnTypes, data){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return (rowIndex + 1);
                    case 5:
                        final JButton button = new JButton("Call Patient");
                        Helper.setBorderBtn(button);
                        button.addActionListener((ActionEvent ae) -> {
                            btnCallSelectedPatientActionPerformed();
                        });
                        return button;
                    default:
                        return data[rowIndex][columnIndex];
                }
            }
        });
        tblPatientQueue.setRowHeight(50);
        util.tableCustom.TblColumnTextRenderer textRenderer = new util.tableCustom.TblColumnTextRenderer();
        tblPatientQueue.getColumnModel().getColumn(0).setCellRenderer(new util.tableCustom.TblColumnIndexRenderer());
        tblPatientQueue.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblPatientQueue.getColumnModel().getColumn(1).setCellRenderer(textRenderer);
        tblPatientQueue.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblPatientQueue.getColumnModel().getColumn(2).setCellRenderer(textRenderer);
        tblPatientQueue.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblPatientQueue.getColumnModel().getColumn(3).setCellRenderer(textRenderer);
        tblPatientQueue.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblPatientQueue.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblPatientQueue.getColumnModel().getColumn(5).setCellRenderer(new util.tableCustom.TblColumnButtonRenderer().setWidth(150));
        tblPatientQueue.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    private void tblPatientQueueRowSelected() {
        if (!btnCallSelectedPatient.isEnabled()) {
            btnCallSelectedPatient.setEnabled(true);
        }
    }
                
    private javax.swing.JButton btnCallFirstPatient;
    private javax.swing.JButton btnCallSelectedPatient;
    private javax.swing.JComboBox<String> cbxClinicType;
    private javax.swing.JComboBox<String> cbxRoom;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblSelectClinicType;
    private javax.swing.JLabel lblSelectRoom;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPatientQueue;    
}
