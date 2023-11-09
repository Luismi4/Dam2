package ejercicio3;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Eje {


	public static void main(String[] args) {
		JFrame frame = new JFrame("Gestión de Notas");
			
	    frame.setTitle("Aplicación con Botón");
	    frame.setSize(300, 200);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);

	    // Creación del botón
	    JButton botonMostrarFecha = new JButton("Mostrar Fecha");

	    // Manejo del evento de clic con una función lambda
	    botonMostrarFecha.addActionListener(e -> mostrarFechaActual(frame));

	    // Añadir el botón al contenido de la ventana
	    frame.getContentPane().add(botonMostrarFecha);

	    // Hacer visible la ventana
	    frame.setVisible(true);
	}

	private static void mostrarFechaActual(JFrame frame) {
		// Obtener la fecha actual
		Date fechaActual = new Date();

		// Formatear la fecha en el formato especificado
		SimpleDateFormat formatoFecha = new SimpleDateFormat(" hh:mm 'del' dd 'de' MMMM 'de' yyyy");
	    String fechaFormateada = formatoFecha.format(fechaActual);

	    // Mostrar el mensaje con la fecha formateada
	    JOptionPane.showMessageDialog(frame, "Las" + fechaFormateada);
	}
}
