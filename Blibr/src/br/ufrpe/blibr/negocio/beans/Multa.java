package br.ufrpe.blibr.negocio.beans;

public class Multa {
	
	private double divida;
	
	public Multa(double divida){
		this.divida = divida;
	}
	
	public Multa(){
		this.divida=0;
	}
	
	public double getDivida(){
		return divida;
	}
	
	public void setDivida(double divida){
		this.divida = divida;
	}

	@Override
	public String toString() {
		return "Multa: "+getDivida();
	}
}
