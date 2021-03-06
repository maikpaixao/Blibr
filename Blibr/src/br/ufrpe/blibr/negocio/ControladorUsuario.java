package br.ufrpe.blibr.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Usuario;;

public class ControladorUsuario implements IControladorUsuario{
	
	private IRepositorio<Usuario> repoUsuario;
	private static ControladorUsuario instance;
	
	private ControladorUsuario(){
		this.repoUsuario = new RepositorioGenerico<>("usuario.arq");
	}
	
	public static synchronized ControladorUsuario getInstance(){
		if(instance==null){
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	public void adicionarUsuario(Usuario usuario) throws ElementoJaExisteException, ElementoNaoExisteException{
		try{
			if(usuario!=null){
				throw new ElementoJaExisteException("Esse usu�rio j� est� cadastrado!");
			}else{
				repoUsuario.adicionar(usuario);
			}
		} catch (ElementoJaExisteException e) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> listarUsuario(){
		List<Usuario> lista = repoUsuario.listar();
		return lista;
	}
	
	public Usuario buscarUsuario(Long cpf) {
		Usuario retorno = null;
		try {
			if(cpf==null){
				throw new ElementoNaoExisteException(buscarUsuario(cpf));
			}else{
				for(Usuario usuario: repoUsuario.listar()){
					if(usuario.getCpf().equals(cpf)){
						retorno = usuario;
					}
				}
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public void removerUsuario(Long cpf){
		try{
			if(cpf!=null){
				repoUsuario.remover(buscarUsuario(cpf));
			}else{
				throw new ElementoNaoExisteException(buscarUsuario(cpf));
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}
	
	public void editarUsario(Usuario usuario){
		try{
			if(usuario!=null){
				repoUsuario.atualizar(usuario);
			}else{
				throw new ElementoNaoExisteException(usuario);
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}	
	
}