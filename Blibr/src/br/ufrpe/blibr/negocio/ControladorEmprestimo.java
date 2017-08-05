package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ufrpe.blibr.dados.RepositorioEmprestimo;
import br.ufrpe.blibr.dados.RepositorioLivro;
import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorEmprestimo implements IControladorEmprestimo{
	
	private static ControladorEmprestimo instance;
	private RepositorioLivro repoLivro = RepositorioLivro.getInstance();
	private RepositorioEmprestimo repoEmprestimo = RepositorioEmprestimo.getInstance();
	private ControladorMulta  multa = ControladorMulta.getInstance();
	private RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	Calendar cal = Calendar.getInstance();
	
	public static ControladorEmprestimo getInstance(){
		if(instance==null){
			instance = new ControladorEmprestimo();
		}
		return instance;
	}
	
	public void registrarEmprestimo(Emprestimo emprestimo, Date date) throws ElementoNaoExisteException, ElementoJaExisteException{
		try {
			if(emprestimo == null){
				throw new ObjetoInvalidoExcpetion("Desculpa, mas esses dados são inválidos!");
			}else{
				repoLivro.buscarLivrro(emprestimo.getLivro().getNomeLivro()).setQuantidadeLivros
				(repoLivro.buscarLivrro(emprestimo.getLivro().getNomeLivro()).getQuantidadeLivros()-1);
				
				cal.setTime(date);
				cal.add(Calendar.DATE, +7);
				date=cal.getTime();
				emprestimo.setDataDevolucao(date);
				
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
			if(cpf==null){
				throw new ObjetoInvalidoExcpetion("Descule, mas esse cpf é inválido!");
			}else{
				if(repoEmprestimo.buscarEmprestimo(cpf).getDataDevolucao().compareTo
						(repoEmprestimo.buscarEmprestimo(cpf).getDataEmprestimo())>0){
					multa.atribuirMulta(cpf);
				}
			}
		} catch (ObjetoInvalidoExcpetion e) {
			e.printStackTrace();
		}
	}

	public void realizarDevolução(Emprestimo emprestimo) throws ElementoNaoExisteException{
		try {
			if(emprestimo!=null){
				repoLivro.buscarLivrro(emprestimo.getLivro().getNomeLivro()).setQuantidadeLivros
				(repoLivro.buscarLivrro(emprestimo.getLivro().getNomeLivro()).getQuantidadeLivros()+1);
				repoEmprestimo.remover(emprestimo);
			}else{
				
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
}