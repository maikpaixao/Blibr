package br.ufrpe.blibr.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;

public abstract class RepositorioGenerico<T> implements IRepositorio<T>{
	
	protected List<T> lista = new ArrayList<T>();

	public void adicionar(T entidade)throws ElementoJaExisteException, ElementoNaoExisteException{
		try {
			if(entidade==null || this.lista.contains(entidade)){
				throw new ElementoJaExisteException(entidade);
			}else{
				lista.add(entidade);
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
			if(entidade!=null && this.lista.contains(entidade)){
				for(T obj: lista){
					int indice = this.lista.indexOf(entidade);
					this.lista.set(indice, entidade);
				}
			}else{
				throw new ElementoNaoExisteException(entidade);
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
	
	public void remover(T entidade)throws ElementoNaoExisteException{
		try {
			if(entidade!=null && this.lista.contains(entidade)){
				lista.remove(entidade);
			}else{
				throw new ElementoNaoExisteException(entidade);
			}
		} catch (ElementoNaoExisteException e) {
			e.getObj();
		}
	}
}
