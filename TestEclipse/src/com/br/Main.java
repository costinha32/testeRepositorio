package com.br;

public class Main {

	public static void main(String[] args) {
		
		Retangulo r = new Retangulo();
		ConversorDeMoeda c = new ConversorDeMoeda();
		double resultado = r.calculaArea(4, 8);
		
		
		Calculadora calc =  new Calculadora();
		System.out.println(calc.soma(2, 2));
		System.out.println("A área do retangulo e: " + resultado);
		System.out.println("O valor da moeda e: " + resultado);
		
		
	}

}
