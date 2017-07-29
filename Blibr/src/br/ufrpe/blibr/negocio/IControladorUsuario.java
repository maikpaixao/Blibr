package br.ufrpe.blibr.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.blibr.exception.ElementoNaoExistente;
import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IControladorUsuario {

	public void adicionarUsuario(Usuario usuario) throws ElementoNaoExistente;
	public List<Usuario> listarUsuario();
	public Usuario buscarUsuario(Long cpf);
	public void removerUsuario(Long cpf);
	public void editarUsario(Usuario usuario);
}
