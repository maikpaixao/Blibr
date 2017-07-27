package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Livro implements Serializable{
	
	private static long nextCod = 1;
	
	private Long codigoLivro;
	private int quantidadeLivros;
	private String nomeLivro;
	private String autorLivro;
	private String editora;
	
	public Livro(String nomeLivro, String autorLivro, String editora){
		this.nomeLivro = nomeLivro;
		this.autorLivro = autorLivro;
		this.editora = editora;
	}
	
	public Livro(){
		this.codigoLivro = nextCod;
		nextCod++;
		
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

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
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

	@Override
	public String toString() {
		return "| Codigo do Livro: " + codigoLivro + "| Quantidade de Livros(Estoque): " + quantidadeLivros +
				"| Nome do Livro=" + nomeLivro + "| Autor do Livro=" + autorLivro + "| Editora=" + editora;
	}
	
}
