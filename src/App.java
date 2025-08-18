import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("====================================");
            System.out.println("Atividade 1");
            System.out.println("====================================");
            
            Integer[] numeros = BubbleSort.carregarArquivo("src/numeros_aleatorios.txt");
            Integer[] numerosCopia = Arrays.copyOf(numeros, numeros.length);
            BubbleSort<Integer> bsort = new BubbleSort<>();
            
            System.out.println("\nAntes de ordenar: " + Arrays.toString(numeros)+"\n");
            System.out.println("--- Bubble Sort Padrão ---");
            System.out.println("Depois de ordenar (Padrão): " + Arrays.toString(numeros) + "\n");
            bsort.sort(numeros);
        
            System.out.println("\n--- Bubble Sort Otimizado ---");
            System.out.println("\nDepois de ordenar (Otimizado): " + Arrays.toString(numerosCopia) + "\n");
            bsort.sortOtimizado(numerosCopia);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}