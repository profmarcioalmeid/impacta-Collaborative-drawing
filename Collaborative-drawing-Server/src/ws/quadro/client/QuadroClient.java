package ws.quadro.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

 
import ws.quadro.Quadro;

public class QuadroClient {
	public static void main(String[] args) throws MalformedURLException{
		
		URL url = new URL("http://10.0.200.243:54321/quadro?wsdl");
		QName qname = new QName("http://quadro.ws/","QuadroImplService");
		
		Service service = Service.create(url, qname);
		Quadro quadro =  service.getPort(Quadro.class);
                 
                quadro.setRemetente("TESTE");
                for(int i=10; i <= 100; i++ ){                    
                    quadro.setDesenho("<circle id=\"1\" cx=\""+i+"\" cy=\"300\" r=\"10\" stroke=\"Black\" stroke-width=\"10\" fill=\"#00FFFF\"  />");
               }
                
              /*  String desenho = quadro.getDesenho();
                System.err.println(" Remetente "+ quadro.getRemetente());
		for(;;)	
                {
                  if (quadro.getDesenho()!=null && !quadro.getDesenho().equals(desenho)){
                    System.out.println(quadro.getRemetente());
                    System.out.println(quadro.getDesenho());
                    desenho=quadro.getDesenho();
                    }
                }*/
		 
		
	}

}
