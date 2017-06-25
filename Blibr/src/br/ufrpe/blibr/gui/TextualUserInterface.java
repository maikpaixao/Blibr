package br.ufrpe.blibr.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class TextualUserInterface {
	
	private Fachada fachada = Fachada.getInstance();
	private Livro livro;
	private Usuario usuario;
	private Funcionario funcionario;
	private int opcao;
	
	Scanner sc = new Scanner(System.in);
	
	public void showInterface(){
		
			do{
				System.out.println("==========Menu========");
				System.out.println("1 - Menu Livro");
				System.out.println("2 - Menu Usuario");
				System.out.println("3 - Emprestar Livro");
				System.out.println("4 - Listar Funcionarios");
				System.out.println("======================");
				
				opcao = sc.nextInt();
				
				switch (opcao) {
				case 1:
					menuLivro();
					break;
				case 2:
					menuUsuario();
					break;
				case 3:
					emprestarLivro();
					break;
				case 4:
					preencherFuncionario();
					listarFuncionario();
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
		
		System.out.println("Digite a opcao desejada: ");
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
		
		System.out.println("Digite a opcao desejada: ");
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
	
	public void emprestarLivro(){
		String nome;
		System.out.println("Digite o nome do livro a ser emprestado: ");
		nome = sc.next();
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
			System.out.println("Nome: "+usu.getNome()+" CPF: "+usu.getCpf()+" Idade: "+usu.getIdade()+" Sexo: "+usu.getSexo());
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
			System.out.println("Nome: "+li.getNomeLivro()+"Autor: "+li.getAutorLivro()+"Editora: "+li.getEditora());
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
		funcionario.setNome("Joao");
		funcionario.setCpf("00011100099");
		funcionario.setSexo("masculino");
		funcionario.setIdade("150");
		funcionario.setCodFuncionario(1909);
		fachada.adicionarFuncionario(funcionario);
	
	}
	
	public void listarFuncionario(){
		Iterator itr = fachada.listarFuncionario().iterator();
		while(itr.hasNext()){
			Funcionario func = (Funcionario)itr.next();
			System.out.println("Codigo Funcionario: "+funcionario.getCodFuncionario()+" Nome: "+func.getNome()+" Cpf: "+func.getCpf()+" Idade: "+func.getIdade()+" Sexo: "+func.getSexo());
		}
	}
	
}
