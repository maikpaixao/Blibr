package br.ufrpe.blibr.negocio.beans;

import java.util.Date;

public class Reserva {
	
	private int codUsuario;
	private int codLivro;
	private int prioridadeReserva;
	private Date dataReserva;
	
	public Reserva(int codUsuario, int codLivro, int prioridadeReserva, Date dataReserva){
		this.codUsuario = codUsuario;
		this.codLivro = codLivro;
		this.prioridadeReserva = prioridadeReserva;
		this.dataReserva = dataReserva;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public int getCodLivro() {
		return codLivro;
	}

	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}

	public int getPrioridadeReserva() {
		return prioridadeReserva;
	}

	public void setPrioridadeReserva(int prioridadeReserva) {
		this.prioridadeReserva = prioridadeReserva;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
	
	
}
