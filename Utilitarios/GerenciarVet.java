package Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import AlgoritmosPesquisa.Ordenadores;

public class GerenciarVet {

    // ================== Métodos de manipulação do arquivo ==================

    public static int[] gerarVetor(int qtdNum) {
        int[] numeros = new int[qtdNum];
        for (int i = 0; i < qtdNum; i++) {
            numeros[i] = (int) (Math.random() * 1000);
        }
        return numeros;
    }

    public static String gerarArquivo(int qtdNum, String nomeArquivo) {
        int[] numeros = gerarVetor(qtdNum);

        try (BufferedWriter gerar = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (int num : numeros) {
                gerar.write(String.valueOf(num));
                gerar.newLine();
            }
            return "Arquivo \"" + nomeArquivo + "\" criado com sucesso contendo " + numeros.length + " números!";

        } catch (Exception e) {
            return "Erro ao criar o arquivo \"" + nomeArquivo + "\": " + e.getMessage();
        }
    }

    public static int[] lerArquivo(String nomeArquivo)
            throws IOException, FileNotFoundException { // nn pode usar o try sem isso aqui

        int[] numeros = new int[tamArquivo(nomeArquivo)];

        try (BufferedReader ler = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int i = 0;

            while ((linha = ler.readLine()) != null) {
                numeros[i] = Integer.parseInt(linha.trim());
                i++;
            }
        }
        if (numeros.length > 0) {
            return numeros;
        } else {
            return null; // pra tratar os erros lá na frente
        }

    }

    public static int[] ordenarVetor(int[] vetor) {
        if (vetor != null) {
            if (vetor.length < 1000) {
                Ordenadores.insercaoDireta(vetor);
            } else {
                Ordenadores.quicksort(vetor);
            }
            return vetor;
        } else {
            return null;
        }
    }

    public static int[] ordenarArquivo(String nomeArquivo)
            throws IOException, FileNotFoundException {
        int tam = tamArquivo(nomeArquivo);
        int[] vetor = lerArquivo(nomeArquivo);

        if (vetor != null) {
            if (tam < 1000) { // se o tamanho do vetor for "pequeno",
                Ordenadores.insercaoDireta(vetor); // usa inserção direta pra ordenar
            } else {
                Ordenadores.quicksort(vetor); // se não, quicksort
            }
            return vetor;
        } else {
            return null;
        }
    }

    // ================== MAIOR, MENOR, MODA ==================

    public static String maiorMenor(int[] vet) {
        ordenarVetor(vet);
        int menor = vet[0];
        int maior = vet[vet.length - 1];

        return "O maior número do vetor é: " + maior + "\nE o menor número é: " + menor;

    }

    // moda

    public static String acharModa(int[] vet) {

        ordenarVetor(vet);

        StringBuilder moda = new StringBuilder("A moda deste vetor é: ");
        int maxCont = 0;
        int contAtual = 1;
        int numAnt = vet[0];

        for (int i = 1; i <= vet.length; i++) {

            if (i == vet.length || vet[i] != numAnt) {

                if (contAtual > maxCont) {
                    maxCont = contAtual;
                    moda.setLength(0); // apaga a moda antiga
                    moda.append(numAnt); // adiciona a moda com mais numeros de repetições atualmente

                } else if (contAtual == maxCont) { // caso tenha moda com o msm numero de repeticoes
                    moda.append(", ");
                    moda.append(numAnt);
                }
                if (i < vet.length) {
                    contAtual = 1;
                    numAnt = vet[i];
                }
            } else {
                contAtual++; // msm número, só incrementa no fim do loop
            }
        }

        if (maxCont == 1) {
            return "Nenhuma moda";
        }

        return moda.toString();
    }

    // ================== Métodos private / auxiliares ==================

    private static int tamArquivo(String nomeArquivo) { // pra ver quantas linhas o arquivo tem
        int cont = 0; // e basear o tamanho do vetor a partir disso
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            while ((reader.readLine()) != null) {
                cont++;
            }
        } catch (IOException e) {
            return 0;
        }
        return cont;
    }

    public static String toString(int[] numeros) {
        String msg = "| ";
        for (int i : numeros) {
            msg += i + " | ";
        }
        return msg;
    }

    // ========== testes =====================

}
