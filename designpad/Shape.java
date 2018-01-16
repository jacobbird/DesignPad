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
public interface Shape {
    
    public String getShapeType();
    public Point getFirstPoint();
    public Point getSecondPoint();
    public void setXFirstPoint(double x1);
    public void setYFirstPoint(double y1);
    public void setXSecondPoint(double x2);
    public void setYSecondPoint(double y2);
    
}
