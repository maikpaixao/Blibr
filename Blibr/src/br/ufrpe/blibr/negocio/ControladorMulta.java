package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.dados.RepositorioEmprestimo;
import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.ElementoNaoExistente;

public class ControladorMulta implements IControladorMulta{
	
	RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	RepositorioEmprestimo repoEmprestimo = RepositorioEmprestimo.getInstance();
	private static ControladorMulta instance;
	
	public static ControladorMulta getInstance(){
		if(instance==null){
			instance = new ControladorMulta();
		}
		return instance;
	}
	
	public void atribuirMulta(Long cpf) throws ElementoNaoExistente{
		if(repoEmprestimo.buscarEmprestimo(cpf)!=null){
			repoEmprestimo.buscarEmprestimo(cpf).getMulta().setDivida(50);
		}
	}
	
	public Double pagarMulta(Long cpf, Double valor) throws ElementoNaoExistente{
		Double troco = null;
		if(repoEmprestimo.buscarEmprestimo(cpf)!=null){
			if(valor >= repoEmprestimo.buscarEmprestimo(cpf).getMulta().getDivida()){
				troco = valor - repoEmprestimo.buscarEmprestimo(cpf).getMulta().getDivida();
				repoEmprestimo.buscarEmprestimo(cpf).getMulta().setDivida(0);
			}else{
				System.out.println("Valor nao e suficiente!");
			}
		}
		return troco;
	}
}
