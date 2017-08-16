package br.ufrpe.blibr.gui;

import java.io.IOException;

import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.exception.ValidadeEmprestimoException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaMultaController {
	
	Fachada f = Fachada.getInstance();
	ObservableList<Emprestimo> cbList2 = FXCollections.observableArrayList();
	
	@FXML
	private TextField nomeUsuario;
	@FXML
	private TextField cpfPg;
	@FXML
	private TextField valorPg;
	
	@FXML
	private TableView<Emprestimo> multaTable;
	@FXML
	private TableColumn<Emprestimo, Usuario> usuarioColuna;
	@FXML
	private TableColumn<Emprestimo, Livro> livroColuna;
	@FXML
	private TableColumn<Emprestimo, Multa> multaColuna;
	
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
	
	public void verificarMulta() throws ElementoNaoExisteException, ValidadeEmprestimoException{
		Long cpf = Long.parseLong(nomeUsuario.getText().toString());
		if(cpf!=null){
			f.verificarEmprestimo(cpf);
			cbList2.add(f.buscarEmprestimo(cpf));
			if(multaTable!=null){
				usuarioColuna.setCellValueFactory(new PropertyValueFactory<>("usuario"));
				livroColuna.setCellValueFactory(new PropertyValueFactory<>("livro"));
				multaColuna.setCellValueFactory(new PropertyValueFactory<>("multa"));
				multaTable.setItems(cbList2);
			}
		}else{
			Alert alert = new Alert(AlertType.INFORMATION, "Campo nullo!");
			alert.show();
		}
	}
	
	public void pagarMulta() throws ElementoNaoExisteException{
		Long cpf = Long.parseLong(cpfPg.getText().toString());
		Double valor = Double.parseDouble(valorPg.getText().toString());
		f.pagarMulta(cpf, valor);
	}
}
