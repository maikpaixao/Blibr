package br.ufrpe.blibr.dados;

import java.util.ArrayList;

import br.ufrpe.blibr.exception.ElementoNaoExistente;
import br.ufrpe.blibr.negocio.beans.Multa;

public class RepositorioMulta {
	RepositorioUsuario repoUsuario = RepositorioUsuario.getInstance();
	private ArrayList<Multa> listaMulta = new ArrayList<Multa>();
	
	public void atribuirMulta(Long cpf) throws ElementoNaoExistente{
		Multa multa = new Multa();
		multa.setUsuario(repoUsuario.buscarUsuario(cpf));
		multa.setDivida(50.00);
	}
	
	public void pagarMulta(Long cpf, Double valor)throws ElementoNaoExistente{
		try {
			for(Multa m: listaMulta){
				if(m.getUsuario().getCpf().equals(cpf) && valor>m.getDivida()){
					listaMulta.remove(m);
					break;
				}else{
					throw new ElementoNaoExistente(m);
				}
			}
		} catch (ElementoNaoExistente e) {
			e.getObj();
		}
	}
}
