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
		for(Usuario usuario: listaUsuario){
			if(usuario.getCpf().equals(cpf)){
				return usuario;
			}
		}
		return null;
	}
	
	public void editarUsuario(Usuario usuario){
		if(usuario!=null){
			for(Usuario us: this.listaUsuario){
				if (us.getNome().equals(usuario.getNome())){
					int indice = this.listaUsuario.indexOf(us);
		            listaUsuario.set(indice, usuario);
		        }else{
		        	
		        }
			}
		}
	}
	
	public void removerUsuario(String cpf){
		if(cpf!=null){
			for(Usuario us: listaUsuario){
				if(us.getCpf().equals(cpf)){
					this.listaUsuario.remove(us);
					break;
				}else{
					
				}
			}
		}
	}
	
}
