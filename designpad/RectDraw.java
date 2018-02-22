/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpad;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javafx.geometry.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author Jacob
 */
public class RectDraw extends JPanel {
            
    private enum currentShape{rectangle,square,oval,circle,cubiccurve};
    private currentShape cs;
    private Point2D startPoint;
    private Point2D endPoint;
    private JPanel jPanel;
    
    public RectDraw(Point2D startPoint, Point2D endPoint){
       cs=cs.rectangle; 
       this.startPoint=startPoint;
       this.endPoint=endPoint;
    }
    
    public RectDraw(){}
    
    public void addPoints(Point2D startPoint, Point2D endPoint){
        this.startPoint=startPoint;
       this.endPoint=endPoint;
    }
    
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
        }

