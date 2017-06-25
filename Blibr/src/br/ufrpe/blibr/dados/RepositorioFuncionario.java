package br.ufrpe.blibr.dados;

import java.util.ArrayList;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioFuncionario {
	
	private static RepositorioFuncionario instance;
	private ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

	public static synchronized RepositorioFuncionario getInstance(){
		if(instance == null){
			instance = new RepositorioFuncionario();
		}
		return instance;
	}
	
	public void adicionarFuncionario(Funcionario funcionario){
		if(funcionario!=null && !this.listaFuncionario.contains(funcionario)){
			this.listaFuncionario.add(funcionario);
		}else{
			
		}
	}
	
	public ArrayList<Funcionario> listarFuncionario(){
		return this.listaFuncionario;
	}
	
	public Funcionario buscarFuncionario(long codFuncionario){
		for(Funcionario funcionario: listaFuncionario){
			if(funcionario.getCodFuncionario()==codFuncionario){
				return funcionario;
			}
		}
		return null;
	}
	
	public void editarFuncionario(Funcionario funcionario){
		if(funcionario!=null){
			for(Funcionario func: this.listaFuncionario){
				if (func.getNome().equals(funcionario.getNome())){
					int indice = this.listaFuncionario.indexOf(func);
		            listaFuncionario.set(indice, funcionario);
		        }else{
		        	
		        }
			}
		}
	}
	
	public void removerUsuario(Long codFuncionario){
		if(codFuncionario!=null){
			for(Funcionario func: listaFuncionario){
				if(func.getCodFuncionario()==codFuncionario){
					this.listaFuncionario.remove(func);
					break;
				}else{
					
				}
			}
		}
	}
	
}
