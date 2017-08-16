package br.ufrpe.blibr.gui;

import java.io.IOException;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.ControladorFuncionario;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Funcionario;
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
	
	private ControladorFuncionario cF = ControladorFuncionario.getInstance();
	private Fachada f = Fachada.getInstance();
	public static Funcionario funcionario;
	TextualUserInterface t = new TextualUserInterface();
	
	@FXML
	private TextField user;
	@FXML
	private TextField pass;
	
	@FXML
	public void showPainelF(ActionEvent event) throws Exception{
		Long login = Long.parseLong(user.getText());
		
		if(login==12 && pass.getText().equals("123")){
			funcionario = f.buscarFuncionario(login);
			//System.out.println(f.buscarFuncionario(login).getNome());
			
			Parent t2 = FXMLLoader.load(getClass().getResource("TelaPainelFuncionario.fxml"));
			Scene scene2 = new Scene(t2);
			Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
			win.setScene(scene2);
			win.show();
		}else if(login==11 && pass.getText().equals("123")){
			//cF.buscarFuncionario(login).getCodFuncionario(
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
	
	//Vai funcionar para pegar o currentLoing do funcionario logado e setar no emprestimo
//	public Funcionario getFuncionaio(Long cpf) throws ElementoNaoExisteException{
//		return cF.buscarFuncionario(cpf);
//	}
}
