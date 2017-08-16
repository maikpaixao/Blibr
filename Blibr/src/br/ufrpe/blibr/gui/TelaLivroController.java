package br.ufrpe.blibr.gui;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;
import br.ufrpe.blibr.negocio.Fachada;
import br.ufrpe.blibr.negocio.beans.Autor;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaLivroController {
	
	TextualUserInterface in = new TextualUserInterface();
	Fachada f = Fachada.getInstance();
	ObservableList<String> cbList = FXCollections.observableArrayList("10","20");
	ObservableList<Livro> cbList2 = FXCollections.observableArrayList();
	
	@FXML
	private TextField nomeLivro;
	@FXML
	private TextField autorLivro;
	@FXML
	private TextField editoraLivro;
	@FXML
	private ComboBox quantidadeLiv;
	
	@FXML
	private TableView<Livro> livroTable;
	@FXML
	private TableColumn<Livro, String> nomeColuna;
	@FXML
	private TableColumn<Livro, String> autorColuna;
	@FXML
	private TableColumn<Livro, String> editoraColuna;
	@FXML
	private TableColumn<Livro, Integer> quantLivro;
	
	public void initialize(){
		
		Iterator<Livro> itr = f.listarLivros().iterator();
		while(itr.hasNext()){
			Livro fun = (Livro)itr.next();
			cbList2.add(fun);
		}
		
		if(livroTable!=null){
			nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nomeLivro"));
			autorColuna.setCellValueFactory(new PropertyValueFactory<>("nomeAutor"));
			editoraColuna.setCellValueFactory(new PropertyValueFactory<>("editora"));
			quantLivro.setCellValueFactory(new PropertyValueFactory<>("quantidadeLivros"));
			livroTable.setItems(cbList2);
		}
		if(quantidadeLiv!=null){
			quantidadeLiv.setItems(cbList);
		}
	}
	
	public void cadastrarLivro() throws ElementoNaoExisteException, ElementoJaExisteException{
		Livro livro = new Livro();
		
		String nome = nomeLivro.getText().toString();
		String autor = autorLivro.getText().toString();
		String editora = editoraLivro.getText().toString();
		int ql = Integer.parseInt(quantidadeLiv.getSelectionModel().getSelectedItem().toString());
		
		livro.setNomeLivro(nome);
		livro.setAutorLivro(autor);
		livro.setEditora(editora);
		livro.setQuantidadeLivros(ql);
		f.adicionarLivro(livro);
		in.listarLivro();
		
		Alert alert = new Alert(AlertType.INFORMATION, "Livro Cadastrado!");
		alert.show();
	}
	
	public Livro buscarLivro(String nomeLivro) throws ElementoNaoExisteException{
		return f.buscarLivro(nomeLivro);
	}
	
	public void removerLivro(){
		f.removerUsuario(livroTable.getSelectionModel().getSelectedItem().getCodigoLivro());
		
		Alert alert = new Alert(AlertType.WARNING, "Usuário Removido!");
		alert.show();
		livroTable.setItems(null);
		livroTable.layout();
		livroTable.setItems(FXCollections.observableList(cbList2));
	}

}