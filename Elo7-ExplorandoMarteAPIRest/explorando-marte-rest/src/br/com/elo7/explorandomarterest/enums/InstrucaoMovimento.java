package br.com.elo7.explorandomarterest.enums;

public enum InstrucaoMovimento {

	LEFT('L'),
	
	RIGHT('R'),
	
	MOVE('M');
	
	private char valor;
	
	private InstrucaoMovimento(char valor) {
		this.valor = valor;
	}

	public char getValor() {
		return valor;
	}
}

