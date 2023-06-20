package analise;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	private long numero;
	private Date data;
	private double valorTotal;
	private ArrayList<ItensDePedido> itens;
	private FormaDePagamento pagamento;
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public boolean calcularTotal() {
		
		return calcularTotal();
	}
	
	public String finalizarPedido() {
		
		return finalizarPedido();
	}
	
	
}
