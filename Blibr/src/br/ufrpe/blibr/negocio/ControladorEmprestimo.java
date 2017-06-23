package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.dados.RepositorioEmprestimo;
import br.ufrpe.blibr.dados.RepositorioLivro;
import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorEmprestimo {
	
	private int livroEmprestado;
	private static ControladorEmprestimo instance;
	private RepositorioEmprestimo repoEmprestimo;
	
	public ControladorEmprestimo getInstance(){
		if(instance==null){
			instance = new ControladorEmprestimo();
		}
		return instance;
	}
	
	public void emprestarLivro(Livro livro, Usuario usuario){
		repoEmprestimo.emprestarLivro(livro, usuario);
	}
}
