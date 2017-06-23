package br.ufrpe.blibr.negocio.beans;

public class Usuario extends Pessoa{
	
	private long id;
	private String senha;
	private int livroEmprestado;
	private Livro livro;
	
	public Usuario(String nome, String cpf, String sexo, int idade, String senha){
		super(nome, cpf, idade, sexo);
		this.senha = senha;
		this.id = (this.id)+1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
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
