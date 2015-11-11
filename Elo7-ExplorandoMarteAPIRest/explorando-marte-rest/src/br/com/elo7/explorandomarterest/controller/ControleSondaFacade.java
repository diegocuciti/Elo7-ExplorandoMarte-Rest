package br.com.elo7.explorandomarterest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.elo7.explorandomarterest.dto.Planalto;
import br.com.elo7.explorandomarterest.dto.Sonda;
import br.com.elo7.explorandomarterest.exception.CamposInvalidosException;
import br.com.elo7.explorandomarterest.exception.CoordenadaForaDoEixoDoPlanaltoException;
import br.com.elo7.explorandomarterest.movimento.MovimentoSonda;

@Path("/controlesonda/testes")
public class ControleSondaFacade {

	StringBuilder coordenadaDestino = new StringBuilder();
	
	Sonda sonda;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{nome}")
	public String teste(@PathParam("nome") String nome) {
		return "Olá: " + nome;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/processarDados")
	public String processarDados(String coordenadasPlanalto, String coordenadasSonda)
			throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {

		Planalto planalto = new Planalto(coordenadasPlanalto);

		String[] arraySonda = coordenadasSonda.split("\r\n");

		for (int i = 0; i < arraySonda.length; i++) {

			sonda = new Sonda(planalto, arraySonda[i], arraySonda[i + 1].replace(" ", ""));

			MovimentoSonda movimentoSonda = new MovimentoSonda();
			movimentoSonda.executarInstrucao(sonda);

			processarSaida(sonda);

			++i;
		}

		return String.valueOf(getCoordenadaDestino());
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
