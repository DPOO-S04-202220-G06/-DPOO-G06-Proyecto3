package liga;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Temporada {
	private String nombre;
	private ArrayList<Jornada> jornadas;
	private Map<String,Equipo> equipos;
	private Map<String, Jugador> jugadores;
	private Map<String, Partido> partidos;
	private Date fechaInicial;
	private Date fechaFinal;
	
	public Temporada(Map<String,Equipo> equipos, 
			ArrayList<Jornada> jornadas, Map<String, Jugador> jugadores)
	{
		this.jornadas = jornadas;
		this.equipos = equipos;
		this.jugadores = jugadores;
		this.fechaInicial = jornadas.get(0).getInicio();
		this.fechaFinal = jornadas.get(jornadas.size()-1).getFinal();
		for (Jornada jornada: jornadas)
		{
			ArrayList<Partido> listaPartidos = jornada.getPartidos();	
			for (Partido partido: listaPartidos) 
			{
				String key = partido.getLocal() + ";" + partido.getVisitante();
				partidos.put(key, partido);
			}
		}
	}
		
	public String getNombre()
	{
		return this.nombre;
	}
	
	public ArrayList<Jornada> getJornadas()
	{
		return this.jornadas;
	}
	
	public Map<String, Equipo> getEquipos()
	{
		return this.equipos;
	}
	
	public Map<String, Jugador> getJugadores()
	{
		return this.jugadores;
	}
	
	public Map<String, Partido> getPartidos()
	{
		return this.partidos;
	}
	
	public Date fechaInicio()
	{
		return this.fechaInicial;
	}
	
	public Date fechaFinal()
	{
		return this.fechaFinal;
	}
}
