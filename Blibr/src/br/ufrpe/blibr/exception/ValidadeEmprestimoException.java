package br.ufrpe.blibr.exception;

public class ValidadeEmprestimoException extends Exception{
	Object obj;
	public ValidadeEmprestimoException(Object obj){
		super("O prazo para devolu��o ainda n�o venceu! ");
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
