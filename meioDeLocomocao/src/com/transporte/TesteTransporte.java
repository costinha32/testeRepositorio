package com.transporte;

public class TesteTransporte {

	public static void main(String[] args) {
		Automovel fusca = new Automovel();

		fusca.setCapacidade(1000);
		fusca.setNumPortas(2);
		fusca.setCor("Prata");
		fusca.setNumRodas(4);
		fusca.setPlaca("123A4CD");

		System.out.println(fusca.getCor());

	}

}
