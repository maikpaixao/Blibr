package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioEmprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorEmprestimo {
	
	private static ControladorEmprestimo instance;
	private RepositorioEmprestimo repoEmprestimo = RepositorioEmprestimo.getInstance();
	
	public static ControladorEmprestimo getInstance(){
		if(instance==null){
			instance = new ControladorEmprestimo();
		}
		return instance;
	}
	
	public void emprestarLivro(Livro livro, Usuario usuario){
		if(livro!=null && usuario!=null){
			System.out.println("sdasd");
			repoEmprestimo.emprestarLivro(livro, usuario);
		}
	}
	
	public ArrayList<Usuario> listarLivrosEmprestados(){
		return repoEmprestimo.listarLivrosEmprestados();
	}
}
