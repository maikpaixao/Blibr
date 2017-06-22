package br.ufrpe.blibr.dados;

import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioUsuario {
	
	private static RepositorioUsuario instance;
	private Usuario[] repoUsuario;
	private int numUsuario;
	
	public static synchronized RepositorioUsuario getInstance(){
		if(instance == null){
			instance = new RepositorioUsuario();
		}
		return instance;
	}
	
	public RepositorioUsuario(){
		this.numUsuario=0;
	}
	
	public void adicionarUsuario(Usuario usuario){
		if(usuario != null && this.numUsuario < repoUsuario.length){
			this.repoUsuario[numUsuario] = usuario;
			this.numUsuario++;
		}else if(usuario != null && this.numUsuario == repoUsuario.length){
			duplicaArray();
			this.repoUsuario[numUsuario] = usuario;
			this.numUsuario++;
		}
	}
	
	public boolean existeUsuario(double cpf){
		boolean retorno = false;
		for(int i = 0; i < this.numUsuario; i++){
			if(this.repoUsuario[i].getCpf() == cpf){
				retorno = true;
			}
		}
		return retorno;
	}
	
	private void duplicaArray(){
		if(this.repoUsuario != null && this.repoUsuario.length > 0){
			Usuario[] repositorioDuplicado = new Usuario[this.repoUsuario.length * 2];
			for(int i = 0; i < repoUsuario.length; i++){
				repositorioDuplicado[i] = this.repoUsuario[i];
			}
			this.repoUsuario = repositorioDuplicado;
		}
	}
	
	public Usuario buscarUsuario(double cpf){
		int i;
		Usuario retorno = null;
		for(i = 0; i < numUsuario; i++){
			if(this.repoUsuario[i].getCpf() == cpf){
				retorno = this.repoUsuario[i];
			}
		}
		return retorno;
	}
	
	public void removerUsuario(double cpf){
		int i;
		for(i = 0; i < numUsuario; i++){
			if(this.repoUsuario[i].getCpf() == cpf){
				this.repoUsuario[i] = this.repoUsuario[numUsuario-1];
				this.repoUsuario[numUsuario-1] = null;
				this.numUsuario--;
			}
		}
	}
	
	public boolean atualizarUsuario(Usuario usuario){
		boolean retorno = false;
		int i;	
		for(i = 0; i < numUsuario; i++){
			if(this.repoUsuario[i].getCpf() == usuario.getCpf()){
				this.repoUsuario[i] = usuario;
				retorno = true;
			}
		}
		return retorno;
	}
	
}
