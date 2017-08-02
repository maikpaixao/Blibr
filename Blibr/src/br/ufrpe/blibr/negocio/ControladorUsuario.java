package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
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
	
	public void adicionarUsuario(Usuario usuario) throws ElementoJaExisteException, ElementoNaoExisteException{
		try{
			if(usuario!=null && repoUsuario.buscarUsuario(usuario.getCpf())!=null){
				throw new ElementoJaExisteException("Esse usuário já está cadastrado!");
			}else{
				repoUsuario.adicionar(usuario);
			}
		} catch (ElementoJaExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Usuario> listarUsuario(){
		return repoUsuario.listar();
	}
	
	public Usuario buscarUsuario(Long cpf) {
		Usuario retorno = null;
		try {
			if(cpf!=null && repoUsuario.buscarUsuario(cpf)==null){
				throw new ElementoNaoExisteException(repoUsuario.buscarUsuario(cpf));
			}else{
				retorno = repoUsuario.buscarUsuario(cpf);
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
		return retorno;
	}

	public void removerUsuario(Long cpf){
		try{
			if(cpf!=null && repoUsuario.buscarUsuario(cpf)!=null){
				repoUsuario.remover(repoUsuario.buscarUsuario(cpf));
			}else{
				throw new ElementoNaoExisteException(repoUsuario.buscarUsuario(cpf));
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
	
	public void editarUsario(Usuario usuario){
		try{
			if(usuario!=null && repoUsuario.buscarUsuario(usuario.getCpf())!=null){
				repoUsuario.atualizar(usuario);
			}else{
				throw new ElementoNaoExisteException(usuario);
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
}