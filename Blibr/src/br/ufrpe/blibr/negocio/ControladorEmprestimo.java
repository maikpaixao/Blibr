package br.ufrpe.blibr.negocio;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.exception.ValidadeEmprestimoException;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorEmprestimo implements IControladorEmprestimo{
	
	private static ControladorEmprestimo instance;
	private IRepositorio<Livro> repoLivro;
	private IRepositorio<Emprestimo> repoEmprestimo;
	private ControladorLivro controllerLivro = ControladorLivro.getInstance();
	private IRepositorio<Usuario> repoUsuario;
	
	private ControladorEmprestimo(){
		repoEmprestimo = new RepositorioGenerico<>("emprestimo.arq");
		repoUsuario = new RepositorioGenerico<>("usuario.arq");
		repoLivro = new RepositorioGenerico<>("livro.arq");
	}
	
	public static ControladorEmprestimo getInstance(){
		if(instance==null){
			instance = new ControladorEmprestimo();
		}
		return instance;
	}
	
	public void registrarEmprestimo(Emprestimo emprestimo) throws ElementoNaoExisteException, ElementoJaExisteException{
		try {
			if(emprestimo == null && 
			   buscarEmprestimo(emprestimo.getUsuario().getCpf()).getMulta().getDivida()>(0.0)){
				throw new ObjetoInvalidoExcpetion("Desculpa, mas esses dados são inválidos!");
			}else{
				controllerLivro.buscarLivro(emprestimo.getLivro().getNomeLivro()).setQuantidadeLivros
				(controllerLivro.buscarLivro(emprestimo.getLivro().getNomeLivro()).getQuantidadeLivros()-1);
				repoEmprestimo.adicionar(emprestimo);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			e.printStackTrace();
		}
	}
	
	public List<Emprestimo> listarEmprestimos(){
		List<Emprestimo> lista = repoEmprestimo.listar();
		return lista;
	}
	
	public void verificarEmprestimo(Long cpf) throws ValidadeEmprestimoException, ElementoNaoExisteException{
		try {
			if(cpf!=null && buscarEmprestimo(cpf).getDataDevolucao().compareTo
				(buscarEmprestimo(cpf).getDataEmprestimo())>0){
				throw new ValidadeEmprestimoException(buscarEmprestimo(cpf));
			}else{
				ControladorMulta  multa = ControladorMulta.getInstance();
				LocalDate dDe = buscarEmprestimo(cpf).getDataDevolucao();
				LocalDate dEm = buscarEmprestimo(cpf).getDataEmprestimo();
				Long dias = ChronoUnit.DAYS.between(dEm, dDe);
				multa.atribuirMulta(cpf, dias);
			}
		} catch (ValidadeEmprestimoException e) {
			e.printStackTrace();
		}
	}
	
	public Emprestimo buscarEmprestimo(Long cpf) throws ElementoNaoExisteException{
		Emprestimo rotorno = null;
		try {
			for(Emprestimo emprestimo: listarEmprestimos()){
				if(emprestimo.getUsuario().getCpf().equals(cpf)){
					rotorno = emprestimo;
				}else{
					throw new ElementoNaoExisteException(emprestimo);
				}
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
		return rotorno;
	}

	public void realizarDevolução(Emprestimo emprestimo) throws ElementoNaoExisteException{
		try {
			if(emprestimo!=null){
				controllerLivro.buscarLivro(emprestimo.getLivro().getNomeLivro()).setQuantidadeLivros
				(controllerLivro.buscarLivro(emprestimo.getLivro().getNomeLivro()).getQuantidadeLivros()+1);
				repoEmprestimo.remover(emprestimo);
			}else{
				
			}
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}
}