package utils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame {
	
	private static Stack<JFrame> windows = new Stack<>();
	
	protected BaseFrame(String title, int width, int height, Runnable run) {
		setTitle(title);
		setSize(width, height);	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		initDesign();
		initAction();
		setVisible(true);
	}
	
	// 닫기 버튼에서 호출하면 됨 
	public void close() {
		if (windows.isEmpty()) System.exit(0);
		windows.pop().show();
		hide();
	}
	
	public void changeFrame(JFrame frame) {
		hide();
		windows.add(this);
	}
	
	protected abstract void initDesign();
	protected abstract void initAction();

}
