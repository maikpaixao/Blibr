package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.util.ArrayList;

import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IFachada {

	public void adicionarUsuario(Usuario usuario);
	public ArrayList<Usuario> listarUsuario();
	public Usuario buscarUsuario(String cpf);
	public void removerUsuario(String cpf);
	public void editarUsario(Usuario usuario);
	
	public void adicionarLivro(Livro livro);
	public Livro buscarLivro(String nomeLivro);
	public void editarLivro(Livro livro);
	public ArrayList<Livro> listarLivros();
	public void removerLivro(String nome);
	
	public void adicionarFuncionario(Funcionario funcionario);
	public ArrayList<Funcionario> listarFuncionario();
	public void editarFuncionario(Funcionario funcionario);
	public void removerUsuario(Long codFuncionario);
	public Funcionario buscarFuncionario(int codFuncionario);
	
	public void emprestarLivro(Livro livro, Usuario usuario) throws ParseException;
	public void registrarEmprestimo(Emprestimo emprestimo);
	public ArrayList<Emprestimo> listarEmprestimos();
	public void verificarEmprestimo(String cpf);
	public Double pagarMulta(String cpf, Double valor);
}
