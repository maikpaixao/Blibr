package br.ufrpe.blibr.negocio.beans;

public abstract class Pessoa {
	
	private String nome;
	private Long cpf;
	private int idade;
	private String sexo;
	
	public Pessoa(String nome, Long cpf, int idade, String sexo){
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public Pessoa(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean equals(Object o){
		boolean retorno = false;
		if(this.getCpf()==((Pessoa) o).getCpf()){
			retorno=true;
		}
		return retorno;
	}
}
