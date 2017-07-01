package br.ufrpe.blibr.negocio.beans;

public class Emprestimo {
	
	private Funcionario funcionario;
	private Usuario usuario = new Usuario();
	
	public Emprestimo(){
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String toString() {
		return "\n"+"| Código do funcionario: " + funcionario.getCodFuncionario()+"| Nome do funcionario: "+funcionario.getNome() +"\n"+
				"| Nome do usuario: " + usuario.getNome() + "| Cpf do usuario: " + usuario.getCpf() + "\n"+
				"| Livro emprestado: "+usuario.getLivro()+"\n";
	}

	
}
