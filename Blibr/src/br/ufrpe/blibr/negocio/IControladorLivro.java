package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Livro;

public interface IControladorLivro {
	
	public void adicionarLivro(Livro livro) throws ElementoNaoExisteException;
	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExisteException;
	public void editarLivro(Livro livro) throws ElementoNaoExisteException;
	public ArrayList<Livro> listarLivros();
	public void removerLivro(String nome) throws ElementoNaoExisteException;
}
