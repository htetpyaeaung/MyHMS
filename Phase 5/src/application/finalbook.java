package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class finalbook {
	private Stage stage;
	private DatePicker checkInDatePicker;
	Button done;
	
	public finalbook(){
		
		stage = new Stage();
		stage.setHeight(800);
        stage.setWidth(1500);
        HBox root = new HBox();
        checkInDatePicker = new DatePicker();
     
        
        
        Label ID = new Label("Your Referrence ID: 11025489");
        Label other = new Label("An Email has been sent for confirmation");
        
        
        Button done = new Button("Done");
        EventHandler<ActionEvent> doneButton = new EventHandler<ActionEvent>(){
    		@Override public void handle(ActionEvent e){
    	
    		
    		
    		
    		stage.close();
    		
    	
    		}
    		};
    		
    		done.setOnAction(doneButton);
        
		 
		
        
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
		GridPane grid = new GridPane();
		
		
		
		
		
		Scene scene = new Scene(root);
		
		
		
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        
        
        grid.add(ID, 0, 0);       
        grid.add(other, 0, 1);
        
        grid.add(done, 1, 6);
		
        root.getChildren().addAll(grid);
        
        
        stage.setScene(scene);
		stage.show();

		
	}
	

}
