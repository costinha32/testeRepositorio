package com.ifsc.tds;

public class Gerente {
	private String cpf;
	private String nome;
	private double salario;
	private int senha;

	

	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}



	public int getSenha() {
		return senha;
	}



	public void setSenha(int senha) {
		this.senha = senha;
	}



	public boolean validarSenha(int valorSenha) {
		if (senha == valorSenha) {
			return true;
		}
		return false;
	}

}
