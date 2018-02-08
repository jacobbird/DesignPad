/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class DesignPad extends Application {

    private enum modes {
        square, rectangle, circle, oval, curve, undo
    };
    private modes currentMode;
    private double mouseStartPointX;
    private double mouseStartPointY;
    private double mouseControlPoint1X;
    private double mouseControlPoint1Y;
    private double mouseControlPoint2X;
    private double mouseControlPoint2Y;
    private double mouseEndPointX;
    private double mouseEndPointY;
    private boolean control1;
    private Drawing drawing;
    private CubicCurveLocalShape cCurveLocalS;

    /*public void start(Stage primaryStage){
        Pane canvas = new Pane();
        RectangleLocal rl = new RectangleLocal();
        rl.draw(canvas);
        
        Scene scene = new Scene(canvas, 700, 600);
        
        primaryStage.setTitle("DesignPad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/
    @Override
    public void start(Stage primaryStage) {
        cCurveLocalS=new CubicCurveLocalShape();
        drawing = new Drawing();
        control1 = true;

        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        // File menu - new, save, exit
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem saveMenuItem = new MenuItem("Save");
        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem exportMenuItem = new MenuItem("Export");
        exportMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem, openMenuItem,
                exportMenuItem, new SeparatorMenuItem(), exitMenuItem);

        Menu editMenu = new Menu("Edit");

        MenuItem undoMenuItem = new MenuItem("Undo");
        undoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        editMenu.getItems().add(undoMenuItem);

        MenuItem redoMenuItem = new MenuItem("Redo");
        redoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        editMenu.getItems().add(redoMenuItem);
        editMenu.getItems().add(new SeparatorMenuItem());

        MenuItem cutMenuItem = new MenuItem("Cut");
        cutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        editMenu.getItems().add(cutMenuItem);

        MenuItem copyMenuItem = new MenuItem("Copy");
        copyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        editMenu.getItems().add(copyMenuItem);

        MenuItem pasteMenuItem = new MenuItem("Paste");
        pasteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        editMenu.getItems().add(pasteMenuItem);

        Menu viewMenu = new Menu("View");

        MenuItem zoomInMenuItem = new MenuItem("Zoom In");
        zoomInMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem zoomOutMenuItem = new MenuItem("Zoom Out");
        zoomOutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem fiftyMenuItem = new MenuItem("50%");
        fiftyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem seventyFiveMenuItem = new MenuItem("75%");
        seventyFiveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem oneHundredMenuItem = new MenuItem("100%");
        oneHundredMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem oneFiftyMenuItem = new MenuItem("150%");
        oneFiftyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        viewMenu.getItems().addAll(zoomInMenuItem, zoomOutMenuItem,
                new SeparatorMenuItem(), fiftyMenuItem, seventyFiveMenuItem,
                oneHundredMenuItem, oneFiftyMenuItem);

        Menu helpMenu = new Menu("Help");

        MenuItem toolTipMenuItem = new MenuItem("Tool Tip");
        toolTipMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }

        });

        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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
                currentMode = modes.square;
            }
        });

        rectangleButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                currentMode = modes.rectangle;
            }
        });

        circleButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                currentMode = modes.circle;
            }
        });

        ovalButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                currentMode = modes.oval;
            }
        });

        curveButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                currentMode = modes.curve;
                control1=true;
                drawing.addShape(cCurveLocalS);
                cCurveLocalS.clear();
                
            }
        });

        undoButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                currentMode = modes.undo;
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

        //ScrollPane sp = new ScrollPane();
        //bp2.setCenter(sp);
        //sp.setCursor(Cursor.CROSSHAIR);
        //Pane canvas = new StackPane();
        Pane canvas2 = new Pane();
        bp2.setCenter(canvas2);

        //sp.setContent(canvas);
        Rectangle rectDraw = new Rectangle();
        Ellipse ellDraw = new Ellipse();
        CubicCurve ccuDraw = new CubicCurve();

        final Duration oneFrameAmt = Duration.millis(10);
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(canvas2.scaleYProperty(), 1);
        KeyFrame oneFrame = new KeyFrame(oneFrameAmt, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                
                if(drawing.count()>0){
                    drawing.draw(canvas2);
                }
                
                RectangleLocal rect = new RectangleLocal();
                OvalLocal ell = new OvalLocal();
                CircleLocal cir = new CircleLocal();
                SquareLocal squ = new SquareLocal();
                CCurveLocal ccu = new CCurveLocal();

                canvas2.setOnMousePressed(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        if (currentMode == modes.curve) {
                            if (control1 == true) {
                                mouseStartPointX = me.getX();
                                mouseStartPointY = me.getY();

                            } else {
                                mouseEndPointX = me.getX();
                                mouseEndPointY = me.getY();
                            }
                        } else {
                            mouseStartPointX = me.getX();
                            mouseStartPointY = me.getY();
                        }

                        /*Rectangle rectangle2 = new Rectangle(100,100, Color.GRAY);
                       rectangle2.relocate(100, 100);
                       //canvas2.getChildren().add(rectangle2);
                       
                            canvas2.setStyle("-fx-background-color: black;");
                            canvas2.setPrefSize(200,200);
                            Circle circle = new Circle(50,Color.BLUE);
                            circle.relocate(20, 20);
                            Rectangle rectangle = new Rectangle(100,100,Color.RED);
                            rectangle.relocate(70,70);
                            canvas2.getChildren().addAll(rectangle,circle);
                         */
                    }
                });
                int i = 1;

                canvas2.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        if (currentMode == modes.curve) {
                            if (control1 == true) {
                                mouseControlPoint1X = me.getX();
                                mouseControlPoint1Y = me.getY();
                            } else {
                                mouseControlPoint2X = (mouseEndPointX - me.getX()) + mouseEndPointX;
                                mouseControlPoint2Y = (mouseEndPointY - me.getY()) + mouseEndPointY;
                            }
                        } else {
                            mouseEndPointX = me.getX();
                            mouseEndPointY = me.getY();
                        }
                        Point2D startPoint = new Point2D(mouseStartPointX, mouseStartPointY);
                        Point2D endPoint = new Point2D(mouseEndPointX, mouseEndPointY);
                        if (currentMode == modes.rectangle) {
                            
        
                            rect.setPoint2DFirst(startPoint);
                            rect.setPoint2DSecond(endPoint);
                            rect.draw(canvas2, rectDraw);
                        } else if (currentMode == modes.oval) {
                           
                            
                            ell.setPoint2DFirst(startPoint);
                            ell.setPoint2DSecond(endPoint);
                            ell.setCenterPoint();
                            ell.draw(canvas2, ellDraw);
                        } else if (currentMode == modes.circle) {
                            
                           
        
                            
                            cir.setPoint2DFirst(startPoint);
                            cir.setPoint2DSecond(endPoint);
                            cir.setCenterPoint();
                            cir.draw(canvas2, ellDraw);
                        } else if (currentMode == modes.square) {
                            
                           
       
                            
                            squ.setPoint2DFirst(startPoint);
                            squ.setPoint2DSecond(endPoint);
                            squ.draw(canvas2, rectDraw);
                        } else if (currentMode == modes.curve && control1 == false) {
                            
        
                                 
                            ccu.setStartPoint(mouseStartPointX, mouseStartPointY);
                            ccu.setControlPoint1(mouseControlPoint1X, mouseControlPoint1Y);
                            ccu.setEndPoint(mouseEndPointX, mouseEndPointY);
                            ccu.setControlPoint2(mouseControlPoint2X, mouseControlPoint2Y);
                            ccu.draw(canvas2, ccuDraw);

                        }
                        /*
                            canvas2.setStyle("-fx-background-color: black;");
                            canvas2.setPrefSize(200+i,200+i);
                            Circle circle = new Circle(50,Color.BLUE);
                            circle.relocate(20, 20);
                            Rectangle rectangle = new Rectangle(100,100,Color.RED);
                            rectangle.relocate(70+i,70+i);
                            canvas2.getChildren().addAll(circle,rectangle);
                         */
                    }
                });

                canvas2.setOnMouseReleased(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent me) {
                        if(control1 == false){
                            mouseStartPointX = mouseEndPointX;
                            mouseStartPointY = mouseEndPointY;
                            mouseControlPoint1X= 2*mouseStartPointX-mouseControlPoint2X;
                            mouseControlPoint1Y= 2*mouseStartPointY-mouseControlPoint2Y;
                        }

                        if (currentMode == modes.rectangle) {
                            drawing.addShape(rect);
                        } else if (currentMode == modes.oval) {
                            drawing.addShape(ell);
                        } else if (currentMode == modes.circle) {
                            drawing.addShape(cir);
                        } else if (currentMode == modes.square) {
                            drawing.addShape(squ);
                        } else if (currentMode == modes.curve && control1 == false) {
                            cCurveLocalS.addCurve(ccu);
                        }
                        System.out.print(cCurveLocalS.count());
                        
                        
                        if (control1 == true) {
                            control1 = false;
                        }
                    }

                });
                
                

                //f(currentMode==modes.rectangle){
            }
         ;},kv);

        timeline.getKeyFrames().add(oneFrame);
        timeline.play();

        Scene scene = new Scene(root, 700, 600);

        primaryStage.setTitle("DesignPad");
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
