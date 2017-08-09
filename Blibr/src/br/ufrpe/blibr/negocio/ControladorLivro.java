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
		repoLivro = new RepositorioGenerico<>("sad");
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
			System.out.println(e.getMessage());
		}
	}

	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExisteException {
		Livro retorno = null;
		try {
			if(nomeLivro==null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else{
				//retorno = repoLivro.buscarLivrro(nomeLivro);
				for(Livro livro: listarLivros()){
					if(livro.getNomeLivro().equals(nomeLivro)){
						retorno = livro;
					}
				}
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
				repoLivro.remover(buscarLivro(nome));
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void salvarListaDeLivros(){
		File file = new File("ListaDeLivros.txt");
		try {
		
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream ous = new ObjectOutputStream(fos);
			ous.writeObject(repoLivro);
			ous.close();
		} catch (IOException e) {
		
		}
		
	}
	public void LendoListaDeLivros(){
		File file = new File("ListaDeLivros.txt");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			Livro clone = (Livro) o;
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}