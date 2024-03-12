package com.transporte;

public class Aviao extends Terrestre {
	private String cor;
	private int qntdTurbinas;
	private int qntdAssentos;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQntdTurbinas() {
		return qntdTurbinas;
	}

	public void setQntdTurbinas(int qntdTurbinas) {
		this.qntdTurbinas = qntdTurbinas;
	}

	public int getQntdAssentos() {
		return qntdAssentos;
	}

	public void setQntdAssentos(int qntdAssentos) {
		this.qntdAssentos = qntdAssentos;
	}

}
