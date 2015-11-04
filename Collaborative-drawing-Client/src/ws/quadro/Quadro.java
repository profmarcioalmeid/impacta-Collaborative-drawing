package ws.quadro;



import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Quadro {

	@WebMethod void setDesenho(String svg);
	@WebMethod String getDesenho(); 
	@WebMethod String test();
	
}
