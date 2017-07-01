package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.ufrpe.blibr.dados.RepositorioEmprestimo;
import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
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
		repoEmprestimo.emprestarLivro(livro, usuario);
	}
	
	public void registrarEmprestimo(Emprestimo emprestimo){
		repoEmprestimo.registrarEmprestimo(emprestimo);
	}
	
	public ArrayList<Emprestimo> listarEmprestimos(){
		return repoEmprestimo.listarEmprestimos();
	}
	
	public void verificarEmprestimo(String cpf){
		if(repoUsuario.buscarUsuario(cpf).getLivro().getDataEmprestimo().equals(repoUsuario.buscarUsuario(cpf).getLivro().getDataDevolucao())){
			multa.atribuirMulta(cpf);
		}
	}
}
