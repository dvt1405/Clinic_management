package util.tableCustom;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ledin
 */
public class TblColumnHeaderCheckBoxRenderer implements TableCellRenderer {
    private final JCheckBox check = new JCheckBox();

    /**
     *
     * @param header
     * @param index
     * @param tableModel
     */
    public TblColumnHeaderCheckBoxRenderer(JTableHeader header, final int index, AbstractTableModel tableModel) {
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = ((JTableHeader) e.getSource()).getTable();
                TableColumnModel columnModel = table.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int modelColumn = table.convertColumnIndexToModel(viewColumn);
                if (modelColumn == index) {
                    check.setSelected(!check.isSelected());
                    Boolean f = check.isSelected();
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        tableModel.setValueAt(f, i, index);
                    }
                    ((JTableHeader) e.getSource()).repaint();
                }
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable tbl, Object val, boolean isS, boolean hasF, int row, int col) {
        TableCellRenderer r = tbl.getTableHeader().getDefaultRenderer();
        JLabel lbl = (JLabel) r.getTableCellRendererComponent(tbl, val, isS, hasF, row, col);
        lbl.setText("");
        lbl.setHorizontalAlignment(CENTER);
        lbl.setIcon(new CheckBoxIcon(check));
        return lbl;
    }

    class CheckBoxIcon implements Icon {
        private final JCheckBox check;

        public CheckBoxIcon(JCheckBox check) {
            this.check = check;
        }

        @Override
        public int getIconWidth() {
            return check.getPreferredSize().width;
        }

        @Override
        public int getIconHeight() {
            return check.getPreferredSize().height;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            SwingUtilities.paintComponent(g, check, (Container) c, x, y, getIconWidth(), getIconHeight());
        }
    }
}
