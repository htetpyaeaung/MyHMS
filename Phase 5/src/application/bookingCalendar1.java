package application;
import java.time.LocalDate;

//import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class bookingCalendar1{
	
	private Stage stage;
	private DatePicker checkInDatePicker;
	
	public bookingCalendar1(){
		
		stage = new Stage();
		stage.setHeight(800);
        stage.setWidth(1500);
        HBox root = new HBox();
        checkInDatePicker = new DatePicker();
        
        
        checkInDatePicker.setValue(LocalDate.now());
        
        DatePickerSkin dps = new DatePickerSkin(checkInDatePicker);
        
        Node popUpContent = dps.getPopupContent();
        
        
        
        for (Node node : popUpContent.lookupAll(".day-cell")) {
            node.setOnMouseClicked((event) -> {
                DateCell dateCell = (DateCell) node;
                System.out.println("You clicked: " + dateCell.getText());
                new timeSlot(dateCell.getText());
                stage.close();
                
            });
        }
        
        
        Label checkInlabel = new Label("Appointment Date:");
		 
		
        
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
		GridPane grid = new GridPane();
		
		
		
		
		
		Scene scene = new Scene(root);
		
		
		
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.add(checkInlabel, 0, 0);
        
        
        grid.add(popUpContent, 0, 1);
		
        root.getChildren().addAll(grid);
        
        
        stage.setScene(scene);
		stage.show();

		
	}
	

}