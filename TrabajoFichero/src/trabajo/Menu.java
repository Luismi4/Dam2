package trabajo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static ArrayList<Videojuego> videojuegos = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Integer> numju = new ArrayList<Integer>();
	
 // Menú principal del programa
	public static void Menu() {
		
        while (true) {
            System.out.println("Videojuego Menu:");
            System.out.println("1. Crear XML");
            System.out.println("2. Añadir Videojuego");
            System.out.println("3. Actualizar Videojuego");
            System.out.println("4. Eliminar Videojuego");
            System.out.println("5. Leer Videojuegos");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CrearXML(); // Opción 1: Crear un archivo XML (no proporcionado en este fragmento)
                    break;
                case 2:
                	// Opción 2: Agregar un nuevo Videojuego al ArrayList
                case 3:
                    actualizarVideojuego(scanner, videojuegos); // Opción 3: Actualizar un Videojuego existente
                    break;
                case 4:
                    eliminarVideojuego(scanner, videojuegos); // Opción 4: Eliminar un Videojuego
                    break;
                case 5:
                	LeerXML(); // Opción 5: Leer Videojuegos desde XML
                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
		
	}
	
	private static void CrearXML() {
		CrearXML.CrearXML();
	}
	

    private static void actualizarVideojuego(Scanner scanner, ArrayList<Videojuego> videojuegos) {
        
    	System.out.println("Actualización de un Videojuego existente:");

        System.out.println("Lista de Videojuegos:");
        for (int i = 0; i < videojuegos.size(); i++) {
            System.out.println(i + ". " + videojuegos.get(i).getTitulo());
        }
        System.out.print("Elija el índice del Videojuego a actualizar: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < videojuegos.size()) {
            Videojuego videojuego = videojuegos.get(index);
            
            System.out.println("Seleccionó el Videojuego: " + videojuego.getTitulo());
            System.out.println("Opciones de actualización:");

            System.out.print("Nuevo Título (Deje en blanco para no cambiar): ");
            String nuevoTitulo = scanner.nextLine();
            if (!nuevoTitulo.isEmpty()) {
                videojuego.setTitulo(nuevoTitulo);
            }

            System.out.print("Nuevo Desarrollador (Deje en blanco para no cambiar): ");
            String nuevoDesarrollador = scanner.nextLine();
            if (!nuevoDesarrollador.isEmpty()) {
                videojuego.setDesarrollador(nuevoDesarrollador);
            }

            System.out.print("Nuevo Director (Deje en blanco para no cambiar): ");
            String nuevoDirector = scanner.nextLine();
            if (!nuevoDirector.isEmpty()) {
                videojuego.setDirector(nuevoDirector);
            }

            System.out.print("Nuevo Productor (Deje en blanco para no cambiar): ");
            String nuevoProductor = scanner.nextLine();
            if (!nuevoProductor.isEmpty()) {
                videojuego.setProductor(nuevoProductor);
            }
            
            System.out.println("Videojuego actualizado.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

    private static void eliminarVideojuego(Scanner scanner, ArrayList<Videojuego> videojuegos) {
        
        System.out.println("Lista de Videojuegos:");
        for (int i = 0; i < videojuegos.size(); i++) {
            System.out.println(i + ". " + videojuegos.get(i).getTitulo());
        }
        System.out.print("Elija el índice del Videojuego a eliminar: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < videojuegos.size()) {
            Videojuego videojuego = videojuegos.remove(index);
            System.out.println("Videojuego eliminado: " + videojuego.getTitulo());
        } else {
            System.out.println("Índice no válido.");
        }
    }
    
    private static void LeerXML() {
    	
    }
    
}
