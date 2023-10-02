package Iterador;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Menu {

	public static Scanner sc = new Scanner(System.in);
	public static Map<Integer, Integer> hashMap = new HashMap<>();
	
	public static void Menu() {
		while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar dato");
            System.out.println("2. Eliminar dato");
            System.out.println("3. Mostrar colección de datos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    InserDato();
                    break;
                case 2:
                    ElimDato();
                    break;
                case 3:
                    MostDato();
                    break;
                case 4:
                	System.out.println("Saliendo del programa.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
		}
	}
	
	public static void InserDato() {
		int cont;
		if(hashMap.size() >= 10) {
			System.out.println("El hashmap esta lleno");
		}else {
			System.out.println("Introduzca la clave");
			int dat1 = sc.nextInt();
			System.out.println("Introduzca el dato");
			cont = sc.nextInt();
			hashMap.put(cont, dat1);
		}
		
		
	}
	
	public static void ElimDato() {
		
		System.out.println("Introduzca el dato que desea eliminar");
		int dat1 = sc.nextInt();
		if(hashMap.containsValue(dat1)) {
			hashMap.remove(dat1);
		}
	}
	
	public static void MostDato() {
		for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			System.out.println("Clave: " + entry.getKey() + " , Valor: " + entry.getValue());
		}
	}
	
}
