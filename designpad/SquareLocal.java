/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author Jacob
 */
public class SquareLocal implements Shape {
    private static final String shapeType = "Square";
    private Point2D firstPoint2D;
    private Point2D secondPoint2D;
    
    public SquareLocal(){
        firstPoint2D = new Point2D(0,0);
        secondPoint2D = new Point2D(0,0);
    }
    
    public SquareLocal(double x1, double y1, double x2, double y2){
        firstPoint2D = new Point2D(x1,y1);
        secondPoint2D = new Point2D(x2,y2);
    }
    
    public SquareLocal(Point2D p1, Point2D p2){
        firstPoint2D = new Point2D(0,0);
        secondPoint2D = new Point2D(0,0);
        this.firstPoint2D.add(p1);
        this.secondPoint2D.add(p2);
    }
    
     public void setPoint2DFirst(Point2D p2D){
        firstPoint2D = p2D;
    }
    
    public void setPoint2DSecond(Point2D p2D){
        secondPoint2D = p2D;
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
    
    public void draw(Pane canvas, Rectangle rect){
        if(Math.abs(secondPoint2D.getX()-firstPoint2D.getX())>Math.abs(secondPoint2D.getY()-secondPoint2D.getY())){
        
            if(((this.secondPoint2D.getX()-this.firstPoint2D.getX())<0)&&((this.secondPoint2D.getY()-this.firstPoint2D.getY())<0)){
                rect.setX(this.secondPoint2D.getX());
                rect.setY(this.secondPoint2D.getY());
                rect.setWidth(this.firstPoint2D.getX()-this.secondPoint2D.getX());
                rect.setHeight(this.firstPoint2D.getX()-this.secondPoint2D.getX());
            }
            else if (this.secondPoint2D.getX()-this.firstPoint2D.getX()<0){
                rect.setX(this.secondPoint2D.getX());
                rect.setY(this.firstPoint2D.getY());
                rect.setWidth(this.firstPoint2D.getX()-this.secondPoint2D.getX());
                rect.setHeight(this.firstPoint2D.getX()-this.secondPoint2D.getX());
            }
            else if(this.secondPoint2D.getY()-this.firstPoint2D.getY()<0){
                rect.setX(this.firstPoint2D.getX());
                rect.setY(this.secondPoint2D.getY());
                rect.setWidth(this.secondPoint2D.getX()-this.firstPoint2D.getX());
                rect.setHeight(this.secondPoint2D.getX()-this.firstPoint2D.getX());
            }
            else{
                rect.setX(this.firstPoint2D.getX());
                rect.setY(this.firstPoint2D.getY());
                rect.setWidth(this.secondPoint2D.getX()-this.firstPoint2D.getX()); 
                rect.setHeight(this.secondPoint2D.getX()-this.firstPoint2D.getX());
            }
        }
        else{
            if(((this.secondPoint2D.getX()-this.firstPoint2D.getX())<0)&&((this.secondPoint2D.getY()-this.firstPoint2D.getY())<0)){
                rect.setX(this.secondPoint2D.getX());
                rect.setY(this.secondPoint2D.getY());
                rect.setWidth(this.firstPoint2D.getY()-this.secondPoint2D.getY());
                rect.setHeight(this.firstPoint2D.getY()-this.secondPoint2D.getY());
            }
            else if (this.secondPoint2D.getX()-this.firstPoint2D.getX()<0){
                rect.setX(this.secondPoint2D.getX());
                rect.setY(this.firstPoint2D.getY());
                rect.setWidth(this.secondPoint2D.getY()-this.firstPoint2D.getY());
                rect.setHeight(this.secondPoint2D.getY()-this.firstPoint2D.getY());
            }
            else if(this.secondPoint2D.getY()-this.firstPoint2D.getY()<0){
                rect.setX(this.firstPoint2D.getX());
                rect.setY(this.secondPoint2D.getY());
                rect.setWidth(this.firstPoint2D.getY()-this.secondPoint2D.getY());
                rect.setHeight(this.firstPoint2D.getY()-this.secondPoint2D.getY());
            }
            else{
                rect.setX(this.firstPoint2D.getX());
                rect.setY(this.firstPoint2D.getY());
                rect.setWidth(this.secondPoint2D.getY()-this.firstPoint2D.getY()); 
                rect.setHeight(this.secondPoint2D.getY()-this.firstPoint2D.getY());
            }
        }
          
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.color(0, 0, 0, 0));
        
        canvas.getChildren().add(rect);
    }
}

