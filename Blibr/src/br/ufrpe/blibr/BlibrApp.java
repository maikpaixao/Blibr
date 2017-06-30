package br.ufrpe.blibr;

import java.text.ParseException;

import br.ufrpe.blibr.exception.UsuarioNaoExistente;
import br.ufrpe.blibr.gui.TextualUserInterface;

public class BlibrApp {
	
	public static void main(String[] args) throws UsuarioNaoExistente, ParseException {
        TextualUserInterface textUI = new TextualUserInterface();
        textUI.showInterface();
    }
}
