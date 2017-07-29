package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.exception.ElementoNaoExistente;

public interface IControladorMulta {

	public void atribuirMulta(Long cpf) throws ElementoNaoExistente;
	public Double pagarMulta(Long cpf, Double valor) throws ElementoNaoExistente;
}
