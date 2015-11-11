package br.com.elo7.explorandomarterest.exception;

public class CamposInvalidosException extends Exception {

	public CamposInvalidosException() {
		super();
	}
	
	public CamposInvalidosException(String erro) {
		super(erro);
	}
}

