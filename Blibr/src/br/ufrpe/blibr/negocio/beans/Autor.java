package br.ufrpe.blibr.negocio.beans;

import java.io.Serializable;

public class Autor implements Serializable{
	
	private String nomeAutor;
	private static final long serialVersionUID = 5882184175404246169L;
	
	public String getNomeAutor() {
		return nomeAutor;
	}
	
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	@Override
	public String toString() {
		return nomeAutor;
	}
}