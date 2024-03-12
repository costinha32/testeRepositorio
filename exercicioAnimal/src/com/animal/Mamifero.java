package com.animal;

public class Mamifero extends Animal {

	private String alimento;
	
	public Mamifero(String nome, double comprimento, int numPatas, String cor, String ambiente, double velMedia, String alimento) {
		super(nome, comprimento, numPatas, cor, ambiente, velMedia);
		this.alimento = alimento;
	}

	

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public void dados() {
		super.dados();
		System.out.println("Ele se alimenta de: " + getAlimento());

	}

}
