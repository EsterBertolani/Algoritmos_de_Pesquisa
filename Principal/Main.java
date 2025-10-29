package principal;

import java.io.IOException;
import java.util.Scanner;
import AlgoritmosPesquisa.*;
import Utilitarios.*;
import dados.Resultado;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pesquisar pesquisar = new Pesquisar();
        int[] vetor = null;
        boolean executando = true;

        while (executando) {
            System.out.println("\n====== MENU PRINCIPAL ======");
            System.out.println("1. Criar vetor aleatório e salvar em arquivo");
            System.out.println("2. Carregar vetor de arquivo");
            System.out.println("3. Analisar vetor (maior, menor, moda)");
            System.out.println("4. Pesquisar valor no vetor");
            System.out.println("5. Comparar desempenho (Sequencial vs Binária)");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opcao = TratamentoErros.lerInteiro(sc, "");

            switch (opcao) {
                case 1:
                    criarArquivo(sc);
                    break;
                case 2:
                    vetor = carregarArquivo(sc);
                    break;
                case 3:
                    if (vetor != null) analisarVetor(vetor);
                    else System.out.println("Carregue um vetor primeiro!");
                    break;
                case 4:
                    if (vetor != null) pesquisarValor(sc, vetor, pesquisar);
                    else System.out.println("Carregue um vetor primeiro!");
                    break;
                case 5:
                    if (vetor != null) compararDesempenho(sc, vetor, pesquisar);
                    else System.out.println("Carregue um vetor primeiro!");
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
        sc.close();
    }

    private static void criarArquivo(Scanner sc) {
        int qtd = TratamentoErros.lerInteiro(sc, "Quantidade de números: ");
        System.out.print("Nome do arquivo (ex: vetor.txt): ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println(ManipulaArquivo.gerarArquivo(qtd, nome));
    }

    private static int[] carregarArquivo(Scanner sc) {
        System.out.print("Nome do arquivo: ");
        sc.nextLine();
        String nome = sc.nextLine();
        try {
            int[] vetor = ManipulaArquivo.lerArquivo(nome);
            if (vetor != null) System.out.println("Vetor carregado com sucesso!");
            else System.out.println("Arquivo vazio!");
            return vetor;
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
            return null;
        }
    }

    private static void analisarVetor(int[] vetor) {
        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;
        for (int n : vetor) {
            if (n > maior) maior = n;
            if (n < menor) menor = n;
        }

        // Calcular moda
        int moda = vetor[0], freqMax = 0;
        for (int i = 0; i < vetor.length; i++) {
            int freq = 0;
            for (int j = 0; j < vetor.length; j++) {
                if (vetor[j] == vetor[i]) freq++;
            }
            if (freq > freqMax) {
                freqMax = freq;
                moda = vetor[i];
            }
        }

        System.out.println("🔎 Maior: " + maior + " | Menor: " + menor + " | Moda: " + moda);
    }

    private static void pesquisarValor(Scanner sc, int[] vetor, Pesquisar pesquisar) {
        int valor = TratamentoErros.lerInteiro(sc, "Valor para buscar: ");
        System.out.println("\n1. Sequencial");
        System.out.println("2. Sequencial Otimizada");
        System.out.println("3. Binária");
        System.out.println("4. Hash");
        int op = TratamentoErros.lerInteiro(sc, "Escolha: ");

        int pos = -1;
        switch (op) {
            case 1:
                pos = pesquisar.pesquisaSequencial(valor, vetor);
                break;
            case 2:
                Ordenadores.quicksort(vetor);
                pos = pesquisar.pesquisaMelhorada(valor, vetor);
                break;
            case 3:
                Ordenadores.quicksort(vetor);
                pos = pesquisar.pesquisaBinaria(valor, vetor);
                break;
            case 4:
                pos = pesquisar.pesquisaHash(vetor, valor, 50, 10);
                break;
        }

        if (pos >= 0)
            System.out.println("Valor encontrado na posição: " + pos);
        else
            System.out.println("Valor não encontrado.");

        System.out.println("Comparações: " + pesquisar.comparacoes + " | Tempo: " + pesquisar.tempoExecucao + " ns");
    }

    private static void compararDesempenho(Scanner sc, int[] vetor, Pesquisar pesquisar) {
        int valor = TratamentoErros.lerInteiro(sc, "Valor para buscar: ");

        Resultado seq = new Resultado(
                pesquisar.pesquisaSequencial(valor, vetor),
                pesquisar.comparacoes,
                pesquisar.tempoExecucao);

        Ordenadores.quicksort(vetor);

        Resultado bin = new Resultado(
                pesquisar.pesquisaBinaria(valor, vetor),
                pesquisar.comparacoes,
                pesquisar.tempoExecucao);

        System.out.println("\n=== COMPARATIVO ===");
        System.out.println("Sequencial → Comparações: " + seq.getComparacoes() + " | Tempo: " + seq.getTempoExecucao());
        System.out.println("Binária → Comparações: " + bin.getComparacoes() + " | Tempo: " + bin.getTempoExecucao());
    }
}
