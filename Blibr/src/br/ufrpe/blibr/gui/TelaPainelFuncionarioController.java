package br.ufrpe.blibr.gui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Multa;
import br.ufrpe.blibr.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaPainelFuncionarioController {
	
	Fachada f = Fachada.getInstance();
	ObservableList<Emprestimo> cbList2 = FXCollections.observableArrayList();
	
	@FXML
	private Parent root;
	
	@FXML
	private TableView<Emprestimo> emprestimoTable;
	@FXML
	private TableColumn<Emprestimo, Livro> nomeLivro;
	@FXML
	private TableColumn<Emprestimo, Usuario> nomeUsuario;
	@FXML
	private TableColumn<Emprestimo, LocalDate> dataEmp;
	@FXML
	private TableColumn<Emprestimo, LocalDate> dataDev;
	@FXML
	private TableColumn<Emprestimo, Multa> multa;
	
	
	public void initialize() {
		Iterator<Emprestimo> itr = f.listarEmprestimos().iterator();
		while(itr.hasNext()){
			Emprestimo fun = (Emprestimo)itr.next();
			cbList2.add(fun);
		}
		
		if(emprestimoTable!=null){
			nomeLivro.setCellValueFactory(new PropertyValueFactory<>("livro"));
			nomeUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
			dataEmp.setCellValueFactory(new PropertyValueFactory<>("dataEmprestimo"));
			dataDev.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
			multa.setCellValueFactory(new PropertyValueFactory<>("multa"));
			emprestimoTable.setItems(cbList2);
		}
	}
	
	public void showTelaEmprestimo(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaEmprestimo.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
		win.setScene(scene2);
		win.show();
	}
	
	public void showTelaDevolucao(ActionEvent event) throws IOException{
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaDevolucao.fxml"));
		Scene scene2 = new Scene(t2);
		Stage win = new Stage();
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
	
	public void sair(ActionEvent event) throws IOException{
		Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
		win.close();
	
		Parent t2 = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Scene scene2 = new Scene(t2);
		Stage st = new Stage();
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
