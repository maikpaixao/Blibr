package br.ufrpe.blibr.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaMultaController {
	
	
	public void showTelaMultaPagamento(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaMultaPagamento.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void voltarPainelFuncionario(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaPainelFuncionario.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
		win.setScene(scene2);
		win.show();
	}
}
