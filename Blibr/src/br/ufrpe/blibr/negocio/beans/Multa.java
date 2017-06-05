package br.ufrpe.blibr.negocio.beans;

public class Multa {
	private double pagamento;
	private double divida;
	private double troco;
	
	public Multa(double pagamento, double divida){
		this.pagamento = pagamento;
		this.divida = divida;
	}
	
	public double getPagamento(){
		return pagamento;
	}
	
	public void setPagamento(double pagamento){
		this.pagamento = pagamento;
	}
	
	public double getDivida(){
		return divida;
	}
	
	public void setDivida(double divida){
		this.divida = divida;
	}
	
	public double getTroco(){
		return troco;
	}
	
	public void setTroco(double troco){
		this.troco = troco;
	}
}
