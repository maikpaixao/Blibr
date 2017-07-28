package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class Fachada {
	private static Fachada instance;
	private ControladorUsuario controladorU = ControladorUsuario.getInstance();
	private ControladorLivro controladorL = ControladorLivro.getInstance();
	private ControladorFuncionario controladorF = ControladorFuncionario.getInstance();
	private ControladorEmprestimo emprestimoE = ControladorEmprestimo.getInstance();
	private ControladorMulta controladorM = ControladorMulta.getInstance();
	
	public static synchronized Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

	public void adicionarUsuario(Usuario usuario) {
		if(usuario!=null){
			controladorU.adicionarUsuario(usuario);
		}
	}

	public ArrayList<Usuario> listarUsuario() {
		return controladorU.listarUsuario();
	}

	public Usuario buscarUsuario(Long cpf) {
		return controladorU.buscarUsuario(cpf);
	}

	public void removerUsuario(Long cpf) {
		controladorU.removerUsuario(cpf);
	}

	public void editarUsario(Usuario usuario) {
		controladorU.editarUsario(usuario);
	}

	////////////////Livro////////////////////
	
	public void adicionarLivro(Livro livro){
		controladorL.adicionarLivro(livro);
	}

	public Livro buscarLivro(String nomeLivro) {
		return controladorL.buscarLivro(nomeLivro);
	}

	public void editarLivro(Livro livro){
		controladorL.editarLivro(livro);
	}

	public ArrayList<Livro> listarLivros() {
		return controladorL.listarLivros();
	}

	public void removerLivro(String nome){
		controladorL.removerLivro(nome);
	}
	
	///////////////Funcionario////////////////////////
	
	public void adicionarFuncionario(Funcionario funcionario) {
		controladorF.adicionarFuncionario(funcionario);
	}

	public ArrayList<Funcionario> listarFuncionario() {
		return controladorF.listarFuncionario();
	}

	public void editarFuncionario(Funcionario funcionario) {
		controladorF.editarFuncionario(funcionario);
	}

	public void removerFuncionario(Long codFuncionario) {
		controladorF.removerUsuario(codFuncionario);
	}
	
	
	public Funcionario buscarFuncionario(int codFuncionario){
		return controladorF.buscarFuncionario(codFuncionario);
	}
	
	//////////////////Emprestar///////////////
	
	//public void emprestarLivro(Emprestimo emprestimo) throws ParseException {
	//	emprestimoE.emprestarLivro(livro, usuario);
	//}
	
	public void registrarEmprestimo(Emprestimo emprestimo){
		emprestimoE.registrarEmprestimo(emprestimo);
	}
	
	public ArrayList<Emprestimo> listarEmprestimos(){
		return emprestimoE.listarEmprestimos();
	}
	
	//public void verificarEmprestimo(Long cpf){
	//	emprestimoE.verificarEmprestimo(cpf);
	//}
	
	public Double pagarMulta(Long cpf, Double valor){
		return controladorM.pagarMulta(cpf, valor);
	}
	
	public void realizarDevolução(Usuario usuario, Livro livro){
		emprestimoE.realizarDevolução(usuario, livro);
	}
}