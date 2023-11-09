package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Eje {
	public static void main(String[] args) {
		
		List<String> nombres = new ArrayList<>();
		List<Integer> tama = new ArrayList<Integer>();
		
		nombres.add("Juan");
        nombres.add("María");
        nombres.add("Carlos");
        nombres.add("Ana");
        
        nombres.forEach(nom -> tama.add(nom.length()));
		
        System.out.println("El tamaño de cada uno de los nombres es: " + tama);
        
        int sumatama = tama.stream().mapToInt(Integer::intValue).sum();
        
        System.out.println("La suma de las longitudes es: " + sumatama);
        
	}
}
