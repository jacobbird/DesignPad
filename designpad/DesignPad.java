/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package designpad;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class DesignPad extends Application {

    
    private enum modes{square,rectangle,circle,oval,curve,undo};
    private static modes currentMode;
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
    

    MenuBar menuBar = new MenuBar();
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    root.setTop(menuBar);

    // File menu - new, save, exit
    Menu fileMenu = new Menu("File");
    MenuItem newMenuItem = new MenuItem("New");
    newMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem saveMenuItem = new MenuItem("Save");
    saveMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem openMenuItem = new MenuItem("Open");
    openMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem exportMenuItem = new MenuItem("Export");
    exportMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem exitMenuItem = new MenuItem("Exit");
    exitMenuItem.setOnAction(actionEvent -> Platform.exit());

    fileMenu.getItems().addAll(newMenuItem, saveMenuItem, openMenuItem, 
        exportMenuItem, new SeparatorMenuItem(), exitMenuItem);

    Menu editMenu = new Menu("Edit");
    
    MenuItem undoMenuItem = new MenuItem("Undo");
    undoMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    editMenu.getItems().add(undoMenuItem);

    MenuItem redoMenuItem = new MenuItem("Redo");
    redoMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    editMenu.getItems().add(redoMenuItem);
    editMenu.getItems().add(new SeparatorMenuItem());
    
    MenuItem cutMenuItem = new MenuItem("Cut");
    cutMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    editMenu.getItems().add(cutMenuItem);
    
    MenuItem copyMenuItem = new MenuItem("Copy");
    copyMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    editMenu.getItems().add(copyMenuItem);

    MenuItem pasteMenuItem = new MenuItem("Paste");
    pasteMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    editMenu.getItems().add(pasteMenuItem);
    
    Menu viewMenu = new Menu("View");
    
    MenuItem zoomInMenuItem = new MenuItem("Zoom In");
    zoomInMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
   
    MenuItem zoomOutMenuItem = new MenuItem("Zoom Out");
    zoomOutMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem fiftyMenuItem = new MenuItem("50%");
    fiftyMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem seventyFiveMenuItem = new MenuItem("75%");
    seventyFiveMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem oneHundredMenuItem = new MenuItem("100%");
    oneHundredMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem oneFiftyMenuItem = new MenuItem("150%");
    oneFiftyMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });

    viewMenu.getItems().addAll(zoomInMenuItem, zoomOutMenuItem,
        new SeparatorMenuItem(), fiftyMenuItem, seventyFiveMenuItem, 
        oneHundredMenuItem, oneFiftyMenuItem);

    Menu helpMenu = new Menu("Help");
    
    MenuItem toolTipMenuItem = new MenuItem("Tool Tip");
    toolTipMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    MenuItem aboutMenuItem = new MenuItem("About");
    aboutMenuItem.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            
        }
    
    });
    
    helpMenu.getItems().addAll(toolTipMenuItem, new SeparatorMenuItem(), 
            aboutMenuItem);
    
    menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu, helpMenu);

        
        
        Button squareButton = new Button();
        Button rectangleButton = new Button();
        Button circleButton = new Button();
        Button ovalButton = new Button();
        Button curveButton = new Button();
        Button undoButton = new Button();
        
        squareButton.setText("Square");
        rectangleButton.setText("Rectangle");
        circleButton.setText("Circle");
        ovalButton.setText("Oval");
        curveButton.setText("Curve");
        undoButton.setText("Undo");
        
        squareButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                currentMode=modes.square;
            }
        });
        
        rectangleButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                currentMode=modes.rectangle;
            }
        });
        
        circleButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                currentMode=modes.circle;
            }
        });
        
        ovalButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                currentMode=modes.oval;
            }
        });
        
        curveButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                currentMode=modes.curve;
            }
        });
        
        undoButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                currentMode=modes.undo;
            }
        });
        
        
        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10);
        hbButtons.setPadding(new Insets(10, 20, 10, 20)); 
        hbButtons.getChildren().addAll(squareButton, rectangleButton, 
                circleButton, ovalButton, curveButton, undoButton);
        
        BorderPane bp2 = new BorderPane();
        bp2.setTop(hbButtons);
        
        root.setCenter(bp2);
        
        Scene scene = new Scene(root, 700, 600);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
