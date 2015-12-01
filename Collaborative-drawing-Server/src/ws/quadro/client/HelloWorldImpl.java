package ws.quadro.client;

import javax.jws.WebService;

import ws.teste.HelloWorld;

@WebService(endpointInterface="ws.teste.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorld(String name) {
		 
		return "Ola JAX-WS "+ name;
	}

}
