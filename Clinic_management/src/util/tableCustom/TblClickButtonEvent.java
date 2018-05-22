package util.tableCustom;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;

public class TblClickButtonEvent extends MouseAdapter {
    private final JTable table;
    private final int columnButton;

    public TblClickButtonEvent(JTable table, int columnButton) {
        this.table = table;
        this.columnButton = columnButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = table.getColumnModel().getColumnIndexAtX(e.getX());    // get the coloum of the button
        int row = e.getY()/table.getRowHeight();    //get the row of the button

        if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
            if (column == columnButton){
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton)
                    ((JButton) value).doClick();
            }
        }
    }
}