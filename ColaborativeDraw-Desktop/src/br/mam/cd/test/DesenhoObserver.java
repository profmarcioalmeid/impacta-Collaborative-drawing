/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mam.cd.test;

import br.mam.cd.model.Circle;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author marcio.mendes
 */
public class DesenhoObserver implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.err.println(o+ "Foi atualizado");
    }
   
    public static void main(String[] args) {
    Circle circle =new Circle();
    circle.setId(1l);
    // add observer to the watched object
    DesenhoObserver watcher = new DesenhoObserver();
   circle.addObserver(watcher);
  circle.setFill("fff");
  
        
    
    }
}
