package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Funcionario;

public class ControladorFuncionario implements IControladorFuncionario{
	private IRepositorio<Funcionario> repoFuncionario;
	private static ControladorFuncionario instance;
	
	private ControladorFuncionario(){
		repoFuncionario = new RepositorioGenerico<>("funcionario.txt");
	}
	
	public static synchronized ControladorFuncionario getInstance(){
		if(instance==null){
			instance = new ControladorFuncionario();
		}
		return instance;
	}

	public void adicionarFuncionario(Funcionario funcionario) throws Exception {
		try {
			if(funcionario!=null){
				repoFuncionario.adicionar(funcionario);
			}else{
				throw new ObjetoInvalidoExcpetion("Não foi possível realizar a operação,"
						+ " os dados fornecidos são inválidos!");
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Funcionario> listarFuncionario() {
		return repoFuncionario.listar();
	}

	public void editarFuncionario(Funcionario funcionario) throws Exception {
		try {
			if(funcionario!=null){
				repoFuncionario.atualizar(funcionario);
			}else{
				throw new ObjetoInvalidoExcpetion("Não foi possível realizar a operação,"
						+ " os dados fornecidos são inválidos!");
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}

	public void removerUsuario(Long codFuncionario) throws ElementoNaoExisteException {
		try {
			if(codFuncionario!=null){
				repoFuncionario.remover(buscarFuncionario(codFuncionario));
			}else{
				throw new ObjetoInvalidoExcpetion("Não foi possível realizar a operação,"
						+ " os dados fornecidos são inválidos!");
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Funcionario buscarFuncionario(Long codFuncionario) throws ElementoNaoExisteException{
		Funcionario retorno = null;
		try {
			if(codFuncionario!=null){
				for(Funcionario funcionario: listarFuncionario()){
					if(funcionario.getCodFuncionario() == codFuncionario){
						retorno =  funcionario;
					}
				}
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
