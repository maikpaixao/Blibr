package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;

public class Funcionario extends Usuario implements Serializable{
	
	private String senha;
	private static final long serialVersionUID = -8155234771236394489L;
	
	public Funcionario(){
		
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}