package br.com.elo7.explorandomarterest.enums;

import br.com.elo7.explorandomarterest.dto.Sonda;
import br.com.elo7.explorandomarterest.enums.DirecaoCardinal;
import br.com.elo7.explorandomarterest.enums.InstrucaoMovimento;
import br.com.elo7.explorandomarterest.interfaces.DirecaoCardinalSonda;

public enum DirecaoCardinal implements DirecaoCardinalSonda {
	
	NORTH('N') {
		@Override
		public void alterarCoordenadas(Sonda coordenadasY) {
			coordenadasY.setCoordenadaY(coordenadasY.getCoordenadaY() + 1);
		}

		@Override
		public void recuperarDirecaoAtual(Sonda coordenadas) {
			if (coordenadas.getMovimentoAtual() == InstrucaoMovimento.LEFT.getValor())
				coordenadas.setDirecaoAtual(DirecaoCardinal.WEST.codigoDirecaoCardinal);
			else 
				coordenadas.setDirecaoAtual(DirecaoCardinal.EAST.codigoDirecaoCardinal);
		}
	},
	
	SOUTH('S') {
		@Override
		public void alterarCoordenadas(Sonda coordenadasY) {
			coordenadasY.setCoordenadaY(coordenadasY.getCoordenadaY() - 1);
		}
		
		@Override
		public void recuperarDirecaoAtual(Sonda coordenadas) {
			if (coordenadas.getMovimentoAtual() == InstrucaoMovimento.LEFT.getValor())
				coordenadas.setDirecaoAtual(DirecaoCardinal.EAST.codigoDirecaoCardinal);
			else 
				coordenadas.setDirecaoAtual(DirecaoCardinal.WEST.codigoDirecaoCardinal);
		}
	},
	
	EAST('E') {
		@Override
		public void alterarCoordenadas(Sonda coordenadasX) {
			coordenadasX.setCoordenadaX(coordenadasX.getCoordenadaX() + 1);
		}
		
		@Override
		public void recuperarDirecaoAtual(Sonda coordenadas) {
			if (coordenadas.getMovimentoAtual() == InstrucaoMovimento.LEFT.getValor())
				coordenadas.setDirecaoAtual(DirecaoCardinal.NORTH.codigoDirecaoCardinal);
			else 
				coordenadas.setDirecaoAtual(DirecaoCardinal.SOUTH.codigoDirecaoCardinal);
		}
	},
	
	WEST('W') {
		@Override
		public void alterarCoordenadas(Sonda coordenadasX) {
			coordenadasX.setCoordenadaX(coordenadasX.getCoordenadaX() - 1);
		}
	
		@Override
		public void recuperarDirecaoAtual(Sonda coordenadas) {
			if (coordenadas.getMovimentoAtual() == InstrucaoMovimento.LEFT.getValor())
				coordenadas.setDirecaoAtual(DirecaoCardinal.SOUTH.codigoDirecaoCardinal);
			else 
				coordenadas.setDirecaoAtual(DirecaoCardinal.NORTH.codigoDirecaoCardinal);
		}
	};

	private char codigoDirecaoCardinal;
	
	private DirecaoCardinal(char direcaoCardinal) {
		this.codigoDirecaoCardinal = direcaoCardinal;
	}

	public char getCodigoDirecaoCardinal() {
		return codigoDirecaoCardinal;
	}

}
