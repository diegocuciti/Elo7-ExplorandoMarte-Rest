package br.com.elo7.explorandomarterest.dto;

public class Planalto {
	
	private int coordenadaPontoInferiorX = 0;
	private int coordenadaPontoInferiorY = 0;
	private int coordenadaPontoSuperiorX;
	private int coordenadaPontoSuperiorY;

	public Planalto(String coordenadasPlanalto) {
		String[] arrayPlanalto = coordenadasPlanalto.split("\\s");
		this.coordenadaPontoSuperiorX = Integer.valueOf(arrayPlanalto[0]);
		this.coordenadaPontoSuperiorY = Integer.valueOf(arrayPlanalto[1]);
	}

	public int getCoordenadaPontoInferiorX() {
		return coordenadaPontoInferiorX;
	}

	public int getCoordenadaPontoInferiorY() {
		return coordenadaPontoInferiorY;
	}

	public int getCoordenadaPontoSuperiorX() {
		return coordenadaPontoSuperiorX;
	}

	public int getCoordenadaPontoSuperiorY() {
		return coordenadaPontoSuperiorY;
	}
}
