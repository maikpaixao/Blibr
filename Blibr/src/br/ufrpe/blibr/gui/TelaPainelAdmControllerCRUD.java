package br.ufrpe.blibr.gui;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.ControladorFuncionario;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Usuario;
import javafx.collections.FXCollections;
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

public class TelaPainelAdmControllerCRUD {
	
	private Fachada fachada = Fachada.getInstance();
	Funcionario funcionario;
	
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
	
	ObservableList<Funcionario> cbList = FXCollections.observableArrayList();
	
	public void initialize() throws Exception{
		
		Iterator<Funcionario> itr = fachada.listarFuncionario().iterator();
		while(itr.hasNext()){
			Funcionario fun = (Funcionario)itr.next();
			cbList.add(fun);
		}
		
		nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfColuna.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		sexoColuna.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		idadeColuna.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
		funcionarioTable.setItems(cbList);
	}
	
	public void cadastrarFuncionario(ActionEvent event) throws Exception{
		
		String nome = nomeUsuario.getText().toString();
		Long cpf = Long.parseLong(cpfUsuario.getText().toString());
		String sexo = sexoUsuario.getSelectionModel().getSelectedItem().toString();
		
		funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSexo(sexo);
		funcionario.setDataNascimento(nascimentoUsuario.getValue());
		//funcionario.setSenha(senhaUsuario.getText());
		fachada.adicionarFuncionario(funcionario);
		
		Alert alert = new Alert(AlertType.INFORMATION, "Funcionario Cadastrado!");
		alert.show();
	}
}
