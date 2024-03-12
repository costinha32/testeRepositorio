package com.hidroaviao;

public class Quadrado implements FiguraGeometrica {
	private double lado;

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String getNomeFigura() {
		// TODO Auto-generated method stub
		return "Quadrado";
	}

	@Override
	public double getArea() {
		double area = 0;
		area = lado * lado;
		return area;
	}
	@Override
	public double getPerimetro() {
		double perimetro = 0;
		perimetro = lado * 4;
		return perimetro;
	}

	@Override
	public double getAltura() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
