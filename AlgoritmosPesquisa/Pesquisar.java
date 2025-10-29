package AlgoritmosPesquisa;

public class Pesquisar {

    public static int pesquisaSequencial(int num, int[] vetor) {
        int i = 0;
        int pos = 0;
        while (i < vetor.length) {
            if (num == vetor[i]) {
                return pos;
            }
            i++;
            pos++;
        }
        return -1;
    }

    public static int pesquisaMelhorada(int num, int[] vetor) {
        int i = 0;
        int pos = 0;
        while (i < vetor.length) {
            if (num == vetor[i]) {
                return pos;
            }
            if (num < vetor[i]) {
                return -1;
            }
            i++;
            pos++;
        }
        return -1;
    }

    public static int pesquisaBinaria(int num, int[] vetor) {
        int inicio = 0, fim = vetor.length - 1;
        int meio;

        if (num > vetor[fim]) {
            return -1;
        } else {
            while (inicio <= fim) {
                meio = (inicio + fim) / 2;

                if (num == vetor[meio]) {
                    return meio;
                }

                if (num < vetor[meio]) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            }
            return -1;
        }
    }

}
