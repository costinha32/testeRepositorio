package com.animal;

public class Animal {
	protected String nome;
	protected double comprimento;
	protected int numPatas;
	protected String cor;
	protected String ambiente;
	protected double velMedia;
	
	public  Animal(String nome, double comprimento, int numPatas, String cor, String ambiente, double velMedia ) {
		this.nome = nome;
		this.comprimento = comprimento;
		this.numPatas = numPatas;
		this.cor = cor;
		this.ambiente = ambiente; 
		this.velMedia = velMedia;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	public int getNumPatas() {
		return numPatas;
	}
	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public double getVelMedia() {
		return velMedia;
	}
	public void setVelMedia(float velMedia) {
		this.velMedia = velMedia;
	}
	public void dados() {
		System.out.println("O nome do animal e........................: " + nome);
		System.out.println("Ele possui................................: " + comprimento);
		System.out.println("Ele possui................................: " + numPatas );
		System.out.println("Tem a cor.................................: " + cor);
		System.out.println("Vive em ambiente..........................: " + ambiente);
		System.out.println("E consegue atingir uma velocidade média de: " + velMedia);
		
	}
	

}
