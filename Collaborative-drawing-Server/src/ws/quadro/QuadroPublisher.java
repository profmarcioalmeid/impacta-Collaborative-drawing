package ws.quadro;

import javax.xml.ws.Endpoint;

public class QuadroPublisher {

	
	public static void main(String[ ] args) {
            System.out.println("Servidor está executando !");
	      Endpoint.publish("http://0.0.0.0:54321/quadro", new QuadroImpl());

	    }
	
}
