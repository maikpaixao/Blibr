package br.ufrpe.blibr.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class RepositorioEmprestimo {
	
	private RepositorioLivro repoLivro;
	private List<Livro> liv = new ArrayList();
	
	public void emprestarLivro(Livro livro, Usuario usuario){
		for(Livro livros: liv){
			if(repoLivro.existeLivro(livro)){
				usuario.setLivro(livro);
				livro.setQuantidadeLivros((livro.getQuantidadeLivros())-1);
			}
		}
	}
}
