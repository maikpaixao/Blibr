package br.ufrpe.blibr.gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

import br.ufrpe.blibr.dados.IRepositorio;
import br.ufrpe.blibr.dados.RepositorioGenerico;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Funcionario;
import br.ufrpe.blibr.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaCadastroUsuarioControlador {
	
	Fachada f = Fachada.getInstance();
	TextualUserInterface in = new TextualUserInterface();
	ObservableList<String> cbList = FXCollections.observableArrayList("Masculino","Feminino");
	ObservableList<Usuario> cbList2 = FXCollections.observableArrayList();
	
	private IRepositorio<Usuario> repo;
	@FXML
	private TextField nomeUsuario;
	@FXML
	private TextField cpfUsuario;
	@FXML
	private ComboBox sexoUsuario;
	@FXML
	private DatePicker nascimentoUsuario;
	
	@FXML
	private TextField buscaCpf;
	@FXML
	private TextField atualizarNome;
	@FXML
	private ComboBox atualizarSexo;
	@FXML
	private DatePicker atualizarData;
	
	@FXML
	private TableView<Usuario> usuarioTable;
	@FXML
	private TableColumn<Usuario, String> nomeColuna;
	@FXML
	private TableColumn<Usuario, Long> cpfColuna;
	@FXML
	private TableColumn<Usuario, String> sexoColuna;
	@FXML
	private TableColumn<Usuario, Date> idadeColuna;
	
	public void initialize(){
		
		Iterator<Usuario> itr = f.listarUsuario().iterator();
		while(itr.hasNext()){
			Usuario fun = (Usuario)itr.next();
			cbList2.add(fun);
		}
		
		if(usuarioTable!=null){
			nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
			cpfColuna.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			sexoColuna.setCellValueFactory(new PropertyValueFactory<>("sexo"));
			idadeColuna.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
			usuarioTable.setItems(cbList2);
		}
		
		if(atualizarSexo!=null){
			atualizarSexo.setItems(cbList);
		}
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
		in.listarUsuario();
		Alert alert = new Alert(AlertType.INFORMATION, "Usuário Cadastrado!");
		alert.show();
	}
	
	public void atualzarUsuario() throws ElementoNaoExisteException{

		Long cpf = Long.parseLong(buscaCpf.getText());
		atualizarNome.setText(buscarUsuario(cpf).getNome());
		atualizarData.setValue(buscarUsuario(cpf).getDataNascimento());
		atualizarSexo.getSelectionModel().select(buscarUsuario(cpf).getSexo());
	}
	
	public Usuario buscarUsuario(Long cpf) throws ElementoNaoExisteException{
		return f.buscarUsuario(cpf);
	}
	
	public void removerUsuario() throws ElementoNaoExisteException, IOException{
		f.removerUsuario(usuarioTable.getSelectionModel().getSelectedItem().getCpf());
	
		Alert alert = new Alert(AlertType.WARNING, "Usuário Removido!");
		alert.show();
		usuarioTable.setItems(null);
		usuarioTable.layout();
		usuarioTable.setItems(FXCollections.observableList(cbList2));
		
	}
}
