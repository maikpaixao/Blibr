package br.ufrpe.blibr.gui;

import java.time.LocalDate;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

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
	
	public void emprestarLivro(ActionEvent event) throws ElementoNaoExisteException, ElementoJaExisteException{
		
		Emprestimo emprestimo = new Emprestimo();
		String livro1 = nomeLivro.getText().toString();
		Long cpf = Long.parseLong(cpfUsuario.getText().toString());
		LocalDate date = LocalDate.now();
		
		emprestimo.setLivro(f.buscarLivro(livro1));
		emprestimo.setUsuario(f.buscarUsuario(cpf));
		emprestimo.setFuncionario(TelaLoginController.funcionario);
		emprestimo.setDataEmprestimo(date);
		emprestimo.setDataDevolucao(date.plusDays(1));
		f.registrarEmprestimo(emprestimo);
		
		Alert alert = new Alert(AlertType.WARNING, "Emprestimo realizado com sucesso!");
		alert.show();

		Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
		win.close();
		
	}
	
	public void realizarDevolucao(ActionEvent event) throws ElementoNaoExisteException{
		
		Emprestimo emprestimo = new Emprestimo();
		
		String livro1 = livroDev.getText();
		Long cpf = Long.parseLong(cpfDev.getText().toString());
		
		emprestimo.setLivro(f.buscarLivro(livro1));
		emprestimo.setUsuario(f.buscarUsuario(cpf));
		f.realizarDevolução(emprestimo);
		
		Alert alert = new Alert(AlertType.WARNING, "Devolução realizado com sucesso!");
		alert.show();
		
		Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
		win.close();
	}
}