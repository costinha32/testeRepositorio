package br.com.caio;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int quantidadeFuncionariosAvaliados = 0;

		do {
			System.out.println("Avalia��o do Colaborador");
			System.out.print("Informe o nome do colaborador: ");
			String nome = scanner.nextLine();

			System.out.print("Informe a quantidade de notas a serem lan�adas: ");
			int quantidadeNotas = scanner.nextInt();
			scanner.nextLine();

			double maiorNota = Double.MIN_VALUE;
			double menorNota = Double.MAX_VALUE;
			double somaNotas = 0;

			for (int i = 1; i <= quantidadeNotas; i++) {
				System.out.print("Informe a nota " + i + ": ");
				double nota = scanner.nextDouble();
				scanner.nextLine();

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
				situacao = "Poss�vel Advert�ncia";
			} else {
				situacao = "Corre risco de demiss�o";
			}

			System.out.println("Nome do colaborador: " + nome);
			System.out.println("Maior nota: " + maiorNota);
			System.out.println("Menor nota: " + menorNota);
			System.out.println("Quantidade de notas: " + quantidadeNotas);
			System.out.println("M�dia: " + media);
			System.out.println("Situa��o: " + situacao);

			quantidadeFuncionariosAvaliados++;

			System.out.print("Deseja avaliar outro funcion�rio? (S/N): ");
			String continuar = scanner.nextLine();

			if (!continuar.equalsIgnoreCase("S")) {
				break;
			}
		} while (true);

		System.out.println("Quantidade de funcion�rios avaliados: " + quantidadeFuncionariosAvaliados);
		scanner.close();
	}

}
