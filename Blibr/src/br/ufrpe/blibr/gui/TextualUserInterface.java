package br.ufrpe.blibr.gui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ValidadeEmprestimoException;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Autor;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class TextualUserInterface {
	
	private Fachada fachada = Fachada.getInstance();
	private Livro livro;
	private Usuario usuario;
	private Funcionario funcionario;
	private Emprestimo emprestimo;
	private int opcao;
	
	Scanner sc = new Scanner(System.in);
	
	public void showInterface() throws ParseException, Exception{
		    
			preencherFuncionario();
			
			do{
				System.out.println("==========Menu========");
				System.out.println("1 - Menu Livro");
				System.out.println("2 - Menu Usuario");
				System.out.println("3 - Menu Emprestimo");
				System.out.println("4 - Menu Multa");
				System.out.println("0 - Sair");
				System.out.println("======================\n");
				System.out.println("Digite o opcao desejada: \n");
				opcao = sc.nextInt();
				
				switch (opcao) {
				case 1:
					menuLivro();
					break;
				case 2:
					menuUsuario();
					break;
				case 3:
					menuEmprestimo();
					break;
				case 4:
					menuMulta();
					break;
				case 0:
					System.exit(0);
				default:
					break;
				}
			}while(opcao!=0);
			
	}
	
	public void menuLivro() throws ElementoNaoExisteException, ElementoJaExisteException{
		
		System.out.println("1-Adicionar Livro");
		System.out.println("2-Listar Livro");
		System.out.println("3-Editar Livro");
		System.out.println("4-Remover Livro");
		
		System.out.println("Digite a opcao desejada: \n");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			adicionarLivro();
			break;
		case 2:
			listarLivro();
			break;
		case 3:
			editarLivro();
			break;
		case 4:
			removerLivro();
			break;
		default:
			break;
		}
	}
	
	public void menuUsuario() throws ElementoNaoExisteException, ElementoJaExisteException{
		Scanner sc = new Scanner(System.in);

		System.out.println("1-Adicionar Usuario");
		System.out.println("2-Listar Usuario");
		System.out.println("3-Editar Usuario");
		System.out.println("4-Remover Usuario");
		
		System.out.println("Digite a opcao desejada: \n");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			adicionarUsuario();
			break;
		case 2:
			listarUsuario();
			break;
		case 3:
			editarUsuario();
			break;
		case 4:
			removerUsuario();
			break;
		default:
			break;
		}
	}
	
	public void menuEmprestimo() throws ParseException, ElementoNaoExisteException, ElementoJaExisteException{
		System.out.println("1 - Emprestar Livro");
		System.out.println("2 - Livros Emprestados");
		System.out.println("3 - Devolver Livro");
		
		System.out.println("Digite a opcao desejada: \n");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			emprestarLivro();
			break;
		case 2:
			listarEmprestimos();
			break;
		case 3:
			realizarDevolucao();
			break;
		default:
			break;
		}
	}
	
	public void menuMulta() throws ElementoNaoExisteException, ValidadeEmprestimoException{
		
		System.out.println("1-Verificar Multa");
		System.out.println("2-Pagar Multa");
		
		System.out.println("Digite a opcao desejada: \n");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			verificarMulta();
			break;
		case 2:
			pagarMulta();
			break;
		default:
			break;
		}
	}
	
	public void adicionarUsuario() throws ElementoNaoExisteException, ElementoJaExisteException{
		
		String nome;
		Long cpf;
		String sexo;
		String dataNascimento;
		
		System.out.println("Digite o nome do usuario: ");
		nome = sc.next();
		System.out.println("Digite o CPF do usuario: ");
		cpf = sc.nextLong();
		System.out.println("Digite o sexo do usuario: ");
		sexo = sc.next();
		System.out.println("Digite a data de nascimento do usuario: ");
		dataNascimento = sc.next();
		
		usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setSexo(sexo);
		//usuario.setDataNascimento(dataNascimento);
		fachada.adicionarUsuario(usuario);
	}
	
	public void listarUsuario(){
		Iterator<Usuario> itr = fachada.listarUsuario().iterator();
		while(itr.hasNext()){
			Usuario usu = (Usuario)itr.next();
			System.out.println(usu);
		}
	}
	
	public void editarUsuario(){
		String nome;
		Long cpf;
		String sexo;
		String dataNascimento;
		
		System.out.println("Digite o CPF do usuario: ");
		cpf = sc.nextLong();
		
		System.out.println("=============================");
		System.out.println("Digite novo nome do usuario: ");
		nome = sc.next();
		System.out.println("Digite novo sexo do usuario: ");
		sexo = sc.next();
		System.out.println("Digite nova idade do usuario: ");
		dataNascimento = sc.next();
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		//usuario.setDataNascimento(dataNascimento);
		usuario.setSexo(sexo);
		usuario.setCpf(cpf);
		fachada.editarUsario(usuario);
	}
	
	public void removerUsuario(){
		Long cpf;
		System.out.println("Digite o cpf do usuario: ");
		cpf = sc.nextLong();
		fachada.removerUsuario(cpf);
	}
	
	//==========================Livro==============================
	
	public void adicionarLivro() throws ElementoNaoExisteException, ElementoJaExisteException{
		
		Autor autorLivro = new Autor();
		
		int codigoLivro;
		String nomeLivro;
		String nomeAutor;
		String editora;
		
		System.out.println("Digite o nome do livro: ");
		nomeLivro = sc.next();
		System.out.println("Digite o nome autor do livro: ");
		nomeAutor = sc.next();
		autorLivro.setNome(nomeAutor);
		System.out.println("Digite a editora do livro: ");
		editora = sc.next();
		
		livro = new Livro();
		
		livro.setNomeLivro(nomeLivro);
		livro.setAutorLivro(autorLivro);
		livro.setEditora(editora);
		fachada.adicionarLivro(livro);
	
	}
	
	public void listarLivro(){
		Iterator itr = fachada.listarLivros().iterator();
		while(itr.hasNext()){
			Livro li = (Livro)itr.next();
			System.out.println(li);
		}
	}
	
	public void editarLivro() throws ElementoNaoExisteException{
		
		Autor autorLivro = new Autor();
		
		String nomeLivro;
		String nomeAutor;
		String editora;
		int quantidadeLivro;
		
		System.out.println("Digite o nome do Livro: ");
		nomeLivro = sc.next();
		
		System.out.println("=============================");
		System.out.println("Digite novo autor do Livro: ");
		nomeAutor = sc.next();
		autorLivro.setNome(nomeAutor);
		System.out.println("Digite nova editora do Livro: ");
		editora = sc.next();
		System.out.println("Digite nova quantidade de Livros: ");
		quantidadeLivro = sc.nextInt();
		
		Livro livro = new Livro();
		livro.setNomeLivro(nomeLivro);
		livro.setAutorLivro(autorLivro);
		livro.setEditora(editora);
		livro.setQuantidadeLivros(quantidadeLivro);
		
		fachada.editarLivro(livro);
		
	}
	
	public void removerLivro() throws ElementoNaoExisteException{
		String nome;
		System.out.println("Digite o nome do livro: ");
		nome = sc.next();
		
		fachada.removerLivro(nome);
	}
	
	public void preencherFuncionario() throws Exception{
		funcionario = new Funcionario();
		funcionario.setCodFuncionario(11);
		funcionario.setNome("Joao");
		funcionario.setCpf((long) 00011100055);
		funcionario.setSexo("masculino");
		//funcionario.setDataNascimento("22/02/1990");
		
		fachada.adicionarFuncionario(funcionario);
	}
	
	public void emprestarLivro() throws ParseException, ElementoNaoExisteException, ElementoJaExisteException{
		String nomeLivro;
		Long cpfUsuario;
		Long codigoFuncionario;
		
		Date date = new Date();
		livro = new Livro();
		usuario = new Usuario();
		emprestimo = new Emprestimo();
		funcionario = new Funcionario();
		
		System.out.println("Digite o seu código como funcionario: ");//Funcionario preenchido pelo método preencherFuncionario()
		codigoFuncionario = sc.nextLong();
		funcionario = fachada.buscarFuncionario(codigoFuncionario);
		emprestimo.setFuncionario(funcionario);
		
		System.out.println("Digite o nome do livro a ser emprestado: ");
		nomeLivro = sc.next();
		livro = fachada.buscarLivro(nomeLivro);
		emprestimo.setLivro(livro);
		
		System.out.println("Digite o CPF do usuario a emprestar o livro: ");
		cpfUsuario=sc.nextLong();
		usuario = fachada.buscarUsuario(cpfUsuario);
		emprestimo.setUsuario(usuario);
		
		emprestimo.setDataEmprestimo(date);
		
		fachada.registrarEmprestimo(emprestimo, date);
		//fachada.emprestarLivro(livro, usuario);
	}
	
	public void realizarDevolucao() throws ElementoNaoExisteException{
		Long cpfUsuario;
		String nomeLivro;
		emprestimo = new Emprestimo();
		usuario = new Usuario();
		livro = new Livro();
		
		System.out.println("Digite o CPF do usuario: ");
		cpfUsuario = sc.nextLong();
		usuario = fachada.buscarUsuario(cpfUsuario);
		emprestimo.setUsuario(usuario);
		
		System.out.println("Digite o nome do livro: ");
		nomeLivro = sc.next();
		livro = fachada.buscarLivro(nomeLivro);
		emprestimo.setLivro(livro);
		
		fachada.realizarDevolução(emprestimo);
	}
	
	public void listarEmprestimos(){
		/*for(Emprestimo emp: fachada.listarEmprestimos()){
			System.out.println(emp);
		}*/
		
		Iterator itr = fachada.listarEmprestimos().iterator();
		while(itr.hasNext()){
			Emprestimo emp = (Emprestimo)itr.next();
			System.out.println(emp);
		}
	}
	
	public void verificarMulta() throws ElementoNaoExisteException, ValidadeEmprestimoException{
		Long cpf;
		System.out.println("Digite o cpf do usuario: ");
		cpf = sc.nextLong();
		
		fachada.verificarEmprestimo(cpf);
	}
	
	public void pagarMulta() throws ElementoNaoExisteException{
		
		Long cpf;
		Double valor;
		
		System.out.println("Digite o cpf do usuario: ");
		cpf = sc.nextLong();
		System.out.println("Digite o valor fornecido: ");
		valor = sc.nextDouble();
		
		fachada.pagarMulta(cpf, valor);
	}
	
}
