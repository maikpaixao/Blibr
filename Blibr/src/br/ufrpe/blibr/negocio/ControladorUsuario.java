package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.ElementoNaoExistente;
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
	
	public void adicionarUsuario(Usuario usuario) throws ElementoNaoExistente{
		try{
			if(usuario!=null && repoUsuario.buscarUsuario(usuario.getCpf())!=null){
				throw new UsuarioExistente("Esse usuário já está cadastrado!");
			}else{
				repoUsuario.adicionarUsuario(usuario);
				
			}
		} catch (UsuarioExistente e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public List<Usuario> listarUsuario(){
		return repoUsuario.listarUsuarios();
	}
	
	public Usuario buscarUsuario(Long cpf) {
		Usuario retorno = null;
		try {
			if(cpf!=null && repoUsuario.buscarUsuario(cpf)==null){
				throw new ElementoNaoExistente(repoUsuario.buscarUsuario(cpf));
			}else{
				retorno = repoUsuario.buscarUsuario(cpf);
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
		return retorno;
	}

	public void removerUsuario(Long cpf){
		try{
			if(cpf!=null && repoUsuario.buscarUsuario(cpf)!=null){
				repoUsuario.removerUsuario(cpf);
			}else{
				throw new ElementoNaoExistente(repoUsuario.buscarUsuario(cpf));
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
	}
	
	public void editarUsario(Usuario usuario){
		try{
			if(usuario!=null && repoUsuario.buscarUsuario(usuario.getCpf())!=null){
				repoUsuario.editarUsuario(usuario);
			}else{
				throw new ElementoNaoExistente(usuario);
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
	}
}