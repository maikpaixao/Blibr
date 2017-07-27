package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;

public class Usuario extends Pessoa{
	
	private static long nextId = 1;
	private Long idUsuario;
	private Livro livro;
	private boolean pendenciaMulta = false;
	private double valorMulta=0;
	
	public Usuario(String nome, Long cpf, String sexo, int idade){
		super(nome, cpf, idade, sexo);
	}
	
	public Usuario(){
		this.idUsuario = nextId;
		nextId++;
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

	public String toString() {
		return "Id do Usuario: " + idUsuario + "Nome do Usuario: "+getNome()+" CPF do Usuario: "+getCpf()+", livro=" + livro + ", pendenciaMulta=" + pendenciaMulta
				+ ", valorMulta=" + valorMulta + "]";
	}
	
}
