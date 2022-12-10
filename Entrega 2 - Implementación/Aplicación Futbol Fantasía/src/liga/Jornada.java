package liga;

import java.util.ArrayList;
import java.util.Date;

public class Jornada {
	private int numero;
	private ArrayList<Partido> partidos;
	private Date fechaInicio;
	private Date fechaFinal;
	
	public Jornada(int numero, ArrayList<Partido> partidos)
	{
		this.numero = numero;
		this.partidos = partidos;
		this.fechaInicio = partidos.get(0).getFecha();
		this.fechaFinal = partidos.get(partidos.size()-1).getFecha();
	}
	
	public int getNumero()
	{
		return this.numero;
	}
	
	public Date getInicio()
	{
		return this.fechaInicio;
	}
	
	public Date getFinal()
	{
		return this.fechaFinal;
	}
	public ArrayList<Partido> getPartidos()
	{
		return this.partidos;
	}
}
