package br.ufrpe.blibr.negocio;

import java.util.ArrayList;

import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IControladorUsuario {

	public void adicionarUsuario(Usuario usuario);
	public ArrayList<Usuario> listarUsuario();
	public Usuario buscarUsuario(String cpf);
	public void removerUsuario(String cpf);
	public void editarUsario(Usuario usuario);
}
