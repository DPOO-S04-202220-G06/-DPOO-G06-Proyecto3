package fantasia;

import liga.Jornada;
import liga.Jugador;
import aplicacion.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EquipoFantasia {
	private String nombre;
	private Usuario owner;
	private int presupuesto;
	private Map<Jornada, int[]> puntosJornadas;
	private int puntos;
	private Map<String,Jugador> jugadores;
	private ArrayList<Jugador> titulares;
	private Map<String,Jugador> arqueros;
	private Map<String,Jugador> defensas;
	private Map<String,Jugador> mediocampistas;
	private Map<String,Jugador> delanteros;
	private Jugador capitan;
	
	public EquipoFantasia(Usuario owner, String nombre)
	{
		this.owner = owner;
		this.nombre = nombre;
		this.titulares = new ArrayList<Jugador>(11);
		this.arqueros = new HashMap<String, Jugador>(2);
		this.defensas = new HashMap<String, Jugador>(5);
		this.mediocampistas = new HashMap<String, Jugador>(5);
		this.delanteros = new HashMap<String, Jugador>(3);
		this.puntos = 0;
		
	}
	
	public boolean comprarJugador(Jugador nuevoJugador)
	{
		int precio = nuevoJugador.getValor();
		if (presupuesto >= precio) 
		{
			this.presupuesto -= precio;
		}
		String posicion = nuevoJugador.getPosicion();
		switch (posicion)
		{
        	case "Arquero":
        	{
        		if (this.arqueros.size() < 2)
        		{
        			this.arqueros.put(nuevoJugador.getNombre(), nuevoJugador);
        			this.jugadores.put(nuevoJugador.getNombre(), nuevoJugador);
        			return true;
        		}
        	}
        	case "Defensa":
        	{
        		if (this.defensas.size() < 5)
        		{
        			this.defensas.put(nuevoJugador.getNombre(), nuevoJugador);
        			this.jugadores.put(nuevoJugador.getNombre(), nuevoJugador);
        			return true;
        		}
        	}
        	case "Mediocampista":
        	{
        		if (this.mediocampistas.size() < 5)
        		{
        			this.mediocampistas.put(nuevoJugador.getNombre(), nuevoJugador);
        			this.jugadores.put(nuevoJugador.getNombre(), nuevoJugador);
        			return true;
        		}
        	}
        	case "Delantero":
        	{
        		if (this.delanteros.size() < 3)
        		{
        			this.delanteros.put(nuevoJugador.getNombre(), nuevoJugador);
        			this.jugadores.put(nuevoJugador.getNombre(), nuevoJugador);
        			return true;
        		}
        	}
		}
		return false;		
	}
	public void venderJugador(Jugador nuevoJugador)
	{
		int precio = nuevoJugador.getValor();
		this.presupuesto += Math.round(precio*0.97);
		String posicion = nuevoJugador.getPosicion();
		switch (posicion)
		{
        	case "Arquero":
        	{
        		this.arqueros.remove(nuevoJugador.getNombre());
        		this.jugadores.remove(nuevoJugador.getNombre());
        	}
        	case "Defensa":
        	{
        		this.defensas.remove(nuevoJugador.getNombre());
        		this.jugadores.remove(nuevoJugador.getNombre());
        	}
        	case "Mediocampista":
        	{
        		this.mediocampistas.remove(nuevoJugador.getNombre());
        		this.jugadores.remove(nuevoJugador.getNombre());
        	}
        	case "Delantero":
        	{
        		this.delanteros.remove(nuevoJugador.getNombre());
        		this.jugadores.remove(nuevoJugador.getNombre());
        	}
		}
	}
	
	public void cambiarTitulares(ArrayList<Jugador> titulares)
	{
		this.titulares = titulares;
	}
	
	public boolean cambiarCapitan(String capitan)
	{
		Jugador jugador = this.jugadores.get(capitan);
		if (jugador != null) 
		{
			this.capitan = jugador;
			return true;
		}
		return false;
	}
	public Map<String, Jugador> getJugadores()
	{
		return this.jugadores;
	}

	public String getNombre()
	{
		return this.nombre;
	}
	
	public Usuario getOwner()
	{
		return this.owner;
	}
	
	public int getPuntos()
	{
		return this.puntos;
	}
	
	public Jugador getCapitan()
	{
		return this.capitan;
	}
	
	public ArrayList<Jugador> getTitulares()
	{
		return this.titulares;
	}
	public Map<Jornada, int[]>getPJornadas()
	{
		return this.puntosJornadas;
	}
}
