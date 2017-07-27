package br.ufrpe.blibr.negocio;

import br.ufrpe.blibr.exception.ObjetoInvalidoExcpetion;
import br.ufrpe.blibr.negocio.beans.Emprestimo;
import br.ufrpe.blibr.negocio.beans.Livro;
import br.ufrpe.blibr.negocio.beans.Reserva;
import br.ufrpe.blibr.negocio.beans.Usuario;

public class ControladorReserva {
	
	private static ControladorReserva instance;
	
	public static synchronized ControladorReserva getInstance(){
		if(instance==null){
			instance = new ControladorReserva();
		}
		return instance;
	}
	
	public void reservarLivro(Usuario usuario, Livro livro){
		try {
			if(usuario!=null & livro!=null){
				Reserva reserva = new Reserva();
				reserva.setUsuario(usuario);
				reserva.setLivro(livro);
			}else{
				throw new ObjetoInvalidoExcpetion("Os objetos destinados para a reserva são inválidos!");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
