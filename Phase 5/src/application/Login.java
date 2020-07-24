package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Login extends Application{

	public static void main(String[] args) {
        System.out.println("Starting Post-It Note application...\n"+ "Author: Htet Pyae Aung");
        launch(args);
    }
	
	@Override
	public void start(Stage arg0) throws Exception {
		LoginStage main = new LoginStage(200,200,50,50);
		
	}

}
