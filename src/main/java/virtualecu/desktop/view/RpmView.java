package virtualecu.desktop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;

import eu.hansolo.steelseries.gauges.Radial;

public class RpmView {
	private JSlider tpsSlider;
	private JPanel tpsPanel;
	private JLabel tpsLabel;
	private JLabel rpmLabel;
	private int tpsAngle = 0;
	private Radial rpmGauge;
	
	public RpmView() {
		tpsPanel = new JPanel();
		JLabel title = new JLabel();
		
		title.setText("TPS position");
		tpsPanel.add(title,BorderLayout.NORTH);
		
		Border blackline = BorderFactory.createLineBorder(Color.gray);
		tpsPanel.setBorder(blackline);

		tpsSlider = new JSlider(JSlider.HORIZONTAL, 40, 90, 40);
		tpsLabel = new JLabel();
		rpmLabel = new JLabel();
		tpsLabel.setText("40");
		rpmLabel.setText("0");
		this.setTpsAngle(40);
	}
	
	public Radial getGauge() {
		return rpmGauge;
	}
	
	public JLabel getRpmLabel() {
		return rpmLabel;
	}
	
	public void setGauge() throws FontFormatException, IOException {
		//TODO Implement builder or factory!!!
	
//		Font font;
//		font = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getClassLoader().getResource("digital-7.ttf").getFile()));
//		font = font.deriveFont(Font.PLAIN);
		
		rpmGauge = new Radial();
		rpmGauge.setTitle("Engine Speed");
		rpmGauge.setUnitString("RPM (x1000)");
		rpmGauge.setLcdVisible(false);
//		rpmGauge.setLcdColor(LcdColor.STANDARD_GREEN_LCD);
//		rpmGauge.setLcdUnitStringVisible(true);
//		rpmGauge.setLcdUnitString("RPMs");
//		rpmGauge.setLcdUnitFont(font);
//		rpmGauge.setLcdValueFont(font);
//		rpmGauge.setLcdInfoFont(font);
		rpmGauge.setMaxValue(8);
	}
	
	public void setTpsAngle(int angle) {
		this.tpsAngle = angle;
	}
	
	public int getTpsAngle() {
		return this.tpsAngle;
	}
	
	public JSlider getTpsAngleSlider() {
		return this.tpsSlider;
	}
	
	public JLabel getTpsLabel() {
		return this.tpsLabel;
	}
	
	public JPanel prepareInputWidget() {
		tpsSlider.setPaintTicks(true);
		tpsSlider.setPaintLabels(true);
		tpsSlider.setMajorTickSpacing(10);
		tpsSlider.setMinorTickSpacing(5);
		
	    JPanel panel1 = new JPanel();
	    panel1.add(tpsSlider);
	    panel1.add(new JLabel("Angle:"));
	    tpsPanel.add(panel1);
	    tpsPanel.add(tpsLabel, BorderLayout.SOUTH);
	    
	    JPanel panel2 = new JPanel();
	    panel2.add(new JLabel("RPMs:"));
	    tpsPanel.add(panel2);
	    tpsPanel.add(rpmLabel, BorderLayout.SOUTH);
	    
		return tpsPanel;
	}
	
	public JPanel prepareOutputWidget(Radial gauge) {
		JPanel rpmPanel = new JPanel() {
			//TODO find out why an UID is required and which is its impact in automated testing.
			private static final long serialVersionUID = 1L;

			@Override 
			public Dimension getPreferredSize() {
				return new Dimension(150,150);
			}
		};
		
		rpmPanel.setLayout(new BorderLayout());
		rpmPanel.add(gauge, BorderLayout.CENTER);
		
		return rpmPanel;
	}

}
