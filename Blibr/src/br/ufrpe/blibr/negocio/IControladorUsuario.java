package br.ufrpe.blibr.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IControladorUsuario {

	public void adicionarUsuario(Usuario usuario) throws ElementoJaExisteException, ElementoNaoExisteException, IOException;
	public List<Usuario> listarUsuario();
	public Usuario buscarUsuario(Long cpf);
	public void removerUsuario(Long cpf) throws IOException;
	public void editarUsario(Usuario usuario) throws IOException;
}
