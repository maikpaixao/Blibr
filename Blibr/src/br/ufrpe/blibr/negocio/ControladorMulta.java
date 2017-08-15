package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorMulta implements IControladorMulta{
	
	private IRepositorio<Usuario> repoUsuario;
	private ControladorEmprestimo controllerEmprestimo = ControladorEmprestimo.getInstance();
	private static ControladorMulta instance;
	
	public static ControladorMulta getInstance(){
		if(instance==null){
			instance = new ControladorMulta();
		}
		return instance;
	}
	
	private ControladorMulta(){
		this.repoUsuario = new RepositorioGenerico<>("emprestimo.txt");
	}
	
	public void atribuirMulta(Long cpf, Long dias) throws ElementoNaoExisteException{
		try {
			if(cpf!=null){
				controllerEmprestimo.buscarEmprestimo(cpf).getMulta().setDivida(10);
			}else{
				
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
	
	public Double pagarMulta(Long cpf, Double valor) throws ElementoNaoExisteException{
		Double troco = null;
		if(controllerEmprestimo.buscarEmprestimo(cpf)!=null){
			if(valor >= controllerEmprestimo.buscarEmprestimo(cpf).getMulta().getDivida()){
				troco = valor - controllerEmprestimo.buscarEmprestimo(cpf).getMulta().getDivida();
				controllerEmprestimo.buscarEmprestimo(cpf).getMulta().setDivida(0);
			}else{
				System.out.println("Valor nao e suficiente!");
			}
		}
		return troco;
	}
}
