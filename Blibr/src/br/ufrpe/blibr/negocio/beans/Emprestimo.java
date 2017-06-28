package br.ufrpe.blibr.negocio.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Emprestimo {
	
	Usuario usuario = new Usuario();
	static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	static Calendar cal = Calendar.getInstance();
	
	Emprestimo(){
		
	}
	
}
