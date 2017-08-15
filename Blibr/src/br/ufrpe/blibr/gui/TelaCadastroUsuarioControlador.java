package br.ufrpe.blibr.gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class TelaCadastroUsuarioControlador {
	
	Fachada f = Fachada.getInstance();
	TextualUserInterface in = new TextualUserInterface();
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
	}
	
	public void cadastrarUsuario() throws ElementoJaExisteException, ElementoNaoExisteException, IOException{
		Usuario usuario = new Usuario();
		
		String nome = nomeUsuario.getText().toString();
		Long cpf = Long.parseLong(cpfUsuario.getText().toString());
		String sexo = sexoUsuario.getSelectionModel().getSelectedItem().toString();
		LocalDate date = nascimentoUsuario.getValue();
		
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setSexo(sexo);
		usuario.setDataNascimento(date);
		f.adicionarUsuario(usuario);
		//in.listarUsuario();
		Alert alert = new Alert(AlertType.INFORMATION, "Usuário Cadastrado!");
		alert.show();
	}
}
