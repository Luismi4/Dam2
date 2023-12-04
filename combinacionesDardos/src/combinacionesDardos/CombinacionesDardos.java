package combinacionesDardos;

public class CombinacionesDardos {

    public static void main(String[] args) {
        int[] regiones = {10, 25, 50, 75};
        int totalPuntos = 100;
        int numDardos = 5;

        encontrarCombinaciones(regiones, totalPuntos, numDardos, new int[numDardos], 0, 0);
    }

    public static void encontrarCombinaciones(int[] regiones, int totalPuntos, int numDardos, int[] combinacionActual, int sumaActual, int indice) {
        if (indice == numDardos) {
            if (sumaActual == totalPuntos) {
                imprimirCombinacion(combinacionActual);
            }
            return;
        }

        for (int i = 0; i < regiones.length; i++) {
            combinacionActual[indice] = regiones[i];
            encontrarCombinaciones(regiones, totalPuntos, numDardos, combinacionActual, sumaActual + regiones[i], indice + 1);
        }
    }

    public static void imprimirCombinacion(int[] combinacion) {
        System.out.print("Combinación: ");
        for (int i = 0; i < combinacion.length; i++) {
            System.out.print(combinacion[i] + " ");
        }
        System.out.println();
    }
}