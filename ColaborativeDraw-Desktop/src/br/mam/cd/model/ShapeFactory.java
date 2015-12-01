/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mam.cd.model;

import java.util.List;
import java.util.Objects;
import java.util.Observable;

/**
 *
 * @author marcioam
 */
public final class ShapeFactory {
 
    private   List<Observable> monitorShapes;
    
    public Shape getShape(TypesOfShapes typesOfDraws) {
        
        switch(typesOfDraws){
            case Circle:
              return new Circle();
            
        }
        
    return null;
    }
    
    public Shape getShapeById(Long id ){
        for( Observable o : monitorShapes){
            if (o instanceof Circle  ) {
                Circle circle = (Circle)o;
                if(Objects.equals(circle.getId(), id)){
                 return circle;
                }
        }
        }
    return null;
    }
    
    public Boolean contains(Long id ){
        for( Observable o : monitorShapes){
            if (o instanceof Circle  ) {
                Circle circle = (Circle)o;
                if(Objects.equals(circle.getId(), id)){
                 return true;
                }
        }
        }
    return false;
    }
    
    public void removeShape(Shape shape){
        for(Observable o : monitorShapes){
              if (o instanceof Circle  ) {
                    Circle circle = (Circle)o;
                    if(Objects.equals(circle.getId(), shape.getId())){
                     this.monitorShapes.remove( o );
                    }
              }     
            }
    }
 
    public void updateShape(Shape shape){
        
      if( !this.contains( shape.getId() )){ 
                for(int i=0; i < this.monitorShapes.size(); i++){
                    if(Objects.equals(shape.getId(), this.monitorShapes.get(i))){
                        if(shape instanceof Circle){
                          this.monitorShapes.set(i, (Circle)shape); i=this.monitorShapes.size();
                        }
                    }
                } 
              }
    
    } 


    public void addShape(Shape shape, Object observer){
            if(shape instanceof Circle){
                Shape foundShape =   getShapeById(shape.getId());
             Circle circle=(Circle)shape;
             if(foundShape!=null){                           
                foundShape.setId(shape.getId());
                foundShape.setX(shape.getX());
                foundShape.setY(shape.getY());
                foundShape.setRadius(shape.getRadius());
                foundShape.setStroke(shape.getStroke());
                foundShape.setFill(shape.getFill());
                foundShape.setStrokeWidth(shape.getStrokeWidth());
                foundShape.setSvg(shape.getSvg());
                updateShape(shape);
                
            }else{       
               
                this.monitorShapes.add(circle);
                
              }
            }
             
    }
   

}
