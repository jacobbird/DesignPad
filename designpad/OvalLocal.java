/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
/**
 *
 * @author Jacob
 */
public class OvalLocal implements Shape{
    private static final String shapeType = "Oval";
    private Point2D firstPoint2D;
    private Point2D secondPoint2D;
    
    public OvalLocal(){
        this.firstPoint2D.add(0,0);
        this.secondPoint2D.add(0,0);
    }
    
    public OvalLocal(double x1, double y1, double x2, double y2){
        this.firstPoint2D.add(x1,y1);
        this.secondPoint2D.add(x2,y2);
    }
    
    public OvalLocal(Point2D p1, Point2D p2){
        this.firstPoint2D.add(p1);
        this.secondPoint2D.add(p2);
    }
    /*
    public void setXFirstPoint2D(double x1){
        this.firstPoint2D.setX(x1);
    }
    
    public void setYFirstPoint2D(double y1){
        this.firstPoint2D.setY(y1);
    }
    
    public void setXSecondPoint2D(double x2){
        this.secondPoint2D.setX(x2);
    }
    
    public void setYSecondPoint2D(double y2){
        this.secondPoint2D.setY(y2);
    }
    */
    public String getShapeType(){
        return this.shapeType;
    }
    
    public Point2D getFirstPoint2D(){
        return this.firstPoint2D;
    }
    
    public Point2D getSecondPoint2D(){
        return this.secondPoint2D;
    }
    
    public void draw(Pane canvas){
        javafx.scene.shape.Ellipse ellipse = new javafx.scene.shape.Ellipse(
        firstPoint2D.getX(),firstPoint2D.getY(),
        secondPoint2D.getX()-firstPoint2D.getX(),
        secondPoint2D.getY()-firstPoint2D.getY());
        
        canvas.getChildren().add(ellipse);
        
    }
    
}

