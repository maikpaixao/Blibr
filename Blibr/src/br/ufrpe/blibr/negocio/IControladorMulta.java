package br.ufrpe.blibr.negocio;

public interface IControladorMulta {

	public void atribuirMulta(Long cpf);
	public Double pagarMulta(Long cpf, Double valor);
}
