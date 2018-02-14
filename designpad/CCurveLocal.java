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
import javafx.scene.shape.CubicCurve;
import javafx.util.Duration;

/**
 *
 * @author Jacob
 */
public class CCurveLocal {
    private static final String shapeType = "CubicCurve";
    Double startX;
    Double startY;
    Double endX;
    Double endY;
    Double control1X;
    Double control1Y;
    Double control2X;
    Double control2Y;
    
    
    public CCurveLocal(){
        startX=0.0;
        startY=0.0;
        endX=0.0;
        endY=0.0;
        control1X=0.0;
        control1Y=0.0;
        control2X=0.0;
        control2Y=0.0;
    
        
    }
    
    public CCurveLocal(Double point1X, Double point1Y, Double point2X, Double point2Y,
            Double point3X, Double point3Y, Double point4X, Double point4Y){
        startX=point1X;
        startY=point1Y;
        endX=point2X;
        endY=point2Y;
        control1X=point3X;
        control1Y=point3Y;
        control2X=point4X;
        control2Y=point4Y;   
    }
    
    public void setStartPoint(Double point1X, Double point1Y){
        startX=point1X;
        startY=point1Y;
    }
    
    public void setEndPoint(Double point4X, Double point4Y){
        endX=point4X;
        endY=point4Y;
    }
    
    public void setControlPoint1(Double point2X, Double point2Y){
        control1X=point2X;
        control1Y=point2Y;
    }
    
    public void setControlPoint2(Double point3X, Double point3Y){
        control2X=point3X;
        control2Y=point3Y;
    }
    
    public String getShapeType(){
        return this.shapeType;
    }
    
    public void draw(Pane canvas, CubicCurve cub){
        
            cub.setStartX(startX);
            cub.setStartY(startY);
            cub.setControlX1(control1X);
            cub.setControlY1(control1Y);
            cub.setControlX2(control2X);
            cub.setControlY2(control2Y);
            cub.setEndX(endX);
            cub.setEndY(endY);
         
            cub.setStroke(Color.BLACK);
            cub.setFill(Color.color(0, 0, 0, 0));
      
        canvas.getChildren().add(cub);
    }
    
    public void drawForDrawing(Pane canvas, CubicCurve cub){
        
        
        
        cub.setStartX(startX);
            cub.setStartY(startY);
            cub.setControlX1(control1X);
            cub.setControlY1(control1Y);
            cub.setControlX2(control2X);
            cub.setControlY2(control2Y);
            cub.setEndX(endX);
            cub.setEndY(endY);
         
            cub.setStroke(Color.BLACK);
            cub.setFill(Color.color(0, 0, 0, 0));
      
        canvas.getChildren().add(cub);
    }
    
}
