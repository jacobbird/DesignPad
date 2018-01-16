/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

/**
 *
 * @author Jacob
 */
public class Square implements Shape {
    private static final String shapeType = "Square";
    private Point firstPoint;
    private Point secondPoint;
    
    public Square(){
        this.firstPoint.setX(0);
        this.firstPoint.setY(0);
        this.secondPoint.setX(0);
        this.secondPoint.setY(0);
        
    }
    
    public Square(double x1, double y1, double x2, double y2){
        this.firstPoint.setX(x1);
        this.firstPoint.setY(y1);
        this.secondPoint.setX(x2);
        this.secondPoint.setY(y2);
    }
    
    public Square(Point p1, Point p2){
        this.firstPoint.setX(p1.getX());
        this.firstPoint.setY(p1.getY());
        this.secondPoint.setX(p2.getX());
        this.secondPoint.setY(p2.getY());
    }
    
    public void setXFirstPoint(double x1){
        this.firstPoint.setX(x1);
    }
    
    public void setYFirstPoint(double y1){
        this.firstPoint.setY(y1);
    }
    
    public void setXSecondPoint(double x2){
        this.secondPoint.setX(x2);
    }
    
    public void setYSecondPoint(double y2){
        this.secondPoint.setY(y2);
    }
    
    public String getShapeType(){
        return this.shapeType;
    }
    
    public Point getFirstPoint(){
        return this.firstPoint;
    }
    
    public Point getSecondPoint(){
        return this.secondPoint;
    }
    
    public void vaidSquare() throws EquSideException{
        if(!this.firstPoint.equalSide(this.secondPoint)){
            throw new EquSideException("This is not a valid square");
        }
    }
}

