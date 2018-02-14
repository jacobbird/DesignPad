/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author Jacob
 */
public class RectangleLocal implements Shape {
    private static final String shapeType = "Rectangle";
    private Point2D firstPoint2D;
    private Point2D secondPoint2D;
    
    public RectangleLocal(){
        firstPoint2D = new Point2D(0,0);
        secondPoint2D = new Point2D(0,0); 
    }
    
    public RectangleLocal(Double x1, Double y1, Double x2, Double y2){
        firstPoint2D = new Point2D(0,0);
        secondPoint2D = new Point2D(0,0); 
        this.firstPoint2D.add(x1,y1);
        this.secondPoint2D.add(x2,y2);
    }
    
    public RectangleLocal(Point2D p1, Point2D p2){
        firstPoint2D = new Point2D(0,0);
        secondPoint2D = new Point2D(0,0); 
        this.firstPoint2D.add(p1.getX(),p1.getY());
        this.secondPoint2D.add(p2.getX(),p2.getY());
    }
    
    /*public void setXFirstPoint2D(Double x1){
        this.firstPoint2D.x=x1;
    }
    
    public void setYFirstPoint2D(Double y1){
        this.firstPoint2D.y=y1;
    }
    
    public void setXSecondPoint2D(Double x2){
        this.secondPoint2D.x=x2;
    }
    
    public void setYSecondPoint2D(Double y2){
        this.secondPoint2D.y=y2;
    }
    */
    
    public void setPoint2DFirst(Point2D p2D){
        firstPoint2D = p2D;
    }
    
    public void setPoint2DSecond(Point2D p2D){
        secondPoint2D = p2D;
    }
    
    public String getShapeType(){
        return this.shapeType;
    }
    
    public Point2D getFirstPoint2D(){
        return this.firstPoint2D;
    }
    
    public Point2D getSecondPoint2D(){
        return this.secondPoint2D;
    }
    
    public void draw(Pane canvas, Rectangle rect){
        
        if(((this.secondPoint2D.getX()-this.firstPoint2D.getX())<0)&&((this.secondPoint2D.getY()-this.firstPoint2D.getY())<0)){
            rect.setX(this.secondPoint2D.getX());
            rect.setY(this.secondPoint2D.getY());
            rect.setWidth(this.firstPoint2D.getX()-this.secondPoint2D.getX());
            rect.setHeight(this.firstPoint2D.getY()-this.secondPoint2D.getY());
        }
        else if (this.secondPoint2D.getX()-this.firstPoint2D.getX()<0){
            rect.setX(this.secondPoint2D.getX());
            rect.setY(this.firstPoint2D.getY());
            rect.setWidth(this.firstPoint2D.getX()-this.secondPoint2D.getX());
            rect.setHeight(this.secondPoint2D.getY()-this.firstPoint2D.getY());
        }
        else if(this.secondPoint2D.getY()-this.firstPoint2D.getY()<0){
            rect.setX(this.firstPoint2D.getX());
            rect.setY(this.secondPoint2D.getY());
            rect.setWidth(this.secondPoint2D.getX()-this.firstPoint2D.getX());
            rect.setHeight(this.firstPoint2D.getY()-this.secondPoint2D.getY());
        }
        else{
            rect.setX(this.firstPoint2D.getX());
            rect.setY(this.firstPoint2D.getY());
            rect.setWidth(this.secondPoint2D.getX()-this.firstPoint2D.getX()); 
            rect.setHeight(this.secondPoint2D.getY()-this.firstPoint2D.getY());
        }
            
            rect.setStroke(Color.BLACK);
            rect.setFill(Color.color(0, 0, 0, 0));
      
        canvas.getChildren().add(rect);
        
        
    }
    
}
