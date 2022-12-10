package liga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Partido {

	private Equipo local;
	private Equipo visitante;
	private Date fecha;
	private int jornada;
	
	public Partido(String fecha, Equipo local, Equipo visitante, int jornada) throws ParseException
	{
		this.fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fecha); 
		this.local = local;
		this.visitante = visitante;
		this.jornada = jornada;
	}
	
	public Date getFecha()
	{
		return this.fecha;
	}
	
	public Equipo getLocal()
	{
		return this.local;
	}
	
	public Equipo getVisitante()
	{
		return this.visitante;
	}
	
	public int getJornada()
	{
		return this.jornada;
	}
	
	public boolean isDone()
	{
		LocalDateTime fechaActual = LocalDateTime.now();
		return fechaActual.isBefore(convertToLocalDateTimeViaInstant(fecha)); 
	}
	
	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
}
