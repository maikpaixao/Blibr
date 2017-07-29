package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.ElementoNaoExistente;
import br.ufrpe.blibr.negocio.beans.Funcionario;

public interface IControladorFuncionario {
	
	public void adicionarFuncionario(Funcionario funcionario) throws Exception;
	public ArrayList<Funcionario> listarFuncionario();
	public void editarFuncionario(Funcionario funcionario) throws Exception;
	public void removerUsuario(Long codFuncionario) throws ElementoNaoExistente;
	public Funcionario buscarFuncionario(Long codFuncionario) throws ElementoNaoExistente;
}
