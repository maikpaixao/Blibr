package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IControladorUsuario {

	public void adicionarUsuario(Usuario usuario) throws ElementoJaExisteException, ElementoNaoExisteException;
	public List<Usuario> listarUsuario();
	public Usuario buscarUsuario(Long cpf);
	public void removerUsuario(Long cpf);
	public void editarUsario(Usuario usuario);
}
