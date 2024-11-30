package utils;

import java.awt.Font;

import javax.swing.JOptionPane;

public class Common {
	
	public static Font title = new Font("맑은 고딕", 1, 17);
	
	public static void infoMessage(String t) {
		JOptionPane.showMessageDialog(null, t,"정보",1);
	}
	
	public static void errorMessage(String t) {
		JOptionPane.showMessageDialog(null, t,"경고",0);
	}

}
