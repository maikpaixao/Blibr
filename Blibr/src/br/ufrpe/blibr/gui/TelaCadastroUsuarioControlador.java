package br.ufrpe.blibr.gui;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class TelaCadastroUsuarioControlador {
	
	ObservableList<String> cbList = FXCollections.observableArrayList("Masculino","Feminino");
	
	private IRepositorio<Usuario> repo;
	@FXML
	private TextField nomeUsuario;
	@FXML
	private TextField cpfUsuario;
	@FXML
	private ComboBox sexoUsuario;
	@FXML
	private DatePicker nascimentoUsuario;
	
	public void initialize(){
		sexoUsuario.setItems(cbList);
		repo = new RepositorioGenerico<>("");
	}
	
	public void cadastrarUsuario() throws ElementoJaExisteException, ElementoNaoExisteException{
		Usuario usuario = new Usuario();
		
		usuario.setNome(nomeUsuario.getText());
		usuario.setCpf(Long.parseLong(cpfUsuario.getText()));
		usuario.setSexo(sexoUsuario.getSelectionModel().getSelectedItem().toString());
		usuario.setDataNascimento(nascimentoUsuario.getValue());
		repo.adicionar(usuario);
		System.out.println(repo.listar());
		Alert alert = new Alert(AlertType.INFORMATION, "Usuário Cadastrado!");
		alert.show();
	}
	
	
}
