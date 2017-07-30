package br.ufrpe.blibr.negocio.beans;

public class Funcionario extends Pessoa{
	
	private int codFuncionario;
	private String senha;
	
	public Funcionario(String nome, Long cpf, int idade, String sexo) {
		super(nome, cpf, idade, sexo);
	}
	
	public Funcionario(){
		
	}

	public int getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return "Funcionario [codFuncionario=" + codFuncionario + ", getNome()=" + getNome() + ", getCpf()=" + getCpf()
				+ ", getIdade()=" + getIdade() + ", getSexo()=" + getSexo() + "]";
	}
	
}
