package br.ufrpe.blibr.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Tela extends Application {
	private BorderPane mainLayout;
	private BorderPane mainPainelF;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Biblr");
		showTelaView();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void showTelaView() throws IOException{
		Parent t = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Scene scene = new Scene(t);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}