import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            Integer[] numeros = BubbleSort.carregarArquivo("src/numeros_aleatorios.txt");

            System.out.println("Vetor original: " + Arrays.toString(numeros));

            Integer[] numerosCopia = Arrays.copyOf(numeros, numeros.length);
            BubbleSort<Integer> bSortOtimizado = new BubbleSort<>();
            System.out.println("\n--- Usando Bubble Sort Otimizado ---");
            bSortOtimizado.sortOtimizado(numeros);
            System.out.println("Vetor ordenado: " + Arrays.toString(numeros));
            BubbleSort<Integer> bSortComum = new BubbleSort<>();
            System.out.println("\n--- Usando Bubble Sort Comum ---");
            bSortComum.sort(numerosCopia);
            System.out.println("Vetor ordenado: " + Arrays.toString(numerosCopia));
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}