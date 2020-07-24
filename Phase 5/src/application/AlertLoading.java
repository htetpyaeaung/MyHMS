package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertLoading {
	private static int secCurrent = 0;
	
	public static void display(String user, Stage s) {
		//instantiate new stage
		Stage window = new Stage();		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setMinWidth(250);
		//logo for each popup window 
		Text logo = new Text("!");
		logo.setFont(Font.font("Calibri", FontWeight.BOLD,70));
		logo.setFill(Color.DARKRED);

		Text load = new Text("Checking the Credemtials");
		//initialise the current second to zero
		secCurrent = 0;
		//create new progress bar 
		ProgressBar progress = new ProgressBar(0);
        progress.setMinWidth(400);
        progress.setId("bar-colour");
        
        //this layout will be used to position progress bar, logo and text
        BorderPane loadbar = new BorderPane();
        loadbar.setLeft(logo);
        loadbar.setTop(load);
        loadbar.setCenter(progress);
		BorderPane.setAlignment(progress, Pos.CENTER);
		loadbar.setPadding(new Insets(30));
		

		BorderPane signinForm = new BorderPane();
		signinForm.setCenter(loadbar);
		
		Scene signnScene = new Scene(signinForm, 500, 300);			
		window.setScene(signnScene);
		//link current scene with css form
		signnScene.getStylesheets().add(AlertLoading.class.getResource("progress.css").toExternalForm());
		
		//the following is used to fill the progress bar
        Timer myTimer = new Timer();
        TimerTask task = new TimerTask() {

			@Override
			public void run() {
				//as the secCurrent pass, it is increased to one and progress bar value will set accordingly
				secCurrent++;

				if (secCurrent == 1) {						
					progress.setProgress(0.1);
				}
				if (secCurrent == 3) {
					progress.setProgress(0.4);
				}
				if (secCurrent == 4) {
					progress.setProgress(0.6);
				}
				if (secCurrent == 5) {
					progress.setProgress(0.8);
				}
				if (secCurrent == 6) {
					progress.setProgress(1);
				}
				if (secCurrent == 7) {
					load.setText("You have successfully sign-in. Please close the window");
					progress.setVisible(false);
					myTimer.cancel();
					
				}
				
			}
        	
        };
        
        myTimer.scheduleAtFixedRate(task, 1000, 1000);
        //checking login credentials for each user
        if(user.equals("radio121")) {
        	//window will show and wait
        	window.showAndWait();
        	//login window will close
        	s.close();
        	//current window will close when user click on close button
        	window.close();
        	// and user page will appear
        	radiologistScreenStage mainWindow = new radiologistScreenStage();
			
        }
        else if(user.equals("pp000265")) {
        	window.showAndWait();
        	s.close();
        	window.close();
        	PatientRegister pr = new PatientRegister();
        }
        else {
        	//if there is no match, set the text to error
        	Text error = new Text("Error!!");
        	//display that text in the middle of the scene
        	signinForm.setCenter(error);
        	//window will show and close
        	window.show();
        	window.close();
        }
        
				
	}
}
