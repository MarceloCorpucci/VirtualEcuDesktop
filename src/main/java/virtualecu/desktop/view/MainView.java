package virtualecu.desktop.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {
	private JFrame frame;
	
	public MainView() {
		//TODO Make a builder here!
		frame = new JFrame();
		frame.setTitle("VirtualEcu Desktop");
		Dimension d = new Dimension();
		d.height = 600;
		d.width = 800;
		frame.setSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
	}
	
	public void addOutputWidget(JPanel panel) {
		frame.add(panel, BorderLayout.CENTER);
	}
	
	public void addInputWidget(JPanel panel) {
		frame.add(panel, BorderLayout.SOUTH);
	}
	
	public void build() {
		// https://stackoverflow.com/questions/8193801/how-to-set-specific-window-frame-size-in-java-swing
//		frame.pack();
		frame.setVisible(true);
	}
}
