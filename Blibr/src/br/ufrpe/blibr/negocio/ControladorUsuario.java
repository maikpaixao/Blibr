package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.negocio.beans.Usuario;;

public class ControladorUsuario {
	
	private RepositorioUsuario repoUsuario;
	private static ControladorUsuario instance;
	
	public ControladorUsuario(){
		this.repoUsuario = new RepositorioUsuario();
	}
	
	public static ControladorUsuario getInstance(){
		if(instance==null){
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	public void adicionarUsuario(Usuario usuario) throws UsuarioExistente{
		try{
			if(usuario != null){
				repoUsuario.adicionarUsuario(usuario);
			}else{
				throw new UsuarioNaoExistente("Usuario já existe");
			}
		}catch(UsuarioNaoExistente e){
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Usuario> listarUsuario(double cpf){
		return repoUsuario.listarUsuarios();
	}
	
	public void removerUsuario(Usuario usuario){
		try {
			if(usuario != null){
				repoUsuario.removerUsuario(usuario);
			}else{
				throw new UsuarioNaoExistente("Usuario não existe");
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void editarUsario(Usuario usuario){
		try {
			if(usuario != null){
				repoUsuario.editarUsuario(usuario);
			}else{
				throw new UsuarioNaoExistente("Usuario nao existe");
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
	}
}