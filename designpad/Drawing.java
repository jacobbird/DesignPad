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
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Jacob
 */
public class Drawing {
    private Stack<Shape> sStack;
    private RectangleLocal rectLoc;
    private SquareLocal squaLoc;
    private OvalLocal ovalLoc;
    private CircleLocal circLoc;
    private CubicCurveLocalShape cubLoc;
    
    Drawing(){
        sStack = new Stack<Shape>();
        
        
        squaLoc = new SquareLocal();
        ovalLoc = new OvalLocal();
        circLoc = new CircleLocal();
        cubLoc = new CubicCurveLocalShape();
    }
    
    public int count(){
        return sStack.size();
    }
    
    public void addShape(Shape s){
        sStack.push(s);
    }
    
    public void removeShape(){
        sStack.pop();
    }
    
    public void draw(Pane canvas){
        Iterator it = sStack.iterator();
        
        while(it.hasNext()){
            Shape sh = (Shape)it.next();
            if(sh.getShapeType().compareToIgnoreCase("rectangle")==0){
                Rectangle rect = new Rectangle();
                rectLoc = new RectangleLocal();
                rectLoc = (RectangleLocal)sh;
                rectLoc.draw(canvas, rect);
            }
            else if(sh.getShapeType().compareToIgnoreCase("square")==0){
                Rectangle rect = new Rectangle();
                squaLoc = (SquareLocal)sh;
                squaLoc.draw(canvas, rect);     
            }
            else if(sh.getShapeType().compareToIgnoreCase("oval")==0){
                Ellipse ell = new Ellipse();
                ovalLoc = (OvalLocal)sh;
                ovalLoc.draw(canvas, ell);
            }
            else if(sh.getShapeType().compareToIgnoreCase("circle")==0){
                Ellipse ell = new Ellipse();
                circLoc = (CircleLocal)sh;
                circLoc.draw(canvas, ell);
            }
            else if(sh.getShapeType().compareToIgnoreCase("curve")==0){
                CubicCurve cub = new CubicCurve();
                cubLoc = (CubicCurveLocalShape)sh;
                cubLoc.draw(canvas, cub);
            }
            
        }
    }
    
}
