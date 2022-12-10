package liga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Liga {

	private String nombre;
	private ArrayList<Temporada> temporadas;
	
	public Liga(String nombre)
	{
		this.nombre = nombre;
		this.temporadas = new ArrayList<Temporada>(5);
	}
	
	public void crearTemporada(Temporada nuevaTemporada)
	{
		this.temporadas.add(nuevaTemporada);
	}
	
	public boolean temporadaEnCurso() throws ParseException
	{
		if (this.temporadas.isEmpty())
		{
			return false;
		}
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDateTime fechaActual = LocalDateTime.now();
		String stringFecha = formato.format(fechaActual);
		Date fechaA = new SimpleDateFormat("dd/MM/yyyy").parse(stringFecha); 
		if (fechaFinalTActual().before(fechaA))
		{
			return true;
		}
		return false;
	}
		
	public Date fechaInicioTActual()
	{
		return temporadas.get(temporadas.size()-1).fechaInicio();
	}
	
	public Date fechaFinalTActual()
	{
		return temporadas.get(temporadas.size()-1).fechaFinal();
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getNumTemporada()
	{
		return this.temporadas.size();
	}
	
	public Temporada getTemporada()
	{
		return this.temporadas.get(this.temporadas.size()-1);
	}
}
