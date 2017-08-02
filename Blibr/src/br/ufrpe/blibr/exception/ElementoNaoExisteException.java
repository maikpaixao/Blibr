package br.ufrpe.blibr.exception;

public class ElementoNaoExisteException extends Exception{
	Object obj;
	public ElementoNaoExisteException(Object obj){
		super("Objeto nao existe no repositorio!");
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
