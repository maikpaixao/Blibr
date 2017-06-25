package br.ufrpe.blibr.negocio.beans;

public class Funcionario extends Pessoa{

	private Long codFuncionario;
	
	public Funcionario(String nome, String cpf, String idade, String sexo) {
		super(nome, cpf, idade, sexo);
	}
	
	
	public Funcionario(){
		
	}

	public long getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(long codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	
}
