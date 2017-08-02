package br.ufrpe.blibr.dados;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IRepositorioUsuario {
	
	public Usuario buscarUsuario(Long cpf) throws ElementoNaoExisteException;
}
