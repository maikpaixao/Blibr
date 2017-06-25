package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;

public class Usuario extends Pessoa{
	
	private Livro livro;
	
	public Usuario(String nome, String cpf, String sexo, String idade){
		super(nome, cpf, idade, sexo);
	}
	
	public Usuario(){
		
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
}
