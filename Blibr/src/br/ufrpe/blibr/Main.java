package br.ufrpe.blibr;
import java.text.ParseException;

import br.ufrpe.blibr.exception.ElementoNaoExistente;
import br.ufrpe.blibr.gui.TextualUserInterface;

public class Main{
	
	public static void main(String[] args) throws Exception {
        TextualUserInterface textUI = new TextualUserInterface();
        textUI.showInterface();
    }
}
