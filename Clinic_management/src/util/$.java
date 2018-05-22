package util;

import GUI.Main;
import view.MainContent;
import view.MainHeader;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Stack;

public class $ {
    public static final Stack<Container> stPnlHeader = new Stack<>();
    public static final Stack<Container> stPnlContent = new Stack<>();
    public static final Stack<String> breakCums = new Stack<>();
    
//    public static int idUser = 1;   // for testing
    public static int idUser = 0;
    public static String typeUser = "visitor";
    
    public static Thread threadLoading = null;
    
    public static Main main;
    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int frWidth = (int)($.screenSize.width * 0.8);
    public static int frHeight = (int)($.screenSize.height * 0.8);
    public static MainHeader pnlHeader;
    public static int pnlHeaderWidth = $.frWidth;
    public static int pnlHeaderHeight = (int)($.frHeight*0.1);
    public static MainContent pnlContent;
    public static int pnlContentWidth = $.frWidth;
    public static int pnlContentHeight = $.frHeight - $.pnlHeaderHeight;
}
