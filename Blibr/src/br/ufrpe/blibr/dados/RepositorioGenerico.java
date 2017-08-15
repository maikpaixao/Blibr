package br.ufrpe.blibr.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;

public class RepositorioGenerico<T> implements IRepositorio<T>{
	
	protected List<T> lista;
	private String name;
	 
	public RepositorioGenerico(String name){
		this.name = name;
        this.lista = new ArrayList<>();
        
        Object listaElementos = RepositorioArquivo.lerDoArquivo(this.name); 
        if (listaElementos != null && listaElementos instanceof List<?>){
            this.lista = (List<T>) listaElementos;
        }
	}

	public void adicionar(T entidade)throws ElementoJaExisteException{
		try {
			if(!this.lista.contains(entidade)){
				this.lista.add(entidade);
			}else{
				throw new ElementoJaExisteException(entidade);
			}
			RepositorioArquivo.salvarArquivo(this.lista, this.name);
		} catch (ElementoJaExisteException e) {
			e.printStackTrace();
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
		//	RepositorioArquivo.salvarArquivo(lista, this.name);
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(T entidade)throws ElementoNaoExisteException{
		try {
			if(this.lista.contains(entidade)){
				this.lista.remove(this.lista.indexOf(entidade));
			}else{
				throw new ElementoNaoExisteException(entidade);
			}
			//RepositorioArquivo.salvarArquivo(lista, this.name);
		} catch (ElementoNaoExisteException e) {
			e.printStackTrace();
		}
	}
}
