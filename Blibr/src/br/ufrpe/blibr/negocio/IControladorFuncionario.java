package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Funcionario;

public interface IControladorFuncionario {
	
	public void adicionarFuncionario(Funcionario funcionario) throws Exception;
	public List<Funcionario> listarFuncionario();
	public void editarFuncionario(Funcionario funcionario) throws Exception;
	public void removerUsuario(Long codFuncionario) throws ElementoNaoExisteException;
	public Funcionario buscarFuncionario(Long codFuncionario) throws ElementoNaoExisteException;
}
