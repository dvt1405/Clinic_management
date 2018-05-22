package view.contents;

import javax.swing.table.AbstractTableModel;

public class ClinicDoctorBg2TblTestingModel extends AbstractTableModel {

    private final String[] columnNames;
    private final Class<?>[] columnTypes;
    private Object[][] data;

    public ClinicDoctorBg2TblTestingModel(String[] columnNames, Class<?>[] columnTypes, Object[][] data) {
        this.columnNames = columnNames;
        this.columnTypes = columnTypes;
        this.data = data;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            data[rowIndex][columnIndex] = value;
        }
    }

    public int getGid(int rowIndex) {
        return (int) data[rowIndex][getColumnCount()];
    }

    public void removeRow(int row) {
        Object[][] temp = new Object[][]{};
        for (int i = 0; i < data.length; i++) {
            if (i != row) {
                temp[i] = data[i];
            } else {
                i--;
                continue;
            }
        }
        fireTableRowsDeleted(row, row);
    }

    public void insertRow(Object[][] newData) {
        data = newData;
        fireTableRowsInserted(0, 0);
//        table.repaint();
    }
}
