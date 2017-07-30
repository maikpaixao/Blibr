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
import br.ufrpe.blibr.exception.ElementoNaoExistente;

public class RepositorioEmprestimo {
	
	private RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	private RepositorioLivro repoLivro = RepositorioLivro.getInstance();
	private ArrayList<Emprestimo> empLista = new ArrayList<Emprestimo>();
	private List<Usuario> listaUsuario;
	private ArrayList<Livro> listaLivro;
	Calendar cal = Calendar.getInstance();
	
	private DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
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
	
	public List<Usuario> listarLivrosEmprestados(){
		List<Usuario> retorno = null;
		listaUsuario = repoUsuario.listarUsuarios();
		listaLivro = repoLivro.listarLivros();
		for(Usuario usu: listaUsuario){
			for(Livro li: listaLivro){
				if(listaLivro.contains(usu.getLivro())){
					retorno = listaUsuario;
				}
			}
		}
		return retorno;
	}
	
	public void registrarEmprestimo(Emprestimo emprestimo)throws ElementoNaoExistente{
		try {
			if(emprestimo!=null){
				Date date = new Date();
				Livro livro = new Livro();
				livro.setQuantidadeLivros((livro.getQuantidadeLivros())-1);
				emprestimo.setDataEmprestimo(date);
				cal.setTime(date);
				cal.add(Calendar.DATE, +7);
				date=cal.getTime();
				emprestimo.setDataDevolucao(date);
				this.empLista.add(emprestimo);
			}else{
				throw new ElementoNaoExistente(emprestimo);
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
	}
	
	public Emprestimo buscarEmprestimo(Long cpf) throws ElementoNaoExistente{
		Emprestimo rotorno = null;
		try {
			for(Emprestimo emprestimo: empLista){
				if(emprestimo.getUsuario().getCpf().equals(cpf) && cpf!=null){
					rotorno = emprestimo;
				}else{
					throw new ElementoNaoExistente(emprestimo);
				}
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
		return rotorno;
	}
	
	public ArrayList<Emprestimo> listarEmprestimos(){
		return this.empLista;
	}
	
	public void realizarDevolução(Usuario usuario, Livro livro)throws ElementoNaoExistente{
		try {
			for(Emprestimo emp: empLista){
				if(emp.getUsuario().getCpf().equals(usuario.getCpf()) && emp.getLivro().getCodigoLivro().equals(livro.getCodigoLivro())){
					this.empLista.remove(emp);
					livro.setQuantidadeLivros((livro.getQuantidadeLivros())+1);
					break;
				}else{
					throw new ElementoNaoExistente(emp);
				}
			}
		}catch(ElementoNaoExistente e){
			e.getObj();
		}
	}
}