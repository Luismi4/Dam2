package trabajo;

import java.util.ArrayList;

public class ResetearXML {


	
	public static void ResetearXML(ArrayList<Videojuego> videojuegos) {
		
		videojuegos.clear();
	
		Jugadores jugadores = new Jugadores (10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
	
		Videojuego juego1 = new Videojuego("The Witcher 3: Wild Hunt", "CD Projekt Red", "Konrad Tomaszkiewicz",
                "Piotr Krzywonosiuk", Genero.rol, Subgenero.actionRPG, 18, 2015, "PS4", jugadores);

        Videojuego juego2 = new Videojuego("Red Dead Redemption 2", "Rockstar Games", "Rob Nelson",
                "Jerome Sanuth", Genero.accion, Subgenero.shooter, 18, 2018, "Xbox One", jugadores);

        Videojuego juego3 = new Videojuego("The Legend of Zelda: Breath of the Wild", "Nintendo", "Hidemaro Fujibayashi",
                "Eiji Aonuma", Genero.aventura, Subgenero.actionRPG, 12, 2017, "Nintendo Switch", jugadores);

        Videojuego juego4 = new Videojuego("Uncharted 4: A Thief's End", "Naughty Dog", "Neil Druckmann",
                "Bruce Straley", Genero.accion, Subgenero.shooter, 16, 2016, "PS4", jugadores);

        Videojuego juego5 = new Videojuego("Super Mario Odyssey", "Nintendo", "Kenta Motokura",
                "Yoshiaki Koizumi", Genero.accion, Subgenero.plataformas, 7, 2017, "Nintendo Switch", jugadores);

        Videojuego juego6 = new Videojuego("Overwatch", "Blizzard Entertainment", "Jeff Kaplan",
                "Ray Gresko", Genero.accion, Subgenero.shooter, 12, 2016, "PC", jugadores);

        Videojuego juego7 = new Videojuego("Fortnite", "Epic Games", "Darren Sugg",
                "Zak Phelps", Genero.accion, Subgenero.battleRoyale, 12, 2017, "Multiplataforma", jugadores);

        Videojuego juego8 = new Videojuego("FIFA 22", "EA Sports", "Aaron McHardy",
                "David Rutter", Genero.deportes, Subgenero.futbol, 3, 2021, "Multiplataforma", jugadores);

        Videojuego juego9 = new Videojuego("Minecraft", "Mojang Studios", "Markus Persson",
                "Jens Bergensten", Genero.simulacion, Subgenero.construccion, 7, 2011, "Multiplataforma", jugadores);

        Videojuego juego10 = new Videojuego("Among Us", "InnerSloth", "Forest Willard",
                "Amy Liu", Genero.accion, Subgenero.sigilo, 7, 2018, "Multiplataforma", jugadores);
    
		
		
      
        videojuegos.add(juego1);
        videojuegos.add(juego2);
        videojuegos.add(juego3);
        videojuegos.add(juego4);
        videojuegos.add(juego5);
        videojuegos.add(juego6);
        videojuegos.add(juego7);
        videojuegos.add(juego8);
        videojuegos.add(juego9);
        videojuegos.add(juego10);
		
		CrearXML2.CrearXML2(videojuegos);
		
		//Metodos.NumJugadores(ArrayListVideojuegos);
		//ActualizarObjetoEnXML.escribirXML(Metodos.editarVideojuego(ArrayListVideojuegos));
		
		//for (Videojuego juego : ArrayListVideojuegos) {
		//	System.out.println(juego.toString());
		//}
		
		//CrearXML.CrearXML();
		

	}

}
