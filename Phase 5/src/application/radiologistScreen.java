package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class radiologistScreen extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	radiologistScreenStage mainWindow;
	@Override
	public void start(Stage arg0) throws Exception {
		mainWindow = new radiologistScreenStage();
	}

	public radiologistScreen() {
		System.out.println("Starting Radiologist screen layout...");
		System.out.println("Author: Anthony John Cava");
	}
	
	


}
