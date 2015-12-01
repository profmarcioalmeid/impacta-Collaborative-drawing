/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.quadro;

import br.mam.cd.model.Circle;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Marcio
 */
public class Transmitter implements Runnable{
    Quadro quadro = null;
    Circle circle;
    String remetente;
    Boolean finalize=false;
    
 public Transmitter(Circle c, String remetente, String ip) throws MalformedURLException {
        
        URL url = new URL("http://"+ip+":54321/quadro?wsdl");
        System.out.println("Conect  to "+ip);
        //URL url = new URL("http://10.0.200.243:54321/quadro?wsdl");
        //QName represents a qualified name as defined in the XML specifications
        QName qname = new QName("http://quadro.ws/","QuadroImplService");
        Service service = Service.create(url, qname);
        quadro =  service.getPort(Quadro.class);
        this.circle = c;
        this.remetente = remetente;
}
    
	
    @Override
    public void run() {
         System.out.println(remetente + " transmitiu !! ");
         System.err.println(" Anterior "+quadro.getDesenho()); 
         
          
           if(quadro.getDesenho()==null){
                quadro.setRemetente(remetente);
                quadro.setDesenho(this.circle.getSvg());
            } else if(this.remetente!=null && this.circle !=null && quadro  != null && !quadro.getDesenho().equals(this.circle.getSvg()) ) {
                quadro.setRemetente(remetente);
                System.out.println("Transmitiu : "+ this.circle.getSvg());
                quadro.setDesenho(this.circle.getSvg());
            } 
        
              
    }
    
    public void stop(){
     this.finalize=true;
    }
    
}
