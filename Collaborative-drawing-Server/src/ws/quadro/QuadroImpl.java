package ws.quadro;

import javax.jws.WebService;

@WebService(endpointInterface = "ws.quadro.Quadro")
public class QuadroImpl implements Quadro {
	private String desenho;
	private String remetente;

	@Override
	public void setDesenho(String desenho) {
		this.desenho = desenho;
	}
        @Override
        public void setRemetente(String id) {
            this.remetente = id;
        }
        
	@Override
	public String getDesenho() {
		return this.desenho;
	}
	
	@Override
	public String test(){
		return "Teste";
	}
    @Override
    public String getRemetente() {
       return this.remetente;
    }



}
