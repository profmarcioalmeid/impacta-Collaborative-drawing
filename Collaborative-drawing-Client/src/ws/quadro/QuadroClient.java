package ws.quadro;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class QuadroClient {
	public static void main(String[] args) throws MalformedURLException, InterruptedException{		
		URL url = new URL("http://10.0.200.243:54321/quadro?wsdl");
		QName qname = new QName("http://quadro.ws/","QuadroImplService");		
		Service service = Service.create(url, qname);
		Quadro quadro =  service.getPort(Quadro.class);			
						for(int i=10; i < 100; i++){
							//Thread.sleep(500l);
							quadro.setRemetente("Jos� ");
							quadro.setDesenho("<circle id=\"1\" cx=\""+i+"\" cy=\"350\" r=\"10\" stroke=\"Black\" stroke-width=\"10\" fill=\"#00FFFF\"  />");
							System.out.println(quadro.getDesenho());
						}		
	}
}
