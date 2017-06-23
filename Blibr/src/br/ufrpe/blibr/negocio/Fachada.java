package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.exception.UsuarioExistente;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class Fachada {
	private static Fachada instance;
	private ControladorUsuario controladorU;
	private ControladorLivro controladorL;
	
	private Fachada(){
		this.controladorU = ControladorUsuario.getInstance();
		this.controladorL = ControladorLivro.getInstance();
	}
	
	public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

	public String toString() {
		return instance.toString();
	}

	public void adicionarUsuario(Usuario usuario) throws UsuarioExistente {
		controladorU.adicionarUsuario(usuario);
	}

	public ArrayList<Usuario> listarUsuario(double cpf) {
		return controladorU.listarUsuario(cpf);
	}

	public void removerUsuario(Usuario usuario) {
		controladorU.removerUsuario(usuario);
	}

	public void editarUsario(Usuario usuario) {
		controladorU.editarUsario(usuario);
	}

	public void adicionarLivro(Livro livro) throws Exception {
		controladorL.adicionarLivro(livro);
	}

	public Livro buscarLivrro(double codigoLivro) {
		return controladorL.buscarLivrro(codigoLivro);
	}

	public void editarLivro(Livro livro) throws LivroNaoExistente {
		controladorL.editarLivro(livro);
	}

	public ArrayList<Livro> listarLivros() {
		return controladorL.listarLivros();
	}

	public void removerLivro(Livro livro) throws LivroNaoExistente {
		controladorL.removerLivro(livro);
	}
	
	
}
