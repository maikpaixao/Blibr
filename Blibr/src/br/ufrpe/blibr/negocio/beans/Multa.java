package br.ufrpe.blibr.negocio.beans;

public class Multa {
	
	private Usuario usuario;
	private double divida;
	
	public Multa(double divida){
		this.divida = divida;
	}
	
	public Multa(){
		
	}
	
	public double getDivida(){
		return divida;
	}
	
	public void setDivida(double divida){
		this.divida = divida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
