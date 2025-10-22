package AlgoritmosPesquisa;

public class Pesquisar {

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

