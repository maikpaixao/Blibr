package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ValidadeEmprestimoException;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IFachada {

	public void adicionarUsuario(Usuario usuario) throws ElementoNaoExisteException, ElementoJaExisteException;
	public List<Usuario> listarUsuario();
	public Usuario buscarUsuario(Long cpf);
	public void removerUsuario(Long cpf);
	public void editarUsario(Usuario usuario);
	
	public void adicionarLivro(Livro livro) throws ElementoNaoExisteException, ElementoJaExisteException;
	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExisteException;
	public void editarLivro(Livro livro) throws ElementoNaoExisteException;
	public List<Livro> listarLivros();
	public void removerLivro(String nome) throws ElementoNaoExisteException;
	
	public void adicionarFuncionario(Funcionario funcionario) throws Exception;
	public List<Funcionario> listarFuncionario();
	public void editarFuncionario(Funcionario funcionario) throws Exception;
	public void removerFuncionario(Long codFuncionario) throws ElementoNaoExisteException;
	public Funcionario buscarFuncionario(Long codFuncionario) throws ElementoNaoExisteException;
	
	public void registrarEmprestimo(Emprestimo emprestimo) throws ElementoNaoExisteException, ElementoJaExisteException;
	public Emprestimo buscarEmprestimo(Long cpf) throws ElementoNaoExisteException;
	public List<Emprestimo> listarEmprestimos();
	public void verificarEmprestimo(Long cpf) throws ElementoNaoExisteException, ValidadeEmprestimoException;
	public Double pagarMulta(Long cpf, Double valor) throws ElementoNaoExisteException;
}
