package br.ufrpe.blibr;
import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.gui.TextualUserInterface;

public class Main{
	
	public static void main(String[] args) {
        TextualUserInterface textUI = new TextualUserInterface();
        textUI.showInterface();
    }
}
