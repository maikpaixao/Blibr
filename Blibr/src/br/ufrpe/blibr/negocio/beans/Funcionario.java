package br.ufrpe.blibr.negocio.beans;

public class Funcionario extends Pessoa{
	
	private int codFuncionario;
	
	public Funcionario(String nome, String cpf, String idade, String sexo) {
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


	public String toString() {
		return "Funcionario [codFuncionario=" + codFuncionario + ", getNome()=" + getNome() + ", getCpf()=" + getCpf()
				+ ", getIdade()=" + getIdade() + ", getSexo()=" + getSexo() + "]";
	}
	
}
