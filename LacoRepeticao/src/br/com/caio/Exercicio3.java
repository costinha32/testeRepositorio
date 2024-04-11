package br.com.caio;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int opcao;
		int quantidadeMaquinas = 0;
		double valorUnitario = 0;

		boolean continuar = true;

		while (continuar) {
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Cadastrar máquinas");
			System.out.println("2 - Retirar produto de estoque");
			System.out.println("3 - Consultar estoque");
			System.out.println("4 - Sair");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Informe a quantidade de máquinas a cadastrar:");
				quantidadeMaquinas += scanner.nextInt();
				System.out.println("Informe o valor unitário das máquinas:");
				valorUnitario = scanner.nextDouble();
				System.out.println("Máquinas cadastradas com sucesso.");
				break;
			case 2:
				if (quantidadeMaquinas == 0) {
					System.out.println("Estoque vazio. Nenhuma máquina para retirar.");
				} else {
					System.out.println("Informe a quantidade de máquinas a retirar:");
					int quantidadeRetirar = scanner.nextInt();
					if (quantidadeRetirar > quantidadeMaquinas) {
						System.out.println("Quantidade insuficiente em estoque.");
					} else {
						quantidadeMaquinas -= quantidadeRetirar;
						System.out.println(quantidadeRetirar + " máquina(s) retirada(s) do estoque com sucesso.");
					}
				}
				break;
			case 3:
				if (quantidadeMaquinas == 0) {
					System.out.println("Estoque vazio. Nenhuma máquina cadastrada.");
				} else {
					System.out.println("Quantidade de máquinas cadastradas: " + quantidadeMaquinas);
					System.out.println("Valor unitário de cada máquina: R$" + valorUnitario);
					System.out
							.println("Valor total das máquinas em estoque: R$" + (quantidadeMaquinas * valorUnitario));
				}
				break;
			case 4:
				continuar = false;
				System.out.println("Saindo do programa. Obrigado!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
		scanner.close();
	}

}
