package Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import AlgoritmosPesquisa.Ordenadores;

public class ManipulaArquivo {

    // ================== Métodos de manipulação do arquivo ==================

    public static String gerarArquivo(int qtdNum, String nomeArquivo) {
        int[] numeros = gerarNum(qtdNum);

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

    // ================== Métodos private auxiliares ==================

    private static int[] gerarNum(int qtdNum) {
        int[] numeros = new int[qtdNum];
        for (int i = 0; i < qtdNum; i++) {
            numeros[i] = (int) (Math.random() * 1000);
        }
        return numeros;
    }

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

}
