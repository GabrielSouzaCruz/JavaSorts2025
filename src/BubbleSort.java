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

    public T[] sort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        int cont = 0;
        for (int fase = 1; fase < n; fase++) {
            for (int j = 0; j < n - fase; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    troca(array, j, j + 1);
                    cont++;
                }
            }
        }
        System.out.println("Parou na fase: " + cont);
        return array;
    }

    // Método Otimizado
    public T[] sortOtimizado(T[] array, Comparator<T> comparator) {
        int n = array.length;
        boolean trocou;
        for (int fase = 1; fase < n; fase++) {
            trocou = false;
            for (int j = 0; j < n - fase; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    troca(array, j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                System.out.println("Parou na fase: " + fase);
                break;
            }
        }
        return array;
    }


    public T[] sort(T[] array) {
        return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }
    
    // Sobrecarga para o método otimizado
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