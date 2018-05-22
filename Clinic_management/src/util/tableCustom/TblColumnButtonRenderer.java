package util.tableCustom;

import util.Helper;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

public class TblColumnButtonRenderer extends DefaultTableCellRenderer {

    private int width;

    public TblColumnButtonRenderer setWidth(int width) {
        this.width = width;
        return this;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JButton btn = (JButton) value;
        Helper.setCursorBtn(btn);
        JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        lbl.setIcon(new ButtonIcon(btn));
        lbl.setText("");
        lbl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lbl.setHorizontalAlignment(CENTER);
        return lbl;
    }

    class ButtonIcon implements Icon {

        private final JButton btn;

        public ButtonIcon(JButton btn) {
            this.btn = btn;
        }

        @Override
        public int getIconWidth() {
            return width;
        }

        @Override
        public int getIconHeight() {
            return btn.getPreferredSize().height;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            SwingUtilities.paintComponent(g, btn, (Container) c, x, y, getIconWidth(), getIconHeight());
        }
    }
}
