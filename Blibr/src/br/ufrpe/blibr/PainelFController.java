package br.ufrpe.blibr;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PainelFController {
	
	@FXML
	public void showPainelF(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("PainelF.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
		win.setScene(scene2);
		win.show();
	}
}
