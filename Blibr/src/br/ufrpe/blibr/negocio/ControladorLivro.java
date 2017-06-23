package br.ufrpe.blibr.negocio;

<<<<<<< HEAD
import java.util.ArrayList;

import br.ufrpe.blibr.dados.RepositorioLivro;
import br.ufrpe.blibr.exception.LivroNaoExistente;
import br.ufrpe.blibr.negocio.beans.Livro;

public class ControladorLivro {
	
	private RepositorioLivro repoLivro;
	private static ControladorLivro instance;
	
	public static ControladorLivro getInstance(){
		if(instance==null){
			instance = new ControladorLivro();
		}
		return instance;
	}

	public void adicionarLivro(Livro livro) throws Exception {
		repoLivro.adicionarLivro(livro);
	}

	public Livro buscarLivrro(double codigoLivro) {
		return repoLivro.buscarLivrro(codigoLivro);
	}

	public void editarLivro(Livro livro) throws LivroNaoExistente {
		repoLivro.editarLivro(livro);
	}

	public boolean equals(Object obj) {
		return repoLivro.equals(obj);
	}

	public ArrayList<Livro> listarLivros() {
		return repoLivro.listarLivros();
	}

	public void removerLivro(Livro livro) throws LivroNaoExistente {
		repoLivro.removerLivro(livro);
	}

	public String toString() {
		return repoLivro.toString();
	}
=======
public class ControladorLivro {
	
>>>>>>> branch 'master' of https://github.com/maikpaixao/Blibr.git
}
