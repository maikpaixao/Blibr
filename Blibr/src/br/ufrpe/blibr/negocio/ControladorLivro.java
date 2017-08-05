package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.dados.RepositorioLivro;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Livro;

public class ControladorLivro implements IControladorLivro{
	
	private RepositorioLivro repoLivro = RepositorioLivro.getInstance();
	private static ControladorLivro instance;
	
	public static ControladorLivro getInstance(){
		if(instance==null){
			instance = new ControladorLivro();
		}
		return instance;
	}

	public void adicionarLivro(Livro livro) throws ElementoNaoExisteException, ElementoJaExisteException{
		try {
			if(livro==null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else{
				repoLivro.adicionar(livro);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}

	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExisteException {
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

	public void editarLivro(Livro livro) throws ElementoNaoExisteException{
		try {
			if(livro==null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else{
				repoLivro.atualizar(livro);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Livro> listarLivros() {
		return repoLivro.listar();
	}

	public void removerLivro(String nome) throws ElementoNaoExisteException{
		try {
			if(nome==null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else{
				repoLivro.remover(repoLivro.buscarLivrro(nome));
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}
}