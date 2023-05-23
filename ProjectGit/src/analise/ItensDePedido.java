package analise;

public class ItensDePedido {
	private int quantidade;
	private Produto produto;

	public boolean incrementaQtde() {
		
		System.out.println("\nQuantidade: " + quantidade);
		System.out.println("\nNova quantidade: " + quantidade++);
		
		return incrementaQtde();
	
	}
	
	public boolean decrementaQtde() {
		
		System.out.println("\nQuantiade: " + quantidade);
		System.out.println("\nNova quantidade: " + quantidade--);
		
		return decrementaQtde();
		
	}
	
	public double calcularSubTotal() {
		double subtotal;
		
		subtotal =  + 	this.produto;
		
		return subtotal;
	}
}
