package trabajo;

import java.util.ArrayList;

public class ResetearXML {


	
	public static void ResetearXML2(ArrayList<Videojuego> videojuegos) {
		
		videojuegos.clear();
		Videojuego.resetearContador();
		
	
		Jugadores jugadores1 = new Jugadores(543, 267, 879, 112, 456, 732, 921, 354, 648, 205, 777, 999);
		Jugadores jugadores2 = new Jugadores(315, 698, 182, 503, 869, 124, 356, 789, 961, 237, 444, 712);
		Jugadores jugadores3 = new Jugadores(932, 167, 594, 378, 741, 256, 803, 149, 672, 418, 555, 889);
		Jugadores jugadores4 = new Jugadores(401, 823, 174, 569, 938, 267, 614, 952, 135, 780, 326, 699);
		Jugadores jugadores5 = new Jugadores(249, 765, 583, 937, 102, 413, 876, 321, 699, 457, 894, 204);
		Jugadores jugadores6 = new Jugadores(512, 986, 349, 725, 178, 634, 941, 267, 573, 819, 105, 398);
		Jugadores jugadores7 = new Jugadores(758, 231, 604, 912, 143, 497, 825, 376, 689, 954, 222, 666);
		Jugadores jugadores8 = new Jugadores(173, 643, 896, 422, 751, 319, 587, 941, 105, 478, 819, 234);
		Jugadores jugadores9 = new Jugadores(963, 518, 277, 625, 814, 361, 749, 105, 482, 937, 202, 564);
		Jugadores jugadores10 = new Jugadores(376, 829, 541, 197, 688, 354, 912, 608, 167, 743, 995, 421);

	
		Videojuego juego1 = new Videojuego("The Witcher 3: Wild Hunt", "CD Projekt Red", "Konrad Tomaszkiewicz",
                "Piotr Krzywonosiuk", Genero.rol, Subgenero.actionRPG, 18, 2015, "PS4", jugadores1);

        Videojuego juego2 = new Videojuego("Red Dead Redemption 2", "Rockstar Games", "Rob Nelson",
                "Jerome Sanuth", Genero.accion, Subgenero.shooter, 18, 2018, "Xbox One", jugadores2);

        Videojuego juego3 = new Videojuego("The Legend of Zelda: Breath of the Wild", "Nintendo", "Hidemaro Fujibayashi",
                "Eiji Aonuma", Genero.aventura, Subgenero.actionRPG, 12, 2017, "Nintendo Switch", jugadores3);

        Videojuego juego4 = new Videojuego("Uncharted 4: A Thief's End", "Naughty Dog", "Neil Druckmann",
                "Bruce Straley", Genero.accion, Subgenero.shooter, 16, 2016, "PS4", jugadores4);

        Videojuego juego5 = new Videojuego("Super Mario Odyssey", "Nintendo", "Kenta Motokura",
                "Yoshiaki Koizumi", Genero.accion, Subgenero.plataformas, 7, 2017, "Nintendo Switch", jugadores5);

        Videojuego juego6 = new Videojuego("Overwatch", "Blizzard Entertainment", "Jeff Kaplan",
                "Ray Gresko", Genero.accion, Subgenero.shooter, 12, 2016, "PC", jugadores6);

        Videojuego juego7 = new Videojuego("Fortnite", "Epic Games", "Darren Sugg",
                "Zak Phelps", Genero.accion, Subgenero.battleRoyale, 12, 2017, "Multiplataforma", jugadores7);

        Videojuego juego8 = new Videojuego("FIFA 22", "EA Sports", "Aaron McHardy",
                "David Rutter", Genero.deportes, Subgenero.futbol, 3, 2021, "Multiplataforma", jugadores8);

        Videojuego juego9 = new Videojuego("Minecraft", "Mojang Studios", "Markus Persson",
                "Jens Bergensten", Genero.simulacion, Subgenero.construccion, 7, 2011, "Multiplataforma", jugadores9);

        Videojuego juego10 = new Videojuego("Among Us", "InnerSloth", "Forest Willard",
                "Amy Liu", Genero.accion, Subgenero.sigilo, 7, 2018, "Multiplataforma", jugadores10);
    
		
		
      
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