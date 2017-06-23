package br.ufrpe.blibr.dados;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.LivroExistente;
import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.negocio.beans.Livro;

public class RepositorioLivro {
	
	private static RepositorioLivro instance;
	private ArrayList<Livro> listaLivro;
	
	public static synchronized RepositorioLivro getInstance(){
		if(instance == null){
			instance = new RepositorioLivro();
		}
		return instance;
	}
	
	public RepositorioLivro(){
		this.listaLivro = new ArrayList<Livro>();
	}
	
	public void adicionarLivro(Livro livro) throws Exception{
		if(this.listaLivro.contains(livro)){
			listaLivro.add(livro);
		}else{
		throw new LivroExistente("Esse livro já existe!");
		}
	}
	
	public Livro buscarLivrro(double codigoLivro){
		for(Livro livro: listaLivro){
			if(livro.getCodigoLivro()==codigoLivro){
				return livro;
			}
		}
		return null;
	}
	
	public ArrayList<Livro> listarLivros(){
		return this.listaLivro;
	}
	
	public void removerLivro(Livro livro) throws LivroNaoExistente{
		if(this.listaLivro.contains(livro)){
			this.listaLivro.remove(livro);
		}else{
			throw new LivroNaoExistente("Esse livro não existe!");
		}
	}
	
	public void editarLivro(Livro livro) throws LivroNaoExistente{
		if (this.listaLivro.contains(livro)) {
            int indice = this.listaLivro.indexOf(livro);
            this.listaLivro.set(indice, livro);
        } else {
            throw new LivroNaoExistente("Esse livro nao existe!");
        }
	}
}