package br.com.elo7.explorandomarterest.interfaces;

import br.com.elo7.explorandomarterest.dto.*;

public interface DirecaoCardinalSonda {

	// Alterar os valores das coordenadas X-Y da sonda
	public void alterarCoordenadas(Sonda coordenadas);
	
	// Recuperar direção atual, através do movimento atual da instrução
	public void recuperarDirecaoAtual(Sonda coordenadas);

}
