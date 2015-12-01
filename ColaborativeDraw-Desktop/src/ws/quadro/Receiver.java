package ws.quadro;

import br.mam.cd.model.Circle;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class Receiver implements Runnable{
Quadro quadro=null;
Circle circle;
String remetente;
String autor;
        
Boolean finalize=false;
    public Receiver(Circle c, String remetente, String ip) throws MalformedURLException {
        
        //URL url = new URL("http://10.0.200.243:54321/quadro?wsdl");
        URL url = new URL("http://"+ip+":54321/quadro?wsdl");
        //QName represents a qualified name as defined in the XML specifications
        QName qname = new QName("http://quadro.ws/","QuadroImplService");
        Service service = Service.create(url, qname);
        quadro =  service.getPort(Quadro.class);
        this.circle = c;
        this.remetente = remetente;
}

    
  
    public void stop(){
    this.finalize=true;
    }
	
    @Override
    public void run() {
        
         System.out.print("Esperando ...");
       while(!finalize){
           
            if(quadro.getRemetente()!= null && !quadro.getRemetente().equals(remetente) && quadro.getDesenho()!= null && !this.circle.getSvg().equals(quadro.getDesenho())){
                this.autor = quadro.getRemetente();
                this.circle.setSvg(quadro.getDesenho());
                System.out.println(quadro.getDesenho());
                
            }
             try {
                 Thread.sleep(100);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }
    
    public String getAutor(){
    return autor;
    }
    
 

}
