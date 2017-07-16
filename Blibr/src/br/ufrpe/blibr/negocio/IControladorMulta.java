package br.ufrpe.blibr.negocio;

public interface IControladorMulta {

	public void atribuirMulta(String cpf);
	public Double pagarMulta(String cpf, Double valor);
}
