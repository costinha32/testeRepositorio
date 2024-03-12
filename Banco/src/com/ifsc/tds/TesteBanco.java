package com.ifsc.tds;

public class TesteBanco {

	public static void main(String[] args) {
		Conta bradesco = new Conta();
		Cliente caio = new Cliente();
		Cidade cidadeCliente = new Cidade();
		
		try {
			caio.setIdade(20);
			caio.setNome("Caio");
			cidadeCliente.setNome("jaragua");
			caio.setCidade(cidadeCliente);
			bradesco.setNumero(1234567);
			bradesco.setCliente(caio);
			
			System.out.println("Nome do cliente da conta: " + bradesco.getCliente().getNome());
			System.out.println("Cidade do cliente da conta: " + bradesco.getCliente().getCidade().getNome());
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
