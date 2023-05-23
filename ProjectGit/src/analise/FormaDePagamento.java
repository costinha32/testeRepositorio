package analise;

public class FormaDePagamento {
	 private String tipo;
	 private String descricao;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	 
	public void realizarPagamento(double valor) {
		
	}
	
	public void cartaoDeCredito(double valor ) {
		
	}
	public void boleto(double valor) {
		
	}
	
	public void dinheiro(double valor) {
		
	}
}
