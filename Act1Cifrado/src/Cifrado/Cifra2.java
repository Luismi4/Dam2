package Cifrado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Cifra2 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contraseñaAlmacenada = cargarHashDesdeArchivo("contrasena2.txt");

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            boolean salir = false;

            while (!salir) {
                System.out.println("Menú:");
                System.out.println("1. Establecer una nueva contraseña");
                System.out.println("2. Ingresar contraseña para acceder");
                System.out.println("3. Salir");
                System.out.print("Elija una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.print("Establecer la nueva contraseña: ");
                        String nuevaContraseña = scanner.nextLine();


                        contraseñaAlmacenada = calcularHash(md, nuevaContraseña);
                        guardarHashEnArchivo(contraseñaAlmacenada, "contrasena2.txt");
                        System.out.println("Contraseña encriptada y guardada en el archivo.");
                        break;
                    case 2:
                        if (contraseñaAlmacenada != null) {
                            System.out.print("Ingrese la contraseña para acceder al archivo: ");
                            String contraseñaUsuario = scanner.nextLine();


                            String hashContraseñaUsuario = calcularHash(md, contraseñaUsuario);

                            if (hashContraseñaUsuario.equals(contraseñaAlmacenada)) {
                                System.out.println("Contraseña correcta. Acceso concedido.");
                            } else {
                                System.out.println("Contraseña incorrecta. Acceso denegado.");
                            }
                        } else {
                            System.out.println("Primero debe establecer una contraseña.");
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
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al crear MessageDigest: " + e.getMessage());
        }

        scanner.close();
    }


    private static String calcularHash(MessageDigest md, String contraseña) {
        byte[] hashBytes = md.digest(contraseña.getBytes());

        StringBuilder hashHex = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hashHex.append('0');
            }
            hashHex.append(hex);
        }

        return hashHex.toString();
    }

    private static void guardarHashEnArchivo(String hash, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            writer.println(hash);
        } catch (FileNotFoundException e) {
            System.err.println("Error al guardar el hash en el archivo: " + e.getMessage());
        }
    }

    private static String cargarHashDesdeArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error al cargar el hash desde el archivo: " + e.getMessage());
            return null;
        }
    }
}
