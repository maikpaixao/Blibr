package br.ufrpe.blibr.negocio.beans;

import java.util.Date;

public class Emprestimo {
	
	private Funcionario funcionario;
	private Usuario usuario;
	private Livro livro;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
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
	
	public Livro getLivro(){
		return livro;
	}
	
	public void setLivro(Livro livro){
		this.livro = livro;
	}
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date date) {
		this.dataEmprestimo = date;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String toString() {
		return "\n"+"| Código do funcionario: " + funcionario.getCodFuncionario()+"| Nome do funcionario: "+funcionario.getNome() +"\n"+
				"| Nome do usuario: " + usuario.getNome() + "| Cpf do usuario: " + usuario.getCpf() + "\n"+
				"| Livro emprestado: "+getLivro().getNomeLivro()+"\n"+"| Data emprestimo: "+ getDataEmprestimo() +" | Data Devolucao: "+getDataDevolucao()+"\n"+"---------------------------------------------------"+"\n";
	}

	
}
