package Cont_Usu;
import java.util.*;
public class Eje {

	static Scanner leer = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		Usuario[] usu = new Usuario[10];
		String nombre = null, contra = null;
		
		int opc, contusu = 0;
		
		do {
            System.out.println("----- MENÚ DE INICIO DE SESIÓN Y REGISTRO -----");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Por favor, seleccione una opción ingresando el número correspondiente: ");
            opc = leer.nextInt();
            
            if(opc == 1) {
            	leer.nextLine();
            	System.out.println("Introduzca el nombre de usuario");
            	nombre = leer.nextLine();
            	System.out.println("Introduzca la contraseña");
            	contra = leer.nextLine();
            	if (iniciarSesion(usu, nombre, contra)) {
                    System.out.println("Inicio de sesión exitoso.");
                } else {
                    System.out.println("Inicio de sesión fallido. Verifique su nombre de usuario y contraseña.");
                }
            	}else if(opc == 2) {     	
	            	if (contusu < usu.length) {
	           		 leer.nextLine(); // Consumir el salto de línea pendiente
	                    System.out.print("Ingrese un nombre de usuario: ");
	                    nombre = leer.nextLine();
	                    System.out.print("Ingrese una contraseña: ");
	                    contra = leer.nextLine();
	                    Usuario NewUsu = new Usuario(nombre, contra);
	                    usu[contusu] = NewUsu;
	                    contusu++;
	                    System.out.println("Registro exitoso.");
	            	} else {
                    System.out.println("La capacidad máxima de usuarios ha sido alcanzada.");
	            	}
	            }else if(opc == 3) {
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                break;
	            }
		}while(opc != 3);
	}
	
	static boolean iniciarSesion(Usuario[] NewUsu, String nombreUsuario, String contraseñaUsuario) {
        for (Usuario usuario : NewUsu) {
            if (usuario != null && usuario.nombre.equals(nombreUsuario) && usuario.contra.equals(contraseñaUsuario)) {
                return true;
            }
        }
        return false;
    }

}
