package com.br;

public class ConversorDeMoeda {
	public static final double DOLAR = 5.34;
	public static final double EURO = 0.16;
	private double valor;
	private String moedaOrigem;
	private String moedaDestino;
	
	

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMoedaOrigem() {
		return moedaOrigem;
	}

	public void setMoedaOrigem(String moedaOrigem) {
		this.moedaOrigem = moedaOrigem;
	}

	public String getMoedaDestino() {
		return moedaDestino;
	}

	public void setMoedaDestino(String moedaDestino) {
		this.moedaDestino = moedaDestino;
	}

	public ConversorDeMoeda () {}
	
	public ConversorDeMoeda(double real, double estrangeira) {
	}
	
	public double converter(double valor, String moedaOrigem, String moedaDestino) {
		if (moedaOrigem.equals("USD") && moedaDestino.equals("BRL")) {
			return valor * DOLAR;
		}
		else if (moedaOrigem.equals("BRL") && moedaDestino.equals("EUR")) {
			return valor * EURO;
			
		}
		
		return 0.0;
	}

}
