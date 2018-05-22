package view.contents;

import javax.swing.table.AbstractTableModel;

public class ClinicDoctorBg1TblModel extends AbstractTableModel {
    private final String[] columnNames;
    private final Class<?>[] columnTypes;
    private Object[][] data;

    public ClinicDoctorBg1TblModel(String[] columnNames, Class<?>[] columnTypes, Object[][] data) {
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
}
