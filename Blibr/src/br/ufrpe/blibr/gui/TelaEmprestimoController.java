package br.ufrpe.blibr.gui;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TelaEmprestimoController {
	
	Fachada f = Fachada.getInstance();
	
	@FXML
	private TextField nomeLivro;
	@FXML
	private TextField cpfUsuario;
	@FXML
	private TextField cpfDev;
	@FXML
	private TextField livroDev;
	
	public void emprestarLivro() throws ElementoNaoExisteException, ElementoJaExisteException{
		
		Emprestimo emprestimo = new Emprestimo();
		String livro1 = nomeLivro.getText().toString();
		Long cpf = Long.parseLong(cpfUsuario.getText().toString());
		
		emprestimo.setLivro(f.buscarLivro(livro1));
		emprestimo.setUsuario(f.buscarUsuario(cpf));
		emprestimo.setFuncionario(TelaLoginController.funcionario);
		f.registrarEmprestimo(emprestimo);
		
		Alert alert = new Alert(AlertType.WARNING, "Emprestimo realizado com sucesso!");
		alert.show();
		
		System.out.println(TelaLoginController.funcionario.getNome());
		
	}
	
	public void realizarDevolucao() throws ElementoNaoExisteException{
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setUsuario(f.buscarUsuario(Long.parseLong(cpfDev.getText().toString())));
		emprestimo.setLivro(f.buscarLivro(livroDev.getText().toString()));
		f.realizarDevolução(emprestimo);
		
		Alert alert = new Alert(AlertType.WARNING, "Devolução realizada com sucesso!");
		alert.show();
	}
	
}