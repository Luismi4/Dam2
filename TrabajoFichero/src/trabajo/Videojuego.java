package trabajo;

import java.util.Arrays;

public class Videojuego {

private final int ID;
private String titulo;
private String desarrollador;
private String director;
private String productor;
private genero genero;
private subgenero subgenero; //Es nodo nieto de genero
private int pegi;
private int anno;
private static int contador;
private String plataforma; //PS5, PS4, PS3, PS2, PS1, PC, xbox, xbox360, xboxOne, xboxOneX, Switch, 
						//NES, SNES, N64, gameCube, wii, wiiU, megaDrive, saturn, dreamcast;
						//El String debera quedar, por ejemplo: "PS5, xboxOneX, Switch, PC"
private int[] jugadores = new int[12]; //un mes por casilla del array

//constructores

public Videojuego(String titulo, String desarrollador, String director, String productor, trabajo.genero genero,
		trabajo.subgenero subgenero, int pegi, int anno, String plataforma, int[] jugadores) {
	super();
	this.ID = contador++;
	this.titulo = titulo;
	this.desarrollador = desarrollador;
	this.director = director;
	this.productor = productor;
	this.genero = genero;
	this.subgenero = subgenero;
	this.pegi = pegi;
	this.anno = anno;
	this.plataforma = plataforma;
	this.jugadores = jugadores;
}

//getters y setters

public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDesarrollador() {
	return desarrollador;
}
public void setDesarrollador(String desarrollador) {
	this.desarrollador = desarrollador;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getProductor() {
	return productor;
}
public void setProductor(String productor) {
	this.productor = productor;
}
public genero getGenero() {
	return genero;
}
public void setGenero(genero genero) {
	this.genero = genero;
}
public subgenero getSubgenero() {
	return subgenero;
}
public void setSubgenero(subgenero subgenero) {
	this.subgenero = subgenero;
}
public int getPegi() {
	return pegi;
}
public void setPegi(int pegi) {
	this.pegi = pegi;
}
public int getAnno() {
	return anno;
}
public void setAnno(int anno) {
	this.anno = anno;
}
public String getPlataforma() {
	return plataforma;
}
public void setPlataforma(String plataforma) {
	this.plataforma = plataforma;
}
public int[] getJugadores() {
	return jugadores;
}
public void setJugadores(int[] jugadores) {
	this.jugadores = jugadores;
}
public int getID() {
	return ID;
}

//toString



@Override
public String toString() {
	return "Videojuego [ID=" + ID + ", titulo=" + titulo + ", desarrollador=" + desarrollador + ", director=" + director
			+ ", productor=" + productor + ", genero=" + genero + ", subgenero=" + subgenero + ", pegi=" + pegi
			+ ", anno=" + anno + ", contador=" + contador + ", plataforma=" + plataforma + ", jugadores="
			+ Arrays.toString(jugadores) + "]";
}

}




//enums

//generos y subgeneros: https://en.wikipedia.org/wiki/List_of_video_game_genres

enum genero{

	accion, accionAventura, aventura, puzzle, rol, simulacion, estrategia, deportes;

}

enum subgenero{

	plataformas, shooter, lucha, beatEmUp, sigilo, survival, ritmo, battleRoyale, //para accion
	survivalHorror, metroidVania, //para accion-aventura
	aventuraGrafica, visualNovel, //para aventura
	actionRPG, JRPG, rolOccidental, MMORPG, roguelike, tacticalRPG, dungeonCrawler, //para rol
	construccion, vida, vehiculos, //para simulacion
	guerra, MOBA, realTimeStrategy, turnBasedStrategy, //para estrategia
	carreras, tenis, futbol, baloncesto, golf; //para deportes

}




