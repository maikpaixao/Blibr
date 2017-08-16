package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.beans.property.SimpleStringProperty;

public class Usuario implements Serializable {
	
	private String nome;
	private Long cpf;
	private int idade;
	private LocalDate dataNascimento;
	private String sexo;
	private static final long serialVersionUID = 5896102336969442664L;
	
	public Usuario(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public int getIdade(){
		LocalDate ld = LocalDate.now();
		int idade = Period.between ( this.getDataNascimento() , ld ).getYears();
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setDataNascimento(LocalDate localDate){
		this.dataNascimento = localDate;
	}
	
	public LocalDate getDataNascimento(){
		return dataNascimento;
	}

	public boolean equals(Object o){
		boolean retorno = false;
		if(this.getCpf()==((Usuario) o).getCpf()){
			retorno=true;
		}
		return retorno;
	}
	
	@Override
	public String toString() {
		return  nome;
	}
}