package ws.quadro.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

public class HelloWorldPublisher implements Runnable {

    private Endpoint ep;
    private Boolean active=false;

    public void active(boolean active) {
        synchronized(this){
        this.active = active;
        notifyAll();
        }
        
    }

    @Override
    public void run() {
 System.err.println(System.getenv("COMPUTERNAME"));
 
        ep = Endpoint.publish("http://0.0.0.0:54321/ws/hello", new HelloWorldImpl());
        start();
        
    }

    public void start() {
        synchronized (this) {
            try {
                while (this.active) {
                    System.out.println("Webservice active on http://"+System.getenv("COMPUTERNAME")+":54321");
                    wait();
                 }
                } catch (InterruptedException ex) {
                    Logger.getLogger(HelloWorldPublisher.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (!active) {
                        ep.stop();
                        System.out.println("Webservice parado");
                    }
                }

            

        }

    }

}
