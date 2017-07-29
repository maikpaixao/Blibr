package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioFuncionario;
import br.ufrpe.blibr.exception.ElementoNaoExistente;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Funcionario;

public class ControladorFuncionario implements IControladorFuncionario{
	private RepositorioFuncionario repoFuncionario = RepositorioFuncionario.getInstance();
	private static ControladorFuncionario instance;
	
	public static synchronized ControladorFuncionario getInstance(){
		if(instance==null){
			instance = new ControladorFuncionario();
		}
		return instance;
	}

	public void adicionarFuncionario(Funcionario funcionario) throws Exception {
		try {
			if(funcionario!=null){
				repoFuncionario.adicionarFuncionario(funcionario);
			}else{
				throw new ObjetoInvalidoExcpetion("Não foi possível realizar a operação,"
						+ " os dados fornecidos são inválidos!");
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Funcionario> listarFuncionario() {
		return repoFuncionario.listarFuncionario();
	}

	public void editarFuncionario(Funcionario funcionario) throws Exception {
		try {
			if(funcionario!=null){
				repoFuncionario.editarFuncionario(funcionario);
			}else{
				throw new ObjetoInvalidoExcpetion("Não foi possível realizar a operação,"
						+ " os dados fornecidos são inválidos!");
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}

	public void removerUsuario(Long codFuncionario) throws ElementoNaoExistente {
		try {
			if(codFuncionario!=null){
				repoFuncionario.removerUsuario(codFuncionario);
			}else{
				throw new ObjetoInvalidoExcpetion("Não foi possível realizar a operação,"
						+ " os dados fornecidos são inválidos!");
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Funcionario buscarFuncionario(Long codFuncionario) throws ElementoNaoExistente{
		Funcionario retorno = null;
		try {
			if(codFuncionario!=0){
				retorno = repoFuncionario.buscarFuncionario(codFuncionario);
			}else{
				throw new ObjetoInvalidoExcpetion("Não foi possível realizar a operação,"
						+ " os dados fornecidos são inválidos!");
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
}
