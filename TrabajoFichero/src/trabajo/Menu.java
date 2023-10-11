package trabajo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static ArrayList<Videojuego> videojuegos = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
	
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
                    CrearXML();
                    break;
                case 2:
                	Videojuego nuevoVideojuego = crearVideojuego(scanner);
                    videojuegos.add(nuevoVideojuego);
                    System.out.println("Videojuego añadido.");
                case 3:
                    actualizarVideojuego(scanner, videojuegos);
                    break;
                case 4:
                    eliminarVideojuego(scanner, videojuegos);
                    break;
                case 5:
                	LeerXML();
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
	
	private static Videojuego crearVideojuego(Scanner scanner) {
		System.out.println("Creación de un nuevo Videojuego:");

	    System.out.print("Título: ");
	    String titulo = scanner.nextLine();

	    System.out.print("Desarrollador: ");
	    String desarrollador = scanner.nextLine();

	    System.out.print("Director: ");
	    String director = scanner.nextLine();

	    System.out.print("Productor: ");
	    String productor = scanner.nextLine();

	    System.out.println("Género:");
	    for (genero g : genero.values()) {
	        System.out.println(g);
	    }
	    System.out.print("Elija un género: ");
	    genero generoSeleccionado = genero.valueOf(scanner.nextLine());

	    System.out.println("Subgénero:");
	    for (subgenero sg : subgenero.values()) {
	        System.out.println(sg);
	    }
	    System.out.print("Elija un subgénero: ");
	    subgenero subgeneroSeleccionado = subgenero.valueOf(scanner.nextLine());

	    System.out.print("PEGI: ");
	    int pegi = scanner.nextInt();
	    scanner.nextLine(); 

	    System.out.print("Año de lanzamiento: ");
	    int anno = scanner.nextInt();
	    scanner.nextLine();

	    System.out.print("Plataforma (separadas por comas): ");
	    String plataforma = scanner.nextLine();

	    int[] jugadores = new int[12];
	    for (int i = 0; i < 12; i++) {
	        System.out.print("Número de jugadores en el mes " + (i + 1) + ": ");
	        jugadores[i] = scanner.nextInt();
	    }

	    return new Videojuego(titulo, desarrollador, director, productor, generoSeleccionado, subgeneroSeleccionado,
	            pegi, anno, plataforma, jugadores);
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
