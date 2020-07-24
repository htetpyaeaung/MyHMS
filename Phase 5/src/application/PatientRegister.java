package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PatientRegister {

	public PatientRegister() {
		
		try {
			Stage stage = new Stage();
			GridPane base = new GridPane();
			base.setAlignment(Pos.CENTER);
			base.setHgap(15);
			base.setVgap(15);
			base.setGridLinesVisible(false);
			
			//create scene and stage
			Scene scene = new Scene(base, 500, 500);
			Stage stage1 = new Stage();
			stage1.setTitle("ALERT");
			
			//Text scenetitle = new Text("Welcome");
			//scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			//base.add(scenetitle, 0, 0, 2, 1);
			
			//creates textfield and their labels
			Label fnameL = new Label("First Name");
			base.add(fnameL, 0, 0);
			TextField fname = new TextField();
			base.add(fname, 1, 0);
			
			Label lnameL = new Label ("Last  Name");
			base.add(lnameL, 0, 1);
			TextField lname = new TextField();
			base.add(lname, 1, 1);
			
			//creaates choice box
			ChoiceBox<String> choiceBox = new ChoiceBox<>();
			choiceBox.getItems().add("Male");
			choiceBox.getItems().add("Female");
			
			Label genderL = new Label ("Gender");
			base.add(genderL, 0, 2);
			base.add(choiceBox, 1, 2);

			
			Label AddressL = new Label ("Address");
			base.add(AddressL, 0, 3);
			TextField Address = new TextField();
			base.add(Address, 1, 3);
			
			Label surburbL = new Label ("Suburb");
			base.add(surburbL, 0, 4);
			TextField surburb = new TextField();
			base.add(surburb, 1, 4);
			
			Label postL = new Label ("Post Code");
			base.add(postL, 0, 5);
			TextField post = new TextField();
			base.add(post, 1, 5);
			
			Label DOBL = new Label("DOB");
			base.add(DOBL, 0, 6);
			TextField DOB = new TextField();
			base.add(DOB, 1, 6);
			
			Label emailL = new Label ("email");
			base.add(emailL, 0, 7);
			TextField email = new TextField();
			base.add(email, 1, 7);
			
			Label phoneL = new Label ("Phone No");
			base.add(phoneL, 0, 8);
			TextField phone = new TextField();
			base.add(phone, 1, 8);
			
			Label passwordL = new Label("Password");
			base.add(passwordL, 0, 9);
			PasswordField password = new PasswordField();
			base.add(password, 1, 9);
			
			//creates submit button
			Button btn = new Button ("Submit");
			HBox hbBtn = new HBox(12);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			base.add(hbBtn, 1, 10);
			
			btn.setOnAction(e -> {
			AlertBox.display("ALERT", "Are you sure you want to submit? Please ensure details are accurate", stage1);
			});
			
			
			//creates button cancel
			Button btn1 = new Button ("Cancel");
			HBox hbBtn1 = new HBox(12);
			hbBtn.setAlignment(Pos.BOTTOM_LEFT);
			hbBtn.getChildren().add(btn1);
			base.add(hbBtn1, 1, 10);
	        btn1.setOnAction(e -> stage.close());

			
			//btn.setOnAction(new EventHandler<ActionEvent>() {
				 
			//    @Override
			//    public void handle(ActionEvent e) {
			//        actiontarget.setFill(Color.FIREBRICK);
			//        actiontarget.setText("Sign in button pressed");
			//    }
			//});
			
	        
	        stage.setTitle("Registration");
	        stage.setScene(scene);
	        stage.show();
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene);
			//primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
