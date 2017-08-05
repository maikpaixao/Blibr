package br.ufrpe.blibr.gui;

import java.io.IOException;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginController {
	
	@FXML
	private TextField user;
	@FXML
	private TextField pass;

	@FXML
	public void showPainelF(ActionEvent event) throws IOException, ElementoNaoExisteException{
		if(user.getText().equals("funcionario") && pass.getText().equals("123")){
			Parent t2 = FXMLLoader.load(getClass().getResource("TelaPainelFuncionario.fxml"));
			Scene scene2 = new Scene(t2);
			Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
			win.setScene(scene2);
			win.show();
		}else if(user.getText().equals("adm") && pass.getText().equals("123")){
			Parent t2 = FXMLLoader.load(getClass().getResource("TelaPainelAdm.fxml"));
			Scene scene2 = new Scene(t2);
			Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
			win.setScene(scene2);
			win.show();
		}else{
			Alert alert = new Alert(AlertType.ERROR, "Login ou senha errado");
			alert.show();
		}
	}
}
