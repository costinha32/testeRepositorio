package com.ifsc.tds;

public class TesteFuncionario {

	public static void main(String[] args) {
		Gerente fulano = new Gerente();
		Funcionario ciclano = new Funcionario();
		
		fulano.setNome("Alexandre");
		fulano.setSenha(123);
		
		ciclano.setNome("Jesse");
		
		System.out.println("Nome " + fulano.getNome());
		System.out.println("Nome " + ciclano.getNome());

	}

}
