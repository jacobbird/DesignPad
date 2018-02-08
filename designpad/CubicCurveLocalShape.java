/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

import java.util.Iterator;
import java.util.Stack;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurve;

/**
 *
 * @author Jacob
 */
public class CubicCurveLocalShape implements Shape {
    
    private static final String shapeType = "Curve";
    private Stack<CCurveLocal> cCArray;
    
    CubicCurveLocalShape(){
        cCArray = new Stack<CCurveLocal>();
    }
    
    public int count(){
        return cCArray.size();
    }
    
    public void clear(){
        cCArray.clear();
    }
    
    public String getShapeType(){
        return this.shapeType;
    }
    
    public void addCurve(CCurveLocal cCL){
        cCArray.push(cCL);
    }
    
    public void removeCurve(){
        cCArray.pop();
    }
    
    public void draw(Pane canvas, CubicCurve drawCurve){
       
        Iterator it = cCArray.iterator();
        
        while(it.hasNext()){
            CCurveLocal cCL = (CCurveLocal)it.next();
            cCL.draw(canvas, drawCurve);
        }
    }
    
    
}
