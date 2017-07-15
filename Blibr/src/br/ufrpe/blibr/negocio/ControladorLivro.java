package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioLivro;
import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
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
		try {
			if(livro==null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else{
				repoLivro.adicionarLivro(livro);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}

	public Livro buscarLivro(String nomeLivro) {
		Livro retorno = null;
		try {
			if(nomeLivro==null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else{
				retorno = repoLivro.buscarLivrro(nomeLivro);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}

	public void editarLivro(Livro livro){
		try {
			if(livro==null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else{
				repoLivro.editarLivro(livro);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Livro> listarLivros() {
		return repoLivro.listarLivros();
	}

	public void removerLivro(String nome){
		try {
			if(nome==null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else{
				repoLivro.removerLivro(nome);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}
}