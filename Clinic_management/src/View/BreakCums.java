package View;

import Utils.$;
import Utils.Helper;
import Utils.JLinkButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BreakCums extends JPanel {
    private final JButton btnBack = new JButton("Quay Lại");
    
    private void initBtnBack(){
        Helper.setBorderBtn(btnBack);
        btnBack.addActionListener((ActionEvent ae) -> {
            Helper.popCard($.pnlContent);
        });
        add(btnBack);
    }
    
    private void initBtnBack(JTabbedPane root){
        Helper.setBorderBtn(btnBack);
        btnBack.addActionListener((ActionEvent ae) -> {
            root.setSelectedIndex(root.getSelectedIndex() - 1);
        });
        add(btnBack);
    }
    
    private void initBreakCumsText(){
        JLabel tempSpace = new JLabel("");
        tempSpace.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
        add(tempSpace);
        
        int countBreakCums = $.breakCums.size();
        for(int i=1; i<=countBreakCums; i++){
            String txtBreakCum = $.breakCums.elementAt(i-1);
            if(i == countBreakCums)
                add(new JLabel(txtBreakCum));
            else{
                JLinkButton button = new JLinkButton(txtBreakCum);
                int numStToPop = countBreakCums - i;
                
                button.addActionListener((ActionEvent ae) -> {
                    Helper.popBreakCum(numStToPop);
                });
                        
                add(button);
                add(new JLabel(">"));
            }
        }
    }
    
    private void setStyle(){
        setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        setPreferredSize(new Dimension(this.getWidth(), 50));
    }
    
    public BreakCums(){
        setStyle();
        initBtnBack();
        initBreakCumsText();
    }
    
    public BreakCums(JTabbedPane root){
        setStyle();
        initBtnBack(root);
        initBreakCumsText();
    }
}
