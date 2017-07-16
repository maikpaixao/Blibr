package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.negocio.beans.Usuario;;

public class ControladorUsuario implements IControladorUsuario{
	
	private RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	private static ControladorUsuario instance;
	
	public static synchronized ControladorUsuario getInstance(){
		if(instance==null){
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	public void adicionarUsuario(Usuario usuario){
		try {
			if(usuario!=null && repoUsuario.buscarUsuario(usuario.getCpf())!=null){
				throw new UsuarioExistente("Esse usuário já está cadastrado!");
			}else{
				repoUsuario.adicionarUsuario(usuario);
				
			}
		} catch (UsuarioExistente e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList<Usuario> listarUsuario(){
		return repoUsuario.listarUsuarios();
	}
	
	public Usuario buscarUsuario(String cpf) {
		Usuario retorno = null;
		try {
			if(cpf!=null && repoUsuario.buscarUsuario(cpf)==null){
				throw new UsuarioNaoExistente("Usuario não existe.");
			}else{
				retorno = repoUsuario.buscarUsuario(cpf);
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}

	public void removerUsuario(String cpf){
		try {
			if(cpf!=null && repoUsuario.buscarUsuario(cpf)!=null){
				repoUsuario.removerUsuario(cpf);
			}else{
				throw new UsuarioNaoExistente("Usuário não existe.");
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void editarUsario(Usuario usuario){
		try {
			if(usuario!=null && repoUsuario.buscarUsuario(usuario.getCpf())!=null){
				repoUsuario.editarUsuario(usuario);
			}else{
				throw new UsuarioNaoExistente("Usuario não existe!");
			}
		} catch (UsuarioNaoExistente e) {
			System.out.println(e.getMessage());
		}
	}
}