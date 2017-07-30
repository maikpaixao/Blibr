package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.ElementoNaoExistente;
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

	public void adicionarUsuario(Usuario usuario) throws ElementoNaoExistente {
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
	
	public void adicionarLivro(Livro livro) throws ElementoNaoExistente{
		controladorL.adicionarLivro(livro);
	}

	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExistente {
		return controladorL.buscarLivro(nomeLivro);
	}

	public void editarLivro(Livro livro) throws ElementoNaoExistente{
		controladorL.editarLivro(livro);
	}

	public ArrayList<Livro> listarLivros() {
		return controladorL.listarLivros();
	}

	public void removerLivro(String nome) throws ElementoNaoExistente{
		controladorL.removerLivro(nome);
	}
	
	///////////////Funcionario////////////////////////
	
	public void adicionarFuncionario(Funcionario funcionario) throws Exception {
		controladorF.adicionarFuncionario(funcionario);
	}

	public ArrayList<Funcionario> listarFuncionario() {
		return controladorF.listarFuncionario();
	}

	public void editarFuncionario(Funcionario funcionario) throws Exception {
		controladorF.editarFuncionario(funcionario);
	}

	public void removerFuncionario(Long codFuncionario) throws ElementoNaoExistente {
		controladorF.removerUsuario(codFuncionario);
	}
	
	
	public Funcionario buscarFuncionario(Long codFuncionario) throws ElementoNaoExistente{
		return controladorF.buscarFuncionario(codFuncionario);
	}
	
	//////////////////Emprestar///////////////
	
	//public void emprestarLivro(Emprestimo emprestimo) throws ParseException {
	//	emprestimoE.emprestarLivro(livro, usuario);
	//}
	
	public void registrarEmprestimo(Emprestimo emprestimo) throws ElementoNaoExistente{
		emprestimoE.registrarEmprestimo(emprestimo);
	}
	
	public ArrayList<Emprestimo> listarEmprestimos(){
		return emprestimoE.listarEmprestimos();
	}
	
	public void verificarEmprestimo(Long cpf) throws ElementoNaoExistente{
		emprestimoE.verificarEmprestimo(cpf);
	}
	
	public Double pagarMulta(Long cpf, Double valor) throws ElementoNaoExistente{
		return controladorM.pagarMulta(cpf, valor);
	}
	
	public void realizarDevolução(Usuario usuario, Livro livro) throws ElementoNaoExistente{
		emprestimoE.realizarDevolução(usuario, livro);
	}
}