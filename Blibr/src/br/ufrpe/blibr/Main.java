package br.ufrpe.blibr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Stage primaryStage;
	private BorderPane mainLayout;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Biblioteca");
		showMain();
	}
	
	public void showMain() throws Exception{
		
		Pane root = FXMLLoader.load(getClass().getResource("/main/Gui.fxml"));
		Scene scene = new Scene(root, 1280, 720);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
