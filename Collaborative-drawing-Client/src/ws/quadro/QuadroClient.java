package ws.quadro;

import java.net.MalformedURLException;
import java.net.URL;
 
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class QuadroClient {
	public static void main(String[] args) throws MalformedURLException{
		
		URL url = new URL("http://127.0.0.1:54321/quadro?wsdl");
		QName qname = new QName("http://quadro.ws/","QuadroImplService");
		
		Service service = Service.create(url, qname);
		Quadro quadro =  service.getPort(Quadro.class);
                       quadro.setDesenho("<circle id=\"1\" cx=\"100\" cy=\"200\" r=\"10\" stroke=\"Black\" stroke-width=\"10\" fill=\"#00FFFF\"  />");
		
		System.out.println(quadro.getDesenho());
		 
		
	}
 

}
