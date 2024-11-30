package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RatioPanel extends JPanel{
	
	private List<GUIElement> elements = new ArrayList<>();
	
	public RatioPanel(FlowLayout flow) {
		setLayout(flow);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				revalidateAll();
				super.componentResized(e);
			}
		});
	}
	
	public void add(JComponent comp, int widthPercent, int heightPercent) {
		addElement(new GUIElement(comp, widthPercent, heightPercent));
	}
	
	public void addLine(int heightPercent) {
		addElement(new GUIElement(new JLabel(), 100, heightPercent));
	}
	
	private void addElement(GUIElement element) {
		this.elements.add(element);
		this.add(element.getElement());
	}
	
	private void revalidateAll() {
		elements.forEach(element -> element.setPercentSize(getSize()));
		revalidate();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}
