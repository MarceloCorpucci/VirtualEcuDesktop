package virtualecu.desktop;

import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.SwingUtilities;

import virtualecu.desktop.controller.RpmController;
import virtualecu.desktop.model.RpmModel;
import virtualecu.desktop.view.MainView;
import virtualecu.desktop.view.RpmView;

public class App {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainView mainView = new MainView();
				RpmView rpmView = new RpmView();

				RpmModel rpmModel = new RpmModel();

				RpmController rpmController;
				try {
					rpmController = new RpmController(rpmModel, rpmView, mainView);
					rpmController.checkTpsAngleState();
				} catch (FontFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	}
}	
