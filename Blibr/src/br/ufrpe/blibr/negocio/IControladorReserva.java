package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IControladorReserva {

	public void reservarLivro(Usuario usuario, Livro livro);
}
