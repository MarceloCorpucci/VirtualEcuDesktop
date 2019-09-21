package virtualecu.desktop.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eu.hansolo.steelseries.gauges.Radial;

public class EctView {
	private Radial gauge;
	
	public Radial getGauge() {
		return gauge;
	}
	
	public void setGauge() {
		gauge = new Radial();
		gauge.setTitle("ECT");
		gauge.setUnitString("Cº");
		
	}
	
	public JPanel prepareOutputWidget(Radial gauge) {
		JPanel ectPanel = new JPanel() {
			//TODO find out why an UID is required and which is its impact in automated testing.
			private static final long serialVersionUID = 1L;

			@Override 
			public Dimension getPreferredSize() {
				return new Dimension(300, 300);
			}
		};
		
		ectPanel.setLayout(new BorderLayout());
		ectPanel.add(gauge, BorderLayout.CENTER);
		
		return ectPanel;
	}
	
	public JPanel prepareInputWidget(final Radial gauge) {
		JPanel buttonsPanel = new JPanel();
		JLabel valueLabel = new JLabel("Value:");

		//TODO this could be extracted from this method to another one!
		final JTextField valueField = new JTextField(7);
		valueField.setText("30");
		JButton button = new JButton("Set");
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double value = Double.valueOf(valueField.getText());
					gauge.setValueAnimated(value);
				} catch(NumberFormatException ex) { 
					//TODO - handle invalid input 
					System.err.println("invalid input");
				}
			}
		});

		buttonsPanel.add(valueLabel);
		buttonsPanel.add(valueField);
		buttonsPanel.add(button);
		
		return buttonsPanel;
	}
}
