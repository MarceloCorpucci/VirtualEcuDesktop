package virtualecu.desktop.controller;

import virtualecu.desktop.model.RpmModel;
import virtualecu.desktop.view.InputView;

public class InputController {
	private RpmModel rpmModel;
	private InputView inputView;
	
	public InputController(RpmModel rpmModel, InputView inputView) {
		this.rpmModel = rpmModel;
		this.inputView = inputView;
	}

}
