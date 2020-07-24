package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class booking extends Application{
	
	
	private Stage stage;
	Button booking;
    Font buttonFont;
	
	
	public static void main(String[] args) {
		System.out.println("Starting Post-It Note application...");
		System.out.println("Author:Pham Gia Huy");
		
		launch(args);
        
    }

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		this.stage = stage;
	
		stage.setHeight(800);
        stage.setWidth(1500);
        HBox root = new HBox();
        booking = new Button("Booking");
        
        
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        GridPane grid = new GridPane();
        Scene scene = new Scene(root);
        
        
		
		grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.add(booking, 0, 0);
        
        root.getChildren().addAll(grid);
        
        stage.setScene(scene);
        
       
		stage.show();
		
		
		EventHandler<ActionEvent> bookingButton = new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
		
			
			
			new bookingCalendar1();
			stage.close();
			
		
			}
			};
			
				booking.setOnAction(bookingButton);
        
        
	}
	
	public booking() {
		
	}



	

}
