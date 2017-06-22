package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.negocio.beans.Usuario;;

public class ControladorUsuario {
	
	private RepositorioUsuario repoUsuario;
	private static ControladorUsuario instance;
	
	public ControladorUsuario(){
		this.repoUsuario = new RepositorioUsuario();
	}
	
	public ControladorUsuario getInstance(){
		if(instance==null){
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	public void adicionarUsuario(Usuario usuario){
		try{
			if(usuario != null && repoUsuario.existeUsuario(usuario.getCpf()) == false){
				repoUsuario.adicionarUsuario(usuario);
			}else{
				throw new UsuarioNaoExistente("Usuario já existe");
			}
		}catch(UsuarioNaoExistente e){
			System.out.println(e.getMessage());
		}
	}
	
	public Usuario buscarUsuario(double cpf){
		try {
			if(repoUsuario.existeUsuario(cpf)){
				return repoUsuario.buscarUsuario(cpf);
			}else{
				throw new UsuarioNaoExistente("Usuario não existe");
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void removerUsuario(double cpf){
		try {
			if(repoUsuario.existeUsuario(cpf)){
				repoUsuario.removerUsuario(cpf);
			}else{
				throw new UsuarioNaoExistente("Usuario não existe");
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void atualizarUsario(Usuario usuario){
		try {
			if(usuario != null && repoUsuario.existeUsuario(usuario.getCpf())){
				repoUsuario.atualizarUsuario(usuario);
			}else{
				throw new UsuarioNaoExistente("Usuario nao existe");
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
	}
}
