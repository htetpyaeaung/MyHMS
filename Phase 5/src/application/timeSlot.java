package application;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
 
public class timeSlot{
 
    private TableView table = new TableView();
    private String date;
    double sth = 100;
    
    final ObservableList<appointment> data = FXCollections.observableArrayList(
    	    new appointment("Reserved", "10:00 ~ 11:00am","State your Reason"),
    	    new appointment("Unreserverd", "11:00 ~ 12:00am","State your Reason"),
    	    new appointment("Unreserverd", "1:00 ~ 2:00pm", "State your Reason"),
    	    new appointment("Reserved", "2:00 ~ 3:00pm", "State your Reason"),
    	    new appointment("Reserved", "3:00 ~ 4:00pm", "State your Reason")
    	);
    
 
    public timeSlot(String date)  {
    	Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("TimeSlot");
        stage.setWidth(100);
        stage.setHeight(100);
        this.date = date;
        
        
 
        final Label label = new Label(date);
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        
        TableColumn StatusCol = new TableColumn("Status");
        StatusCol.setMinWidth(100);
        StatusCol.setCellValueFactory(
                new PropertyValueFactory<appointment, String>("Status"));
 
        TableColumn TimeCol = new TableColumn("Time");
        TimeCol.setMinWidth(100);
        TimeCol.setCellValueFactory(
                new PropertyValueFactory<appointment, String>("Time"));
 
        
        TableColumn ReasonCol = new TableColumn("Reason");
        ReasonCol.setMinWidth(200);
        ReasonCol.setCellValueFactory(
                new PropertyValueFactory<appointment, String>("Reason"));
        
        
 
        table.setItems(data);
        table.getColumns().addAll(StatusCol, TimeCol,ReasonCol);
        
        Button done = new Button("Done");
        EventHandler<ActionEvent> doneButton = new EventHandler<ActionEvent>(){
    		@Override public void handle(ActionEvent e){
    	
    		
    		
    		new userDetail();
    		stage.close();
    		
    	
    		}
    		};
    		
    		done.setOnAction(doneButton);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table,done);
        
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        addButtonToTable();
 
        
      
        
       
        Timer animationTimer = new Timer();
        animationTimer.scheduleAtFixedRate(new TimerTask() {
            int i=0;

            
            public void run() {
                if (i<150) {
                    stage.setWidth(stage.getWidth()+3);
                    stage.setHeight(stage.getHeight()+3);
                } else {
                    this.cancel();
                }
                i++;
            }

        }, 2000, 15);
          
        stage.setScene(scene);
        stage.show();
        
	}
    
    
        
    
    private void addButtonToTable() {
        TableColumn<appointment, Void> colBtn = new TableColumn("");

        Callback<TableColumn<appointment, Void>, TableCell<appointment, Void>> cellFactory = new Callback<TableColumn<appointment, Void>, TableCell<appointment, Void>>() {
            @Override
            public TableCell<appointment, Void> call(final TableColumn<appointment, Void> param) {
                final TableCell<appointment, Void> cell = new TableCell<appointment, Void>() {

                    private final Button btn = new Button("Select");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);

    }
    
    
    public static class appointment {
        private final SimpleStringProperty status;
        private final SimpleStringProperty time;
        private final SimpleStringProperty reason;
     
        private appointment(String statusDat, String timeDat, String reasonDat) {
            this.status = new SimpleStringProperty(statusDat);
            this.time = new SimpleStringProperty(timeDat);
            this.reason = new SimpleStringProperty(reasonDat);
            
        }
     
        public String getStatus() {
            return status.get();
        }
        public void setStatus(String statusDat) {
            status.set(statusDat);
        }
            
        public String getTime() {
            return time.get();
        }
        public void setTime(String statusDat) {
            reason.set(statusDat);
        }
        
        
        public String getReason() {
            return reason.get();
        }
        public void setReason(String statusDat) {
            reason.set(statusDat);
            
    }
}
    
    
    }

    
