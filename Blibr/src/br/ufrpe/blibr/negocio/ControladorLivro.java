package br.ufrpe.blibr.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorLivro implements IControladorLivro{
	
	private IRepositorio<Livro> repoLivro;
	private static ControladorLivro instance;
	
	private ControladorLivro(){
		repoLivro = new RepositorioGenerico<>("livro.arq");
	}
	
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
			e.printStackTrace();
		}
	}

	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExisteException {
		Livro retorno = null;
		try {
			if(nomeLivro==null){
				throw new ElementoNaoExisteException(nomeLivro);
			}else{
				for(Livro livro: listarLivros()){
					if(livro.getNomeLivro().equals(nomeLivro)){
						retorno = livro;
					}
				}
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public void editarLivro(Livro livro) throws ElementoNaoExisteException{
		try {
			if(livro==null){
				throw new ElementoNaoExisteException(livro);
			}else{
				repoLivro.atualizar(livro);
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}

	public List<Livro> listarLivros() {
		List<Livro> lista = repoLivro.listar();
		return lista;
	}

	public void removerLivro(String nome) throws ElementoNaoExisteException{
		try {
			if(nome==null){
				throw new ElementoNaoExisteException(nome);
			}else{
				repoLivro.remover(buscarLivro(nome));
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}
	
}