package br.ufrpe.blibr.negocio;

import java.text.ParseException;
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
	private ControladorMulta  multa = ControladorMulta.getInstance();
	private RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	
	public static ControladorEmprestimo getInstance(){
		if(instance==null){
			instance = new ControladorEmprestimo();
		}
		return instance;
	}
	
	public void emprestarLivro(Livro livro, Usuario usuario) throws ParseException{
		if(livro!=null && usuario!=null){
			repoEmprestimo.emprestarLivro(livro, usuario);
		}
	}
	
	public ArrayList<Usuario> listarLivrosEmprestados(){
		return repoEmprestimo.listarLivrosEmprestados();
	}
	
	public void verificarEmprestimo(String cpf){
		if(repoUsuario.buscarUsuario(cpf).getLivro().getDataEmprestimo().equals(repoUsuario.buscarUsuario(cpf).getLivro().getDataDevolucao()) && cpf!=null){
			multa.atribuirMulta(cpf);
			System.out.println("O usuario possui uma multa de: "+repoUsuario.buscarUsuario(cpf).getValorMulta());
		}else{
			System.out.println("O usuario não possui nenhuma multa");
		}
	}
}
