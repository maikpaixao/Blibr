package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.negocio.beans.Livro;

public interface IControladorLivro {
	
	public void adicionarLivro(Livro livro);
	public Livro buscarLivro(String nomeLivro);
	public void editarLivro(Livro livro);
	public ArrayList<Livro> listarLivros();
	public void removerLivro(String nome);
}
