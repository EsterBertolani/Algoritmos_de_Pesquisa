package Principal;

import java.util.Scanner;

import Utilitarios.ManipulaArquivo;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.print("===== MENU PRINCIPAL =====\n"
                    + "1. Gerenciar vetor\n"
                    + "2. Análise do vetor\n"
                    + "3. Algoritmos de Pesquisa\n"
                    + "4. Análise de Desempenho\n"
                    + "0. SAIR\n"
                    + " | Opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                // ===== Gerenciar vetor =====
                case 1:
                    System.out.print("===== Gerenciar vetor =====\n"
                            + "1. Criar vetor\n"
                            + "2. Carregar de Arquivo\n"
                            + "0. SAIR\n"
                            + " | Opção: ");
                    opcao = scan.nextInt();

                    switch (opcao) {
                        case 1:
                            System.out.print("\nDigite a quantidade de números que deseja no vetor: ");
                            int qtdNum = scan.nextInt();
                            ManipulaArquivo.gerarVetor(qtdNum);
                            break;
                        case 2:
                            break;
                        case 0:
                            System.out.println("\nVoltando ao menu principal...");
                            break;
                        default:
                            System.out.println("\nInválido. Tente novamente.");
                    }

                    break;

                // ===== Análise do vetor =====
                case 2:
                    System.out.print("===== Análise do vetor =====\n"
                            + "1. Encontrar Menor e Maior valor\n"
                            + "2. Calcular a Moda\n"
                            + "0. SAIR\n"
                            + " | Opção: ");
                    opcao = scan.nextInt();

                    switch (opcao) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 0:
                            System.out.println("\nVoltando ao menu principal...");
                            break;
                        default:
                            System.out.println("\nInválido. Tente novamente.");
                    }

                    break;

                // ===== Algoritmos de Pesquisa =====
                case 3:
                    System.out.print("===== Algoritmos de Pesquisa =====\n"
                            + "1. Pesquisa Sequencial Simples\n"
                            + "2. Pesquisa Sequencial Otimizada\n"
                            + "3. Pesquisa Binária\n"
                            + "4. Pesquisa com Hashing\n"
                            + "0. SAIR\n"
                            + " | Opção: ");
                    opcao = scan.nextInt();

                    switch (opcao) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 0:
                            System.out.println("\nVoltando ao menu principal...");
                            break;
                        default:
                            System.out.println("\nInválido. Tente novamente.");
                    }

                    break;

                // ===== Análise de Desempenho =====
                case 4:
                    break;

                case 0:
                    System.out.println("\nEncerrando o programa...");
                    break;

                default:
                    System.out.println("\nInválido. Tente novamente.");
            }

        } while (opcao != 0);

        scan.close();
    }

}
