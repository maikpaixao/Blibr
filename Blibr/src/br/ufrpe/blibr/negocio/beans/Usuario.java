package br.ufrpe.blibr.negocio.beans;

public class Usuario extends Pessoa{
	
	private static int id=0;
	private int senha;
	private int livroEmprestado;
	private Livro livro;
	
	@SuppressWarnings("static-access")
	public Usuario(String nome, String cpf, String sexo, int idade, int senha){
		super(nome, cpf, idade, sexo);
		this.senha = senha;
		this.id = (this.id)+1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Usuario.id = id;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public int getLivroEmprestado() {
		return livroEmprestado;
	}

	public void setLivroEmprestado(int livroEmprestado) {
		this.livroEmprestado = livroEmprestado;
	}
	

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String toString() {
		return "Usuario [id=" + id + ", senha=" + senha + "]";
	}
}
