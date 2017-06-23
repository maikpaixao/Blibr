package br.ufrpe.blibr.gui;

import java.util.Scanner;

import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class TextualUserInterface {
	
	private Fachada fachada;
	private Livro livro;
	private Usuario usuario;
	private int opcao;
	
	public void showInterface(){
		
		System.out.println("==========Menu========");
		System.out.println("1 - Menu Livro");
		System.out.println("2 - Menu Usuario");
		System.out.println("3 - Emprestar Livro");
		System.out.println("======================");
		
		switch (opcao) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
			break;
		}
	}
	
	public void menuLivro(){
		
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("1-Cadastrar Livro");
		System.out.println("2-Listar Livro");
		System.out.println("3-Editar Livro");
		System.out.println("4-Remover Livro");
		
		System.out.println("Digite a opcao desejada: ");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
			break;
		}
	}
	
	public void menuUsuario(){
		Scanner sc = new Scanner(System.in);

		System.out.println("1-Cadastrar Usuario");
		System.out.println("2-Listar Usuario");
		System.out.println("3-Editar Usuario");
		System.out.println("4-Remover Usuario");
		
		System.out.println("Digite a opcao desejada: ");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
			break;
		}
	}
	
	public void emprestarLivro(){
		
	}
	
}
