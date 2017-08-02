package br.ufrpe.blibr.negocio.beans;

public class Funcionario extends Pessoa{
	
	private int codFuncionario;
	private String senha;
	
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
		return "Codigo do Funcionario: " + codFuncionario + "\n"
				+"Nome do Funcionario: " + getNome() + "\n"
				+"CPF do Funcionario: " + getCpf() + "\n"
				+"Sexo do Funcionario: " + getSexo() + "\n"
				+"Idade do Funcionario: " + getIdade() + "\n"
				+"Senha do Funcionario: "+ getSenha();
	}
}