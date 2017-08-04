package br.ufrpe.blibr.negocio.beans;

public class Autor extends Usuario{
	
	private String nomeAutor;
	private Livro livroAutor;
	
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public Livro getLivroAutor() {
		return livroAutor;
	}
	public void setLivroAutor(Livro livroAutor) {
		this.livroAutor = livroAutor;
	}
}