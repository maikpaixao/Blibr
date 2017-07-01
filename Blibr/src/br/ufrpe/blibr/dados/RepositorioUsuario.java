package br.ufrpe.blibr.dados;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioUsuario {
	
	private static RepositorioUsuario instance;
	private ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	
	public static synchronized RepositorioUsuario getInstance(){
		if(instance == null){
			instance = new RepositorioUsuario();
		}
		return instance;
	}
	
	public void adicionarUsuario(Usuario usuario){
		if(usuario!=null && !this.listaUsuario.contains(usuario)){
			this.listaUsuario.add(usuario);
		}else{
			
		}
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		return this.listaUsuario;
	}
	
	public Usuario buscarUsuario(String cpf){
		Usuario rotorno = null;
		for(Usuario usuario: listaUsuario){
			if(usuario.getCpf().equals(cpf) && cpf!=null){
				rotorno = usuario;
			}
		}
		return rotorno;
	}
	
	public void editarUsuario(Usuario usuario){
		for(Usuario us: this.listaUsuario){
			if (us.getNome().equals(usuario.getNome()) && usuario!=null){
				int indice = this.listaUsuario.indexOf(us);
		        listaUsuario.set(indice, usuario);
		    }else{
		        	
		    }
		}
	}
	
	public void removerUsuario(String cpf){
		for(Usuario us: listaUsuario){
			if(us.getCpf().equals(cpf) && cpf!=null){
				this.listaUsuario.remove(us);
				break;
			}else{
					
			}
		}
	}
	
}
