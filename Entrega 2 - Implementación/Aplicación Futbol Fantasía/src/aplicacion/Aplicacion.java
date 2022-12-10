package aplicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fantasia.EquipoFantasia;
import liga.Liga;
import liga.Temporada;
import liga.Jugador;
import liga.Equipo;
import liga.Jornada;
import liga.Partido;

public class Aplicacion {
	
	private Liga ligaAbierta;
	private Map<String, Liga> Ligas;
	private Map<String, Cuenta> mapaCuentas;
	
	public Aplicacion() throws IOException, ParseException
	{
		this.Ligas = new HashMap<String, Liga>(12);
		this.mapaCuentas = new HashMap<String, Cuenta>(1000);
		Administrador admin = new Administrador("admin","123");
		this.mapaCuentas.put("admin", admin); //Cuenta Admin
	}
	
	public Cuenta ingresar(String nombre, String password)
	{
		Cuenta coincidencia = this.mapaCuentas.get(nombre);
		if (coincidencia == null)
		{
			return null;
		}
		boolean verificador = coincidencia.verificarCredenciales(password);
		if (verificador == false)
		{
			return null;
		}
		return coincidencia;
	}
	
	public Cuenta crearCuenta(String nombre, String password)
	{
		Cuenta coincidencia = this.mapaCuentas.get(nombre);
		if (coincidencia != null)
		{
			return null;
		}
		Cuenta nuevaCuenta =  new Usuario(nombre,password);
		return nuevaCuenta;
	}
	
	//ADMIN
	
	public boolean verificarNombreLiga(String nombre, Administrador admin) 
	{
		if (this.Ligas.get(nombre)!=null)
		{
			return false;
		}
		return true;
	}
	
