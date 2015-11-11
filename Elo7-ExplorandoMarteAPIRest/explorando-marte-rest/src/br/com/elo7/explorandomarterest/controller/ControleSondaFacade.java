package br.com.elo7.explorandomarterest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.ResponseBody;

import br.com.elo7.explorandomarterest.dto.Comando;
import br.com.elo7.explorandomarterest.dto.Planalto;
import br.com.elo7.explorandomarterest.dto.Sonda;
import br.com.elo7.explorandomarterest.exception.CamposInvalidosException;
import br.com.elo7.explorandomarterest.exception.CoordenadaForaDoEixoDoPlanaltoException;
import br.com.elo7.explorandomarterest.movimento.MovimentoSonda;

//@Controller
@Path("/controlesonda")
public class ControleSondaFacade {

	StringBuilder coordenadaDestino = new StringBuilder();
	
	Sonda sonda;
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{planalto}/{sondas}/{instrucao}")
//	public Sonda teste(@PathParam("planalto") String planalto, 
//						@PathParam("sondas") String sondas,
//						@PathParam("instrucao") String instrucao) {
//		return sonda.;
//	}

//	public String processarDados(String coordenadasPlanalto, String coordenadasSonda)
//			throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/processarDados/{planalto}/{sondas}")
	public @ResponseBody List<Sonda> teste(@PathParam("planalto") String planalto, 
											@PathParam("sondas") String sondas) throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {

		Planalto planaltos = new Planalto(planalto);

		String[] arraySonda = sondas.split("-");

		List<Sonda> resposta = new ArrayList<Sonda>();
		
		for (int i = 0; i < arraySonda.length; i++) {

			Sonda sonda = new Sonda(planaltos, arraySonda[i], arraySonda[i+1].replace(" ", ""));

			MovimentoSonda movimentoSonda = new MovimentoSonda();
			movimentoSonda.executarInstrucao(sonda);

			sonda.setNomeSonda("Sonda " + i);
			resposta.add(sonda);
			processarSaida(sonda);

			++i;
		}

		return resposta;
	}

	public String processarSaida(Sonda sonda) {
		coordenadaDestino
				.append(String.valueOf(
						sonda.getCoordenadaX() + " " + sonda.getCoordenadaY() + " " + sonda.getDirecaoAtual() + "\n"))
				.toString();

		return coordenadaDestino.toString();
	}

	public void limparQuantidadeSondas() {
		Sonda.quantidadeSondas = 0;
	}

	public StringBuilder getCoordenadaDestino() {
		return coordenadaDestino;
	}

}
