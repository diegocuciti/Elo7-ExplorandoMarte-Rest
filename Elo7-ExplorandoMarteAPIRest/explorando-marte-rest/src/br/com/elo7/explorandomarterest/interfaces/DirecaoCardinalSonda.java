package br.com.elo7.explorandomarterest.interfaces;

import br.com.elo7.explorandomarterest.dto.*;

public interface DirecaoCardinalSonda {

	// Alterar os valores das coordenadas X-Y da sonda
	public void alterarCoordenadas(Sonda coordenadas);
	
	// Recuperar dire��o atual, atrav�s do movimento atual da instru��o
	public void recuperarDirecaoAtual(Sonda coordenadas);

}
