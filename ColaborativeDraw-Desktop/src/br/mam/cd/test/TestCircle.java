/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mam.cd.test;

import br.mam.cd.model.Circle;
import br.mam.cd.model.ShapeFactory;
import br.mam.cd.model.TypesOfShapes;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author marcio.mendes
 */
public class TestCircle implements Observer{
    
    
    public static void main( String [] args){
    
       /* TestCircle testCircle = new TestCircle();
        ShapeFactory shapeFactory = new ShapeFactory();
        Circle circle = (Circle)shapeFactory.getShape(TypesOfShapes.Circle);
        circle.setSvg("<circle id=\"1\" cx=\"90\" cy=\"20\" r=\"10\" stroke=\"Black\" stroke-width=\"10\" fill=\"Black\" />");
        circle.addObserver(testCircle);
        circle.setSvg("<circle id=\"1\" cx=\"90\" cy=\"20\" r=\"100\" stroke=\"Black\" stroke-width=\"10\" fill=\"Black\" />");
        System.err.println("Stroke "+circle.getStroke());
        */
                
    }

    @Override
    public void update(Observable o, Object o1) {
        System.err.println(o+" : "+o1);
    }
    
}
