package virtualecu.desktop.controller;

import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import virtualecu.desktop.model.RpmModel;
import virtualecu.desktop.view.MainView;
import virtualecu.desktop.view.RpmView;

public class RpmController {
	private RpmModel rpmModel;
	private RpmView rpmView;
	private MainView mainView;
	
	public RpmController(RpmModel rpmModel, RpmView rpmView, MainView mainView) throws FontFormatException, IOException {
		this.rpmModel = rpmModel;
		this.rpmView = rpmView;
		this.mainView = mainView;
		this.initView();
	}

	public void initView() throws FontFormatException, IOException {
		rpmView.setGauge();
		
		mainView.addOutputWidget(
				rpmView.prepareOutputWidget(
						rpmView.getGauge()
						)
				);
		
		mainView.addInputWidget(
				rpmView.prepareInputWidget()
			);
		
		mainView.build();
	}
	
	public void checkTpsAngleState() {
		rpmModel.setTpsAngle(rpmView.getTpsAngle());
		rpmView.getTpsAngleSlider().addChangeListener(e -> setRpmCalculation(e));
	}

	private void setRpmCalculation(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		rpmView.getTpsLabel().setText("" + source.getValue());
		rpmModel.setTpsAngle(source.getValue());
		
		double b = rpmModel.showGaugePointerRpms();
		rpmView.getGauge().setValueAnimated(b);
		
		double a = rpmModel.showGaugeLcdRpms();
//		rpmView.getGauge().setLcdThreshold(7000);
//		rpmView.getGauge().setLcdValueAnimated(a);
		rpmView.getRpmLabel().setText(Double.toString(a));
	}
	
}
