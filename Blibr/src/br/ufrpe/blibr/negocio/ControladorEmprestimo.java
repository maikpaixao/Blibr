package br.ufrpe.blibr.negocio;

import java.text.ParseException;
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
	Calendar cal = Calendar.getInstance();
	
	private ControladorEmprestimo(){
		repoEmprestimo = new RepositorioGenerico<>("sad");
		repoUsuario = new RepositorioGenerico<>("sad");
		repoLivro = new RepositorioGenerico<>("sad");
	}
	
	public static ControladorEmprestimo getInstance(){
		if(instance==null){
			instance = new ControladorEmprestimo();
		}
		return instance;
	}
	
	public void registrarEmprestimo(Emprestimo emprestimo, Date date) throws ElementoNaoExisteException, ElementoJaExisteException{
		try {
			if(emprestimo == null && buscarEmprestimo(emprestimo.getUsuario().getCpf()).getMulta()==null){
				throw new ObjetoInvalidoExcpetion("Desculpa, mas esses dados s�o inv�lidos!");
			}else{
				controllerLivro.buscarLivro(emprestimo.getLivro().getNomeLivro()).setQuantidadeLivros
				(controllerLivro.buscarLivro(emprestimo.getLivro().getNomeLivro()).getQuantidadeLivros()-1);
				cal.setTime(date);
				cal.add(Calendar.DATE, +7);
				date=cal.getTime();
				emprestimo.setDataDevolucao(date);
				repoEmprestimo.adicionar(emprestimo);
			}
		} catch (ObjetoInvalidoExcpetion e) {
			e.printStackTrace();
		}
	}
	
	public List<Emprestimo> listarEmprestimos(){
		return repoEmprestimo.listar();
	}
	
	public void verificarEmprestimo(Long cpf) throws ValidadeEmprestimoException, ElementoNaoExisteException{
		try {
			if(cpf!=null && buscarEmprestimo(cpf).getDataDevolucao().compareTo
				(buscarEmprestimo(cpf).getDataEmprestimo())>0){
				throw new ValidadeEmprestimoException(buscarEmprestimo(cpf));
			}else{
				ControladorMulta  multa = ControladorMulta.getInstance();
				Date dDe = buscarEmprestimo(cpf).getDataDevolucao();
				Date dEm = buscarEmprestimo(cpf).getDataEmprestimo();
				Long subDias = (dDe.getTime()-dEm.getTime());
				Long dias = subDias/86400000L;
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
			e.getObj();
		}
		return rotorno;
	}

	public void realizarDevolu��o(Emprestimo emprestimo) throws ElementoNaoExisteException{
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