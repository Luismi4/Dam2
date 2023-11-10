package ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Eje {
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();	
		int tama = 10000;
		
		for (int i = 0; i <= tama; i++) {
            numeros.add((int)(Math.random() * 10000 + 1));
        }
		
		// Calcular el tamaño de cada parte
        int tamanoParte = numeros.size() / 4;

        // Crear las sublistas
        List<Integer> parte1 = numeros.subList(0, tamanoParte);
        List<Integer> parte2 = numeros.subList(tamanoParte, 2 * tamanoParte);
        List<Integer> parte3 = numeros.subList(2 * tamanoParte, 3 * tamanoParte);
        List<Integer> parte4 = numeros.subList(3 * tamanoParte, numeros.size());

        // Imprimir las sublistas
        System.out.println("Parte 1: " + parte1);
        System.out.println("Parte 2: " + parte2);
        System.out.println("Parte 3: " + parte3);
        System.out.println("Parte 4: " + parte4);
		
        int sumatama1 = parte1.parallelStream().mapToInt(Integer::intValue).sum();
        int sumatama2 = parte2.parallelStream().mapToInt(Integer::intValue).sum();
        int sumatama3 = parte3.parallelStream().mapToInt(Integer::intValue).sum();
        int sumatama4 = parte4.parallelStream().mapToInt(Integer::intValue).sum();
        
        System.out.println("Suma parte 1: " + sumatama1);
        System.out.println("Suma parte 2: " + sumatama2);
        System.out.println("Suma parte 3: " + sumatama3);
        System.out.println("Suma parte 4: " + sumatama4);
        
        int tot = sumatama1 + sumatama2 + sumatama3 + sumatama4;
        System.out.println("Suma total: " + tot);
        
	}
	

	
}
