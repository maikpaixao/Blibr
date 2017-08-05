package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Livro implements Serializable{
	
	private Long codigoLivro;
	private int quantidadeLivros;
	private String nomeLivro;
	private Autor autorLivro;
	private String editora;
	
	public Livro(){
		this.quantidadeLivros = 10;
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

	public Autor getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(Autor autorLivro) {
		this.autorLivro = autorLivro;
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
		if(this.getCodigoLivro()==((Livro) o).getCodigoLivro()){
			retorno=true;
		}
		return retorno;
	}
	
	@Override
	public String toString(){
		return "Codigo do Livro: " + codigoLivro + "\n"
				+"Quantidade de Livros(Estoque): "+ quantidadeLivros + "\n"
				+"Nome do Livro: " + nomeLivro + "\n"
				+"Autor do Livro: " + autorLivro.getNome() + "\n"
				+"Editora: " + editora;
	}
}