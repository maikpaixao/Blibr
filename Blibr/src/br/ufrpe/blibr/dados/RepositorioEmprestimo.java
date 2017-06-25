package br.ufrpe.blibr.dados;

import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioUsuario;

public class RepositorioEmprestimo {
	
	private RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	private RepositorioLivro repoLivro = RepositorioLivro.getInstance();
	private ArrayList<Usuario> listaUsuario;
	private ArrayList<Livro> listaLivro;
	
	private static RepositorioEmprestimo instance;
	
	public static synchronized RepositorioEmprestimo getInstance(){
		if(instance == null){
			instance = new RepositorioEmprestimo();
		}
		return instance;
	}
	
	public void emprestarLivro(Livro livro, Usuario usuario){
		listaUsuario = repoUsuario.listarUsuarios();
		if(livro!=null && usuario!=null){
			System.out.println("nuuuulll");
		}
		for(Usuario usu: listaUsuario){
			System.out.println("oiii");
			if(repoUsuario.listarUsuarios().contains(usuario)){
				System.out.println("funcionou");
				usuario.setLivro(livro);
				livro.setQuantidadeLivros((livro.getQuantidadeLivros())-1);
			}
		}
	}
	
	public ArrayList<Usuario> listarLivrosEmprestados(){
		ArrayList<Usuario> retorno = null;
		listaUsuario = repoUsuario.listarUsuarios();
		listaLivro = repoLivro.listarLivros();
		for(Usuario usu: listaUsuario){
			for(Livro li: listaLivro){
				if(listaLivro.contains(usu.getLivro())){
					System.out.println("Funcionou");
					retorno = listaUsuario;
				}
			}
		}
		return retorno;
	}
}
