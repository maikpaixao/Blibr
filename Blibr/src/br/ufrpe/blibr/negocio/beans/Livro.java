package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;

public class Livro implements Serializable{
	
	private int codigoLivro;
	private String nomeLivro;
	private String autorLivro;
	private int quantidadeLivros;
	
	public Livro(int codigoLivro, String nomeLivro, String autorLivro, int quantidadeLivros){
		this.codigoLivro = codigoLivro;
		this.nomeLivro = nomeLivro;
		this.autorLivro = autorLivro;
		this.quantidadeLivros = quantidadeLivros;
	}

	public int getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public int getQuantidadeLivros() {
		return quantidadeLivros;
	}

	public void setQuantidadeLivros(int quantidadeLivros) {
		this.quantidadeLivros = quantidadeLivros;
	}
	
}
