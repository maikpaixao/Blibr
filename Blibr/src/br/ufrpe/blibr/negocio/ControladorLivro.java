package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioLivro;
import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.negocio.beans.Livro;

public class ControladorLivro {
	
	private RepositorioLivro repoLivro = RepositorioLivro.getInstance();
	private static ControladorLivro instance;
	
	public static ControladorLivro getInstance(){
		if(instance==null){
			instance = new ControladorLivro();
		}
		return instance;
	}

	public void adicionarLivro(Livro livro){
		repoLivro.adicionarLivro(livro);
	}

	public Livro buscarLivro(String nomeLivro) {
		return repoLivro.buscarLivrro(nomeLivro);
	}

	public void editarLivro(Livro livro){
		repoLivro.editarLivro(livro);
	}

	public ArrayList<Livro> listarLivros() {
		return repoLivro.listarLivros();
	}

	public void removerLivro(String nome){
		repoLivro.removerLivro(nome);
	}

}