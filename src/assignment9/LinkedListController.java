/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class LinkedListController extends Application {
    private Assignment8<Integer> mlist = new Assignment8<Integer>();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button[] button = new Button[5];
        HBox numberField = new HBox();
        Label outputText = new Label(mlist.printList());
    
        EventHandler<ActionEvent> clickListener = new EventHandler<ActionEvent>() {
      
        @Override
        public void handle(ActionEvent event) {
            Button button = ((Button)event.getSource());
            mlist.insertItem(Integer.parseInt(button.getText()));
            
            button.setDisable(true);
            outputText.setText(mlist.printList());
        }
      };
        for( int i = 0; i < 5 ; i++ ){
            button[i] = new Button("" + (i + 1));
            numberField.getChildren().add(button[i]);
            
            button[i].setOnAction(clickListener);
        }
        //Create a reset button
        HBox hBox = new HBox();
        Button reset = new Button("Reset");
       
        reset.setOnAction(new EventHandler<ActionEvent>(){
       
        //All numbered buttons are enabled, mList clears, & list is updated   
        @Override
        public void handle(ActionEvent event){
            mlist.clearList();
            for(int i = 0; i < 5; i++)
            button[i].setDisable(false);
            
            outputText.setText(mlist.printList());
           }
        });
       
       //Create a Close button
        hBox.getChildren().add(reset);
        Button close = new Button("Close");
        
        //The application will be closed
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            System.exit(0);
        }
    });
        
        hBox.getChildren().add(close);
        
        //GUI layout of the buttons and numbers
        BorderPane borderpane = new BorderPane();
        borderpane.setTop(numberField);
        borderpane.setBottom(hBox);
        borderpane.setCenter(outputText);
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        
        
       //Sizing of the frame
        Scene scene = new Scene(borderpane, 300, 90);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
    launch(args);
    
    }
}