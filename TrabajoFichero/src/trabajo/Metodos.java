package trabajo;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void NumJugadores(ArrayList<Videojuego> arrayListVideojuego) {
		System.out.println("Introduzca ID del videojuego que quiera consultar los espectadores: ");
		int id = sc.nextInt();
		for (Videojuego videojuego : arrayListVideojuego) {
			if (videojuego.getID()==id) {
				
				System.out.println("De que mes desea consultar los espectadores?");
				String mes = sc.next().toLowerCase();
				int jugadoresMes=0;
				
				try {
				
				switch(mes) {
				case "enero":
			        jugadoresMes = videojuego.getJugadores().getEnero();
			        break;
			    case "febrero":
			        jugadoresMes = videojuego.getJugadores().getFebrero();
			        break;
			    case "marzo":
			        jugadoresMes = videojuego.getJugadores().getMarzo();
			        break;
			    case "abril":
			        jugadoresMes = videojuego.getJugadores().getAbril();
			        break;
			    case "mayo":
			        jugadoresMes = videojuego.getJugadores().getMayo();
			        break;
			    case "junio":
			        jugadoresMes = videojuego.getJugadores().getJunio();
			        break;
			    case "julio":
			        jugadoresMes = videojuego.getJugadores().getJulio();
			        break;
			    case "agosto":
			        jugadoresMes = videojuego.getJugadores().getAgosto();
			        break;
			    case "septiembre":
			        jugadoresMes = videojuego.getJugadores().getSeptiembre();
			        break;
			    case "octubre":
			        jugadoresMes = videojuego.getJugadores().getOctubre();
			        break;
			    case "noviembre":
			        jugadoresMes = videojuego.getJugadores().getNoviembre();
			        break;
			    case "diciembre":
			        jugadoresMes = videojuego.getJugadores().getDiciembre();
			        break;
			    default:
			        System.out.println("Mes no valido");
		    	}
				
				}catch(Exception e) {
					System.out.println("Por favor, introduzca un mes correcto.");
				}
				
				int total = videojuego.getJugadores().getEnero() +
		                videojuego.getJugadores().getFebrero() +
		                videojuego.getJugadores().getMarzo() +
		                videojuego.getJugadores().getAbril() +
		                videojuego.getJugadores().getMayo() +
		                videojuego.getJugadores().getJunio() +
		                videojuego.getJugadores().getJulio() +
		                videojuego.getJugadores().getAgosto() +
		                videojuego.getJugadores().getSeptiembre() +
		                videojuego.getJugadores().getOctubre() +
		                videojuego.getJugadores().getNoviembre() +
		                videojuego.getJugadores().getDiciembre();
				
				int media = total/12;
				
				System.out.println(videojuego.getTitulo()+": jugadores en " + mes + ": " + jugadoresMes + "; total de jugadores: " + total + "; media anual: " + media + ".");
				
			}
		}
		
		
		
	}
	
	public static Videojuego editarVideojuego(ArrayList<Videojuego> arrayListVideojuego) {
		System.out.println("Introduzca ID del videojuego que quiera editar: ");
		int id = sc.nextInt();
		for (Videojuego videojuego : arrayListVideojuego) {
			if (videojuego.getID()==id) {
				
				System.out.println("Elija el atributo que desee editar:\n\n"
						+ "1. Titulo\n"
						+ "2. Desarrollador\n"
						+ "3. Director\n"
						+ "4. Productor\n"
						+ "5. Genero\n"
						+ "6. Subgenero\n"
						+ "7. Pegi\n"
						+ "8. Anno\n"
						+ "9. Plataforma\n"
						+ "10. Jugadores");
				
				int opcion = sc.nextInt();

		        switch (opcion) {
		            case 1:
		                System.out.println("Introduzca el nuevo título:");
		                sc.nextLine(); // Limpiar el buffer del scanner antes de leer la línea
		                String nuevoTitulo = sc.nextLine();
		                videojuego.setTitulo(nuevoTitulo);
		                break;
		            case 2:
		                System.out.println("Introduzca el nuevo desarrollador:");
		                sc.nextLine();
		                String nuevoDesarrollador = sc.nextLine();
		                videojuego.setDesarrollador(nuevoDesarrollador);
		                break;
		            case 3:
		                System.out.println("Introduzca el nuevo director:");
		                sc.nextLine();
		                String nuevoDirector = sc.nextLine();
		                videojuego.setDirector(nuevoDirector);
		                break;
		            case 4:
		                System.out.println("Introduzca el nuevo productor:");
		                sc.nextLine();
		                String nuevoProductor = sc.nextLine();
		                videojuego.setProductor(nuevoProductor);
		                break;
		            case 5:
		                System.out.println("Introduzca el nuevo género:");
		                sc.nextLine();
		                String nuevoGenero = sc.nextLine();
		                Genero genero = Genero.valueOf(nuevoGenero);
		                videojuego.setGenero(genero);
		                break;
		            case 6:
		                System.out.println("Introduzca el nuevo subgénero:");
		                sc.nextLine();
		                String nuevoSubgenero = sc.nextLine();
		                Subgenero subgenero = Subgenero.valueOf(nuevoSubgenero);
		                videojuego.setSubgenero(subgenero);
		                break;
		            case 7:
		                System.out.println("Introduzca el nuevo PEGI:");
		                int nuevoPegi = sc.nextInt();
		                videojuego.setPegi(nuevoPegi);
		                break;
		            case 8:
		                System.out.println("Introduzca el nuevo año:");
		                int nuevoAnno = sc.nextInt();
		                videojuego.setAnno(nuevoAnno);
		                break;
		            case 9:
		                System.out.println("Introduzca la nueva plataforma:");
		                sc.nextLine();
		                String nuevaPlataforma = sc.nextLine();
		                videojuego.setPlataforma(nuevaPlataforma);
		                break;
		            case 10:
		                System.out.println("Introduzca el nuevo número de jugadores:");
		                Jugadores nuevosJugadores = new Jugadores();
		                int jugadores=0;
		                for (int i = 0; i < 12; i++) {
		                    System.out.print("Introduzca la cantidad de jugadores para el mes" + (i + 1) + ": ");
		                    jugadores=sc.nextInt();
		                    switch (i) {
		                            case 0:
		                            	nuevosJugadores.setEnero(jugadores);
		                                break;
		                            case 1:
		                            	nuevosJugadores.setFebrero(jugadores);
		                                break;
		                            case 2:
		                            	nuevosJugadores.setMarzo(jugadores);
		                                break;
		                            case 3:
		                            	nuevosJugadores.setAbril(jugadores);
		                                break;
		                            case 4:
		                            	nuevosJugadores.setMayo(jugadores);
		                                break;
		                            case 5:
		                            	nuevosJugadores.setJunio(jugadores);
		                                break;
		                            case 6:
		                            	nuevosJugadores.setJulio(jugadores);
		                                break;
		                            case 7:
		                            	nuevosJugadores.setAgosto(jugadores);
		                                break;
		                            case 8:
		                            	nuevosJugadores.setSeptiembre(jugadores);
		                                break;
		                            case 9:
		                            	nuevosJugadores.setOctubre(jugadores);
		                                break;
		                            case 10:
		                            	nuevosJugadores.setNoviembre(jugadores);
		                                break;
		                            case 11:
		                            	nuevosJugadores.setDiciembre(jugadores);
		                                break;
		                            default:
		                                System.out.println("Mes no válido");
		                                break;
		                        }
		                    }
		                    
		                
		                videojuego.setJugadores(nuevosJugadores);
		                break;
		            default:
		                System.out.println("Opción no válida");
		        }
		        
		        System.out.println("Datos del videojuego actualizados:\n"
		        		+ ""+videojuego.toString());
		        
		        for (Videojuego juego : arrayListVideojuego) {
					if (juego.getID()==id) juego = videojuego;
				}
		        
		        return videojuego;
				
			}
		}
		return null;
		
		
        
	}

}
