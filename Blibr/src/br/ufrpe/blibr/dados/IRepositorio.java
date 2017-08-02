package br.ufrpe.blibr.dados;

import java.util.List;

import br.ufrpe.blibr.exception.ElementoJaExisteException;
import br.ufrpe.blibr.exception.ElementoNaoExisteException;

public interface IRepositorio<T>{
	void adicionar(T entidade) throws ElementoJaExisteException, ElementoNaoExisteException;
    List<T> listar();
    void atualizar(T entidade) throws ElementoNaoExisteException;
    void remover(T entidade) throws ElementoNaoExisteException;
}