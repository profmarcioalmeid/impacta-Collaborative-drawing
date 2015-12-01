/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws.quadro;

import br.mam.cd.model.Circle;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author marcioam
 */
public class MyDraw extends JComponent {
    
    
    public void paint(Graphics g){
    
      super.paintComponent(g);

    // draw entire component white
    g.setColor(Color.white);
    g.fillRect(0, 0, getWidth(), getHeight());

    // yellow circle
    g.setColor(Color.yellow);
    g.fillOval(0, 0, 240, 240);
   // Circle circle = new Circle(50f, 50f, 30f, "red", "black", 5f); 
    
    }
    
      public Dimension getPreferredSize() {
    return new Dimension(400, 400);
  }

  public Dimension getMinimumSize() {
    return getPreferredSize();
  }
    
}
