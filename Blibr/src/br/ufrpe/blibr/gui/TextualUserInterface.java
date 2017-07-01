package br.ufrpe.blibr.gui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import br.ufrpe.blibr.negocio.Fachada;
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
	
	public void showInterface() throws ParseException{
		    
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
	
	public void menuLivro(){
		
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
	
	public void menuUsuario(){
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
	
	public void menuEmprestimo() throws ParseException{
		System.out.println("1 - Emprestar Livro");
		System.out.println("2 - Livros Emprestados");
		
		System.out.println("Digite a opcao desejada: \n");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			emprestarLivro();
			break;
		case 2:
			listarEmprestimos();
			//listarLivrosEmprestados();
			break;
		default:
			break;
		}
	}
	
	public void menuMulta(){
		
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
	
	public void emprestarLivro() throws ParseException{
		String nomeLivro;
		String cpfUsuario;
		int codigoFuncionario;
		
		livro = new Livro();
		usuario = new Usuario();
		emprestimo = new Emprestimo();
		funcionario = new Funcionario();
		
		System.out.println("Digite o seu código como funcionario: ");//Funcionario preenchido pelo método preencherFuncionario()
		codigoFuncionario = sc.nextInt();
		funcionario = fachada.buscarFuncionario(codigoFuncionario);
		emprestimo.setFuncionario(funcionario);
		
		System.out.println("Digite o nome do livro a ser emprestado: ");
		nomeLivro = sc.next();
		livro = fachada.buscarLivro(nomeLivro);
		
		System.out.println("Digite o CPF do usuario a emprestar o livro: ");
		cpfUsuario=sc.next();
		usuario = fachada.buscarUsuario(cpfUsuario);
		emprestimo.setUsuario(usuario);
		
		fachada.registrarEmprestimo(emprestimo);
		fachada.emprestarLivro(livro, usuario);
	}
	
	public void adicionarUsuario(){
		
		String nome;
		String cpf;
		String sexo;
		String idade;
		
		System.out.println("Digite o nome do usuario: ");
		nome = sc.next();
		System.out.println("Digite o CPF do usuario: ");
		cpf = sc.next();
		System.out.println("Digite o sexo do usuario: ");
		sexo = sc.next();
		System.out.println("Digite o idade do usuario: ");
		idade = sc.next();
		
		usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setIdade(sexo);
		usuario.setSexo(idade);
		fachada.adicionarUsuario(usuario);
	
	}
	
	public void listarUsuario(){
		Iterator itr = fachada.listarUsuario().iterator();
		while(itr.hasNext()){
			Usuario usu = (Usuario)itr.next();
			System.out.println(usu);
		}
	}
	
	public void editarUsuario(){
		
		String nome;
		String cpf;
		String sexo;
		String idade;
		
		System.out.println("Digite o nome do usuario: ");
		nome = sc.next();
		
		System.out.println("=============================");
		System.out.println("Digite novo CPF do usuario: ");
		cpf = sc.next();
		System.out.println("Digite novo sexo do usuario: ");
		sexo = sc.next();
		System.out.println("Digite nova idade do usuario: ");
		idade = sc.next();
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setIdade(idade);
		usuario.setSexo(sexo);
		usuario.setCpf(cpf);
		fachada.editarUsario(usuario);
		
	}
	
	public void removerUsuario(){
		String cpf;
		System.out.println("Digite o cpf do usuario: ");
		cpf = sc.next();
		
		fachada.removerUsuario(cpf);
	}
	
	//==========================Livro==============================
	
	public void adicionarLivro(){
		
		int codigoLivro;
		String nomeLivro;
		String autorLivro;
		String editora;
		
		System.out.println("Digite o nome do livro: ");
		nomeLivro = sc.next();
		System.out.println("Digite o autor do livro: ");
		autorLivro = sc.next();
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
	
	public void editarLivro(){
		
		String nomeLivro;
		String autorLivro;
		String editora;
		int quantidadeLivro;
		
		System.out.println("Digite o nome do Livro: ");
		nomeLivro = sc.next();
		
		System.out.println("=============================");
		System.out.println("Digite novo autor do Livro: ");
		autorLivro = sc.next();
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
	
	public void removerLivro(){
		String nome;
		System.out.println("Digite o nome do livro: ");
		nome = sc.next();
		
		fachada.removerLivro(nome);
	}
	
	public void preencherFuncionario(){
		
		funcionario = new Funcionario();
		
		funcionario.setCodFuncionario(11);
		funcionario.setNome("Joao");
		funcionario.setCpf("00011100055");
		funcionario.setSexo("masculino");
		funcionario.setIdade("50");
		
		fachada.adicionarFuncionario(funcionario);
	
	}
	
	public void listarEmprestimos(){
		Iterator itr = fachada.listarEmprestimos().iterator();
		while(itr.hasNext()){
			Emprestimo emp = (Emprestimo)itr.next();
			System.out.println(emp);
		}
	}
	
	public void verificarMulta(){
		String cpf;
		System.out.println("Digite o cpf do usuario: ");
		cpf = sc.next();
		
		fachada.verificarEmprestimo(cpf);
	}
	
	public void pagarMulta(){
		
		String cpf;
		Double valor;
		
		System.out.println("Digite o cpf do usuario: ");
		cpf = sc.next();
		System.out.println("Digite o valor fornecido: ");
		valor = sc.nextDouble();
		
		fachada.pagarMulta(cpf, valor);
	}
	
}
