package com.ifsc.tds;

public class Gerente extends Funcionario {
	private int senha;
	
	public boolean validarSenha(int valorSenha) {
	if (senha == valorSenha);
	{
		return true;
	}
	return false;
	}
	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	
	

}

	