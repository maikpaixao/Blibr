package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private int id;
	private String nome;
	private int cpf;
	private int senha;
	
	public Usuario(int id, String nome, int cpf, int senha){
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

}
