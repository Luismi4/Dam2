package trabajo;

public class Videojuego {

private final int ID;
private String titulo;
private String desarrollador;
private String director;
private String productor;
private Genero genero; //generos y subgeneros: https://en.wikipedia.org/wiki/List_of_video_game_genres
private Subgenero subgenero;
private int pegi;
private int anno;
private static int contador;
private String plataforma; //PS5, PS4, PS3, PS2, PS1, PC, xbox, xbox360, xboxOne, xboxOneX, Switch, 
						//NES, SNES, N64, gameCube, wii, wiiU, megaDrive, saturn, dreamcast;
						//El String debera quedar, por ejemplo: "PS5, xboxOneX, Switch, PC"
private Jugadores jugadores; //clase con sus propios atributos para después poder serializarlo en el xml de golpe

//constructores

public Videojuego(String titulo, String desarrollador, String director, String productor, Genero genero,
		Subgenero subgenero, int pegi, int anno, String plataforma, Jugadores jugadores) {
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

public Videojuego() {
	this.ID = -1;
	
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
public Genero getGenero() {
	return genero;
}
public void setGenero(Genero genero) {
	this.genero = genero;
}
public Subgenero getSubgenero() {
	return subgenero;
}
public void setSubgenero(Subgenero subgenero) {
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
public Jugadores getJugadores() {
	return jugadores;
}
public void setJugadores(Jugadores jugadores) {
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
			+ ", anno=" + anno + ", plataforma=" + plataforma + ", jugadores="
			+ jugadores.toString() + "]";
}

}











