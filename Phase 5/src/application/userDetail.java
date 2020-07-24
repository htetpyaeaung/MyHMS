package application;
import java.time.LocalDate;

//import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class userDetail{
	
	private Stage stage;
	private DatePicker checkInDatePicker;
	Button done;
	
	public userDetail(){
		
		stage = new Stage();
		stage.setHeight(800);
        stage.setWidth(1500);
        HBox root = new HBox();
        checkInDatePicker = new DatePicker();
     
        
        
        Label name = new Label("Name:");
        Label DoB = new Label("Date of Birth:");
        Label address = new Label("Address:");
        Label gender = new Label("Gender:");
        Label email = new Label("Email:");
        Label mh = new Label("medical History:");
        
        final TextField addName = new TextField();
        final TextField addDoB = new TextField();
        final TextField addAddress = new TextField();
        final TextField addGender = new TextField();
        final TextField addEmail = new TextField();
        final TextField addMH = new TextField();
        
        Button done = new Button("Done");
        EventHandler<ActionEvent> doneBut = new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
		
			
			
			new finalbook();
			stage.close();
		
			}
			};
			
				done.setOnAction(doneBut);
        
		 
		
        
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
		GridPane grid = new GridPane();
		
		
		
		
		
		Scene scene = new Scene(root);
		
		
		
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        
        
        grid.add(name, 0, 0);       
        grid.add(DoB, 0, 1);
        grid.add(address, 0, 2);
        grid.add(gender, 0, 3);
        grid.add(email, 0, 4);
        grid.add(mh, 0, 5);
        grid.add(addName, 1, 0);
        grid.add(addDoB, 1, 1);
        grid.add(addAddress, 1, 2);
        grid.add(addGender, 1, 3);
        grid.add(addEmail, 1, 4);
        grid.add(addMH, 1, 5);
        
        grid.add(done, 1, 6);
		
        root.getChildren().addAll(grid);
        
        
        stage.setScene(scene);
		stage.show();

		
	}
	

}