package analise;

import java.util.Iterator;

public class ItensDePedido {
	private int quantidade;
	private Produto produto;
	
	public ItensDePedido (int quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public boolean incrementaQtde() {
		
		quantidade ++;
		System.out.println("\nNova quantidade: " + quantidade);
		
		return true;	
	}
	
	public boolean decrementaQtde() {

		quantidade--;
		System.out.println("\nNova quantiade: " + quantidade);

		return true;		
	}
	
	public double calcularSubTotal() {
		double subtotal = 0.0;
		
		subtotal = produto.getValor();
		subtotal *= quantidade;
		
		return subtotal;
	}
}
