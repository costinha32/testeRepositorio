package com.zoologico;

public class TesteZoologico {

	public static void main(String[] args) {
		Gato xanin = new Gato();
		Cachorro bob = new Cachorro();
		
		xanin.setNome("Xanin");
		bob.setNome("Huulke");
		
		System.out.println("O nome do gato e: " + xanin.getNome());
		xanin.miar();
		System.out.println("O nome do cachorro e: " + bob.getNome());
		bob.latir();

	}

}
