package br.ufrpe.blibr.gui;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.ControladorFuncionario;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Xcu {
ObservableList<String> cbList = FXCollections.observableArrayList("Masculino","Feminino");
ObservableList<Funcionario> cbList2 = FXCollections.observableArrayList();
	Fachada f = Fachada.getInstance();
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
	
	@FXML
	private TextField atualizarNome;
	@FXML
	private TextField atualizarCpf;
	@FXML
	private ComboBox atualizarSexo;
	@FXML
	private DatePicker atualizarData;
	@FXML
	private TextField buscaUsuariaoCpf;
	
	
	public void initialize(){
//		if(repo.listar()!=null){
//		nomeColuna.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("nome"));
//		cpfColuna.setCellValueFactory(new PropertyValueFactory<Funcionario,Long>("cpf"));
//		sexoColuna.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("sexo"));
//		idadeColuna.setCellValueFactory(new PropertyValueFactory<Funcionario,Date>("dataNascimento"));
//		funcionarioTable.setItems((ObservableList<Funcionario>) repo.listar());
//		funcionarioTable.getColumns().addAll(nomeColuna,cpfColuna,sexoColuna,idadeColuna);
//		}
		//funcionarioTable.setItems(data);
		
		Iterator<Funcionario> itr = f.listarFuncionario().iterator();
		while(itr.hasNext()){
			Funcionario fun = (Funcionario)itr.next();
			cbList2.add(fun);
		}
		
		if(funcionarioTable!=null){
			nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
			cpfColuna.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			sexoColuna.setCellValueFactory(new PropertyValueFactory<>("sexo"));
			idadeColuna.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
			funcionarioTable.setItems(cbList2);
		}

		if(sexoUsuario!=null){
			sexoUsuario.setItems(cbList);
		}
	}
	
	public void cadastrarFuncionario(ActionEvent event) throws Exception{
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(nomeUsuario.getText());
		funcionario.setCpf(Long.parseLong(cpfUsuario.getText()));
		funcionario.setSexo(sexoUsuario.getSelectionModel().getSelectedItem().toString());
		funcionario.setDataNascimento(nascimentoUsuario.getValue());
		funcionario.setSenha(senhaUsuario.getText());
		f.adicionarFuncionario(funcionario);
		Alert alert = new Alert(AlertType.INFORMATION, "Usuário Cadastrado!");
		alert.show();
	}
	
	public void editarFuncionario() throws ElementoNaoExisteException{

		atualizarSexo.setItems(cbList);
		Long cpf = Long.parseLong(buscaUsuariaoCpf.getText());
		atualizarNome.setText(buscarFuncionario(cpf).getNome());
		atualizarData.setValue(buscarFuncionario(cpf).getDataNascimento());
		atualizarSexo.getSelectionModel().select(buscarFuncionario(cpf).getSexo());
	}
	
	public Funcionario buscarFuncionario(Long cpf) throws ElementoNaoExisteException{
		return cF.buscarFuncionario(cpf);
	}
	
	public void remove() throws ElementoNaoExisteException, IOException{
		cF.removerUsuario(funcionarioTable.getSelectionModel().getSelectedItem().getCpf());
	
		Alert alert = new Alert(AlertType.WARNING, "Usuário Removido!");
		alert.show();
		funcionarioTable.setItems(null);
		funcionarioTable.layout();
		funcionarioTable.setItems(FXCollections.observableList(cbList2));
		
	}
}