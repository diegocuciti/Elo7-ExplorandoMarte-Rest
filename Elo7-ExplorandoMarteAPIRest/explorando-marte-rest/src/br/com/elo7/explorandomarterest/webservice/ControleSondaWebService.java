package br.com.elo7.explorandomarterest.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.web.bind.annotation.ResponseBody;

import br.com.elo7.explorandomarterest.dto.DestinoSonda;
import br.com.elo7.explorandomarterest.dto.Planalto;
import br.com.elo7.explorandomarterest.dto.Sonda;
import br.com.elo7.explorandomarterest.exception.CamposInvalidosException;
import br.com.elo7.explorandomarterest.exception.CoordenadaForaDoEixoDoPlanaltoException;
import br.com.elo7.explorandomarterest.movimento.MovimentoSonda;

/**
 * @author Diego Armelin Cuciti
 *
 *         WebService utilizado para seguintes fins: 
 *         - Receber requisições via URI, informando os dados do Planalto e das Sondas via parâmetros. Formatação: 
 *         		- Planalto: separado por espaços. Ex.: 0 0;
 *         		- Sondas: coordenadas X-Y + Direção Cardinal separadas por espaço, seguido de um hífen para informar
 *         		a instrução de movimento. Ex.: 1 2 N-LMLMLMLMM-3 3 E-MMRMMRMRRM.
 *         - Exibir retorno das coordenadas de destino das sondas informadas em formato Content-Type JSON.  
 */
@Path("/controlesonda")
public class ControleSondaWebService {

	// @GET
	// @Path("/processarDados/{planalto}/{sondas}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public @ResponseBody List<DestinoSonda>
	// processarDados(@PathParam("planalto") String planalto,
	// @PathParam("sondas") String sondas) throws
	// CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {

	// @GET
	// @Path("/processarDados")
	// @Produces(MediaType.APPLICATION_JSON)
	// public @ResponseBody List<DestinoSonda>
	// processarDados(@QueryParam("planalto") String planalto,
	// @QueryParam("sondas") String sondas) throws
	// CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {

	@GET
	@Path("/processarDados")
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<DestinoSonda> processarDados(@Context UriInfo infoUri)
			throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {

		String planalto = infoUri.getQueryParameters().getFirst("planalto");
		String sondas = infoUri.getQueryParameters().getFirst("sondas");

		Planalto planaltos = new Planalto(planalto);

		String[] arraySonda = sondas.split("-");

		List<DestinoSonda> resposta = new ArrayList<DestinoSonda>();

		for (int i = 0; i < arraySonda.length; i++) {

			Sonda sonda = new Sonda(planaltos, arraySonda[i], arraySonda[i + 1].replace(" ", ""));

			MovimentoSonda movimentoSonda = new MovimentoSonda();
			movimentoSonda.executarInstrucao(sonda);

			DestinoSonda destinoSonda = new DestinoSonda();

			destinoSonda.setCoordenadaX(sonda.getCoordenadaX());
			destinoSonda.setCoordenadaY(sonda.getCoordenadaY());
			destinoSonda.setDirecaoAtual(sonda.getDirecaoAtual());

			resposta.add(destinoSonda);

			++i;
		}

		return resposta;
	}
}
