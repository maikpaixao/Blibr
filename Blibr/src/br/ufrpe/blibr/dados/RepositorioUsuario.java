package br.ufrpe.blibr.dados;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.ufrpe.blibr.exception.ElementoNaoExistente;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioUsuario {
	
	private static RepositorioUsuario instance;
	protected List<Usuario> listaUsuario;
	
	public static synchronized RepositorioUsuario getInstance(){
		if(instance == null){
			instance = new RepositorioUsuario();
		}
		return instance;
	}
	
	public RepositorioUsuario(){
		this.listaUsuario =  new ArrayList<>();
	}
	
	
	public void adicionarUsuario(Usuario usuario) throws ElementoNaoExistente{
		try {
			if(usuario!=null && !this.listaUsuario.contains(usuario)){
				this.listaUsuario.add(usuario);
			}else{
				throw new ElementoNaoExistente(usuario);
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
	}
	
	public List<Usuario> listarUsuarios(){
		return listaUsuario;
	}
	
	public Usuario buscarUsuario(Long cpf) throws ElementoNaoExistente{
		Usuario rotorno = null;
		try {
			for(Usuario usuario: listaUsuario){
				if(usuario.getCpf().equals(cpf) && cpf!=null){
					rotorno = usuario;
				}else{
					throw new ElementoNaoExistente(usuario);
				}
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
		return rotorno;
	}
	
	public void editarUsuario(Usuario usuario)throws ElementoNaoExistente{
		try {
			for(Usuario us: this.listaUsuario){
				if (us.getNome().equals(usuario.getNome()) && usuario!=null){
					int indice = this.listaUsuario.indexOf(us);
			        listaUsuario.set(indice, usuario);
			    }else{
			    	throw new ElementoNaoExistente(usuario);
			    }
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
	}
	
	public void removerUsuario(Long cpf) throws ElementoNaoExistente{
		try {
			for(Usuario us: listaUsuario){
				if(us.getCpf().equals(cpf) && cpf!=null){
					this.listaUsuario.remove(us);
					break;
				}else{
					throw new ElementoNaoExistente(buscarUsuario(cpf));
				}
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
	}
}