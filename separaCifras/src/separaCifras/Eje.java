package separaCifras;

import java.util.ArrayList;
import java.util.Scanner;

public class Eje {

	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Ingrese un número: ");
	        String input = scanner.nextLine();
	        scanner.close();

	        try {
	            long numero = Long.parseLong(input);

	            if (numero >= 0) {
	                ArrayList<Long> resultado = separarNumeroRecursivamente(numero);
	                System.out.print("El número separado de forma recursiva es: ");
	                for (long cifra : resultado) {
	                    System.out.print(cifra + " ");
	                }
	            } else {
	                System.out.println("Por favor, ingrese un número no negativo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Por favor, ingrese un número válido.");
	        }
	    }

	    public static ArrayList<Long> separarNumeroRecursivamente(long numero) {
	        ArrayList<Long> resultado = new ArrayList<>();
	        if (numero < 10) {
	            resultado.add(numero);
	        } else {
	            long resto = numero % 10;
	            resultado.addAll(separarNumeroRecursivamente(numero / 10));
	            resultado.add(resto);
	        }
	        return resultado;
	    }

}
