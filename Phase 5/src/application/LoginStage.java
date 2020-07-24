package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import Test.Login;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginStage {

	public LoginStage(double sizeX, double sizeY, double positionX, double positionY) {
		//create new stage and set position of x and y 
		Stage stage = new Stage();
		stage.setX(positionX);
		stage.setY(positionY);
		
		//different text to display in the screen layout
		Text welText = new Text("Welcome to MyHMS Portal");
		Text timeinfo = new Text("Today in Adelaide (GMT +09:30)");
		Text update = new Text ("What you can do with MyHMS Portal?");
		String info = "Manage your appointments \nAccess your test result \nAnd many More";	
		Text infoText = new Text(info);
		
		//set ID for each text to have decoration
		welText.setId("welcome-text");
		update.setId("update");
		infoText.setId("info");
		timeinfo.setId("update");
		
		//create borderpane layout for the stage
		BorderPane bp = new BorderPane();
		BorderPane.setAlignment(welText, Pos.CENTER);
		bp.setTop(welText);
		//date formate to get the current date and time
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		//assign it to text
		Text time = new Text(formatter.format(date));
		//create vbox layout to add current date time and some text
		VBox vb = new VBox();
		vb.setSpacing(10);
		//set margin for each elements
		VBox.setMargin(timeinfo, new Insets(20,20,0,20));
		VBox.setMargin(time, new Insets(0,20,10,20));
		VBox.setMargin(update, new Insets(20,20,0,20));
		VBox.setMargin(infoText, new Insets(0,20,20,20));
		
		ObservableList list = vb.getChildren();
		list.addAll(timeinfo,time,update,infoText);
		
		vb.setId("timezone-bg");
		vb.setMaxHeight(150);
		
		//Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
         
        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(100,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.TOP_CENTER); 
        
        Text text = new Text("Member Zone");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
         
        //Adding text to HBox
        hb.getChildren().add(text);
                           
         
       //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        Button btnReset = new Button("Reset");
        Button btnNewPatient = new Button("New Booking");
        final Label lblMessage = new Label();
         
        //Adding Nodes to GridPane layout
        gridPane.add(text, 0, 0, 2, 1);
        gridPane.add(lblUserName, 0, 1);
        gridPane.add(txtUserName, 1, 1);
        gridPane.add(lblPassword, 0, 2);
        gridPane.add(pf, 1, 2);

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnLogin);
        hbBtn.getChildren().add(btnReset);
        hbBtn.getChildren().add(btnNewPatient);
        gridPane.add(hbBtn, 1, 4);
        
        
        Text copy = new Text("©2020 HMS System");
        HBox hbcopy = new HBox(10);
        hbcopy.setAlignment(Pos.CENTER);
        hbcopy.getChildren().add(copy);
        gridPane.add(hbcopy, 1, 8);
        
        
        //Add ID's to Nodes
        gridPane.setId("sign-in");
        btnLogin.setId("btnLogin");
        btnReset.setId("btnLogin");
        btnNewPatient.setId("btnLogin");
        text.setId("text");
//        gridPane.setMaxWidth(500);
        
        
        Text mainText = new Text("Maintenance Notice to Portal");
		String notice = "The portal site will be in maintenance in every second\n week of the month."
				+ " We encourage you to save your\n account info before that.";
		
		Text mainInfo = new Text(notice);
		
		mainText.setId("update");
        mainInfo.setId("info");
        //Instantiating the VBox class  
        VBox vBox = new VBox();   
        
        //Setting the space between the nodes of a VBox pane 
        vBox.setSpacing(10);   
        
        //Setting the margin to the nodes 
        VBox.setMargin(mainText, new Insets(20, 20, 20, 20));  
        VBox.setMargin(mainInfo, new Insets(20, 20, 20, 20)); 
        
        //retrieving the observable list of the VBox 
        ObservableList clist = vBox.getChildren(); 
        
        //Adding all the nodes to the observable list 
        clist.addAll(mainText, mainInfo); 
        
		vBox.setMaxHeight(300);
		vBox.setId("timezone-bg");
        
        
		bp.setLeft(vb);
		bp.setCenter(gridPane);
		bp.setRight(vBox);
	
		//click event for login button
		btnLogin.setOnAction(e -> {
			//alert loading class will run in clicking to the button
			AlertLoading.display(txtUserName.getText().toString(),stage);
		});
		
		//click event for new patient button
		btnNewPatient.setOnAction(e -> {
			//booking calendar class will run in clicking to the button
			new bookingCalendar1();
			
		});
		
		Scene scene = new Scene(bp, sizeX, sizeY);
		
		
		stage.setScene(scene);
		stage.setWidth(1500);
		stage.setHeight(800);
		
		stage.setTitle("Hospital Management System");
		//link css class to the current class
		scene.getStylesheets().add(LoginStage.class.getResource("mlogin.css").toExternalForm());
		stage.show();
	}
	
	
	
}
