package liga;

import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private String apellido;
	private int numero;
	private int nacimiento;
	private String nacionalidad;
	private String equipo;
	private String posicion;
	private int valor;
	private ArrayList<int[]> puntosJornada;
	private int puntos;
	
	public Jugador(String nombre, String apellido, int numero, 
					int nacimiento, String nacionalidad, String equipo, 
						String posicion, int valor)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero = numero;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.equipo = equipo;
		this.posicion = posicion;
		this.valor = valor;
	}
	
	public void addGol()
	{
		switch (posicion)
		{
		case "PO":
			this.puntos += 6;
			break;
		case "DF":
			this.puntos += 6;
			break;
		case "CO":
			this.puntos += 5;
			break;
		case "DL":
			this.puntos += 4;
			break;
		}
	}
	
	public void addAsistencia()
	{
		this.puntos += 3;
	}
	
	public void addAmarilla()
	{
		this.puntos -= 1;
	}
	
	public void addRoja()
	{
		this.puntos -= 3;
	}
	
	public void addAutoGol()
	{
		this.puntos -= 2;
	}
	
	public void addAtajado()
	{
		this.puntos += 5;
	}
	
	public void addErrorPenal()
	{
		this.puntos -= 2;
	}
	
	public void addMano()
	{
		this.puntos -= 1;
	}
	
	public void addGolLibre()
	{
		this.puntos += 3;
	}
	
	public void addTLibre()
	{
		this.puntos += 1;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getApellido()
	{
		return this.apellido;
	}
	
	public int getNumero()
	{
		return this.numero;
	}
	
	public int getNacimiento()
	{
		return this.nacimiento;
	}
	
	public String getNacionalidad()
	{
		return this.nacionalidad;
	}
	
	public String getEquipo()
	{
		return this.equipo;
	}
	
	public String getPosicion()
	{
		return this.posicion;
	}
	
	public int getValor()
	{
		return this.valor;
	}

	public ArrayList<int[]> getPuntosJornada()
	{
		return this.puntosJornada;
	}

	public int getPuntosTotales()
	{
		return this.puntos;
	}

}
