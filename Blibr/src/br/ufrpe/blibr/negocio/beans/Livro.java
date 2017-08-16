package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Livro implements Serializable{
	
	private Long codigoLivro = 1L;
	private int quantidadeLivros;
	private String nomeLivro;
	private String nomeAutor;
	private String editora;
	private static final long serialVersionUID = -9084900373440737932L;
	
	public Livro(){
		codigoLivro = codigoLivro+1;
	}

	public Long getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Long codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getAutorLivro() {
		return nomeAutor;
	}

	public void setAutorLivro(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getQuantidadeLivros() {
		return quantidadeLivros;
	}

	public void setQuantidadeLivros(int quantidadeLivros) {
		this.quantidadeLivros = quantidadeLivros;
	}
	
	public boolean equals(Object o){
		boolean retorno = false;
		if(this.getNomeLivro()==((Livro) o).getNomeLivro()){
			retorno=true;
		}
		return retorno;
	}
	
	@Override
	public String toString(){
		return  nomeLivro;
	}
}