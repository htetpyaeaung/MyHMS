package application;

import java.io.File;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class radiologistScreenStage {

	public radiologistScreenStage() {
		Stage stage = new Stage();
		Image chest = new Image("chestXray.jpg");
		Image skull = new Image("skullXray.jpg");
		Image lungs = new Image("lungXray.jpg");
		Image brain = new Image("brainXray.jpg");
		Image lungs2 = new Image("lungXray2.jpg");
		Font labelFont = Font.font("Arial", FontWeight.BOLD,13);
		
		/*
		 * HEADER
		 * Layout and elements of the TOP pane of the window.		
		 */
		// Toolbar
		TabPane toolBarTabPane = new TabPane();
		Tab imageToolBar = new Tab("Image Toolbar");	
		imageToolBar.setClosable(false);
		toolBarTabPane.getTabs().add(imageToolBar);

		ToolBar toolbar = new ToolBar();
		imageToolBar.setContent(toolbar);
	    
	    Image zoomInI=new Image("zoomIn.png");
	    ImageView zoomInIV=new ImageView(zoomInI);
	    zoomInIV.setFitHeight(16);
	    zoomInIV.setFitWidth(16);
	    
	    Image zoomOutI=new Image("zoomOut.png");
	    ImageView zoomOutIV=new ImageView(zoomOutI);
	    zoomOutIV.setFitHeight(16);
	    zoomOutIV.setFitWidth(16);
	    
	    Image editI=new Image("edit.png");
	    ImageView editIV=new ImageView(editI);
	    editIV.setFitHeight(16);
	    editIV.setFitWidth(16);
	    
	    Image eraseI=new Image("erase.png");
	    ImageView eraseIV=new ImageView(eraseI);
	    eraseIV.setFitHeight(16);
	    eraseIV.setFitWidth(16);

	    Image insertCommentI=new Image("insertComment.png");
	    ImageView insertCommentIV=new ImageView(insertCommentI);
	    insertCommentIV.setFitHeight(16);
	    insertCommentIV.setFitWidth(16);
	    
	    Image downloadI=new Image("download.png");
	    ImageView downloadIV=new ImageView(downloadI);
	    downloadIV.setFitHeight(16);
	    downloadIV.setFitWidth(16);
	    
		Button zoomIn = new Button("", zoomInIV);		
		Button zoomOut = new Button("", zoomOutIV);
		Button draw = new Button("", editIV);
		Button erase = new Button("", eraseIV);
		Button insertComment = new Button("", insertCommentIV);
		Button downloadImage = new Button("", downloadIV);
		Button moreOptions = new Button("More Options...");

		toolbar.getItems().addAll(zoomIn, zoomOut, draw, erase, insertComment,
				downloadImage, moreOptions);
		
		// Back button
	    Image backButtonI=new Image("back.png");
	    ImageView backButtonIV=new ImageView(backButtonI);
		Button backButton = new Button("", backButtonIV);
		backButtonIV.setFitHeight(40);
		backButtonIV.setFitWidth(60);
		backButton.setPrefHeight(72);

		BorderPane headerLayout = new BorderPane();

		headerLayout.setLeft(backButton);
		headerLayout.setCenter(toolBarTabPane);
		
		/*
		 * IMAGES
		 * Layout and elements of the LEFT pane of the window.		
		 */
		ScrollPane imagesScrollPane = new ScrollPane();
		imagesScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

		TabPane imagesTabPane = new TabPane();
		Tab imagesTab = new Tab("Images");
		imagesTab.setClosable(false);
		imagesTabPane.getTabs().add(imagesTab);
		
		GridPane imagesGrid = new GridPane();
		
		ImageView chestThumbnailIV = new ImageView(chest);
		chestThumbnailIV.setFitHeight(150);
		chestThumbnailIV.setFitWidth(150);	
		ImageView skullThumbnailIV = new ImageView(skull);
		skullThumbnailIV.setFitHeight(150);
		skullThumbnailIV.setFitWidth(150);
		ImageView lungsThumbnailIV = new ImageView(lungs);
		lungsThumbnailIV.setFitHeight(150);
		lungsThumbnailIV.setFitWidth(150);
		ImageView lungs2ThumbnailIV = new ImageView(lungs2);
		lungs2ThumbnailIV.setFitHeight(150);
		lungs2ThumbnailIV.setFitWidth(150);
		ImageView brainThumbnailIV = new ImageView(brain);
		brainThumbnailIV.setFitHeight(150);
		brainThumbnailIV.setFitWidth(150);
		
		Label chestLabel = new Label("Chest");
		Label skullLabel = new Label("Skull");
		Label lungsLabel = new Label("Lungs");
		Label lungs2Label = new Label("Lungs2");
		Label brainLabel = new Label("Brain");
		
		chestLabel.setFont(labelFont);
		chestLabel.setTextFill(Color.WHITE);
		skullLabel.setFont(labelFont);
		skullLabel.setTextFill(Color.WHITE);
		lungsLabel.setFont(labelFont);
		lungsLabel.setTextFill(Color.WHITE);
		lungs2Label.setFont(labelFont);
		lungs2Label.setTextFill(Color.WHITE);
		brainLabel.setFont(labelFont);
		brainLabel.setTextFill(Color.WHITE);
		
		GridPane.setHalignment(chestLabel, HPos.CENTER);
		GridPane.setHalignment(skullLabel, HPos.CENTER);
		GridPane.setHalignment(lungsLabel, HPos.CENTER);
		GridPane.setHalignment(lungs2Label, HPos.CENTER);
		GridPane.setHalignment(brainLabel, HPos.CENTER);
		
		GridPane.setConstraints(chestLabel, 0, 0);
		GridPane.setConstraints(chestThumbnailIV, 0, 1);
		GridPane.setConstraints(skullLabel, 0, 2);
		GridPane.setConstraints(skullThumbnailIV, 0, 3);
		GridPane.setConstraints(lungsLabel, 0, 4);
		GridPane.setConstraints(lungsThumbnailIV, 0, 5);
		GridPane.setConstraints(lungs2Label, 0, 6);
		GridPane.setConstraints(lungs2ThumbnailIV, 0, 7);
		GridPane.setConstraints(brainLabel, 0, 8);
		GridPane.setConstraints(brainThumbnailIV, 0, 9);
		
		imagesGrid.getChildren().addAll(chestThumbnailIV, skullThumbnailIV, lungsThumbnailIV,
				lungs2ThumbnailIV, brainThumbnailIV, chestLabel, skullLabel, lungsLabel, lungs2Label, brainLabel);
		imagesGrid.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));		
		imagesTab.setContent(imagesGrid);
		imagesScrollPane.setContent(imagesTabPane);		
		
		/*
		 * PATIENT DETAILS
		 * Layout and elements of the RIGHT pane of the window.		
		 */
		TabPane patientDetailsTabPane = new TabPane();
		patientDetailsTabPane.setTabMinWidth(100);

		Tab tabPatient = new Tab("Patient Details");
		tabPatient.setClosable(false);
		patientDetailsTabPane.getTabs().add(tabPatient);

		BorderPane saveAndSubmitButtonLayout = new BorderPane();
		saveAndSubmitButtonLayout.setPadding(new Insets(15));
		Button saveButton = new Button("Save");
		saveButton.setPrefSize(100, 50);
		Button submitButton = new Button("Submit");
		submitButton.setPrefSize(100, 50);
		saveAndSubmitButtonLayout.setLeft(saveButton);
		saveAndSubmitButtonLayout.setRight(submitButton);

		BorderPane patientDetailsLayout = new BorderPane();
		patientDetailsLayout.setCenter(patientDetailsTabPane);
		patientDetailsLayout.setBottom(saveAndSubmitButtonLayout);
		
		GridPane patientDetailsGridLayout = new GridPane();
		patientDetailsGridLayout.setPadding(new Insets(12));
		patientDetailsGridLayout.setHgap(20);
		patientDetailsGridLayout.setVgap(10);

		Label jobIDLabel = new Label("Job ID");
		Label patientIDLabel = new Label("Patient ID");
		Label patientNameLabel = new Label("Patient Name");
		Label ageLabel = new Label("Age");
		Label physicianLabel = new Label("Physician");
		Label physicianNumberLabel = new Label("Physician Number");
		Label physicianNotesLabel = new Label("Physician Notes");
			
		jobIDLabel.setFont(labelFont);
		patientIDLabel.setFont(labelFont);
		patientNameLabel.setFont(labelFont);
		ageLabel.setFont(labelFont);
		physicianLabel.setFont(labelFont);
		physicianNumberLabel.setFont(labelFont);
		physicianNotesLabel.setFont(labelFont);
		Label xjobID = new Label("J001");
		Label xpatientID = new Label("P001");
		Label xpatientName = new Label("Buddy Olson");
		Label xage = new Label("32");
		Label xphysician = new Label("Dr. Nancy Lindsay");
		Label xphysicianNumber = new Label("0401-555-5555");				
		Label xphysicianNotes = new Label("Patient is a 32 year old male coming in for a difficulty in breathing. History started 3 days prior when he had onset of fever associated with coughing episodes. In the interim, symptoms perisisted already associated with difficuly in breathing. Hence, consult.");
		xphysicianNotes.setMaxWidth(230);
		xphysicianNotes.setWrapText(true);
		xphysicianNotes.setTextAlignment(TextAlignment.JUSTIFY);
		GridPane.setColumnSpan(xphysicianNotes, 2);
		
		GridPane.setConstraints(jobIDLabel, 0, 1);
		GridPane.setConstraints(patientIDLabel, 0, 2);
		GridPane.setConstraints(patientNameLabel, 0, 3);
		GridPane.setConstraints(ageLabel, 0, 4);
		GridPane.setConstraints(physicianLabel, 0, 5);
		GridPane.setConstraints(physicianNumberLabel, 0, 6);
		GridPane.setConstraints(physicianNotesLabel, 0, 7);
		GridPane.setConstraints(xjobID, 1, 1);
		GridPane.setConstraints(xpatientID, 1, 2);
		GridPane.setConstraints(xpatientName, 1, 3);
		GridPane.setConstraints(xage, 1, 4);
		GridPane.setConstraints(xphysician, 1, 5);
		GridPane.setConstraints(xphysicianNumber, 1, 6);
		GridPane.setConstraints(xphysicianNotes, 0, 8);
		
		patientDetailsGridLayout.getChildren().addAll(jobIDLabel, patientIDLabel, patientNameLabel,
				ageLabel, physicianLabel, physicianNumberLabel, physicianNotesLabel,
				 xjobID, xpatientID, xpatientName,
				xage, xphysician, xphysicianNumber, xphysicianNotes);
		patientDetailsGridLayout.setAlignment(Pos.TOP_CENTER);
		tabPatient.setContent(patientDetailsGridLayout);		
		
		// Layout and elements of the CENTER pane of the window.
		TabPane centerTabPane = new TabPane();
		
		Tab imageDetailsTab = new Tab("Image Details");
		imageDetailsTab.setClosable(false);		
		Label imageDetailsLabel = new Label("Notes from the Radiographer: \n\n"
				+ "Image taken on April 10, 2020;\n"
				+ "Image taken by: Anthony John Cava\n"
				+ "Radiographer: Anthony John Cava\n"
				+ "Processed: 10-Apr-2020 10:30:04\n"
				+ "WW: 754234567887556\n"
				+ "1.16 dGy7m1.28mAs\n\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus commodo neque eu fringilla bibendum. Nunc tincidunt fermentum nunc, non vestibulum massa. Integer urna ligula, pellentesque a tempor eu, aliquet a lorem. Pellentesque mattis, erat eu sagittis mattis, lectus justo euismod elit, nec finibus ipsum nibh non tortor. In consequat, tortor sit amet faucibus posuere, ante augue mollis purus, a egestas dolor massa sit amet diam. Mauris felis ex, maximus ac condimentum non, pharetra id justo. Praesent tincidunt condimentum metus ut venenatis. In imperdiet mollis libero nec sagittis. Etiam ac sagittis orci. Nulla facilisi. Morbi tristique elit id sodales viverra. Proin rhoncus pellentesque sollicitudin. Nulla commodo vel lacus sed dictum.\n" + 
				"\n" + 
				"Fusce elit ante, porttitor sit amet ipsum quis, volutpat pulvinar eros. Phasellus magna lacus, egestas sed orci sed, sodales posuere purus. Fusce vestibulum mattis purus, non vulputate magna suscipit sed. Proin iaculis eu nisl vitae aliquam. Vivamus vulputate tortor vel tempus rutrum. Nam non lacus nec odio fringilla lacinia viverra eu ex. In hac habitasse platea dictumst. Morbi sit amet sem luctus, venenatis risus quis, euismod massa. Sed eu velit ut metus suscipit ullamcorper ut ut odio. Nulla egestas commodo pharetra. Duis ac facilisis purus, at aliquam tortor. Fusce eget lectus pharetra, elementum libero blandit, finibus nulla. Pellentesque ex ante, suscipit eget purus dignissim, efficitur tempus tellus. Suspendisse potenti. Aliquam sed finibus mauris, a tincidunt nisi. Ut condimentum purus id augue feugiat, sed posuere leo congue.");
		imageDetailsLabel.setTextAlignment(TextAlignment.JUSTIFY);
		imageDetailsLabel.setWrapText(true);
		imageDetailsLabel.setTextFill(Color.YELLOW);
		imageDetailsLabel.setPadding(new Insets(20));
		
		imageDetailsTab.setContent(imageDetailsLabel);
		centerTabPane.getTabs().add(imageDetailsTab);		

		
		// Layout and elements of the BOTTOM pane of the window.
		TabPane bottomTabPane = new TabPane();
		
		Tab diagnosisTab = new Tab("Diagnosis");
		diagnosisTab.setClosable(false);
		TextArea textArea = new TextArea();
		textArea.setPromptText("Enter diagnosis here...");
		diagnosisTab.setContent(textArea);
		
		Tab attachmentsTab = new Tab("Attachments");
		attachmentsTab.setClosable(false);
		FileChooser fileChooser = new FileChooser();
		Button attachFilesButton = new Button("Attach Files...");
		attachFilesButton.setOnAction(e -> {
			File file = fileChooser.showOpenDialog(stage);
			Text attachedFile = new Text(file.getName());
			attachmentsTab.setContent(attachedFile);
		});
		attachmentsTab.setContent(attachFilesButton);		
		bottomTabPane.getTabs().addAll(diagnosisTab, attachmentsTab);

		// Layout of entire Radiologist's window.
		BorderPane windowLayout = new BorderPane();
		windowLayout.setTop(headerLayout);
		windowLayout.setCenter(centerTabPane);
		windowLayout.getCenter().setStyle("-fx-background-color: black");
		windowLayout.setLeft(imagesScrollPane);
		windowLayout.setRight(patientDetailsLayout);
		windowLayout.setBottom(bottomTabPane);
		
		// Sets the size of the window.
		Scene scene = new Scene(windowLayout, 1500, 800);
		stage.setScene(scene);
		stage.show();
		
		//----------------------------------------------------------------------
		
		// Submit Button pressed
		submitButton.setOnAction(e -> {
			AlertBoxRadio.display();
		});
		
		backButton.setOnAction(e -> {
			LoginStage main = new LoginStage(200,200,50,50);
		});
		
		// Save Button pressed
		saveButton.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm Save");
			alert.setHeaderText("Are you sure you want to save?");
			alert.show();
		});

		/*
		 * Images on left pane pressed.
		 */
		chestThumbnailIV.setOnMouseEntered(e -> chestThumbnailIV.setStyle("-fx-cursor: hand;"));
		chestThumbnailIV.setOnMouseClicked(e -> {
			// Selected image
			ImageView chestImage = new ImageView();
			chestImage.setFitHeight(500);
			chestImage.setFitWidth(650);
			chestImage.setImage(chest);
			
			// Add chest
			Tab tabChest = new Tab();
			tabChest.setText("Chest X-Ray");
			
			GridPane chestGrid = new GridPane();
			chestGrid.setAlignment(Pos.TOP_CENTER);
			chestGrid.getChildren().add(chestImage);
			
			tabChest.setContent(chestGrid);			
			centerTabPane.getTabs().add(tabChest);
		});		
		
		skullThumbnailIV.setOnMouseEntered(e -> skullThumbnailIV.setStyle("-fx-cursor: hand;"));
		skullThumbnailIV.setOnMouseClicked(e -> {
			// Selected image
			ImageView skullImage = new ImageView();
			skullImage.setFitHeight(500);
			skullImage.setFitWidth(650);
			skullImage.setImage(skull);
			
			// Add chest
			Tab tabSkull = new Tab();
			tabSkull.setText("Skull X-Ray");
			
			GridPane skullGrid = new GridPane();
			skullGrid.setAlignment(Pos.TOP_CENTER);
			skullGrid.getChildren().add(skullImage);
			
			tabSkull.setContent(skullGrid);			
			centerTabPane.getTabs().add(tabSkull);
		});	
		
		lungsThumbnailIV.setOnMouseEntered(e -> lungsThumbnailIV.setStyle("-fx-cursor: hand;"));
		lungsThumbnailIV.setOnMouseClicked(e -> {
			// Selected image
			ImageView lungsImage = new ImageView();
			lungsImage.setFitHeight(500);
			lungsImage.setFitWidth(650);
			lungsImage.setImage(lungs);
			
			// Add chest
			Tab tabLungs = new Tab();
			tabLungs.setText("Lungs X-Ray");
			
			GridPane lungsGrid = new GridPane();
			lungsGrid.setAlignment(Pos.TOP_CENTER);
			lungsGrid.getChildren().add(lungsImage);
			
			tabLungs.setContent(lungsGrid);			
			centerTabPane.getTabs().add(tabLungs);
		});		
		
		lungs2ThumbnailIV.setOnMouseEntered(e -> lungs2ThumbnailIV.setStyle("-fx-cursor: hand;"));
		lungs2ThumbnailIV.setOnMouseClicked(e -> {
			// Selected image
			ImageView lungs2Image = new ImageView();
			lungs2Image.setFitHeight(500);
			lungs2Image.setFitWidth(650);
			lungs2Image.setImage(lungs2);
			
			// Add chest
			Tab tabLungs2 = new Tab();
			tabLungs2.setText("Lungs2 X-Ray");
			
			GridPane lungs2Grid = new GridPane();
			lungs2Grid.setAlignment(Pos.TOP_CENTER);
			lungs2Grid.getChildren().add(lungs2Image);
			
			tabLungs2.setContent(lungs2Grid);			
			centerTabPane.getTabs().add(tabLungs2);
		});
		
		brainThumbnailIV.setOnMouseEntered(e -> brainThumbnailIV.setStyle("-fx-cursor: hand;"));
		brainThumbnailIV.setOnMouseClicked(e -> {
			// Selected image
			ImageView brainImage = new ImageView();
			brainImage.setFitHeight(500);
			brainImage.setFitWidth(650);
			brainImage.setImage(brain);
			
			// Add chest
			Tab tabBrain = new Tab();
			tabBrain.setText("Brain X-Ray");
			
			GridPane lungs2Grid = new GridPane();
			lungs2Grid.setAlignment(Pos.TOP_CENTER);
			lungs2Grid.getChildren().add(brainImage);
			
			tabBrain.setContent(lungs2Grid);			
			centerTabPane.getTabs().add(tabBrain);
		});		
		
		zoomIn.setOnAction(e -> {
			System.out.println(centerTabPane.getSelectionModel().getSelectedIndex());
			if (centerTabPane.getSelectionModel().getSelectedIndex() != 0) {
				System.out.println("Zoom in allowed");
			}
		});
	}
}




