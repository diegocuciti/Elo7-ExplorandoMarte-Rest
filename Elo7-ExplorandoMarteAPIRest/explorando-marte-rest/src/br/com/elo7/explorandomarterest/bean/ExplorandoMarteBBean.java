package br.com.elo7.explorandomarterest.bean;

import javax.faces.bean.ManagedBean;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.elo7.explorandomarterest.dto.Sonda;
import br.com.elo7.explorandomarterest.exception.CamposInvalidosException;
import br.com.elo7.explorandomarterest.exception.CoordenadaForaDoEixoDoPlanaltoException;

@ManagedBean
public class ExplorandoMarteBBean {

	private static final String SERVER_URI = "http://localhost:8080/explorando-marte-rest/ws/controlesonda/processarDados/5 5/1 2 N/LMLMLMLMM";
	String planalto;
	String sondas;
	
	Sonda sonda;
	
	public String executarProcessaDados() throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {
		
//		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println(planalto);
		System.out.println(sondas);
		
	    Client c = Client.create();
	   
	    WebResource wr = c.resource(SERVER_URI);
//	    wr.p
	    return wr.get(String.class);
	    
		//String response = restTemplate.postForObject(SERVER_URI, String.class,String.class, planalto,sondas);
//		ControleSondaFacade controleSonda = new ControleSondaFacade();
//		controleSonda.processarDados(planalto, sondas);
		
	//	JSONObject json = new JSONObject();

//		json.put("CoordenadasDestino:", controleSonda.getCoordenadaDestino());
		
//		return "explorando-marte";
	}

	public String getPlanalto() {
		return planalto;
	}

	public void setPlanalto(String planalto) {
		this.planalto = planalto;
	}

	public String getSondas() {
		return sondas;
	}

	public void setSondas(String sondas) {
		this.sondas = sondas;
	}
}
