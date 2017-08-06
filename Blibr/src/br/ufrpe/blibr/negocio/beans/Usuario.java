package br.ufrpe.blibr.negocio.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Usuario {
	
	private String nome;
	private Long cpf;
	private int idade;
	private LocalDate dataNascimento;
	private String sexo;
	private static long nextId = 0;
	private Long idUsuario;
	
	public Usuario(){
		this.idUsuario = nextId;
		nextId++;
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
	
//	 public int getIdade(){
//		 	
//		 	Integer idade = null;
//			try {
//				String formato = "dd/MM/yyyy";
//			 	Date data;
//				data = new SimpleDateFormat(formato).parse(getDataNascimento());
//				GregorianCalendar hj=new GregorianCalendar();
//				GregorianCalendar nascimento=new GregorianCalendar();
//				if(getDataNascimento()!=null){
//					nascimento.setTime(data);
//				}		
//				int anohj=hj.get(Calendar.YEAR);
//				int anoNascimento=nascimento.get(Calendar.YEAR);
//				idade = anohj-anoNascimento;
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			return idade;
//		}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Long getId(){
		return idUsuario;
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
		return  "ID do Usuário: " + getId() + "\n"
				+"Nome do Usuáro: " + getNome() + "\n"
				+"CPF do Usuário: "+ getCpf() + "\n"
				+"Idade do Usuário: " + getDataNascimento() + "\n"
				+"Sexo do Usuário: " + getSexo();
	}
}