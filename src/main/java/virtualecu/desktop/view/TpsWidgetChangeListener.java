package virtualecu.desktop.view;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TpsWidgetChangeListener implements ChangeListener {
	private InputView inputView;
	
	public TpsWidgetChangeListener(InputView inputView) {
		this.inputView = inputView;
	}
	
	@Override
	public void stateChanged(ChangeEvent event) {
//		JSlider source = (JSlider) event.getSource();
////		label.setText("" + source.getValue());
//		setTpsAngle(source.getValue());
//		
//		if(getTpsAngle() != 0 ) { 
//			setTpsAngle(source.getValue()); 
//		} else { 
//			setTpsAngle(40); 
//		}
	
	}

}
