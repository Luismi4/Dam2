package trabajo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CrearXML2 {
    public static void CrearXML2(ArrayList <Videojuego> videojuegosLista) {
        try {
            // Crear el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Crear el elemento raíz
            Element videojuegos = document.createElement("videojuegos");
            document.appendChild(videojuegos);

            // Agregar videojuegos
            
            for (Videojuego juego : videojuegosLista) {
            	
            	addVideojuego(document, videojuegos, String.valueOf(juego.getID()), juego.getTitulo(), juego.getDesarrollador(), juego.getDirector(), juego.getProductor(), String.valueOf(juego.getGenero()), String.valueOf(juego.getSubgenero()), String.valueOf(juego.getPegi()), String.valueOf(juego.getAnno()), juego.getPlataforma(), String.valueOf(juego.getJugadores().getEnero()), String.valueOf(juego.getJugadores().getFebrero()), String.valueOf(juego.getJugadores().getMarzo()), String.valueOf(juego.getJugadores().getAbril()), String.valueOf(juego.getJugadores().getMayo()), String.valueOf(juego.getJugadores().getJunio()), String.valueOf(juego.getJugadores().getJulio()), String.valueOf(juego.getJugadores().getAgosto()), String.valueOf(juego.getJugadores().getSeptiembre()), String.valueOf(juego.getJugadores().getOctubre()), String.valueOf(juego.getJugadores().getNoviembre()), String.valueOf(juego.getJugadores().getDiciembre()));
            	
            	
            }
            
            
            // Crear el transformador y escribir el documento a un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("coleccionvideojuegos.xml");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addVideojuego(Document document, Element parentElement, String id, String titulo, String desarrollador, String director, String productor, String genero, String subgenero, String pegi, String anno, String plataforma, String... jugadores) {
        Element videojuego = document.createElement("videojuego");
        parentElement.appendChild(videojuego);

        videojuego.appendChild(createElement(document, "id", id));
        videojuego.appendChild(createElement(document, "titulo", titulo));
        videojuego.appendChild(createElement(document, "desarrollador", desarrollador));
        videojuego.appendChild(createElement(document, "director", director));
        videojuego.appendChild(createElement(document, "productor", productor));
        videojuego.appendChild(createElement(document, "genero", genero));
        videojuego.appendChild(createElement(document, "subgenero", subgenero));
        videojuego.appendChild(createElement(document, "pegi", pegi));
        videojuego.appendChild(createElement(document, "anno", anno));
        videojuego.appendChild(createElement(document, "plataforma", plataforma));

        Element jugadoresElement = document.createElement("jugadores");
        videojuego.appendChild(jugadoresElement);

        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        for (int i = 0; i < meses.length; i++) {
            jugadoresElement.appendChild(createElement(document, meses[i], jugadores[i]));
        }
    }

    private static Element createElement(Document document, String elementName, String textContent) {
        Element element = document.createElement(elementName);
        element.appendChild(document.createTextNode(textContent));
        return element;
    }
}