package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import org.controlsfx.dialog.ProgressDialog;


public class AlertBox {
	
	public static void display(String title, String message, Stage arg0) {
        
		Stage window = new Stage();
		StackPane root = new StackPane();
        VBox bx = new VBox();
        bx.setAlignment(Pos.CENTER);

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        ProgressIndicator  pi =  new ProgressIndicator();
        
        Button back = new Button ("Back");
        Button submit = new Button("Submit");
        
        //Label statusLabel = new Label();
        //statusLabel.setMinWidth(250);
        //statusLabel.setTextFill(Color.BLUE);
        
        // Start Button.
        submit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				VBox box = new VBox(pi);
				box.setAlignment(Pos.CENTER);
				
				bx.setDisable(true);
				root.getChildren().add(box);
				
				
			}
        	
        });
        
        //back button
        back.setOnAction(e -> window.close());
        back.setAlignment(Pos.CENTER_RIGHT);
        
        bx.getChildren().addAll(label,submit,back);
        root.getChildren().add(bx);
        Scene c = new Scene(root);
        arg0.setScene(c);
        arg0.setMinWidth(500);
        arg0.setMinHeight(500);
        arg0.show();
        
        
 

        //VBox layout = new VBox(10);
        //layout.getChildren().addAll(label, submit);
        //layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(bx);
        window.setScene(scene);
        window.showAndWait();
    }

}

	

	

