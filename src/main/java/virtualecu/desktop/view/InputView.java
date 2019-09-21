package virtualecu.desktop.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InputView { // extends Observable {
	public static final int DEFAULT_WIDTH = 350;
	public static final int DEFAULT_HEIGHT = 450;

	private JSlider slider;
	private JPanel sliderPanel;
	private JLabel labelValue;
	private int tpsAngle = 0;
	private ChangeListener listener;
//	private TpsWidgetChangeListener listener2;
	
	public InputView() {
		sliderPanel = new JPanel();
		JLabel title = new JLabel();
		
		title.setText("TPS position");
		sliderPanel.add(title,BorderLayout.NORTH);
		
		Border blackline = BorderFactory.createLineBorder(Color.gray);
		sliderPanel.setBorder(blackline);

		slider = new JSlider(JSlider.HORIZONTAL, 40, 90, 40);
		labelValue = new JLabel();

		
//		listener2 = new TpsWidgetChangeListener(this);
//		slider.addChangeListener(listener2);
//		labelValue.setText(Integer.toString(listener2.getTpsAngle()));
	
	}
	
	public JPanel prepareInputWidget() {
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		
		listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				JSlider source = (JSlider) event.getSource();
				labelValue.setText("" + source.getValue());
//				updateTpsAngle(source.getValue());
				if (source.getValue() == 0) setTpsAngle(slider.getValue()); 
				if (source.getValue() != 0) setTpsAngle(source.getValue());
			}
		};

		slider.addChangeListener(listener);
	    JPanel panel = new JPanel();
	    panel.add(slider);
	    panel.add(new JLabel("Angle:"));
	    sliderPanel.add(panel);
	    sliderPanel.add(labelValue, BorderLayout.SOUTH);
	    
		return sliderPanel;
	}
	
	public void setTpsAngle(int angle) {
		this.tpsAngle = angle;
	}
	
	public int getTpsAngle() {
		return this.tpsAngle;
	}
	
//	public int getTpsAngle() {
////		setChanged();
////		notifyObservers((float)this.slider.getValue());
////		return listener2.getTpsAngle();
//	}	
//	
//	public void updateTpsAngle(int value) {
//		setChanged();
//		notifyObservers((float)value);
//	}
	
//	public JSlider getSlider() {
//		return slider;
//	}
//
//	public void setSlider(JSlider slider) {
//		this.slider = slider;
//	}
//
//	public JLabel getLabelValue() {
//		return labelValue;
//	}
//
//	public void setLabelValue(JLabel labelValue) {
//		this.labelValue = labelValue;
//	}
//	
//	
//	public void setTpsAngle(int angle) {
//		this.tpsAngle = angle;
//	}

}
