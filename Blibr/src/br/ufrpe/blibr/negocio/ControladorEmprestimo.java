package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ufrpe.blibr.dados.RepositorioEmprestimo;
import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorEmprestimo implements IControladorEmprestimo{
	
	private static ControladorEmprestimo instance;
	private RepositorioEmprestimo repoEmprestimo = RepositorioEmprestimo.getInstance();
	private ControladorMulta  multa = ControladorMulta.getInstance();
	private RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	
	public static ControladorEmprestimo getInstance(){
		if(instance==null){
			instance = new ControladorEmprestimo();
		}
		return instance;
	}
	
	/*public void emprestarLivro(Livro livro, Usuario usuario) throws ParseException{
		try {
			if(livro == null || usuario == null){
				throw new ObjetoInvalidoExcpetion("Desculpe, mas esses dados são inválidos!");
			}else if((livro!=null && usuario!=null) && livro.getQuantidadeLivros()==0){
				ctrReserva.reservarLivro(usuario, livro);
			}else{
				repoEmprestimo.emprestarLivro(livro, usuario);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}*/
	
	
	//As tretas das datas tem q fazer aqui e nao no repositorio
	public void registrarEmprestimo(Emprestimo emprestimo) throws ElementoNaoExisteException{
		try {
			if(emprestimo == null){
				throw new ObjetoInvalidoExcpetion("Desculpa, mas esses dados são inválidos!");
			}else{
				repoEmprestimo.adicionar(emprestimo);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			e.getMessage();
		}
	}
	
	public List<Emprestimo> listarEmprestimos(){
		return repoEmprestimo.listar();
	}
	
	public void verificarEmprestimo(Long cpf) throws ElementoNaoExisteException{
		try {
			Date date = new Date();
			if(cpf==null){
				throw new ObjetoInvalidoExcpetion("Descule, mas esse cpf é inválido!");
			}else{
				if(repoEmprestimo.buscarEmprestimo(cpf).getDataDevolucao()==date){
					multa.atribuirMulta(cpf);
				}
			}
		} catch (ObjetoInvalidoExcpetion e) {
			e.printStackTrace();
		}
	}
	
	//Mesma problema do adicionar
	public void realizarDevolução(Usuario usuario, Livro livro) throws ElementoNaoExisteException{
		try {
			if(usuario!=null && livro!=null){
				repoEmprestimo.remover(usuario, livro);
			}else{
				
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
}