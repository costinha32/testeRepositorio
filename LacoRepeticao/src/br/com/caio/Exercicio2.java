package br.com.caio;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        double taxaCambio = 4.27;
        double valorCarroEmEuro = 61307;

        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo à News Cars Zip!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Pagar à vista");
            System.out.println("2 - Parcelar em 4 vezes");
            System.out.println("3 - Parcelar em 8 vezes");
            System.out.println("4 - Parcelar em até 12 vezes");
            System.out.println("5 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    double descontoAVista = valorCarroEmEuro * 0.08 * taxaCambio;
                    System.out.println("Desconto à vista: R$" + descontoAVista);
                    break;
                case 2:
                    double desconto4x = valorCarroEmEuro * 0.05 * taxaCambio;
                    System.out.println("Desconto parcelando em 4 vezes: R$" + desconto4x);
                    break;
                case 3:
                    double desconto8x = valorCarroEmEuro * 0.02 * taxaCambio;
                    System.out.println("Desconto parcelando em 8 vezes: R$" + desconto8x);
                    break;
                case 4:
                    if (valorCarroEmEuro * taxaCambio <= 12) {
                        System.out.println("Parcelamento em até 12 vezes é o mesmo que pagar à vista.");
                    } else {
                        double juros12x = valorCarroEmEuro * 0.02 * taxaCambio;
                        System.out.println("Juros a partir da 13ª parcela: R$" + juros12x);
                    }
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Obrigado por utilizar nosso serviço. Volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
        scanner.close();
	}

}

