package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioFuncionario;
import br.ufrpe.blibr.negocio.beans.Funcionario;

public class ControladorFuncionario {
	private RepositorioFuncionario repoFuncionario = RepositorioFuncionario.getInstance();
	private static ControladorFuncionario instance;
	
	public static synchronized ControladorFuncionario getInstance(){
		if(instance==null){
			instance = new ControladorFuncionario();
		}
		return instance;
	}

	public void adicionarFuncionario(Funcionario funcionario) {
		repoFuncionario.adicionarFuncionario(funcionario);
	}

	public ArrayList<Funcionario> listarFuncionario() {
		return repoFuncionario.listarFuncionario();
	}

	public void editarFuncionario(Funcionario funcionario) {
		repoFuncionario.editarFuncionario(funcionario);
	}

	public void removerUsuario(Long codFuncionario) {
		repoFuncionario.removerUsuario(codFuncionario);
	}
	
	public Funcionario buscarFuncionario(int codFuncionario){
		return repoFuncionario.buscarFuncionario(codFuncionario);
	}
	
}
