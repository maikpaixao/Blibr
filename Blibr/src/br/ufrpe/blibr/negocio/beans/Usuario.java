package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;

public class Usuario extends Pessoa{
	
	private Livro livro;
	private boolean pendenciaMulta = false;
	private double valorMulta=0;
	
	public Usuario(String nome, String cpf, String sexo, String idade){
		super(nome, cpf, idade, sexo);
	}
	
	public Usuario(){
		
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public boolean getPendenciaMulta() {
		return pendenciaMulta;
	}

	public void setPendenciaMulta(boolean pendenciaMulta) {
		this.pendenciaMulta = pendenciaMulta;
	}

	public double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(double valorMulta) {
		this.valorMulta = valorMulta;
	}
	
}
