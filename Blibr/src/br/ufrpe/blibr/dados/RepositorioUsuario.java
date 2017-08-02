package br.ufrpe.blibr.dados;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioUsuario extends RepositorioGenerico<Usuario> implements IRepositorioUsuario{
	
	private static RepositorioUsuario instance;
//	protected List<Usuario> listaUsuario;
//	
	public static synchronized RepositorioUsuario getInstance(){
		if(instance == null){
			instance = new RepositorioUsuario();
		}
		return instance;
	}
//	
//	public RepositorioUsuario(){
//		this.listaUsuario =  new ArrayList<>();
//	}
//	
//	public void adicionarUsuario(Usuario usuario) throws ElementoNaoExistente{
//		try {
//			if(usuario!=null && !this.listaUsuario.contains(usuario)){
//				this.listaUsuario.add(usuario);
//			}else{
//				throw new ElementoNaoExistente(usuario);
//			}
//		} catch (ElementoNaoExistente e) {
//			e.getObj();
//		}
//	}
//	
//	public List<Usuario> listarUsuarios(){
//		return listaUsuario;
//	}
//	
	public Usuario buscarUsuario(Long cpf) throws ElementoNaoExisteException{
		Usuario rotorno = null;
		try {
			for(Usuario usuario: this.lista){
				if(usuario.getCpf().equals(cpf) && cpf!=null){
					rotorno = usuario;
				}else{
					throw new ElementoNaoExisteException(usuario);
				}
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
		return rotorno;
	}
//	
//	public void editarUsuario(Usuario usuario)throws ElementoNaoExistente{
//		try {
//			for(Usuario us: this.listaUsuario){
//				if (us.getNome().equals(usuario.getNome()) && usuario!=null){
//					int indice = this.listaUsuario.indexOf(us);
//			        listaUsuario.set(indice, usuario);
//			    }else{
//			    	throw new ElementoNaoExistente(usuario);
//			    }
//			}
//		} catch (ElementoNaoExistente e) {
//			e.getObj();
//		}
//	}
//	
//	public void removerUsuario(Long cpf) throws ElementoNaoExistente{
//		try {
//			for(Usuario us: listaUsuario){
//				if(us.getCpf().equals(cpf) && cpf!=null){
//					this.listaUsuario.remove(us);
//					break;
//				}else{
//					throw new ElementoNaoExistente(buscarUsuario(cpf));
//				}
//			}
//		} catch (ElementoNaoExistente e) {
//			e.getObj();
//		}
//	}
	
}