package Utils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * JLinkButton draws a button like JLabel. Default foreground color is blue and the text is underlined on mouse hover
 * (behaviour depends on {@link #underlineMode}). Shows the hand cursor.
 * 
 * @author xmedeko
 */

public class JLinkButton extends JButton {

    /**
     *
     */
    public enum UnderlineMode {

        /**
         *
         */
        NONE, 

        /**
         *
         */
        ALWAYS, 

        /**
         *
         */
        HOVER
    };
    
    private final Color linkColor = Color.BLUE;
    private UnderlineMode underlineMode = UnderlineMode.HOVER;

    /**
     *
     */
    public JLinkButton() {
        super();
    }

    /**
     *
     * @param a
     */
    public JLinkButton(Action a) {
        super(a);
    }

    /**
     *
     * @param icon
     */
    public JLinkButton(Icon icon) {
        super(icon);
    }

    /**
     *
     * @param text
     * @param icon
     */
    public JLinkButton(String text, Icon icon) {
        super(text, icon);
    }

    /**
     *
     * @param text
     */
    public JLinkButton(String text) {
        super(text);
    }

    /**
     *
     * @param text
     * @param icon
     */
    @Override
    protected void init(String text, Icon icon) {
        super.init(text, icon);

        setFocusPainted(false);
        setMargin(null);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);
        setHorizontalAlignment(SwingConstants.LEFT);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setForeground(linkColor);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (getUnderlineMode() == UnderlineMode.HOVER) {
                    setUnderlineFont(true);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (getUnderlineMode() == UnderlineMode.HOVER) {
                    setUnderlineFont(false);
                }
            }
        });
    }

    /**
     *
     * @param underline
     */
    protected void setUnderlineFont(boolean underline) {
        Map<TextAttribute, Object> map = (Map<TextAttribute, Object>) getFont().getAttributes();
        if (underline)
            map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        else
            map.remove(TextAttribute.UNDERLINE);
        Font newFont = new Font(map);
        setFont(newFont);
    }

    /**
     *
     * @return
     */
    public UnderlineMode getUnderlineMode() {
        return underlineMode;
    }

    /**
     *
     * @param underlineMode
     * @return
     */
    public JLinkButton setUnderlineMode(UnderlineMode underlineMode) {
        this.underlineMode = underlineMode;
        switch (underlineMode) {
        case ALWAYS:
            setUnderlineFont(true);
            break;
        case NONE:
            setUnderlineFont(false);
            break;
        case HOVER: // nothing
            break;
        }

        return this;
    }
}