package ejemploPeorCaso;

public class Eje {

    public static int sumaElementos(int[] arr) {
        int suma = 0;
        for (int elemento : arr) {
            suma += elemento;
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] arrayEjemplo = {1, 2, 3, 4, 5};
        int resultado = sumaElementos(arrayEjemplo);
        System.out.println("Resultado de la suma: " + resultado);
    }
}
