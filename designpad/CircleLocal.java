/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Jacob
 */
public class CircleLocal implements Shape{
    private static final String shapeType = "Circle";
    private Point2D firstPoint2D;
    private Point2D secondPoint2D;
    private Point2D centerPoint;
    private Double centerX;
    private Double centerY;
    
    public CircleLocal(){
        firstPoint2D = new Point2D(0,0);
        secondPoint2D = new Point2D(0,0); 
    }
    
    public CircleLocal(double x1, double y1, double x2, double y2){
        firstPoint2D = new Point2D(0,0);
        secondPoint2D = new Point2D(0,0); 
        this.firstPoint2D.add(x1,y1);
        this.secondPoint2D.add(x2,y2);
        
    }
    /*
    public CircleLocal(Point2D p1, Point2D p2){
        firstPoint2D = new Point2D(0,0);
        secondPoint2D = new Point2D(0,0); 
        this.firstPoint2D.add(p1);
        this.secondPoint2D.add(p2);
    }
    
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
    
    public void setCenterPoint(){
       centerPoint = firstPoint2D.midpoint(secondPoint2D); 
    }
    
    public void draw(Pane canvas, Ellipse ell){
        if(Math.abs(secondPoint2D.getX()-firstPoint2D.getX())>Math.abs(secondPoint2D.getY()-secondPoint2D.getY())){
        
            if(((this.secondPoint2D.getX()-this.firstPoint2D.getX())<0)&&((this.secondPoint2D.getY()-this.firstPoint2D.getY())<0)){
                ell.setCenterX(centerPoint.getX());
                ell.setCenterY(centerPoint.getY());
                ell.setRadiusX(-secondPoint2D.getX()+centerPoint.getX());
                ell.setRadiusY(-secondPoint2D.getX()+centerPoint.getX());
            }
            else if (this.secondPoint2D.getX()-this.firstPoint2D.getX()<0){
                ell.setCenterX(centerPoint.getX());
                ell.setCenterY(centerPoint.getY());
                ell.setRadiusX(-secondPoint2D.getX()+centerPoint.getX());
                ell.setRadiusY(-secondPoint2D.getX()+centerPoint.getX());
            }
            else if(this.secondPoint2D.getY()-this.firstPoint2D.getY()<0){
                ell.setCenterX(centerPoint.getX());
                ell.setCenterY(centerPoint.getY());
                ell.setRadiusX(secondPoint2D.getX()-centerPoint.getX());
                ell.setRadiusY(secondPoint2D.getX()-centerPoint.getX());
            }
            else{
                ell.setCenterX(centerPoint.getX());
                ell.setCenterY(centerPoint.getY());
                ell.setRadiusX(secondPoint2D.getX()-centerPoint.getX());
                ell.setRadiusY(secondPoint2D.getX()-centerPoint.getX());
            }
        }
        else{
            if(((this.secondPoint2D.getX()-this.firstPoint2D.getX())<0)&&((this.secondPoint2D.getY()-this.firstPoint2D.getY())<0)){
            ell.setCenterX(centerPoint.getX());
            ell.setCenterY(centerPoint.getY());
            ell.setRadiusX(-secondPoint2D.getY()+centerPoint.getY());
            ell.setRadiusY(-secondPoint2D.getY()+centerPoint.getY());
        }
        else if (this.secondPoint2D.getX()-this.firstPoint2D.getX()<0){
            ell.setCenterX(centerPoint.getX());
            ell.setCenterY(centerPoint.getY());
            ell.setRadiusX(secondPoint2D.getY()-centerPoint.getY());
            ell.setRadiusY(secondPoint2D.getY()-centerPoint.getY());
        }
        else if(this.secondPoint2D.getY()-this.firstPoint2D.getY()<0){
            ell.setCenterX(centerPoint.getX());
            ell.setCenterY(centerPoint.getY());
            ell.setRadiusX(-secondPoint2D.getY()+centerPoint.getY());
            ell.setRadiusY(-secondPoint2D.getY()+centerPoint.getY());
        }
        else{
            ell.setCenterX(centerPoint.getX());
            ell.setCenterY(centerPoint.getY());
            ell.setRadiusX(secondPoint2D.getY()-centerPoint.getY());
            ell.setRadiusY(secondPoint2D.getY()-centerPoint.getY());
        }
        
        
        
        ell.setStroke(Color.BLACK);
        ell.setFill(Color.color(0, 0, 0, 0));
      
        canvas.getChildren().add(ell);
            
        }
        
        
        ell.setStroke(Color.BLACK);
        ell.setFill(Color.color(0, 0, 0, 0));
      
        canvas.getChildren().add(ell);
    }

    void setPoint2DFirst(Point2D startPoint) {
        this.firstPoint2D=startPoint;
    }

    void setPoint2DSecond(Point2D endPoint) {
        this.secondPoint2D=endPoint;
    }
    
}
