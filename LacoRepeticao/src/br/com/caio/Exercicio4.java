package br.com.caio;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);

		int quantidadeFuncionariosAvaliados = 0;

		do {
			System.out.println("Avaliação do Colaborador");
			System.out.print("Informe o nome do colaborador: ");
			String nome = teclado.nextLine();

			System.out.print("Informe a quantidade de notas a serem lançadas: ");
			int quantidadeNotas = teclado.nextInt();
			teclado.nextLine();

			double maiorNota = Double.MIN_VALUE;
			double menorNota = Double.MAX_VALUE;
			double somaNotas = 0;

			for (int i = 1; i <= quantidadeNotas; i++) {
				System.out.print("Informe a nota " + i + ": ");
				double nota = teclado.nextDouble();
				teclado.nextLine();

				if (nota > maiorNota) {
					maiorNota = nota;
				}
				if (nota < menorNota) {
					menorNota = nota;
				}

				somaNotas += nota;
			}

			double media = somaNotas / quantidadeNotas;

			String situacao;
			if (media >= 7.0) {
				situacao = "Colaborador Aprovado";
			} else if (media >= 4.0) {
				situacao = "Possível Advertência";
			} else {
				situacao = "Corre risco de demissão";
			}

			System.out.println("Nome do colaborador: " + nome);
			System.out.println("Maior nota: " + maiorNota);
			System.out.println("Menor nota: " + menorNota);
			System.out.println("Quantidade de notas: " + quantidadeNotas);
			System.out.println("Média: " + media);
			System.out.println("Situação: " + situacao);

			quantidadeFuncionariosAvaliados++;

			System.out.print("Deseja avaliar outro funcionário? (S/N): ");
			String continuar = teclado.nextLine();

			if (!continuar.equalsIgnoreCase("S")) {
				break;
			}
		} while (true);

		System.out.println("Quantidade de funcionários avaliados: " + quantidadeFuncionariosAvaliados);
		teclado.close();
	}

}
