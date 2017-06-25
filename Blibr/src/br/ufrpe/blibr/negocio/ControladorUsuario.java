package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.negocio.beans.Usuario;;

public class ControladorUsuario {
	
	private RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	private static ControladorUsuario instance;
	
	public static synchronized ControladorUsuario getInstance(){
		if(instance==null){
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	public void adicionarUsuario(Usuario usuario){
		repoUsuario.adicionarUsuario(usuario);
	}
	
	public ArrayList<Usuario> listarUsuario(){
		return repoUsuario.listarUsuarios();
	}
	
	
	
	public Usuario buscarUsuario(String cpf) {
		return repoUsuario.buscarUsuario(cpf);
	}

	public void removerUsuario(String cpf){
		try {
			if(cpf != null){
				repoUsuario.removerUsuario(cpf);
			}else{
				throw new UsuarioNaoExistente("Usuario não existe");
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void editarUsario(Usuario usuario){
			if(usuario != null){
				repoUsuario.editarUsuario(usuario);
			}else{
				
			}
	}
}