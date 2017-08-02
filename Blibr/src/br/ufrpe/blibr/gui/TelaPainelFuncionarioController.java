package br.ufrpe.blibr.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class TelaPainelFuncionarioController {
	
	@FXML
	private Parent root;
	
	public void showTelaEmprestimo(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaPainelFuncionario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaDevolucao(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaPainelFuncionario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaMulta(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaMulta.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaCadastroUsuario(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaCadastroUsuario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaAtualizarUsuario(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaAtualizarUsuario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaRemoverUsuario(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaRemoverUsuario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaCadastroLivro(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaCadastroLivro.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaAtualizarLivro(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaAtualizarLivro.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaRemoverLivro(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaRemoverLivro.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void sair(ActionEvent event){
		
	}
}
