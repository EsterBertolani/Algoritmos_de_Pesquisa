package AlgoritmosPesquisa;

import Dados.*;

/* pesq. sequencial, melhorada e binária */

public class Pesquisar {

    // public static void main(String[] args) {

    // int[] vetor = { 10, 5, 15, 25, 7, 14, 30, 2, 19, 22 };
    // int[] vetor2 = { 2, 5, 7, 10, 14, 15, 19, 22, 25, 30 };

    // System.out.println(pesquisaSequencial(10, vetor));
    // System.out.println(pesquisaSequencial(7, vetor));
    // System.out.println(pesquisaSequencial(22, vetor));
    // System.out.println(pesquisaSequencial(100, vetor));

    // System.out.println("=======================");
    // System.out.println(pesquisaMelhorada(2, vetor2));
    // System.out.println(pesquisaMelhorada(14, vetor2));
    // System.out.println(pesquisaMelhorada(30, vetor2));
    // System.out.println(pesquisaMelhorada(21, vetor2));

    // System.out.println("=======================");
    // System.out.println(pesquisaBinaria(2, vetor2));
    // System.out.println(pesquisaBinaria(14, vetor2));
    // System.out.println(pesquisaBinaria(30, vetor2));
    // System.out.println(pesquisaBinaria(21, vetor2));
    // }

    public static boolean pesquisaSequencial(int num, int[] vetor) {
        int i = 0;
        while (i < vetor.length) {
            if (num == vetor[i]) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean pesquisaMelhorada(int num, int[] vetor) {
        int i = 0;
        while (i < vetor.length) {
            if (num == vetor[i]) {
                return true;
            }
            if (num < vetor[i]) {
                return false;
            }
            i++;
        }
        return false;
    }

    public static boolean pesquisaBinaria(int num, int[] vetor) {
        int inicio = 0, fim = (vetor.length - 1);
        int meio;

        if (num > vetor[fim]) {
            return false;
        } else {
            while (inicio <= fim) {
                meio = (inicio + fim) / 2;

                if (num == vetor[meio]) {
                    return true;
                }

                if (num < vetor[meio]) {
                    fim = (meio - 1);
                } else {
                    inicio = (meio + 1);
                }
            }
            return false;
        }
    }

}
