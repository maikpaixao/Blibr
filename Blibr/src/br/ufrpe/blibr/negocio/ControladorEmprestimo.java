package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.dados.RepositorioEmprestimo;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorEmprestimo {
	
	private static ControladorEmprestimo instance;
	private RepositorioEmprestimo repoEmprestimo;
	
	public ControladorEmprestimo getInstance(){
		if(instance==null){
			instance = new ControladorEmprestimo();
		}
		return instance;
	}
	
	public void emprestarLivro(Livro livro, Usuario usuario){
		if(livro!=null && usuario!=null){
			repoEmprestimo.emprestarLivro(livro, usuario);
		}
	}
}
