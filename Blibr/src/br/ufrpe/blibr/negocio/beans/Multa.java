package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;

public class Multa implements Serializable{
	public static final Double valorMulta = 50.00;
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
