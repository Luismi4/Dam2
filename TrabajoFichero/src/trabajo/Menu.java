package trabajo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
    public static Scanner scanner = new Scanner(System.in);
	
	public static void MenuVideojuegos() {
		
		ArrayList<Videojuego> videojuegos = CompruebaXML();
		
        while (true) {
        	
        	
            System.out.println("Videojuego Menu:");
            System.out.println("1. Añadir Videojuego");
            System.out.println("2. Actualizar Videojuego");
            System.out.println("3. Eliminar Videojuego");
            System.out.println("4. Listar Videojuegos");
            System.out.println("5. Resetear XML por defecto");
            System.out.println("6. Consultar numero de jugadores");
            System.out.println("8. Salir");
            
            System.out.print("Elija una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                	Videojuego nuevoVideojuego = crearVideojuego(scanner);
                    videojuegos.add(nuevoVideojuego);
                    System.out.println("Videojuego añadido.");
                    CrearXML2.CrearXML2(videojuegos);
                    break;
                case 2:
                	Videojuego videojuegoAEditar = Metodos.editarVideojuego(videojuegos);
                	ActualizarObjetoEnXML.escribirXML(videojuegoAEditar);
                	break;
                case 3:
                	eliminarVideojuego(videojuegos);
                    break;
                case 4:
                	for (Videojuego juego : videojuegos) System.out.println(juego.toString());
                    break;
                case 5:
                	ResetearXML.ResetearXML2(videojuegos);
                	break;
                case 6:
                	Metodos.NumJugadores(videojuegos);
                	break;
                case 8:
                	System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                	break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
		
	}
	
	
	private static ArrayList<Videojuego> CompruebaXML() {
	
		String filePath = "coleccionvideojuegos.xml";

        // Crea un objeto File con la ruta especificada
        File file = new File(filePath);

        // Verifica si el archivo o directorio existe
        if (file.exists()) {
            System.out.println("El archivo o directorio existe.");
            ArrayList<Videojuego> videojuegos = LeerXML.leerXML();
            return videojuegos;
        } else {
            System.out.println("El archivo o directorio no existe.");
            System.out.println("Pulsa enter para crear un XML con valores por defecto.");
            ArrayList<Videojuego> videojuegos = new ArrayList<Videojuego>();
            ResetearXML.ResetearXML2(videojuegos);
            return videojuegos;
        }
		
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
	    for (Genero g : Genero.values()) {
	        System.out.println(g);
	    }
	    System.out.print("Elija un género: ");
	    Genero generoSeleccionado = Genero.valueOf(scanner.nextLine());

	    System.out.println("Subgénero:");
	    for (Subgenero sg : Subgenero.values()) {
	        System.out.println(sg);
	    }
	    System.out.print("Elija un subgénero: ");
	    Subgenero subgeneroSeleccionado = Subgenero.valueOf(scanner.nextLine());

	    System.out.print("PEGI: ");
	    int pegi = scanner.nextInt();
	    scanner.nextLine(); 

	    System.out.print("Año de lanzamiento: ");
	    int anno = scanner.nextInt();
	    scanner.nextLine();

	    System.out.print("Plataforma (separadas por comas si son varias): ");
	    String plataforma = scanner.nextLine();
	    
	    System.out.println("Jugadores por mes:");
	    int[]meses=new int[12];
	    
	    for (int i=0; i<12; i++) {
	    	System.out.println("Jugadores del mes "+(i+1)+":");
		    meses[i]=scanner.nextInt();
	     }
	    
	    Jugadores jugadores = new Jugadores(meses[0], meses[1], meses[2], meses[3], meses[4], meses[5], 
	    		meses[6], meses[7], meses[8], meses[9], meses[10], meses[11]);

	    return new Videojuego(titulo, desarrollador, director, productor, generoSeleccionado, subgeneroSeleccionado,
	            pegi, anno, plataforma, jugadores);
    	}


	public static void eliminarVideojuego(ArrayList<Videojuego> videojuegos) {
        
        System.out.print("Elija el id del Videojuego a eliminar: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < videojuegos.size()) {
            for (Videojuego juego : videojuegos) {
            	if (juego.getID()==index) {
            		juego.setTitulo("---");
            		juego.setDesarrollador("---");
            		juego.setDirector("---");
            		juego.setProductor("---");
            		juego.setGenero(Genero.sinGenero);
            		juego.setSubgenero(Subgenero.sinSubgenero);
            		juego.setPegi(0);
            		juego.setAnno(0);
            		juego.setPlataforma("---");
            		Jugadores jugadores = new Jugadores(0,0,0,0,0,0,0,0,0,0,0,0);
            		juego.setJugadores(jugadores);
            		ActualizarObjetoEnXML.escribirXML(juego);
            	}
            }
        } else {
            System.out.println("Índice no válido.");
        }
    }
    
       
}