package br.ufrpe.blibr.dados;

import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;
import br.ufrpe.blibr.dados.RepositorioUsuario;

public class RepositorioEmprestimo {
	
	private RepositorioUsuario repoUsuario;
	
	public void emprestarLivro(Livro livro, Usuario usuario){
		for(Usuario usu: repoUsuario.listarUsuarios()){
			if(usu.getCpf()==usuario.getCpf()){
				usuario.setLivro(livro);
				livro.setQuantidadeLivros((livro.getQuantidadeLivros())-1);
			}
		}
	}
}
