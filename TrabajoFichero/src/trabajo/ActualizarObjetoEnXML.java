package trabajo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;


public class ActualizarObjetoEnXML {
	
    public static void escribirXML(Videojuego videojuegoAEscribir) {
    	
        try {
            // Paso 1: Obtén el documento XML existente
          
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("coleccionvideojuegos.xml");
    		

            // Paso 2: Obtén el elemento raíz
            NodeList listaID = doc.getElementsByTagName("id");
            System.out.println("Tamaño de la nodelist de id: "+listaID.getLength());
            
            Node juegoAEscribirEnXML = listaID.item(videojuegoAEscribir.getID()).getParentNode();
            escribirDatos(videojuegoAEscribir, factory, builder, doc, juegoAEscribirEnXML);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void escribirDatos(Videojuego videojuegoAEscribir,DocumentBuilderFactory factory, DocumentBuilder builder, Document doc, Node juegoAEscribirEnXML){
    	
    	try {
    		
    	NodeList hijosVideojuego = juegoAEscribirEnXML.getChildNodes();
    	
    	Node idNode = hijosVideojuego.item(1);
    	Node tituloNode = hijosVideojuego.item(2);
        Node desarrolladorNode = hijosVideojuego.item(3);
        Node directorNode = hijosVideojuego.item(4);
        Node productorNode = hijosVideojuego.item(5);
        Node generoNode = hijosVideojuego.item(6);
        Node subgeneroNode = hijosVideojuego.item(7);
        Node pegiNode = hijosVideojuego.item(8);
        Node annoNode = hijosVideojuego.item(9);
        Node plataformaNode = hijosVideojuego.item(10);
        //Node jugadoresNode = hijosVideojuego.item(10);
        
        
        NodeList mesesEnero = doc.getElementsByTagName("enero");
        Node jugadoresNode = mesesEnero.item(videojuegoAEscribir.getID()).getParentNode();
        
        
        System.out.println("longitud nodo meses: "+jugadoresNode.getChildNodes().getLength());
        
        
        
        idNode.setTextContent(Integer.toString(videojuegoAEscribir.getID()));
        
        tituloNode.setTextContent(videojuegoAEscribir.getTitulo()); //nuevo titulo
        
        desarrolladorNode.setTextContent(videojuegoAEscribir.getDesarrollador()); //nuevo desarrollador
        
        directorNode.setTextContent(videojuegoAEscribir.getDirector()); //nuevo director
        
        productorNode.setTextContent(videojuegoAEscribir.getProductor()); //nuevo productor
        
        generoNode.setTextContent(videojuegoAEscribir.getGenero().toString()); // Nuevo genero
        
        subgeneroNode.setTextContent(videojuegoAEscribir.getSubgenero().toString()); // Nuevo subgenero
        
        pegiNode.setTextContent(Integer.toString(videojuegoAEscribir.getPegi())); // Nuevo valor del PEGI
        
        annoNode.setTextContent(Integer.toString(videojuegoAEscribir.getAnno())); // Nuevo año
        
        plataformaNode.setTextContent(videojuegoAEscribir.getPlataforma()); // Nuevas plataformas
        
        
        
        for (int i = 1; i < 13; i++) {
            
        	switch(i) {
            case 1:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getEnero())));
                break;
            case 2:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getFebrero())));
                break;
            case 3:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getMarzo())));
                break;
            case 4:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getAbril())));
                break;
            case 5:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getMayo())));
                break;
            case 6:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getJunio())));
                break;
            case 7:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getJulio())));
                break;
            case 8:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getAgosto())));
                break;
            case 9:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getSeptiembre())));
                break;
            case 10:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getOctubre())));
                break;
            case 11:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getNoviembre())));
                break;
            case 12:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getDiciembre())));
                break;
        	}
        }
        


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