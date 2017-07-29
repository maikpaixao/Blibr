package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.ElementoNaoExistente;
import br.ufrpe.blibr.negocio.beans.Livro;

public interface IControladorLivro {
	
	public void adicionarLivro(Livro livro) throws ElementoNaoExistente;
	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExistente;
	public void editarLivro(Livro livro) throws ElementoNaoExistente;
	public ArrayList<Livro> listarLivros();
	public void removerLivro(String nome) throws ElementoNaoExistente;
}
