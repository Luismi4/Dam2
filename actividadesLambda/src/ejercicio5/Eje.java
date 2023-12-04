package ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Eje {
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();	
		
		int tama = 1000000;
		
		for (int i = 0; i <= tama; i++) {
            numeros.add((int)(Math.random() * 10000 + 1));
        }
		
		// Calcular el tamaño de cada parte
		int tamanoParte = numeros.size() / 4;

        // Crear sublistas utilizando expresiones lambda
        List<List<Integer>> partes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int inicio = i * tamanoParte;
            int fin = (i + 1) * tamanoParte;
            partes.add(numeros.subList(inicio, fin));
        }

        // Imprimir las sublistas y la suma total utilizando expresiones lambda
        int sumaTotal = partes.stream()
                .flatMapToInt(parte -> parte.stream().mapToInt(Integer::intValue))
                .sum();

        int[] cont = {1};
        partes.forEach(parte -> {
            System.out.println("Parte " + cont[0] + ": " + parte);
            int suma = parte.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Suma: " + suma);
            cont[0]++;
        });

        System.out.println("Suma total de todas las partes: " + sumaTotal);

	}
}
