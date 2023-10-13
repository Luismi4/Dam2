package trabajo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.File;


public class ActualizarObjetoEnXML {
	
	private static int nodo;
	private static boolean flag;
    private static Node idNode;
	
    public static void escribirXML(Videojuego videojuegoAEscribir) {
    	
        try {
            // Paso 1: Obtén el documento XML existente
            
            nodo=0;
            flag=false;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
    			doc = builder.parse(new File("coleccionvideojuegos.xml"));
    		

            // Paso 2: Obtén el elemento raíz
            Element rootElement = doc.getDocumentElement();
       
            
            while(!flag) {
            	
            	

            // Paso 3: Busca y actualiza los elementos hijos si ya existen
         // Obtener nodos para los atributos de Videojuego
            idNode = rootElement.getElementsByTagName("id").item(nodo); //annadir un id a los videojuegos para cambiar
            																		//el nombre
            
            if (idNode!=null) {
            if (idNode.toString().equals(String.valueOf(videojuegoAEscribir.getID()))) {
            	
            	escribirDatos(videojuegoAEscribir, factory, builder, doc, rootElement, idNode);
            	flag=true;
            
            }else
            nodo++;
            } else 
            	nodo++;
         
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void escribirDatos(Videojuego videojuegoAEscribir,DocumentBuilderFactory factory, DocumentBuilder builder, Document doc, Element rootElement, Node idNode){
    	
    	try {
    	
    	Node tituloNode = rootElement.getElementsByTagName("titulo").item(nodo);
        Node desarrolladorNode = rootElement.getElementsByTagName("desarrollador").item(nodo);
        Node directorNode = rootElement.getElementsByTagName("director").item(nodo);
        Node productorNode = rootElement.getElementsByTagName("productor").item(nodo);
        Node generoNode = rootElement.getElementsByTagName("genero").item(nodo);
        Node subgeneroNode = generoNode.getFirstChild();
        Node pegiNode = rootElement.getElementsByTagName("pegi").item(nodo);
        Node annoNode = rootElement.getElementsByTagName("anno").item(nodo);
        Node plataformaNode = rootElement.getElementsByTagName("plataforma").item(nodo);
        Node jugadoresNode = rootElement.getElementsByTagName("jugadores").item(nodo);
       
        
        
        for (int i = 0; i < 12; i++) {
        
        	switch(i) {
            case 0:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getEnero())));
                break;
            case 1:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getFebrero())));
                break;
            case 2:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getMarzo())));
                break;
            case 3:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getAbril())));
                break;
            case 4:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getMayo())));
                break;
            case 5:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getJunio())));
                break;
            case 6:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getJulio())));
                break;
            case 7:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getAgosto())));
                break;
            case 8:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getSeptiembre())));
                break;
            case 9:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getOctubre())));
                break;
            case 10:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getNoviembre())));
                break;
            case 11:
            	jugadoresNode.getChildNodes().item(i).setTextContent(String.valueOf((videojuegoAEscribir.getJugadores().getDiciembre())));
                break;
            default:
                System.out.println("Mes no válido");
        	}
        }
        
        idNode.setTextContent(String.valueOf(videojuegoAEscribir.getID()));
        
        tituloNode.setTextContent(videojuegoAEscribir.getTitulo()); //nuevo titulo
        
        desarrolladorNode.setTextContent(videojuegoAEscribir.getDesarrollador()); //nuevo desarrollador
        
        directorNode.setTextContent(videojuegoAEscribir.getDirector()); //nuevo director
        
        productorNode.setTextContent(videojuegoAEscribir.getProductor()); //nuevo productor
        
        pegiNode.setTextContent(Integer.toString(videojuegoAEscribir.getPegi())); // Nuevo valor del PEGI
        
        annoNode.setTextContent(Integer.toString(videojuegoAEscribir.getAnno())); // Nuevo año
        
        plataformaNode.setTextContent(videojuegoAEscribir.getPlataforma()); // Nuevas plataformas
        
        generoNode.setTextContent(videojuegoAEscribir.getGenero().toString()); // Nuevo genero
        
        subgeneroNode.setTextContent(videojuegoAEscribir.getSubgenero().toString()); // Nuevo subgenero
        


        // Paso 4: Guarda el documento XML modificado en un archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("coleccionvideojuegos.xml"));
        transformer.transform(source, result);

        System.out.println("Datos actualizados en el archivo XML.");
        
        
    	} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}