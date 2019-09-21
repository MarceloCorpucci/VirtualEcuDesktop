package virtualecu.desktop.controller;

import java.awt.FontFormatException;
import java.io.IOException;

import virtualecu.desktop.view.InputView;
import virtualecu.desktop.view.MainView;
import virtualecu.desktop.view.RpmView;

public class MainController {
	private MainView mainView;
	private InputView inputView;
	private RpmView rpmView;
	
	public MainController(MainView view, InputView inputView, RpmView rpmView) throws FontFormatException, IOException {
		this.mainView = view;
		this.inputView = inputView;
		this.rpmView = rpmView;
		this.initView();
	}
	
	public void initView() throws FontFormatException, IOException {
		mainView.addInputWidget(
			inputView.prepareInputWidget()
		);
		
		rpmView.setGauge();
		mainView.addOutputWidget(
			rpmView.prepareOutputWidget(
				rpmView.getGauge()
			)
		);
		mainView.build();
	}
}
