package br.ufrpe.blibr.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;

public abstract class RepositorioGenerico<T> implements IRepositorio<T>{
	
	protected List<T> lista;
	
	public RepositorioGenerico(){
		this.lista = new ArrayList<>();
	}

	public void adicionar(T entidade)throws ElementoJaExisteException{
		try {
			if(!this.lista.contains(entidade)){
				this.lista.add(entidade);
			}else{
				throw new ElementoJaExisteException(entidade);
			}
		} catch (ElementoJaExisteException e) {
			e.getObj();
		}
	}
	
	public List<T> listar(){
		return Collections.unmodifiableList(lista);
	}
	
	public void atualizar(T entidade)throws ElementoNaoExisteException{
		try {
			if(this.lista.contains(entidade)){
				int indice = this.lista.indexOf(entidade);
				this.lista.set(indice, entidade);
			}else{
				throw new ElementoNaoExisteException(entidade);
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
	
	public void remover(T entidade)throws ElementoNaoExisteException{
		try {
			if(this.lista.contains(entidade)){
				this.lista.remove(this.lista.indexOf(entidade));
			}else{
				throw new ElementoNaoExisteException(entidade);
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
}
