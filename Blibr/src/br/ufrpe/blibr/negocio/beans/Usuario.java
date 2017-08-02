package br.ufrpe.blibr.negocio.beans;

public class Usuario extends Pessoa{
	
	private static long nextId = 1;
	private Long idUsuario;
	
	public Usuario(){
		this.idUsuario = nextId;
		nextId++;
	}
	
	public String toString() {
		return "Id do Usuario: " + idUsuario + "\n"
				+ " Nome do Usuario: "+getNome()+ "\n"
				+ " CPF do Usuario: "+getCpf()+"\n"
				+ " Sexo do Usuario: "+getSexo()+"\n"
				+ " Idade do Usuario: "+getIdade();
	}
}