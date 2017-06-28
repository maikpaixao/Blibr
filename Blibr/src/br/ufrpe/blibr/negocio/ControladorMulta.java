package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.dados.RepositorioUsuario;

public class ControladorMulta {
	
	RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	
	public void atribuirMulta(String nome){
		if(repoUsuario.buscarUsuario(nome).getNome().equals(nome)){
			repoUsuario.buscarUsuario(nome).setPendenciaMulta(true);
			repoUsuario.buscarUsuario(nome).setValorMulta(50);
		}
	}
	
	public Double pagarMulta(String nome, Double valor){
		Double troco = valor - repoUsuario.buscarUsuario(nome).getValorMulta();
		if(repoUsuario.buscarUsuario(nome).getNome().equals(nome))
			if(repoUsuario.buscarUsuario(nome).getPendenciaMulta()==true){
				if(valor>=repoUsuario.buscarUsuario(nome).getValorMulta()){
					repoUsuario.buscarUsuario(nome).setValorMulta(0);
				}
		}
		return troco;
	}
}
