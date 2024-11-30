package utils;

import java.awt.Dimension;

import javax.swing.JComponent;

public class GUIElement extends JComponent {

	private final JComponent component;
	private final int widthPercent;
	private final int heightPercent;
	
	GUIElement(JComponent component, int widthPercent, int heightPercent) {
		this.component = component;
		this.widthPercent = widthPercent;
		this.heightPercent = heightPercent;
	}
	
	public JComponent getElement() {
		return component;
	}
	
	public void setPercentSize(Dimension parentSize) {
		int width = parentSize.width * widthPercent / 100;
		int height = parentSize.height * heightPercent / 100;
		this.component.setPreferredSize(new Dimension(width, height));
	}
}
