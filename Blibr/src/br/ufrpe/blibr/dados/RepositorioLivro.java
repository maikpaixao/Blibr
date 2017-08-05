package br.ufrpe.blibr.dados;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.LivroExistente;
import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioLivro extends RepositorioGenerico<Livro>{
	
	private static RepositorioLivro instance;
	
	public static synchronized RepositorioLivro getInstance(){
		if(instance == null){
			instance = new RepositorioLivro();
		}
		return instance;
	}
	
	public Livro buscarLivrro(String nome)throws ElementoNaoExisteException{
		Livro retorno = null;
		try {
			for(Livro livro: this.lista){
				if(livro.getNomeLivro().equals(nome) && nome!=null){
					retorno = livro;
				}else{
					throw new ElementoNaoExisteException(livro);
				}
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
		return retorno;
	}

}