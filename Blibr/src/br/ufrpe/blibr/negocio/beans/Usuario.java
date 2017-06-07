package br.ufrpe.blibr.negocio.beans;

public class Usuario extends Pessoa{
	
	private int id;
	private int senha;
	private int limiteMax;
	
	public Usuario(int id, String nome, int cpf, char sexo, int idade, int senha, int limiteMax){
		super(nome, cpf, idade, sexo);
		this.id = id;
		this.senha = senha;
		this.limiteMax = limiteMax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public int getLimiteMax(){
		return limiteMax;
	}
	
	public void setLimiteMax(int limiteMax){
		this.limiteMax = limiteMax;
	}
	
	public String toString() {
		return "Usuario [id=" + id + ", senha=" + senha + ", limiteMax=" + limiteMax + "]";
	}
}
