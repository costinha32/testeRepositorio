package com.hidroaviao;

public class TesteFigura {

	public static void main(String[] args) {
		Quadrado quadrado = new Quadrado();
		quadrado.setLado(4);
		Retangulo retangulo = new Retangulo();
		retangulo.setLado(4);
		retangulo.setAltura(3);
		
		System.out.println(quadrado.getArea());
		System.out.println(quadrado.getPerimetro());
		System.out.println(retangulo.getArea());
		

	}

}
