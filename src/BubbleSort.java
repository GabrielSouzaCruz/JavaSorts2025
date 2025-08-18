import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BubbleSort<T> {
    private void troca(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public T[] sort(T[] array) {
        int fases = 0;
        int comparacoes = 0;
        int trocas = 0;
        Comparator<T> comparator = (a, b) -> ((Comparable<T>) a).compareTo(b);

        int n = array.length;
        for (int fase = 1; fase < n; fase++) {
            fases++; // Conta a fase
            for (int j = 0; j < n - fase; j++) {
                comparacoes++; // Conta a comparação
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    trocas++; // Conta a troca
                    troca(array, j, j + 1);
                }
            }
        }
        System.out.println("Fases: " + fases);
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        return array;
    }

    public T[] sortOtimizado(T[] array) {
        int fases = 0;
        int comparacoes = 0;
        int trocas = 0;
        Comparator<T> comparator = (a, b) -> ((Comparable<T>) a).compareTo(b);

        int n = array.length;
        boolean trocou;
        for (int fase = 1; fase < n; fase++) {
            fases++; // Conta a fase
            trocou = false;
            for (int j = 0; j < n - fase; j++) {
                comparacoes++; // Conta a comparação
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    trocas++; // Conta a troca
                    troca(array, j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
        System.out.println("Fases: " + fases);
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }
    
    public T[] sortOtimizado(T[] array) {
        return sortOtimizado(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }


    public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
        Integer[] numeros = new Integer[linhas.size()];
        for (int i = 0; i < linhas.size(); i++) {
            numeros[i] = Integer.parseInt(linhas.get(i).trim());
        }
        return numeros;
    }
}