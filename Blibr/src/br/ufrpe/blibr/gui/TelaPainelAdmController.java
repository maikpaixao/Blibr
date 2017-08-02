package br.ufrpe.blibr.gui;

import java.io.IOException;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class TelaPainelAdmController {
	
	@FXML
	private MenuBar menuBar;
	
	public void showTelaCadastroFuncionario(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaCadastroFuncionario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaAtualzarFuncionario(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaAtualizarFuncionario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaRemoverFuncionario(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaRemoverFuncionario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void sair(ActionEvent event) throws IOException, ElementoNaoExisteException{
		Stage win = (Stage)menuBar.getScene().getWindow();
		win.close();
		
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Scene scene2 = new Scene(t2);
		win.setScene(scene2);
		win.show();
	}
}
