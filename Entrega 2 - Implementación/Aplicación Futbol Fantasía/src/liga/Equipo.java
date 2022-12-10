package liga;

import java.util.ArrayList;

public class Equipo {
	private String nombre;
	private ArrayList<Jugador> jugadores;
	
	public Equipo(String nombre, int size)
	{
		this.nombre = nombre;
		this.jugadores = new ArrayList<Jugador>(size);
	}
	
	public void addJugador(Jugador jugador)
	{
		jugadores.add(jugador);
	}
	
	public String getNombre() 
	{
		return this.nombre;
	}
	
}