	public boolean crearLiga(String nombre, ArrayList<File> paths, Administrador admin)
	{
		try 
		{
			//Orden equipos, jugadores, jornadas
			Liga nuevaLiga = new Liga(nombre);
			this.ligaAbierta = nuevaLiga;
			this.cargarTemporada(paths.get(0), paths.get(2), paths.get(1), admin);
			admin.ligaCreada();
			this.Ligas.put(nombre, nuevaLiga);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
		
	}
				
	public Liga abrirLiga(String nombre) 
	{
		this.ligaAbierta = this.Ligas.get(nombre);
		return this.ligaAbierta;
	}
	
	public ArrayList<String> getLigas()
	{
		ArrayList<String> lista = new ArrayList<String>(10);
		for (String nombre: this.Ligas.keySet())
		{
			lista.add(nombre);
		}
		return lista;
	}
	
	public int crearTemporada(ArrayList<File> paths, Administrador admin)
	{
		try 
		{
			//Orden equipos, jugadores, jornadas
			this.cargarTemporada(paths.get(0), paths.get(2), paths.get(1), admin);
			admin.ligaCreada();
			return 0;
		}
		catch (IOException e)
		{
			return 1;
		}
		catch (Exception e)
		{
			return 2;
		}
	}
		
	public void cargarTemporada(File fileEquipos, File fileJugadores, 
			File fileJornadas, Administrador admin) throws IOException, Exception 
	{
		if (this.ligaAbierta.temporadaEnCurso())
		{
			throw new Exception();
		}
		Map<String, Equipo> equipos = cargarEquipos(fileEquipos);
		Map<String, Jugador> jugadores = cargarJugadores(fileJugadores, equipos);
		ArrayList<Jornada> jornadas = cargarJornadas(fileJornadas, equipos);
		Temporada nuevaTemporada = new Temporada(equipos, jornadas, jugadores);
		this.ligaAbierta.crearTemporada(nuevaTemporada);
		admin.temporadaCreada();
	}
	
	private Map<String, Equipo> cargarEquipos(File data) throws IOException 
	{
		Map<String, Equipo> equipos = new HashMap<String,Equipo>(20);
		BufferedReader br = new BufferedReader(new FileReader(data));
		String tipo = br.readLine();
		if (tipo.equals("Equipos"))
		{
		String linea = br.readLine();
		linea = br.readLine();
		while (linea != null) 
		{
			String[] dataEquipo = linea.split(",");
			Equipo nuevoEquipo = new Equipo(dataEquipo[0], Integer.parseInt(dataEquipo[1]));
			equipos.put(dataEquipo[0], nuevoEquipo);			
			linea = br.readLine();
		}
		br.close();
		return equipos;
		}
		br.close();
		return null;
	}
	
	private Map<String, Jugador> cargarJugadores(File data, Map<String, Equipo> equipos) throws IOException 
	{
		Map<String, Jugador> jugadores = new HashMap<String, Jugador>(500);
		BufferedReader br = new BufferedReader(new FileReader(data));
		String linea = br.readLine();
		String[] tipo = linea.split(";");
		if (tipo[0].equals("Jugadores"))
		{
		linea = br.readLine();
		linea = br.readLine();
		while (linea != null) 
		{
			String[] dataJugador = linea.split(";");
			String nombre = dataJugador[0];
			String apellido = dataJugador[0];
			int numero = Integer.parseInt(dataJugador[1]);
			int nacimiento = Integer.parseInt(dataJugador[2]);
			String nacionalidad = dataJugador[3];
			String equipo = dataJugador[4];
			String posicion = dataJugador[5];
			int valor = Integer.parseInt(dataJugador[6]);
			Jugador nuevoJugador = new Jugador(nombre, apellido,
												numero, nacimiento, 
													nacionalidad, equipo, 
														posicion, valor);
			Equipo equipoJugador = equipos.get(equipo);
			jugadores.put(nombre, nuevoJugador);
			equipoJugador.addJugador(nuevoJugador);			
			linea = br.readLine();
			
		}
		br.close();
		return jugadores;
		}
		br.close();
		return null;
	}
	
	private ArrayList<Jornada> cargarJornadas(File data, Map<String, Equipo> equipos) throws IOException, ParseException 
	{
		ArrayList<Jornada> jornadas = new ArrayList<>(equipos.size());
		BufferedReader br = new BufferedReader(new FileReader(data));
		String linea = br.readLine();
		if (linea.equals("Jornadas"))
		{
		linea = br.readLine();
		linea = br.readLine();
		linea = br.readLine();
		int i = 1;
		while (linea != null) 
		{
			ArrayList<Partido> partidosJornada = new ArrayList<>(10);
			while (linea.equals("Jornada") == false)
			{
				String[] dataJornada = linea.split(",");
				String fecha = dataJornada[0];
				String local = dataJornada[1];
				String visitante = dataJornada[2];
				Equipo equipoLocal = equipos.get(local);
				Equipo equipoVisitante = equipos.get(visitante);
				Partido nuevoPartido = new Partido(fecha, equipoLocal, equipoVisitante, i);
				partidosJornada.add(nuevoPartido);
				linea = br.readLine();
				if (linea == null)
				{
					break;
				}
			}
			i +=1;
			Jornada jornadaActual = new Jornada(i, partidosJornada);
			jornadas.add(jornadaActual);
			linea = br.readLine();
		}
		br.close();
		return jornadas;
		}
		br.close();
		return null;
	}
	
	public boolean comenzarTemporada()
	{
		
		return true;
	}
	
	public boolean terminarTemporada()
	{
		return true;
	}
			
	
	public int subirResultados(File filedata, Administrador admin)
	{
		try 
		{
			this.cargarResultados(filedata);
			admin.resultadoCargado();
			return 0;
		}
		catch (IOException e)
		{
			return 1;
		}
		catch (Exception e)
		{
			return 2;
		}
	}
	
	private void cargarResultados(File filedata) throws IOException, Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(filedata));
		String linea = br.readLine();
		if (linea != "Resultados")
		{
			br.close();
			throw new Exception();
		}
		linea = br.readLine();
		Map<String, Partido> partidos = this.ligaAbierta.getTemporada().getPartidos();
		Map<String, Jugador> jugadores = this.ligaAbierta.getTemporada().getJugadores();
		Partido match = partidos.get(linea);
		if (!match.isDone())
		{
			br.close();
			throw new Exception();
		}
		String titular = br.readLine();
		String[] titularesL = titular.split(";");
		String titular2 = br.readLine();
		String[] titularesV = titular2.split(";");
		linea = br.readLine();
		while (linea != null) 
		{
			String[] evento = linea.split(";");
			Jugador jugador = jugadores.get(evento[1]);
			switch (evento[0])
			{
			case "Gol":
				jugador.addGol();
				break;
			case "Amarilla":
				jugador.addAmarilla();
				break;	
			case "Roja":
				jugador.addRoja();
				break;	
			case "Asistencia":;
				jugador.addAsistencia();
				break;	
			case "PError":;
				jugador.addErrorPenal();
				break;	
			case "PAtajado":
				jugador.addAtajado();
				break;	
			case "Autogol":
				jugador.addAutoGol();
				break;	
			case "Mano":
				jugador.addMano();
				break;	
			case "TLibreGol":
				jugador.addGolLibre();
				break;	
			case "TLibre":
				jugador.addTLibre();
				break;	
			case "Cambio":
				break;
			}		
			linea = br.readLine();	
		}
		br.close();
	}
		
	//USER
	
	public boolean crearEquipoFantasia(File filedata, Usuario usuario) throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader(filedata));
		String linea = br.readLine();
		if (linea != "Fantasía")
		{
			br.close();
			return false;
		}
		String nombre = br.readLine();
		EquipoFantasia eFantasia = new EquipoFantasia(usuario, nombre);
		String nombreCapitan = br.readLine();
		linea = br.readLine();
		while (linea != null) 
		{
			//Jugador jugador = this.mapaJugadores.get(linea);
			//eFantasia.comprarJugador(jugador);		
			linea = br.readLine();
		}
		eFantasia.cambiarCapitan(nombreCapitan);
		usuario.guardarEquipo(eFantasia);
		br.close();
		return true;
	}
		
	public boolean cambiarTitulares(File filedata, Usuario usuario) throws IOException 
		{
			EquipoFantasia eFantasia = usuario.getEFantasia();
			Map<String,Jugador> mapaJugadores = eFantasia.getJugadores();
			ArrayList<Jugador> titulares = new ArrayList<Jugador>(11);
			int arquero = 0;
			int defensas = 0;
			int mediocampistas = 0;
			int delanteros = 0;
			
			BufferedReader br = new BufferedReader(new FileReader(filedata));
			String linea = br.readLine();
			if (linea != "Titulares")
			{
				br.close();
				return false;
			}
			linea = br.readLine();
			while (linea != null) 
			{
				Jugador jugador = mapaJugadores.get(linea);
				if (jugador != null)
				{
					String posicion = jugador.getPosicion();
					switch (posicion)
					{
					case "Arquero":
					{
						if (arquero < 1)
						{
							titulares.add(jugador);
							arquero += 1;
						}
					}
					case "Defensa":
					{
						if (defensas < 4)
						{
							titulares.add(jugador);
							defensas += 1;
						}
					}
					case "Mediocampista":
					{
						if (mediocampistas < 4)
						{
							titulares.add(jugador);
							mediocampistas += 1;
						}
					}
					case "Delantero":
					{
						if (delanteros < 4)
						{
							titulares.add(jugador);
							delanteros += 1;
						}
					}
					}
				}
				linea = br.readLine();
			}
			br.close();
			if (titulares.size() == 11)
			{
				eFantasia.cambiarTitulares(titulares);
				return true;
			}
			return false;
	}
	
	public boolean cambiarCapitan(File filedata, Usuario usuario) throws IOException 
	{
		EquipoFantasia eFantasia = usuario.getEFantasia();
		BufferedReader br = new BufferedReader(new FileReader(filedata));
		String linea = br.readLine();
		if (linea != "Capitan")
		{
			br.close();
			return false;
		}
		String nombre = br.readLine();
		br.close();
		return eFantasia.cambiarCapitan(nombre);
	}

}
