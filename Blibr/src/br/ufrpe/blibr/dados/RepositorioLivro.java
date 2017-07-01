package br.ufrpe.blibr.dados;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.LivroExistente;
import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioLivro {
	
	private static RepositorioLivro instance;
	private ArrayList<Livro> listaLivro = new ArrayList<Livro>();
	
	public static synchronized RepositorioLivro getInstance(){
		if(instance == null){
			instance = new RepositorioLivro();
		}
		return instance;
	}
	
	public void adicionarLivro(Livro livro){
		if(livro!=null && !this.listaLivro.contains(livro)){
			listaLivro.add(livro);
		}
	}
	
	public ArrayList<Livro> listarLivros(){
		return this.listaLivro;
	}
	
	public Livro buscarLivrro(String nome){
		Livro retorno = null;
		for(Livro livro: listaLivro){
			if(livro.getNomeLivro().equals(nome) && nome!=null){
				retorno = livro;
			}
		}
		return retorno;
	}
	
	public void editarLivro(Livro livro){
		for(Livro li: listaLivro){
			if (li.getNomeLivro().equals(livro.getNomeLivro()) && livro!=null){
				int indice = this.listaLivro.indexOf(li);
				listaLivro.set(indice, livro);
		     }else{
		        	
		     }
		}
	}
	
	public void removerLivro(String nome){
		for(Livro li: listaLivro){
			if(li.getNomeLivro().equals(nome) && nome!=null){
				this.listaLivro.remove(li);
				break;
			}
		}
	}
}