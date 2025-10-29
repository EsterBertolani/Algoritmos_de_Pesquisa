package Principal;

import java.util.Scanner;

import AlgoritmosPesquisa.Pesquisar;
import Utilitarios.GerenciarVet;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static int[] numeros;

    public static void main(String[] args) {

        int opcao;
        int opcao2 = -1;
        do {
            System.out.print("\n===== MENU PRINCIPAL =====\n"
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
                    System.out.print("\n===== Gerenciar vetor =====\n"
                            + "1. Criar vetor\n"
                            + "2. Carregar de Arquivo\n"
                            + "0. SAIR\n"
                            + " | Opção: ");
                    opcao2 = scan.nextInt();

                    switch (opcao2) {
                        case 1:
                            System.out.print("\nDigite a quantidade de números que deseja no vetor: ");
                            int qtdNum = scan.nextInt();
                            numeros = GerenciarVet.gerarVetor(qtdNum);
                            System.out.println(GerenciarVet.toString(numeros));

                            break;
                        case 2:
                            System.out.print("\nVocê já tem o arquivo?\n[s - escolher arquivo] | [n - gerar arquivo]");
                            String resposta = scan.next();

                            if (resposta.equalsIgnoreCase("s")) {
                                System.out.print("\nDigite o nome do arquivo (não esqueça do .txt): ");
                                String nomeArquivo = scan.next();

                                try {
                                    int[] vetorzinho = GerenciarVet.lerArquivo(nomeArquivo);

                                    if (vetorzinho != null) {
                                        System.out.println("Vetor carregado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Arquivo não encontrado: " + e.getMessage());
                                }

                            } else {
                                System.out.print("\nDigite o nome do arquivo (não esqueça do .txt): ");
                                String nomeArquivo = scan.next();

                                System.out.print("\nDigite a quantidade de números que deseja no arquivo: ");
                                int qtdNums = scan.nextInt();

                                GerenciarVet.gerarArquivo(qtdNums, nomeArquivo);

                            }
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
                    System.out.print("\n===== Análise do vetor =====\n"
                            + "1. Encontrar Menor e Maior valor\n"
                            + "2. Calcular a Moda\n"
                            + "0. SAIR\n"
                            + " | Opção: ");
                    opcao2 = scan.nextInt();

                    switch (opcao2) {
                        case 1:
                            System.out.println(GerenciarVet.maiorMenor(numeros));
                            break;
                        case 2:
                            System.out.println(GerenciarVet.acharModa(numeros));
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
                    while (opcao2 != 0) {
                        System.out.print("\n===== Algoritmos de Pesquisa =====\n"
                                + "1. Pesquisa Sequencial Simples\n"
                                + "2. Pesquisa Sequencial Otimizada\n"
                                + "3. Pesquisa Binária\n"
                                + "4. Pesquisa com Hashing\n"
                                + "0. SAIR\n"
                                + " | Opção: ");
                        opcao2 = scan.nextInt();

                        System.out.print("\nDigite o número que deseja pesquisar: "); // não sai imediatamente do loop
                        int numPesquisa = scan.nextInt();

                        int indice;

                        switch (opcao2) { // melhorar isso aqui dps
                            case 1:
                                indice = Pesquisar.pesquisaSequencial(numPesquisa, numeros);
                                if (indice != -1) {
                                    System.out.println("O número que deseja está na posição: " + indice);
                                } else {
                                    System.out.println("O número que deseja não está no vetor");
                                }
                                break;

                            case 2:
                                GerenciarVet.ordenarVetor(numeros);
                                System.out.println("Vetor ordenado para pesquisa sequencial otimizada:\n"
                                        + GerenciarVet.toString(numeros));
                                indice = Pesquisar.pesquisaMelhorada(numPesquisa, numeros);
                                if (indice != -1) {
                                    System.out.println("O número que deseja está na posição: " + indice);
                                } else {
                                    System.out.println("O número que deseja não está no vetor");
                                }
                                break;

                            case 3:
                                GerenciarVet.ordenarVetor(numeros);
                                indice = Pesquisar.pesquisaBinaria(numPesquisa, numeros);
                                if (indice != -1) {
                                    System.out.println("O número que deseja está na posição: " + indice);
                                } else {
                                    System.out.println("O número que deseja não está no vetor");
                                }
                                break;

                            case 4:
                                break;

                            case 0:
                                System.out.println("\nVoltando ao menu principal...");
                                break;
                            default:
                                System.out.println("\nInválido. Tente novamente.");
                        }

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
