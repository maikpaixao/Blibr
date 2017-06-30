package br.ufrpe.blibr.negocio.beans;

public class Funcionario extends Pessoa{
	
	private static long nextId = 1;
	
	private Long idFuncionario;
	
	public Funcionario(String nome, String cpf, String idade, String sexo) {
		super(nome, cpf, idade, sexo);
	}
	
	
	public Funcionario(){
		this.idFuncionario = nextId;
        nextId++;
	}

	public long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}


	public String toString() {
		return "Funcionario [codFuncionario=" + idFuncionario + ", getNome()=" + getNome() + ", getCpf()=" + getCpf()
				+ ", getIdade()=" + getIdade() + ", getSexo()=" + getSexo() + "]";
	}
	
}
