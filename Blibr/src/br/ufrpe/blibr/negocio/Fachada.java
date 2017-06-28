package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.Iterator;

import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class Fachada {
	private static Fachada instance;
	private ControladorUsuario controladorU = ControladorUsuario.getInstance();
	private ControladorLivro controladorL = ControladorLivro.getInstance();
	private ControladorFuncionario controladorF = ControladorFuncionario.getInstance();
	private ControladorEmprestimo emprestimoE = ControladorEmprestimo.getInstance();
	
	public static synchronized Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

	public void adicionarUsuario(Usuario usuario) {
		System.out.println(usuario);
		if(usuario!=null){
			controladorU.adicionarUsuario(usuario);
		}
	}

	public ArrayList<Usuario> listarUsuario() {
		return controladorU.listarUsuario();
	}

	public Usuario buscarUsuario(String cpf) {
		return controladorU.buscarUsuario(cpf);
	}

	public void removerUsuario(String cpf) {
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

	public void removerUsuario(Long codFuncionario) {
		controladorF.removerUsuario(codFuncionario);
	}
	
	//////////////////Emprestar///////////////
	
	public void emprestarLivro(Livro livro, Usuario usuario) {
		emprestimoE.emprestarLivro(livro, usuario);
	}
	
	public ArrayList<Usuario> listarLivrosEmprestados(){
		return emprestimoE.listarLivrosEmprestados();
	}
	
	public void verificarEmprestimo(String usuario){
		emprestimoE.verificarEmprestimo(usuario);
	}
}
