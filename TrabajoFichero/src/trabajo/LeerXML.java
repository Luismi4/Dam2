package trabajo;

import javax.xml.parsers.DocumentBuilderFactory;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

public class LeerXML {
	
	static ArrayList<Videojuego> arrayListVideojuegos = new ArrayList<Videojuego>();
	

    public static ArrayList<Videojuego> leerXML() {

        try {

            // Crear un objeto DocumentBuilderFactory

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();



            // Crear un objeto DocumentBuilder

            DocumentBuilder builder = factory.newDocumentBuilder();



            // Parsear el archivo XML

            Document document = builder.parse("nuevo_ejemplo.xml");



            // Obtener la lista de elementos 'libro'

            NodeList listaVideojuegos = document.getElementsByTagName("Videojuegos");

            //int[] jugadores = new int[12]; //un mes por casilla del array

            // Iterar a través de la lista de libros

            for (int i = 0; i < listaVideojuegos.getLength(); i++) {

            	Element videojuego = (Element) listaVideojuegos.item(i);

            	String titulo = videojuego.getElementsByTagName("titulo").item(i).getTextContent();

            	String desarrollador = videojuego.getElementsByTagName("desarrollador").item(i).getTextContent();

            	String director = videojuego.getElementsByTagName("director").item(i).getTextContent();

            	String productor = videojuego.getElementsByTagName("productor").item(i).getTextContent();

            	genero generoEnum = genero.valueOf(videojuego.getElementsByTagName("genero").item(i).getTextContent());

            	subgenero subgeneroEnum = subgenero.valueOf(videojuego.getElementsByTagName("subgenero").item(i).getTextContent());

            	int pegi = Integer.parseInt(videojuego.getElementsByTagName("pegi").item(i).getTextContent());

            	int anno = Integer.parseInt(videojuego.getElementsByTagName("anno").item(i).getTextContent());

            	String plataforma = videojuego.getElementsByTagName("plataforma").item(i).getTextContent();

            	//jugadores[0]
            	
            	int enero = Integer.parseInt(videojuego.getElementsByTagName("enero").item(i).getTextContent());
            	// Supongamos que tienes un objeto videojuego de tipo Element.
            	// Obtén el contenido de cada mes y conviértelo a un valor entero.
            	int febrero = Integer.parseInt(videojuego.getElementsByTagName("febrero").item(i).getTextContent());
            	int marzo = Integer.parseInt(videojuego.getElementsByTagName("marzo").item(i).getTextContent());
            	int abril = Integer.parseInt(videojuego.getElementsByTagName("abril").item(i).getTextContent());
            	int mayo = Integer.parseInt(videojuego.getElementsByTagName("mayo").item(i).getTextContent());
            	int junio = Integer.parseInt(videojuego.getElementsByTagName("junio").item(i).getTextContent());
            	int julio = Integer.parseInt(videojuego.getElementsByTagName("julio").item(i).getTextContent());
            	int agosto = Integer.parseInt(videojuego.getElementsByTagName("agosto").item(i).getTextContent());
            	int septiembre = Integer.parseInt(videojuego.getElementsByTagName("septiembre").item(i).getTextContent());
            	int octubre = Integer.parseInt(videojuego.getElementsByTagName("octubre").item(i).getTextContent());
            	int noviembre = Integer.parseInt(videojuego.getElementsByTagName("noviembre").item(i).getTextContent());
            	int diciembre = Integer.parseInt(videojuego.getElementsByTagName("diciembre").item(i).getTextContent());

            	// Ahora tendrás los valores de cada mes como enteros.

            	
            	Jugadores jugadores = new Jugadores(enero,  febrero,  marzo,  abril,  mayo,  junio,  julio,  agosto,
			 septiembre,  octubre, noviembre,  diciembre);

            	


            	System.out.println("Título: " + titulo);

            	System.out.println("Desarrollador: " + desarrollador);

            	System.out.println("Director: " + director);

            	System.out.println("Productor: " + productor);

            	System.out.println("Género: " + generoEnum);

            	System.out.println("Subgénero: " + subgeneroEnum);

            	System.out.println("PEGI: " + pegi);

            	System.out.println("Año de lanzamiento: " + anno);

            	System.out.println("Plataforma: " + plataforma);

            	System.out.print("Jugadores: "+jugadores.toString());

            	/*for (String jugador : jugador) {

            	    System.out.print(jugadores + " ");

            	}*/

            	System.out.println();



                System.out.println("----------------------");

                

            	System.out.println();

            	Videojuego videojuegoObjeto = new Videojuego(titulo, desarrollador, director, productor, generoEnum,
            			subgeneroEnum, pegi, anno, plataforma, jugadores);

            	arrayListVideojuegos.add(videojuegoObjeto);
            	
            }

            return arrayListVideojuegos;
            
        } catch (Exception e) {

            e.printStackTrace();

        }
		return arrayListVideojuegos;

    }

}