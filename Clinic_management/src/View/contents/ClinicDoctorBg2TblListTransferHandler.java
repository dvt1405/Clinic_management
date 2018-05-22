package view.contents;

import entity.TestingData;
import entity.iEntity;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.TransferHandler.COPY;
import javax.swing.table.DefaultTableModel;

public class ClinicDoctorBg2TblListTransferHandler extends TransferHandler {

    private final JTable table;
    private final DefaultTableModel tableModel;
    private final List<iEntity> listData;
    private int selectedObjId;
    private int colsCount;

    public ClinicDoctorBg2TblListTransferHandler(JTable table, List<iEntity> listData) {
        this.table = table;
        this.tableModel = (DefaultTableModel) table.getModel();
        this.listData = listData;
        this.colsCount = tableModel.getColumnCount();
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY;
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport ts) {
        return true;
    }

    @Override
    public Transferable createTransferable(JComponent c) {
        JList list = (JList) c;
        iEntity selectedObj = (iEntity) listData.get(list.getSelectedIndex());
        int selectedObjId = selectedObj.getId();

        Object[] row = new Object[colsCount];
        for (int i = 0; i < colsCount; i++) {
            row[i] = "";
        }
        tableModel.addRow(row);

        if (list.getSelectedValue() instanceof String) {
            return new Transferable() {
                @Override
                public DataFlavor[] getTransferDataFlavors() {
                    return new DataFlavor[]{new DataFlavor(Integer.class, "Integer")};
                }

                @Override
                public boolean isDataFlavorSupported(DataFlavor flavor) {
                    return true;
                }

                @Override
                public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                    int res = list.getSelectedIndex();
                    return res;
                }
            };
        }
        return null;
    }

    public void setDataRow(iEntity entity) {

    }

    @Override
    public boolean importData(TransferHandler.TransferSupport ts) {
        JTable.DropLocation drop = (JTable.DropLocation) ts.getDropLocation();

        try {
            Transferable t = ts.getTransferable();
            Object obj = t.getTransferData(new DataFlavor(ArrayList.class, "ArrayList"));
            Integer value = (Integer) obj;
            iEntity selectedObj = (iEntity) listData.get(value);

            if (!tableModel.getValueAt(drop.getRow(), 0).equals("")) {
                return false;
            } else {
                setDataRow(selectedObj);
            }
        } catch (UnsupportedFlavorException | IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void exportDone(JComponent c, Transferable t, int action) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0) == null || tableModel.getValueAt(i, 0).equals("")) {
                tableModel.removeRow(i);
            }
        }
    }
}
