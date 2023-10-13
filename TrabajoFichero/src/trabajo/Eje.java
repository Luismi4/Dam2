package trabajo;

public class Eje {

	public static void main(String[] args) {
		
		Jugadores jugadores = new Jugadores (10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
	
		Videojuego juego1 = new Videojuego("The Witcher 3: Wild Hunt", "CD Projekt Red", "Konrad Tomaszkiewicz",
                "Piotr Krzywonosiuk", genero.rol, subgenero.actionRPG, 18, 2015, "PS4", jugadores);

        Videojuego juego2 = new Videojuego("Red Dead Redemption 2", "Rockstar Games", "Rob Nelson",
                "Jerome Sanuth", genero.accion, subgenero.shooter, 18, 2018, "Xbox One", jugadores);

        Videojuego juego3 = new Videojuego("The Legend of Zelda: Breath of the Wild", "Nintendo", "Hidemaro Fujibayashi",
                "Eiji Aonuma", genero.aventura, subgenero.actionRPG, 12, 2017, "Nintendo Switch", jugadores);

        Videojuego juego4 = new Videojuego("Uncharted 4: A Thief's End", "Naughty Dog", "Neil Druckmann",
                "Bruce Straley", genero.accion, subgenero.shooter, 16, 2016, "PS4", jugadores);

        Videojuego juego5 = new Videojuego("Super Mario Odyssey", "Nintendo", "Kenta Motokura",
                "Yoshiaki Koizumi", genero.accion, subgenero.plataformas, 7, 2017, "Nintendo Switch", jugadores);

        Videojuego juego6 = new Videojuego("Overwatch", "Blizzard Entertainment", "Jeff Kaplan",
                "Ray Gresko", genero.accion, subgenero.shooter, 12, 2016, "PC", jugadores);

        Videojuego juego7 = new Videojuego("Fortnite", "Epic Games", "Darren Sugg",
                "Zak Phelps", genero.accion, subgenero.battleRoyale, 12, 2017, "Multiplataforma", jugadores);

        Videojuego juego8 = new Videojuego("FIFA 22", "EA Sports", "Aaron McHardy",
                "David Rutter", genero.deportes, subgenero.futbol, 3, 2021, "Multiplataforma", jugadores);

        Videojuego juego9 = new Videojuego("Minecraft", "Mojang Studios", "Markus Persson",
                "Jens Bergensten", genero.simulacion, subgenero.construccion, 7, 2011, "Multiplataforma", jugadores);

        Videojuego juego10 = new Videojuego("Among Us", "InnerSloth", "Forest Willard",
                "Amy Liu", genero.accion, subgenero.sigilo, 7, 2018, "Multiplataforma", jugadores);
    
		
		System.out.println(juego1.toString());
		System.out.println(juego2.toString());
		System.out.println(juego3.toString());
		System.out.println(juego4.toString());
		System.out.println(juego5.toString());
		System.out.println(juego6.toString());
		System.out.println(juego7.toString());
		System.out.println(juego8.toString());
		System.out.println(juego9.toString());
		System.out.println(juego10.toString());
		
		CrearXML.CrearXML();
		
		ActualizarObjetoEnXML.escribirXML(juego1);
		ActualizarObjetoEnXML.escribirXML(juego2);
		ActualizarObjetoEnXML.escribirXML(juego3);
		ActualizarObjetoEnXML.escribirXML(juego4);
		ActualizarObjetoEnXML.escribirXML(juego5);
		ActualizarObjetoEnXML.escribirXML(juego6);
		ActualizarObjetoEnXML.escribirXML(juego7);
		ActualizarObjetoEnXML.escribirXML(juego8);
		ActualizarObjetoEnXML.escribirXML(juego9);
		ActualizarObjetoEnXML.escribirXML(juego10);
		

	}

}
