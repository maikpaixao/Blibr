package br.ufrpe.blibr.dados;

import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ufrpe.blibr.dados.RepositorioUsuario;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;

public class RepositorioEmprestimo extends RepositorioGenerico<Emprestimo>{
	
	private static RepositorioEmprestimo instance;
	
	public static synchronized RepositorioEmprestimo getInstance(){
		if(instance == null){
			instance = new RepositorioEmprestimo();
		}
		return instance;
	}
	
	/*public void emprestarLivro(Livro livro, Usuario usuario) throws ParseException{
		
		listaUsuario = repoUsuario.listarUsuarios();
		Date date = new Date();
			for(Usuario usu: listaUsuario){
				if(repoUsuario.listarUsuarios().contains(usuario) && livro!=null && usuario!=null){
					usuario.setLivro(livro);
					livro.setQuantidadeLivros((livro.getQuantidadeLivros())-1);
					livro.setDataEmprestimo(date);
					
					cal.setTime(date);
					cal.add(Calendar.DATE, +7);
					date=cal.getTime();
					livro.setDataDevolucao(date);
				}
			}
	}*/
	
//	public List<Livro> listarLivrosEmprestados(){
//		List<Livro> retorno = null;
//		for(Emprestimo emp: empLista){
//			retorno.add(emp.getLivro());
//		}
//		return retorno;
//	}
//	@Override
//	public void adicionar(Emprestimo emprestimo)throws ElementoNaoExisteException{
//		try {
//			if(emprestimo!=null){
//				empLista.add(emprestimo);
//			}else{
//				throw new ElementoNaoExisteException(emprestimo);
//			}
//		} catch (ElementoNaoExisteException e) {
//			e.getObj();
//		}
//	}
	
	public Emprestimo buscarEmprestimo(Long cpf) throws ElementoNaoExisteException{
		Emprestimo rotorno = null;
		try {
			for(Emprestimo emprestimo: this.lista){
				if(emprestimo.getUsuario().getCpf().equals(cpf) && cpf!=null){
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
	
//	public void remover(Usuario usuario, Livro livro)throws ElementoNaoExisteException{
//		try {
//			for(Emprestimo emp: empLista){
//				if(emp.getUsuario().getCpf().equals(usuario.getCpf()) && emp.getLivro().getCodigoLivro().equals(livro.getCodigoLivro())){
//					this.empLista.remove(emp);
//					livro.setQuantidadeLivros((livro.getQuantidadeLivros())+1);
//					break;
//				}else{
//					throw new ElementoNaoExisteException(emp);
//				}
//			}
//		}catch(ElementoNaoExisteException e){
//			e.getObj();
//		}
//	}
}