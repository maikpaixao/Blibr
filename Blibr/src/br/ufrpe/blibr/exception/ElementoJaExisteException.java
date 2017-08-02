package br.ufrpe.blibr.exception;

public class ElementoJaExisteException extends Exception{
	private Object obj;
    
    public ElementoJaExisteException(Object obj) {
        super("Objeto ja esta cadastrado no repositorio e nao pode ser "
                + "adicionado novamente");
        this.obj = obj;        
    }
    
    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}