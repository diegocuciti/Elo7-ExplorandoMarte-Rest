package br.com.elo7.explorandomarterest.enums;

import java.util.Arrays;

import br.com.elo7.explorandomarterest.dto.Sonda;
import br.com.elo7.explorandomarterest.exception.CamposInvalidosException;

public enum DirecaoCardinal {

	NORTH('N') {
		@Override
		public void alterarCoordenadas(Sonda sonda) {
			sonda.setCoordenadaY(sonda.getCoordenadaY() + 1);
		}

		@Override
		public void recuperarDirecaoAtual(Sonda sonda) {
			if (sonda.getMovimentoAtual() == InstrucaoMovimento.LEFT.getValor())
				sonda.setDirecaoAtual(DirecaoCardinal.WEST.codigoDirecaoCardinal);
			else
				sonda.setDirecaoAtual(DirecaoCardinal.EAST.codigoDirecaoCardinal);
		}
	},

	SOUTH('S') {
		@Override
		public void alterarCoordenadas(Sonda sonda) {
			sonda.setCoordenadaY(sonda.getCoordenadaY() - 1);
		}

		@Override
		public void recuperarDirecaoAtual(Sonda sonda) {
			if (sonda.getMovimentoAtual() == InstrucaoMovimento.LEFT.getValor())
				sonda.setDirecaoAtual(DirecaoCardinal.EAST.codigoDirecaoCardinal);
			else
				sonda.setDirecaoAtual(DirecaoCardinal.WEST.codigoDirecaoCardinal);
		}
	},

	EAST('E') {
		@Override
		public void alterarCoordenadas(Sonda sonda) {
			sonda.setCoordenadaX(sonda.getCoordenadaX() + 1);
		}

		@Override
		public void recuperarDirecaoAtual(Sonda sonda) {
			if (sonda.getMovimentoAtual() == InstrucaoMovimento.LEFT.getValor())
				sonda.setDirecaoAtual(DirecaoCardinal.NORTH.codigoDirecaoCardinal);
			else
				sonda.setDirecaoAtual(DirecaoCardinal.SOUTH.codigoDirecaoCardinal);
		}
	},

	WEST('W') {
		@Override
		public void alterarCoordenadas(Sonda sonda) {
			sonda.setCoordenadaX(sonda.getCoordenadaX() - 1);
		}

		@Override
		public void recuperarDirecaoAtual(Sonda sonda) {
			if (sonda.getMovimentoAtual() == InstrucaoMovimento.LEFT.getValor())
				sonda.setDirecaoAtual(DirecaoCardinal.SOUTH.codigoDirecaoCardinal);
			else
				sonda.setDirecaoAtual(DirecaoCardinal.NORTH.codigoDirecaoCardinal);
		}
	};

	private char codigoDirecaoCardinal;

	private DirecaoCardinal(char direcaoCardinal) {
		this.codigoDirecaoCardinal = direcaoCardinal;
	}

	public abstract void alterarCoordenadas(Sonda sonda);

	public abstract void recuperarDirecaoAtual(Sonda sonda);

	public static DirecaoCardinal find(char direcao) throws CamposInvalidosException {

		for (DirecaoCardinal direcaoCardinal : DirecaoCardinal.values())

			if (Arrays.asList(direcaoCardinal.getCodigoDirecaoCardinal()).contains(direcao))
				return direcaoCardinal;

		throw new CamposInvalidosException();

	}

	public char getCodigoDirecaoCardinal() {
		return codigoDirecaoCardinal;
	}

}
