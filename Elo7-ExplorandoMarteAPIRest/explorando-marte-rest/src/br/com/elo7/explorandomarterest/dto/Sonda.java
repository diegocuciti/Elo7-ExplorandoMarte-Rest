package br.com.elo7.explorandomarterest.dto;

public class Sonda {

	Planalto planalto;
	
	private int coordenadaX;
	private int coordenadaY;
	private char direcaoCardinalInicial;
	private String instrucaoMovimentos;
	
	// Variáveis de controle
	private char direcaoAnterior = ' ';
	private char direcaoAtual = ' ';
	private char movimentoAtual = ' ';
	public static int quantidadeSondas = 0;

	public Sonda(Planalto planalto, String coordenadasSonda, String instrucaoMovimentos){
		String[] coordenadas = coordenadasSonda.split("\\s");
		
		this.planalto = planalto;
		this.coordenadaX = (Integer.valueOf(coordenadas[0]));
		this.coordenadaY = (Integer.valueOf(coordenadas[1])); 
		this.direcaoCardinalInicial = coordenadas[2].toUpperCase().charAt(0);
		this.instrucaoMovimentos = instrucaoMovimentos.toUpperCase();
		
		quantidadeSondas++;
	}
	
	public Planalto getPlanalto() {
		return planalto;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	public char getDirecaoCardinalInicial() {
		return direcaoCardinalInicial;
	}

	public String getInstrucaoMovimentos() {
		return instrucaoMovimentos;
	}

	public char getDirecaoAtual() {
		return direcaoAtual;
	}

	public void setDirecaoAtual(char direcaoAtual) {
		this.direcaoAtual = direcaoAtual;
	}

	public char getDirecaoAnterior() {
		return direcaoAnterior;
	}

	public void setDirecaoAnterior(char direcaoAnterior) {
		this.direcaoAnterior = direcaoAnterior;
	}

	public char getMovimentoAtual() {
		return movimentoAtual;
	}

	public void setMovimentoAtual(char movimentoAtual) {
		this.movimentoAtual = movimentoAtual;
	}

	public int getQuantidadeSondas() {
		return quantidadeSondas;
	}
}
