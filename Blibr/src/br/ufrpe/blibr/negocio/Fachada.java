package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
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

	public void adicionarUsuario(Usuario usuario) throws ElementoNaoExisteException, ElementoJaExisteException {
		if(usuario!=null){
			controladorU.adicionarUsuario(usuario);
		}
	}

	public List<Usuario> listarUsuario() {
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
	
	public void adicionarLivro(Livro livro) throws ElementoNaoExisteException, ElementoJaExisteException{
		controladorL.adicionarLivro(livro);
	}

	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExisteException {
		return controladorL.buscarLivro(nomeLivro);
	}

	public void editarLivro(Livro livro) throws ElementoNaoExisteException{
		controladorL.editarLivro(livro);
	}

	public List<Livro> listarLivros() {
		return controladorL.listarLivros();
	}

	public void removerLivro(String nome) throws ElementoNaoExisteException{
		controladorL.removerLivro(nome);
	}
	
	///////////////Funcionario////////////////////////
	
	public void adicionarFuncionario(Funcionario funcionario) throws Exception {
		controladorF.adicionarFuncionario(funcionario);
	}

	public List<Funcionario> listarFuncionario() {
		return controladorF.listarFuncionario();
	}

	public void editarFuncionario(Funcionario funcionario) throws Exception {
		controladorF.editarFuncionario(funcionario);
	}

	public void removerFuncionario(Long codFuncionario) throws ElementoNaoExisteException {
		controladorF.removerUsuario(codFuncionario);
	}
	
	
	public Funcionario buscarFuncionario(Long codFuncionario) throws ElementoNaoExisteException{
		return controladorF.buscarFuncionario(codFuncionario);
	}
	
	public void registrarEmprestimo(Emprestimo emprestimo, Date date) throws ElementoNaoExisteException, ElementoJaExisteException{
		emprestimoE.registrarEmprestimo(emprestimo, date);
	}
	
	public List<Emprestimo> listarEmprestimos(){
		return emprestimoE.listarEmprestimos();
	}
	
	public void verificarEmprestimo(Long cpf) throws ElementoNaoExisteException{
		emprestimoE.verificarEmprestimo(cpf);
	}
	
	public Double pagarMulta(Long cpf, Double valor) throws ElementoNaoExisteException{
		return controladorM.pagarMulta(cpf, valor);
	}
	
	public void realizarDevolução(Emprestimo emprestimo) throws ElementoNaoExisteException{
		emprestimoE.realizarDevolução(emprestimo);
	}
}