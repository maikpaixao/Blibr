package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Livro implements Serializable{
	
	private Long codigoLivro;
	private Integer quantLivros;
	private String nomeLivro;
	private String nomeAutor;
	private String editora;
	private static final long serialVersionUID = -9084900373440737932L;
	
	public Livro(){
		
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

	public Integer getQuantidadeLivros() {
		return quantLivros;
	}

	public void setQuantidadeLivros(Integer quantidadeLivros) {
		this.quantLivros = quantidadeLivros;
	}
	
	public boolean equals(Object o){
		boolean retorno = false;
		if(this.getCodigoLivro()==((Livro) o).getCodigoLivro()){
			retorno=true;
		}
		return retorno;
	}
	
	@Override
	public String toString(){
		return  nomeLivro;
	}
}