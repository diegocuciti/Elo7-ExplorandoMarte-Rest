package br.com.elo7.explorandomarterest.movimento;

import br.com.elo7.explorandomarterest.dto.Sonda;
import br.com.elo7.explorandomarterest.enums.DirecaoCardinal;
import br.com.elo7.explorandomarterest.enums.InstrucaoMovimento;
import br.com.elo7.explorandomarterest.exception.CamposInvalidosException;
import br.com.elo7.explorandomarterest.exception.CoordenadaForaDoEixoDoPlanaltoException;

public class MovimentoSonda {

	public Sonda executarInstrucao(Sonda sonda)
			throws CoordenadaForaDoEixoDoPlanaltoException, CamposInvalidosException {

		// Validar tamanho das coordenadas X-Y de entrada da sonda
		validarEixoCoordenadasSondaPlanalto(sonda);

		for (int i = 0; i < sonda.getInstrucaoMovimentos().length(); i++) {

			validarMovimentoAtual(i, sonda);

			if (i == 0) {
				sonda.setDirecaoAnterior(sonda.getDirecaoCardinalInicial());
				sonda.setDirecaoAtual(sonda.getDirecaoCardinalInicial());
			} else {
				sonda.setDirecaoAnterior(sonda.getDirecaoAtual());
			}

			if (sonda.getMovimentoAtual() != InstrucaoMovimento.MOVE.getValor()) {
				buscarDirecaoAtual(sonda);
			} else {
				atribuirCoordenadasSonda(sonda);
				// Validar tamanho das coordenadas X-Y da instrução atual da
				// sonda
				validarEixoCoordenadasSondaPlanalto(sonda);
			}

			sonda.setDirecaoAnterior(sonda.getDirecaoAtual());
		}
		return sonda;
	}

	// Realizar manutenção nas coordenadas X-Y da sonda
	public Sonda atribuirCoordenadasSonda(Sonda sonda) throws CamposInvalidosException {

		try {
			DirecaoCardinal.find(sonda.getDirecaoAtual()).alterarCoordenadas(sonda);
		} catch (CamposInvalidosException e) {
			throw new CamposInvalidosException("Sonda possui Direção Cardinal inválida.");
		}
		return sonda;
	}

	// Buscar a direção atual, através do movimento de instrução atual
	public Sonda buscarDirecaoAtual(Sonda sonda) throws CamposInvalidosException {

		try {
			DirecaoCardinal.find(sonda.getDirecaoAnterior()).recuperarDirecaoAtual(sonda);
		} catch (CamposInvalidosException e) {
			throw new CamposInvalidosException("Sonda possui Direção Cardinal inválida.");
		}
		return sonda;
	}

	// Validar se as coordenadas X-Y da sonda são válidas, com base nas
	// coordenadas do ponto inferior-esquerdo e
	// superior-direito do planalto
	public void validarEixoCoordenadasSondaPlanalto(Sonda sonda) throws CoordenadaForaDoEixoDoPlanaltoException {

		if ((sonda.getCoordenadaX() < sonda.getPlanalto().getCoordenadaPontoInferiorX())
				|| (sonda.getCoordenadaX() > sonda.getPlanalto().getCoordenadaPontoSuperiorX()))
			tratarMensagemErro('X', sonda);
		else if ((sonda.getCoordenadaY() < sonda.getPlanalto().getCoordenadaPontoInferiorY())
				|| (sonda.getCoordenadaY() > sonda.getPlanalto().getCoordenadaPontoSuperiorY()))
			tratarMensagemErro('Y', sonda);
	}

	public void tratarMensagemErro(char coordenada, Sonda sonda) throws CoordenadaForaDoEixoDoPlanaltoException {
		throw new CoordenadaForaDoEixoDoPlanaltoException("Sonda estourou o limite do eixo " + coordenada
				+ " do planalto e não foi processada por completo. As próximas sondas não seram processadas!");
	}

	public void validarMovimentoAtual(int i, Sonda sonda) throws CamposInvalidosException {
		sonda.setMovimentoAtual(sonda.getInstrucaoMovimentos().charAt(i));

		if ((sonda.getMovimentoAtual() != InstrucaoMovimento.MOVE.getValor())
				&& (sonda.getMovimentoAtual() != InstrucaoMovimento.LEFT.getValor())
				&& (sonda.getMovimentoAtual() != InstrucaoMovimento.RIGHT.getValor())) {
			throw new CamposInvalidosException("Sonda possui instrução de movimento inválida. Movimento de instrução: "
					+ sonda.getMovimentoAtual() + " é uma instrução inválida. Instruções válidas: L R M ");
		}
	}
}
