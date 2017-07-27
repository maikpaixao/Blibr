package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.dados.RepositorioUsuario;

public class ControladorMulta implements IControladorMulta{
	
	RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	private static ControladorMulta instance;
	
	public static ControladorMulta getInstance(){
		if(instance==null){
			instance = new ControladorMulta();
		}
		return instance;
	}
	
	public void atribuirMulta(Long cpf){
		if(repoUsuario.buscarUsuario(cpf).getNome().equals(cpf) && cpf!=null){
			repoUsuario.buscarUsuario(cpf).setPendenciaMulta(true);
			repoUsuario.buscarUsuario(cpf).setValorMulta(50);
		}
	}
	
	public Double pagarMulta(Long cpf, Double valor){
		Double troco = valor - repoUsuario.buscarUsuario(cpf).getValorMulta();
		if(repoUsuario.buscarUsuario(cpf).getNome().equals(cpf) && repoUsuario.buscarUsuario(cpf).getPendenciaMulta()==true)
			if(valor>=repoUsuario.buscarUsuario(cpf).getValorMulta()){
				repoUsuario.buscarUsuario(cpf).setValorMulta(0);
			}
		return troco;
	}
}
