package virtualecu.desktop.controller;

import virtualecu.desktop.model.EctModel;
import virtualecu.desktop.view.EctView;
import virtualecu.desktop.view.MainView;

public class EctController {
	private EctModel model;
	private EctView view;
	private MainView mainView;
	
	public EctController(EctModel model, EctView view, MainView mainView) {
		this.model = model;
		this.view = view;
		this.mainView = mainView;
		this.initView();
	}
	
	public void initView() {
		view.setGauge();
		
		mainView.addOutputWidget(
				view.prepareOutputWidget(
						view.getGauge()
						)
				);
		
		mainView.addInputWidget(
				view.prepareInputWidget(
						view.getGauge()
						)
				);
		
		mainView.build();
	}

	public void initController() {
//		view..addActionListener(e -> saveFirstname());
//		view.getLastnameSaveButton().addActionListener(e -> saveLastname());
//		view.getHello().addActionListener(e -> sayHello());
//		view.getBye().addActionListener(e -> sayBye());
	}
	
//	private void saveLastname() {
//		  model.setLastname(view.getLastnameTextfield().getText());
//		  JOptionPane.showMessageDialog(null, "Lastname saved : " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
//		 }
}
