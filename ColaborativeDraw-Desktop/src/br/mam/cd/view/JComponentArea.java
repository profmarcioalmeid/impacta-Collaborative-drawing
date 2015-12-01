/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mam.cd.view;

import br.mam.cd.model.Circle;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;

/**
 *
 * @author marcioam
 */
public class JComponentArea extends JComponent implements Observer{

    
        
    @Override
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
     /*for( Observable o : monitorShapes){
            if (o instanceof Circle  ) {
                    Circle circle = (Circle)o;                    
                    g.drawOval(circle.getX(),circle.getY(), circle.getRadius(), circle.getRadius());            
            }
     }*/
  
    }  
    
    
    @Override
  public Dimension getPreferredSize() {
    return new Dimension(1000, 1000);
  }

    @Override
  public Dimension getMinimumSize() {
    return getPreferredSize();
  }

    @Override
    public void update(Observable o, Object o1) {
        System.out.println(o +" ? changed "+o);
        
        if (o instanceof Circle) {
            Circle circle = (Circle)o;
             System.out.println( "update "+circle.getSvg());
            this.getGraphics().drawOval(circle.getX(),circle.getY(), circle.getRadius(), circle.getRadius());
        }
        
    }
    
   
   
}
