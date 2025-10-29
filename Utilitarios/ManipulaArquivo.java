package Utilitarios;

import java.io.*;
import AlgoritmosPesquisa.Ordenadores;

public class ManipulaArquivo {

    public static String gerarArquivo(int qtdNum, String nomeArquivo) {
        int[] numeros = gerarNum(qtdNum, 10000);

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

    public static int[] lerArquivo(String nomeArquivo) throws IOException {
        int[] numeros = new int[tamArquivo(nomeArquivo)];

        try (BufferedReader ler = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int i = 0;
            while ((linha = ler.readLine()) != null) {
                numeros[i++] = Integer.parseInt(linha.trim());
            }
        }

        return numeros.length > 0 ? numeros : null;
    }

    public static int[] ordenarArquivo(String nomeArquivo) throws IOException {
        int[] vetor = lerArquivo(nomeArquivo);
        if (vetor != null) {
            if (vetor.length < 1000)
                Ordenadores.insercaoDireta(vetor);
            else
                Ordenadores.quicksort(vetor);
        }
        return vetor;
    }

    private static int[] gerarNum(int qtdNum, int limiteMax) {
        int[] numeros = new int[qtdNum];
        for (int i = 0; i < qtdNum; i++) {
            numeros[i] = (int) (Math.random() * limiteMax);
        }
        return numeros;
    }

    private static int tamArquivo(String nomeArquivo) {
        int cont = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            while (reader.readLine() != null) cont++;
        } catch (IOException e) {
            return 0;
        }
        return cont;
    }
}
