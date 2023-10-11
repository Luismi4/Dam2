package trabajo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LeerXML {

    public static void LeerXML() {

        try {

            // Crear un objeto DocumentBuilderFactory

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();



            // Crear un objeto DocumentBuilder

            DocumentBuilder builder = factory.newDocumentBuilder();



            // Parsear el archivo XML

            Document document = builder.parse("coleccionvideojuegos.xml");



            // Obtener la lista de elementos 'libro'

            NodeList listaVideojuegos = document.getElementsByTagName("Videojuegos");

            int[] jugadores = new int[12]; //un mes por casilla del array

            // Iterar a través de la lista de libros

            for (int i = 0; i < listaVideojuegos.getLength(); i++) {

            	Element videojuego = (Element) listaVideojuegos.item(i);

            	String titulo = videojuego.getElementsByTagName("titulo").item(0).getTextContent();

            	String desarrollador = videojuego.getElementsByTagName("desarrollador").item(0).getTextContent();

            	String director = videojuego.getElementsByTagName("director").item(0).getTextContent();

            	String productor = videojuego.getElementsByTagName("productor").item(0).getTextContent();

            	genero genero = trabajo.genero.valueOf(videojuego.getElementsByTagName("genero").item(0).getTextContent());

            	subgenero subgenero = trabajo.subgenero.valueOf(videojuego.getElementsByTagName("subgenero").item(1).getTextContent());

            	int pegi = Integer.parseInt(videojuego.getElementsByTagName("pegi").item(0).getTextContent());

            	int anno = Integer.parseInt(videojuego.getElementsByTagName("anno").item(0).getTextContent());

            	String plataforma = videojuego.getElementsByTagName("plataforma").item(0).getTextContent();

            	//jugadores[0];



            	System.out.println("Título: " + titulo);

            	System.out.println("Desarrollador: " + desarrollador);

            	System.out.println("Director: " + director);

            	System.out.println("Productor: " + productor);

            	System.out.println("Género: " + genero);

            	System.out.println("Subgénero: " + subgenero);

            	System.out.println("PEGI: " + pegi);

            	System.out.println("Año de lanzamiento: " + anno);

            	System.out.println("Plataforma: " + plataforma);

            	System.out.print("Jugadores: ");

            	/*for (String jugador : jugador) {

            	    System.out.print(jugadores + " ");

            	}*/

            	System.out.println();



                System.out.println("----------------------");

                

            	System.out.println();



            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
