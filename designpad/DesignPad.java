/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
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
import javafx.embed.swing.SwingNode;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import java.awt.*;
import java.awt.event.*;

import java.util.Vector;

import javax.swing.*;

/**
 *
 * @author Jacob
 */
public class DesignPad extends Application implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
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
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
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
                        
                        
                        startPoint = new Point2D(mouseStartPointX, mouseStartPointY);
                        endPoint = new Point2D(mouseEndPointX, mouseEndPointY);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
    private Point2D startPoint;
    private Point2D endPoint;
    private CubicCurveLocalShape cCurveLocalS;
    private Graphics g;
    private RectDraw r;
    private JScrollPane s;
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
        MyPanel panel = new MyPanel();
        SwingNode swingNode = new SwingNode();
        
         
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

        
        //bp2.setCenter(sp);
        //sp.setCursor(Cursor.CROSSHAIR);
        //Pane canvas = new StackPane();
        
        Pane canvas = new Pane();
        
        startPoint = new Point2D(0,0);
        endPoint = new Point2D(0,0);
        //panel.isRectangle(startPoint, endPoint);
        //panel.createAndSetSwingContent(swingNode);
        //JScrollPane jsp = (JScrollPane)swingNode.getContent();
        //int j = jsp.getComponentCount();
        //System.out.print(j);
        //jp = (RectDraw)jsp.getComponent(0);
        
        SwingNode swingNode2 = new SwingNode();
         r = new RectDraw();
                r.setPreferredSize(new Dimension(12000,12000));
                r.addMouseListener(this);
                
                
                 
                 
            
        s = new JScrollPane(r);
                JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL);
                JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL);
                s.setHorizontalScrollBar(hbar);
                s.setVerticalScrollBar(vbar);
                s.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                s.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                //r.requestFocus();
                //hbar.requestFocusInWindow();
                //vbar.requestFocusInWindow();
                //r.repaint();
                //s.setComponentZOrder((JPanel)r,3);
        
        //swingNode2.setContent(r);
        
        createAndSetSwingContent(swingNode);
        

        bp2.setCenter(swingNode);
        final Duration oneFrameAmt = Duration.millis(100);
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(swingNode.scaleYProperty(), 1);
        
        KeyFrame oneFrame = new KeyFrame(oneFrameAmt, new EventHandler<ActionEvent>() {
            
        

            
            @Override
            public void handle(ActionEvent actionEvent) {
                //r.addPoints(startPoint, endPoint);
                //s.repaint();
                //r.repaint();
                //hbar.repaint();
                //vbar.repaint();
                
                //swingNode.setContent(s);
               
                
                
                /* 
                if(drawing.count()>0){
                    drawing.draw(jp);
                }
                */
                
                
               /* swingNode.setOnMousePressed(new EventHandler<MouseEvent>() {
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
                   // }
                //});
                int i = 1;
                
                /*swingNode.setOnMouseDragged(new EventHandler<MouseEvent>() {
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
                        
                        
                        startPoint = new Point2D(mouseStartPointX+100, mouseStartPointY+100);
                        endPoint = new Point2D(mouseEndPointX+100, mouseEndPointY+100);
                        
                        /*
                            canvas2.setStyle("-fx-background-color: black;");
                            canvas2.setPrefSize(200+i,200+i);
                            Circle circle = new Circle(50,Color.BLUE);
                            circle.relocate(20, 20);
                            Rectangle rectangle = new Rectangle(100,100,Color.RED);
                            rectangle.relocate(70+i,70+i);
                            canvas2.getChildren().addAll(circle,rectangle);
                         */
                   // }
                /*});
                
                Rectangle rectDraw = new Rectangle();
                Ellipse ellDraw = new Ellipse();
                CubicCurve ccuDraw = new CubicCurve();
                
                RectangleLocal rect = new RectangleLocal();
                OvalLocal ell = new OvalLocal();
                CircleLocal cir = new CircleLocal();
                SquareLocal squ = new SquareLocal();
                CCurveLocal ccu = new CCurveLocal();
                
                if (currentMode == modes.rectangle && startPoint!=null && endPoint != null) {
                        rect.setPoint2DFirst(startPoint);
                        rect.setPoint2DSecond(endPoint);
                        } else if (currentMode == modes.oval && startPoint!=null && endPoint != null) {
                            /*ell.setPoint2DFirst(startPoint);
                            ell.setPoint2DSecond(endPoint);
                            ell.setCenterPoint();
                            ell.draw(jp);*/
                        //} else if (currentMode == modes.circle && startPoint!=null && endPoint != null) {
                            /*cir.setPoint2DFirst(startPoint);
                            cir.setPoint2DSecond(endPoint);
                            cir.setCenterPoint();
                            cir.draw(jp);*/
                        //} else if (currentMode == modes.square && startPoint!=null && endPoint != null) {
                            /*squ.setPoint2DFirst(startPoint);
                            squ.setPoint2DSecond(endPoint);
                            squ.draw(jp);*/
                        //} else if (currentMode == modes.curve && control1 == false) 
                        //{
                            /*ccu.setStartPoint(mouseStartPointX, mouseStartPointY);
                            ccu.setControlPoint1(mouseControlPoint1X, mouseControlPoint1Y);
                            ccu.setEndPoint(mouseEndPointX, mouseEndPointY);
                            ccu.setControlPoint2(mouseControlPoint2X, mouseControlPoint2Y);                           
                            ccu.draw(jp);*/
                            
                        //}
               
                /*swingNode.setOnMouseReleased(new EventHandler<MouseEvent>() {

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
                
                */
                
                
            }
         ;},kv);
        
        
        
        
        final Duration twoFrameAmt = Duration.millis(10);
        KeyFrame twoFrame = new KeyFrame(twoFrameAmt, new EventHandler<ActionEvent>() {
            //Pane canvas2 = (Pane)sp.getContent();
            @Override
            public void handle(ActionEvent actionEvent) {
                
             //   canvas2.getChildren().clear();
              
            }
         ;},kv);
        
        timeline.getKeyFrames().addAll(oneFrame);
        timeline.play();

        Scene scene = new Scene(root, 700, 600);
        
        primaryStage.setTitle("DesignPad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public void mousePressed(MouseEvent me) {
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
                    
                }
                
                public void mouseDragged(MouseEvent me){
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
                        
                        
                        startPoint = new Point2D(mouseStartPointX, mouseStartPointY);
                        endPoint = new Point2D(mouseEndPointX, mouseEndPointY);
                        r.addPoints(startPoint,endPoint);
                        r.repaint();
                }
                
                public void mouseReleased(MouseEvent me) {
                    
                }
    
    private void createAndSetSwingContent(final SwingNode swingNode) {

        
  
        
        SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 
                
                 swingNode.setContent(s);
             }
         });
     }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /*class RectDraw extends JPanel {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); 
                Graphics2D g2d = (Graphics2D)g;
                
                //if (cs==cs.rectangle){
                    RectangleLocal rect = new RectangleLocal();
                    rect.setPoint2DFirst(startPoint);
                    rect.setPoint2DSecond(endPoint);
                    rect.draw(g2d);
                //java.awt.Rectangle rect = new java.awt.Rectangle((int)startPoint.getX(),(int)startPoint.getY(),(int)endPoint.getX()-(int)startPoint.getX(),(int)endPoint.getY()-(int)startPoint.getY());
                //java.awt.Rectangle rect = new java.awt.Rectangle(100,100,100,100);
                //}
                
                
            }
        }*/
    
     private void BringToFront() {
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                           if(r != null) {
                                r.requestFocusInWindow();
                               
                                r.repaint();
                            }
                        }           
                    }); 
                }
    
    public class MyOwnFocusTraversalPolicy
                  extends FocusTraversalPolicy
    {
        

        public Component getInitialComponent(Window w){
            return r;
        }
        
        public Component getComponentAfter(Container focusCycleRoot,
                                           Component aComponent)
        {
            return r;
        }

        public Component getComponentBefore(Container focusCycleRoot,
                                            Component aComponent)
        {
            return r;
        }

        public Component getDefaultComponent(Container focusCycleRoot) {
            return r;
        }

        public Component getLastComponent(Container focusCycleRoot) {
            return r;
        }

        public Component getFirstComponent(Container focusCycleRoot) {
            return r;
        }
    }
    

}
