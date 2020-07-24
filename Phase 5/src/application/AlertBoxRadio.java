package application;

import java.util.Timer;
import java.util.TimerTask;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertBoxRadio {
	
	private static int secondPassed = 0;
	
	public static void display() {
		
		Stage window = new Stage();		
		window.initModality(Modality.APPLICATION_MODAL);
		window.initStyle(StageStyle.UNDECORATED);
		window.setMinWidth(250);
		
		Text logo = new Text("!");
		logo.setFont(Font.font("Calibri", FontWeight.BOLD,70));
		logo.setFill(Color.DARKRED);
		
		Text headerMessage = new Text("Are you sure you are done and wish to submit this diagnosis?");
		headerMessage.setFont(Font.font("Calibri", FontWeight.BOLD,16));
		
		BorderPane confirmSubmitHeader = new BorderPane();
		confirmSubmitHeader.setLeft(logo);
		confirmSubmitHeader.setCenter(headerMessage);
		
		BorderPane confirmSubmitLayout = new BorderPane();
		confirmSubmitLayout.setPadding(new Insets(10, 10, 10, 10));
		confirmSubmitLayout.setTop(confirmSubmitHeader);

		Button submitButton = new Button("Submit");
		Button cancelButton = new Button("Cancel");
		
		GridPane buttonLayout = new GridPane();
		GridPane.setConstraints(cancelButton, 0, 0);
		GridPane.setConstraints(submitButton, 1, 0);

		buttonLayout.setAlignment(Pos.CENTER);
		buttonLayout.setHgap(30);
		
		cancelButton.setPrefSize(100, 50);
		submitButton.setPrefSize(100, 50);
		
		buttonLayout.getChildren().add(submitButton);
		buttonLayout.getChildren().add(cancelButton);
		
		confirmSubmitLayout.setCenter(buttonLayout);
		
		//-------------------------------------------------------------------------------------------
		
		submitButton.setOnAction(e -> {
			secondPassed = 0;
			
			Image doneI = new Image("done.png");
		    ImageView doneIV=new ImageView(doneI);
		    doneIV.setFitHeight(80);
		    doneIV.setFitWidth(80);
		    doneIV.setVisible(false);
		    
	        ProgressBar progress = new ProgressBar(0);
	        progress.setMinWidth(400);
	        
	        cancelButton.setText("Done");	
			cancelButton.setVisible(false);
			
			BorderPane animation = new BorderPane();
			animation.setTop(doneIV);
			animation.setCenter(progress);
			animation.setBottom(cancelButton);
			BorderPane.setAlignment(doneIV, Pos.BOTTOM_CENTER);
			BorderPane.setAlignment(progress, Pos.CENTER);
			BorderPane.setAlignment(cancelButton, Pos.TOP_CENTER);
			animation.setPadding(new Insets(30));
	        
			BorderPane submissionLayout = new BorderPane();
			submissionLayout.setTop(confirmSubmitHeader);
			submissionLayout.setCenter(animation);

			Scene submissionScene = new Scene(submissionLayout, 500, 300);			
			window.setScene(submissionScene);
				      
			headerMessage.setText("Submitting...");
	        
	        Timer myTimer = new Timer();
	        TimerTask task = new TimerTask() {
				
				public void run() {
					secondPassed++;

					if (secondPassed == 1) {						
						progress.setProgress(0.1);
						headerMessage.setText("Preparing submission...");
					}
					if (secondPassed == 2) {
						progress.setProgress(0.2);
						headerMessage.setText("Submitting diagnosis to patient's physician...");
					}
					if (secondPassed == 3) {
						progress.setProgress(0.4);
						headerMessage.setText("Notifying the physician via email...");
					}
					if (secondPassed == 4) {
						progress.setProgress(0.6);
						headerMessage.setText("Notifying radiographer of task completion...");
					}
					if (secondPassed == 5) {
						progress.setProgress(0.8);
						headerMessage.setText("Updating job status...");
					}
					if (secondPassed == 6) {
						progress.setProgress(1);
						headerMessage.setText("Sending details to patient's records...");
					}
					if (secondPassed == 7) {
						headerMessage.setText("Successfully submitted diagnosis for Mr. Buddy Olson!");
					    doneIV.setVisible(true);
						progress.setVisible(false);
					}
					
					if (secondPassed == 8) {
						cancelButton.setVisible(true);
						myTimer.cancel();
					}
				}				
			};			
			myTimer.scheduleAtFixedRate(task, 1000, 1000);
		});		
		
		//-------------------------------------------------------------------------------------------
		cancelButton.setOnAction(e -> {
			window.close();	
		});		
		
		Scene confirmSubmitScene = new Scene(confirmSubmitLayout, 500, 300);
		window.setScene(confirmSubmitScene);
		window.showAndWait();
	}
	
}
