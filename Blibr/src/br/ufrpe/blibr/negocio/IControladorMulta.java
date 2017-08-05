package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;

public interface IControladorMulta {

	public void atribuirMulta(Long cpf,  Long dias) throws ElementoNaoExisteException;
	public Double pagarMulta(Long cpf, Double valor) throws ElementoNaoExisteException;
}