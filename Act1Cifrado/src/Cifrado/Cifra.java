package Cifrado;

import java.io.*;
import java.util.Scanner;

public class Cifra {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Establecer una nueva contraseña");
            System.out.println("2. Ingresar contraseña para acceder");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer un entero

            switch (opcion) {
                case 1:
                    System.out.print("Establecer la nueva contraseña: ");
                    String nuevaContraseña = scanner.nextLine();
                    guardarContraseñaEnArchivo(nuevaContraseña);
                    System.out.println("Contraseña guardada en el archivo.");
                    break;
                case 2:
                    System.out.print("Ingrese la contraseña para acceder al archivo: ");
                    String contraseñaUsuario = scanner.nextLine();
                    if (comprobarContraseña(contraseñaUsuario)) {
                        System.out.println("Contraseña correcta. Acceso concedido.");
                    } else {
                        System.out.println("Contraseña incorrecta. Acceso denegado.");
                    }
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }

        scanner.close();
    }

    // Método para guardar la contraseña en un archivo
    private static void guardarContraseñaEnArchivo(String contraseña) {
        try (PrintWriter writer = new PrintWriter("contrasena.txt")) {
            writer.println(contraseña);
        } catch (FileNotFoundException e) {
            System.err.println("Error al guardar la contraseña en el archivo: " + e.getMessage());
        }
    }

    // Método para comprobar la contraseña ingresada con la almacenada en el archivo
    private static boolean comprobarContraseña(String contraseñaUsuario) {
        try (BufferedReader reader = new BufferedReader(new FileReader("contrasena.txt"))) {
            String contraseñaAlmacenada = reader.readLine();
            return contraseñaUsuario.equals(contraseñaAlmacenada);
        } catch (IOException e) {
            System.err.println("Error al leer la contraseña del archivo: " + e.getMessage());
            return false;
        }
    }
}