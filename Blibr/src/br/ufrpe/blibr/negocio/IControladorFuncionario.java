package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.negocio.beans.Funcionario;

public interface IControladorFuncionario {
	
	public void adicionarFuncionario(Funcionario funcionario);
	public ArrayList<Funcionario> listarFuncionario();
	public void editarFuncionario(Funcionario funcionario);
	public void removerUsuario(Long codFuncionario);
	public Funcionario buscarFuncionario(int codFuncionario);
}
