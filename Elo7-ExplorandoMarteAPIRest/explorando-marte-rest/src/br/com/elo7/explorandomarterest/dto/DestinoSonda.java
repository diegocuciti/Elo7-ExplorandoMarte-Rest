package br.com.elo7.explorandomarterest.dto;

public class DestinoSonda {

	private int coordenadaX;
	private int coordenadaY;
	private char direcaoAtual = ' ';

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

	public char getDirecaoAtual() {
		return direcaoAtual;
	}

	public void setDirecaoAtual(char direcaoAtual) {
		this.direcaoAtual = direcaoAtual;
	}

}
