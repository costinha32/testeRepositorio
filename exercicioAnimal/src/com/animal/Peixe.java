package com.animal;

public class Peixe extends Animal {

	private String caracteristica;

	public Peixe(String nome, double comprimento, int numPatas, String cor, String ambiente, double velMedia, String caracteristica) {
		super(nome, comprimento, numPatas, cor, ambiente, velMedia);
		this.caracteristica = caracteristica;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public void dados() {
		super.dados();
		System.out.println("Caracteristica: " + getCaracteristica());
	}

}
