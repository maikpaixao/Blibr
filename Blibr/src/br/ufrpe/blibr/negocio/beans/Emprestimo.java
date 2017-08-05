package br.ufrpe.blibr.negocio.beans;

import java.util.Date;

public class Emprestimo {
	
	private Funcionario funcionario;
	private Usuario usuario;
	private Livro livro;
	private Multa multa;
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
	
	public Multa getMulta(){
		return multa;
	}
	
	public void setMulta(Multa multa){
		this.multa = multa;
	}

	@Override
	public boolean equals(Object o){
		boolean retorno = false;
		if(this.getUsuario().equals(((Emprestimo) o).getUsuario()) &&
				this.getLivro().equals(((Emprestimo) o).getLivro())){
			retorno=true;
		}
		return retorno;
	}

	@Override
	public String toString(){
		return "Nome do Funcionario: "+funcionario.getNome()+"\n"
				+"Nome do Livro: "+livro.getNomeLivro()+"\n"
				+"Nome do Usuario: "+usuario.getNome()+"\n"
				+"Data de Emprestimo: "+getDataEmprestimo()+"\n"
				+"Data de Devolução: "+getDataDevolucao();
	}
}