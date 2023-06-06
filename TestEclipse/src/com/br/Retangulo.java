package com.br;

public class Retangulo {
	
	private double base;
	private double altura;
	
	public Retangulo() {}
	
	public Retangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getLargura() {
		return altura;
	}

	public void setLargura(double largura) {
		this.altura = largura;
	}
	
	public double calculaArea(double base, double altura) {
		
		return base * altura;

	}
	
	
	

}
