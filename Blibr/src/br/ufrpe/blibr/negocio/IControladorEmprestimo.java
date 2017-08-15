package br.ufrpe.blibr.negocio;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public interface IControladorEmprestimo {
	
	//public void emprestarLivro(Livro livro, Usuario usuario) throws ParseException;
	public void registrarEmprestimo(Emprestimo emprestimo) throws ElementoNaoExisteException, ElementoJaExisteException;
	public List<Emprestimo> listarEmprestimos();
	//public void verificarEmprestimo(Long cpf);
}
