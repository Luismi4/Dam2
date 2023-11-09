package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Eje {
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();		
		try {
            int numero = (int)(Math.random() * 1000 + 1);
            for (int i = 0; i <= numero; i++) {
                numeros.add((int)(Math.random() * 10000 + 1));
            }

            // Filtrar números primos con una función lambda
            numeros.removeIf(num -> !esPrimo(num));

            // Ordenar de mayor a menor
            numeros.sort((a, b) -> b - a);

            // Mostrar los resultados
            System.out.println("Números primos ordenados de mayor a menor: " + numeros);
        } catch (Exception e) {
            System.out.println("Ha ocurrido una excepción: " + e.getMessage());
        }
    }

    private static boolean esPrimo(int numero) {
        try {
            if (numero <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error al verificar si es primo: " + e.getMessage());
            return false;
        }
    }

}
