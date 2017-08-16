package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Emprestimo implements Serializable{
	
	private Funcionario funcionario;
	private Usuario usuario;
	private Livro livro;
	private Multa multa;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private static final long serialVersionUID = 3563751937153246732L;
	
	public Emprestimo(){
		multa = new Multa();
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
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate date) {
		this.dataEmprestimo = date;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public Multa getMulta(){
		return multa;
	}
	
	public void setMulta(Multa multa){
		this.multa = multa;
	}

	public boolean equals(Object o){
		boolean retorno = false;
		if(this.getUsuario().equals(((Emprestimo) o).getUsuario()) 
				&& this.getLivro().equals(((Emprestimo) o).getLivro())){
			retorno=true;
		}
		return retorno;
	}
}