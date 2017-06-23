package br.ufrpe.blibr.dados;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioUsuario {
	
	private static RepositorioUsuario instance;
	private ArrayList<Usuario> listaUsuario;
	
	public static synchronized RepositorioUsuario getInstance(){
		if(instance == null){
			instance = new RepositorioUsuario();
		}
		return instance;
	}
	
	public RepositorioUsuario(){
		this.listaUsuario = new ArrayList<Usuario>();
	}
	
	public void adicionarUsuario(Usuario usuario) throws UsuarioExistente{
		if(this.listaUsuario.contains(usuario)){
			listaUsuario.add(usuario);
		}else{
		throw new UsuarioExistente("Esse usuário já existe!");
		}
	}
	
	public Usuario buscarUsuario(String cpf){
		for(Usuario usuario: listaUsuario){
			if(usuario.getCpf().equals(cpf)){
				return usuario;
			}
		}
		return null;
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		return this.listaUsuario;
	}
	
	public void removerUsuario(Usuario usuario) throws UsuarioNaoExistente{
		if(this.listaUsuario.contains(usuario)){
			this.listaUsuario.remove(usuario);
		}else{
			throw new UsuarioNaoExistente("Esse usuario não existe!");
		}
	}
	
	public void editarUsuario(Usuario usuario) throws UsuarioNaoExistente{
		if (this.listaUsuario.contains(usuario)) {
            int indice = this.listaUsuario.indexOf(usuario);
            this.listaUsuario.set(indice, usuario);
        } else {
            throw new UsuarioNaoExistente("Esse usuario nao existe!");
        }
	}
	
}
