package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.ufrpe.blibr.dados.RepositorioEmprestimo;
import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorEmprestimo {
	
	private static ControladorEmprestimo instance;
	private RepositorioEmprestimo repoEmprestimo = RepositorioEmprestimo.getInstance();
	private ControladorMulta  multa = new ControladorMulta();
	private RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	
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
	
	public void verificarEmprestimo(String nome){
		Date data = new Date();
		if(data.after(repoUsuario.buscarUsuario(nome).getLivro().getDataEmprestimo())){
			multa.atribuirMulta(nome);
			System.out.println("funfou");
		}
	}
}
