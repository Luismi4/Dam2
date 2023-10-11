package trabajo;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CrearXML {
	 public static void CrearXML() {
		 try {
			    // Crea un objeto DocumentBuilderFactory
			    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			    
			    // Crea un objeto DocumentBuilder
			    DocumentBuilder builder = factory.newDocumentBuilder();
			    
			    // Crea un nuevo documento XML
			    Document document = builder.newDocument();
			    
			    // Crea el elemento ra�z
			    Element raiz = document.createElement("videojuegos");
			    
			    // Agrega el elemento ra�z al documento
			    document.appendChild(raiz);
			    
			    // Crea elementos y atributos
			    Element videojuego = document.createElement("videojuego");
			    Element id = document.createElement("id");
			    Element titulo = document.createElement("titulo");
			    Element desarrollador = document.createElement("desarrollador");
			    Element director = document.createElement("director");
			    Element productor = document.createElement("productor");
			    Element genero = document.createElement("genero");
			    Element subgenero = document.createElement("subgenero");
			    Element pegi = document.createElement("pegi");
			    Element anno = document.createElement("anno");
			    Element plataforma = document.createElement("plataforma");
			    Element jugadores = document.createElement("jugadores");
			    Element enero = document.createElement("enero");
			    Element febrero = document.createElement("febrero");
			    Element marzo = document.createElement("marzo");
			    Element abril = document.createElement("abril");
			    Element mayo = document.createElement("mayo");
			    Element junio = document.createElement("junio");
			    Element julio = document.createElement("julio");
			    Element agosto = document.createElement("agosto");
			    Element sebtiembre= document.createElement("septiembre");
			    Element octubre = document.createElement("octubre");
			    Element noviembre = document.createElement("noviembre");			    
			    Element diciembre = document.createElement("diciembre");
			    

			    // Agrega elementos hijos al elemento ra�z
			    videojuego.appendChild(id);
			    videojuego.appendChild(titulo);
			    videojuego.appendChild(desarrollador);
			    videojuego.appendChild(director);
			    videojuego.appendChild(productor);
			    videojuego.appendChild(genero);
			    genero.appendChild(subgenero);
			    videojuego.appendChild(pegi);
			    videojuego.appendChild(anno);
			    videojuego.appendChild(plataforma);
			    videojuego.appendChild(jugadores);
			    jugadores.appendChild(enero);
			    jugadores.appendChild(febrero);
			    jugadores.appendChild(marzo);
			    jugadores.appendChild(abril);
			    jugadores.appendChild(mayo);
			    jugadores.appendChild(junio);
			    jugadores.appendChild(julio);
			    jugadores.appendChild(agosto);
			    jugadores.appendChild(sebtiembre);
			    jugadores.appendChild(octubre);
			    jugadores.appendChild(noviembre);
			    jugadores.appendChild(diciembre);
			    raiz.appendChild(videojuego);
			    
			    
			    
			    
			    // Crea un objeto Transformer para escribir el archivo XML
			    TransformerFactory transformerFactory = TransformerFactory.newInstance();
			    Transformer transformer = transformerFactory.newTransformer();
			    
			    // Crea un objeto DOMSource para el documento
			    DOMSource source = new DOMSource(document);
			    
			    // Crea un objeto StreamResult para el archivo XML de salida
			    File archivoXML = new File("coleccionvideojuegos.xml");
			    StreamResult result = new StreamResult(archivoXML);
			    
			    // Transforma el documento a un archivo XML
			    transformer.transform(source, result);
			    
			    System.out.println("Archivo XML creado correctamente en " + archivoXML.getAbsolutePath());
			    
			} catch (Exception e) {
			    e.printStackTrace();
			}

	 }

}
