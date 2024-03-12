package com.transporte;

public class TesteAereo {

	public static void main(String[] args) {
		Aviao tucano = new Aviao();

		tucano.setCapacidade(20000);

		tucano.setCor("Azul");

		System.out.println("Cor " + tucano.getCor());

	}

}
