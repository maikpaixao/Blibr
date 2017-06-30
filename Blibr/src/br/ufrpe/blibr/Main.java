package br.ufrpe.blibr;
import java.text.ParseException;

import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.gui.TextualUserInterface;

public class Main{
	
	public static void main(String[] args) throws ParseException {
        TextualUserInterface textUI = new TextualUserInterface();
        textUI.showInterface();
    }
}
