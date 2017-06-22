package br.ufrpe.blibr.dados;

import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioLivro {
	private static RepositorioLivro instance;
	private Livro[] repoLivro;
	private int numUsuario;
	
	public static synchronized RepositorioLivro getInstance(){
		if(instance == null){
			instance = new RepositorioLivro();
		}
		return instance;
	}
	
	private RepositorioLivro(){
		this.numUsuario=0;
	}
	
	public void adicionarLivro(Livro livro){
		if(livro != null && this.numUsuario < repoLivro.length){
			this.repoLivro[numUsuario] = livro;
			this.numUsuario++;
		}else if(livro != null && this.numUsuario == repoLivro.length){
			duplicaArray();
			this.repoLivro[numUsuario] = livro;
			this.numUsuario++;
		}
	}
	
	private void duplicaArray(){
		if(this.repoLivro != null && this.repoLivro.length > 0){
			Livro[] repositorioDuplicado = new Livro[this.repoLivro.length * 2];
			for(int i = 0; i < repoLivro.length; i++){
				repositorioDuplicado[i] = this.repoLivro[i];
			}
			this.repoLivro = repositorioDuplicado;
		}
	}
	
	public Livro buscarLivrro(double cpf){
		int i;
		Livro retorno = null;
		for(i = 0; i < numUsuario; i++){
			if(this.repoLivro[i].getCodigoLivro() == cpf){
				retorno = this.repoLivro[i];
			}
		}
		return retorno;
	}
	
	public void removerLivro(double cpf){
		int i;	
		for(i = 0; i < numUsuario; i++){
			if(this.repoLivro[i].getCodigoLivro() == cpf){
				this.repoLivro[i] = this.repoLivro[numUsuario-1];
				this.repoLivro[numUsuario-1] = null;
				this.numUsuario--;
			}
		}
	}
	
	public boolean atualizarLivro(Livro livro){
		boolean retorno = false;
		int i;	
		for(i = 0; i < numUsuario; i++){
			if(this.repoLivro[i].getCodigoLivro() == livro.getCodigoLivro()){
				this.repoLivro[i] = livro;
				retorno = true;
			}
		}
		return retorno;
	}
}
