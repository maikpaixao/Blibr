package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Funcionario;

public class ControladorFuncionario implements IControladorFuncionario{
	private IRepositorio<Funcionario> repoFuncionario;
	private static ControladorFuncionario instance;
	
	private ControladorFuncionario(){
		repoFuncionario = new RepositorioGenerico<Funcionario>("funcionario.arq");
	}
	
	public static synchronized ControladorFuncionario getInstance(){
		if(instance==null){
			instance = new ControladorFuncionario();
		}
		return instance;
	}

	public void adicionarFuncionario(Funcionario funcionario) throws ElementoNaoExisteException, ElementoJaExisteException {
		try {
			if(funcionario!=null){
				repoFuncionario.adicionar(funcionario);
			}else{
				throw new ElementoNaoExisteException(funcionario);
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> listarFuncionario() {
		List<Funcionario> lista = repoFuncionario.listar();
		return lista;
	}

	public void editarFuncionario(Funcionario funcionario) throws ElementoNaoExisteException {
		try {
			if(funcionario!=null){
				repoFuncionario.atualizar(funcionario);
			}else{
				throw new ElementoNaoExisteException(funcionario);
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}

	public void removerUsuario(Long codFuncionario) throws ElementoNaoExisteException {
		try {
			if(codFuncionario!=null){
				repoFuncionario.remover(buscarFuncionario(codFuncionario));
			}else{
				throw new ElementoNaoExisteException(codFuncionario);
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}
	
	public Funcionario buscarFuncionario(Long cpf) throws ElementoNaoExisteException{
		Funcionario retorno = null;
		try {
			if(cpf!=null){
				for(Funcionario funcionario: repoFuncionario.listar()){
					if(funcionario.getCpf().equals(cpf)){
						retorno =  funcionario;
					}
				}
			}else{
				throw new ElementoNaoExisteException(cpf);
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
		return retorno;
	}
}
