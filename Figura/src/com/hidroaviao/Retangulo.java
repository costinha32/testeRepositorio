package com.hidroaviao;

public class Retangulo implements FiguraGeometrica {
	private double lado, altura;

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	@Override
	public double getAltura() {
		
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	

	@Override
	public String getNomeFigura() {
		
		return "retangulo";
	}

	@Override
	public double getArea() {
		double area = 0;
		area = area * altura;
		return area;
	}

	@Override
	public double getPerimetro() {
		double perimetro = 0;
		perimetro = 2 * lado + 2 *  altura;
		return perimetro;
	}


	

}
