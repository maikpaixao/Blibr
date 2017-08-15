package br.ufrpe.blibr.gui;

import java.util.Date;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.ControladorFuncionario;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class Xcl {
	private IRepositorio<Funcionario> repo;
	private ControladorFuncionario cF = ControladorFuncionario.getInstance(); 
	
	@FXML
	private TableView<Funcionario> funcionarioTable;
	@FXML
	private TableColumn<Funcionario, String> nomeColuna;
	@FXML
	private TableColumn<Funcionario, Long> cpfColuna;
	@FXML
	private TableColumn<Funcionario, String> sexoColuna;
	@FXML
	private TableColumn<Funcionario, Date> idadeColuna;
	
	@FXML
	private TextField codFun;
	@FXML
	private TextField nomeUsuario;
	@FXML
	private TextField senhaUsuario;
	@FXML
	private TextField cpfUsuario;
	@FXML
	private ComboBox sexoUsuario;
	@FXML
	private DatePicker nascimentoUsuario;
	
	public void initialize(){
		if(repo.listar()!=null){
		nomeColuna.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("nome"));
		cpfColuna.setCellValueFactory(new PropertyValueFactory<Funcionario,Long>("cpf"));
		sexoColuna.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("sexo"));
		idadeColuna.setCellValueFactory(new PropertyValueFactory<Funcionario,Date>("dataNascimento"));
		funcionarioTable.setItems((ObservableList<Funcionario>) repo.listar());
		funcionarioTable.getColumns().addAll(nomeColuna,cpfColuna,sexoColuna,idadeColuna);
		}
	}
	
	

}
