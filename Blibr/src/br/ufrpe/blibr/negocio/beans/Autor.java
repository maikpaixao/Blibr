package br.ufrpe.blibr.negocio.beans;

public class Autor extends Usuario{
	
	private String nomeAutor;
	
	public String getNomeAutor() {
		return nomeAutor;
	}
	
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
}