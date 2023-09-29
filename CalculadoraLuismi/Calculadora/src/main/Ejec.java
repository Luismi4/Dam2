package main;
import java.util.InputMismatchException;
import java.text.DecimalFormat;
import java.util.*;
public class Ejec {
//comentario de prueba
	static Scanner leer = new Scanner(System.in);
	static double num1, num2, res;
	static int opc = 0;
	static DecimalFormat decimalFormat = new DecimalFormat("#.##########");
	public static void menu() {
			 do {
					System.out.println("¿Que desea hacer?");
					System.out.println("1. Suma	/	"
						+ "2. Resta	/	"
						+ "3. Multiplicacion	/	"
						+ "4. Division	/	"
						+ "5. Raíz cuadrada	/	"
						+ "6. Calcular Raiz	/	"
						+ "7. Salir");
					System.out.println("Introduzca el numero de la eleccion");
					
					try {
						opc = leer.nextInt();
						if(opc == 1) {
							Suma();
						}else if(opc == 2) {
							Resta();
						}else if(opc == 3) {
							Multi();
						}else if(opc == 4) {
							Divi();
						}else if(opc == 5) {
							RaizCuadrada();
						}else if(opc == 6) {
							CalcularRaiz();
						}if(opc == 7) {
							System.out.println("Saliendo de la calculadora");
							break;
						}
					}catch (InputMismatchException e) {
		                System.out.println("Error: Entrada no válida. Intente nuevamente.");
		                leer.nextLine();
					}

				}while(opc<1 || opc>6);
			leer.close();
		
	}
	
	public static void IntrodNum() {
		System.out.println("Introduce el primer numero");
		num1 = leer.nextDouble();
		System.out.println("Introducir el segundo numero");
		num2 = leer.nextDouble();
	}
	
	private static void Divi() {
		IntrodNum();
		if(num2 == 0) {
			System.out.println("No se puede dividir, ya que daria infinito");
		}else {
			res = num1 / num2;
		}
		MostRes();
	}

	private static void Multi() {
		IntrodNum();	
		res = num1 * num2;
		MostRes();
	}

	private static void Resta() {
		IntrodNum();	
		res = num1 - num2;
		MostRes();
	}

	private static void Suma() {
		IntrodNum();	
		res = num1 + num2;
		MostRes();
	}
	
	public static void RaizCuadrada() {
		
		NumRaiz();
		if (num1 < 0) {
            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
        } else {
            res = Math.sqrt(num1);
            MostRes();
        }
	}
	
	public static void CalcularRaiz() {
		System.out.println("Introduce los numeros teniendo en cuenta que el primero es la base y el segundo la potencia");
		IntrodNum();
		if (num1 < 0 && num2 % 2 == 0) {
            System.out.println("Error: No se puede calcular una raíz par de un número negativo.");
        } else {
            res = Math.pow(num1, 1.0 / num2);
            MostRes();
        }
	}
	
	public static void NumRaiz() {
		System.out.println("Introduce el numero");
		num1 = leer.nextDouble();
	}

	public static void MostRes() {
		System.out.println("El resultado es " + decimalFormat.format(res));
	}
	
	public static void main(String[] args) {
		
			menu();
		
	}

}
