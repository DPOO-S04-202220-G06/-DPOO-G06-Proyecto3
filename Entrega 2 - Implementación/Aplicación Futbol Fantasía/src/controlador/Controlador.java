package controlador;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Interfaz.CerrarSesion;
import Interfaz.CreadorCuenta;
import Interfaz.Ingreso;
import aplicacion.Administrador;
import aplicacion.Aplicacion;
import aplicacion.Cuenta;
import aplicacion.Usuario;
import interfazAdmin.AbridorLiga;
import interfazAdmin.CreadorLiga;
import interfazAdmin.CreadorTemporada;
import interfazAdmin.IntAdmin;
import interfazAdmin.SubidorR;
import interfazAdmin.ManangerTemporada;
import interfazUser.CreadorEquipos;
import interfazUser.IntUsuario;
import liga.Liga;

public class Controlador implements PropertyChangeListener{
	private Aplicacion appFutbol;
	private Cuenta cuenta;
	private Ingreso vtnIngreso;
	private CreadorCuenta vtnCCuenta;
	private CreadorEquipos vtnCEquipo;
	private IntAdmin vtnAdmin;
	private CreadorLiga vtnCLiga;
	private AbridorLiga vtnALiga;
	private CreadorTemporada vtnCTemp;
	private ManangerTemporada vtnMTemp;
	private SubidorR vtnSubir;
	private IntUsuario vtnUser;
	private CerrarSesion vtnCerrarS;
	
	//private MenuUser vtnUser;
	
	private Controlador() throws IOException, ParseException
	{
		this.appFutbol = new Aplicacion();
		this.vtnIngreso = new Ingreso();
		this.vtnIngreso.agregarPCL(this);
		this.vtnIngreso.mostrar();
	}
		
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object fuente = evt.getSource();
		
		if(fuente instanceof Ingreso)
		{
			csIngreso(evt);
		}
		
		if(fuente instanceof CreadorCuenta)
		{
			csCrearCuenta(evt);
		}
		
		if(fuente instanceof CreadorEquipos)
		{
			csCrearEquipo(evt);
		}
		
		if(fuente instanceof IntAdmin)
		{
			csIntAdmin(evt);
		}
		
		if(fuente instanceof CreadorLiga)
		{
			csCrearLiga(evt);
		}
		if(fuente instanceof AbridorLiga)
		{
			csAbrirLiga(evt);
		}
		if(fuente instanceof CreadorTemporada)
		{
			csCTemporada(evt);
		}
		if(fuente instanceof SubidorR)
		{
			csSubir(evt);
		}
		if(fuente instanceof CerrarSesion)
		{
			csCerrarS(evt);
		}
	}
	
	private void csIngreso(PropertyChangeEvent evt)
	{
		@SuppressWarnings("unchecked")
		ArrayList<String> datos = (ArrayList<String>) evt.getNewValue();
		switch (datos.get(0))
		{
		case "new":
			this.nuevaCuenta();
			break;
		case "old":
			this.compararDatos(datos.get(1), datos.get(2));
			break;
		}
	}
	
	private void csCrearCuenta(PropertyChangeEvent evt)
	{
		if (evt.getNewValue() == null)
		{
			this.vtnCCuenta.cerrar();
			this.vtnCEquipo.mostrar();
		}
		else
		{
		@SuppressWarnings("unchecked")
		ArrayList<String> datos = (ArrayList<String>) evt.getNewValue();
		switch (datos.get(0))
		{
		case "out":
			this.vtnIngreso.mostrar();
			break;
		case "new":
			this.crearDatos(datos.get(1), datos.get(2));
			break;
		}
		}
	}
	
	private void csCrearEquipo(PropertyChangeEvent evt)
	{
		if (evt.getNewValue() == null)
		{
			this.vtnIngreso.mostrar();
		}
	}
	
	private void csIntAdmin(PropertyChangeEvent evt)
	{
		String token = (String) evt.getNewValue();
		switch (token)
		{
		case "cLiga":
			this.vtnCLiga = new CreadorLiga();
			this.vtnCLiga.agregarPCL(this);
			this.vtnAdmin.ocultar();
			this.vtnCLiga.mostrar();
			break;
		case "aLiga":
			ArrayList<String> listaLigas = this.appFutbol.getLigas();
			if (listaLigas.size()== 0)
			{
				this.vtnAdmin.errorLigas();
			}
			else
			{
			this.vtnALiga = new AbridorLiga(listaLigas);
			this.vtnALiga.agregarPCL(this);
			this.vtnAdmin.ocultar();
			this.vtnALiga.mostrar();
			}
			break;
		case "cTemporada":
			this.vtnCTemp = new CreadorTemporada();
			this.vtnCTemp.agregarPCL(this);
			this.vtnAdmin.ocultar();
			this.vtnCTemp.mostrar();
			break;
		case "bTemporada":
			this.vtnMTemp = new ManangerTemporada();
			this.vtnMTemp.agregarPCL(this);
			boolean comenzarT = this.appFutbol.comenzarTemporada();
			if (comenzarT)
			{
				this.vtnMTemp.comenzarT();
			}
			else
			{
				this.vtnMTemp.errorComenzarT();
			}
			break;
		case "eTemporada":
			this.vtnMTemp = new ManangerTemporada();
			this.vtnMTemp.agregarPCL(this);
			boolean terminarT = this.appFutbol.terminarTemporada();
			if (terminarT)
			{
				this.vtnMTemp.terminarT();
			}
			else
			{
				this.vtnMTemp.errorTerminarT();
			}
			break;
		case "subir":
			this.vtnSubir = new SubidorR();
			this.vtnSubir.agregarPCL(this);
			this.vtnAdmin.ocultar();
			this.vtnSubir.mostrar();
			break;
		case "out":
			this.vtnAdmin.cerrar();
			this.vtnCerrarS = new CerrarSesion();
			this.vtnCerrarS.agregarPCL(this);
			this.vtnCerrarS.mostrar();
			break;
		}
	}
	
	private void csCrearLiga(PropertyChangeEvent evt)
	{
		String token = evt.getPropertyName();
		switch (token)
		{
		case "nombre":
			boolean checker = this.appFutbol.verificarNombreLiga((String) 
					evt.getNewValue(), (Administrador) this.cuenta);
			if (!checker)
			{
				this.vtnCLiga.errorNombre();
			}
			else
			{
				this.vtnCLiga.agregarArchivos();
			}
			break;
		case "files":
			ArrayList<File> datos = new ArrayList<File>(3);
			File[] seleccion = (File[]) evt.getNewValue();
			for(File path: seleccion)
			{
				datos.add(path);
			}
			boolean checkerLiga = this.appFutbol.crearLiga((String) evt.getOldValue(),
					datos, (Administrador) this.cuenta);
			if (!checkerLiga)
			{
				this.vtnCLiga.errorCarga();
			}
			else
			{
				this.vtnCLiga.doneCarga();
				this.vtnAdmin.actualizar();
			}
			break;
		case "out":
			this.vtnCLiga.cerrar();
			this.vtnAdmin.mostrar();
			break;
		}
	}
	
	private void csAbrirLiga(PropertyChangeEvent evt)
	{
		String token = evt.getPropertyName();
		switch (token)
		{
		case "abrir":
			Liga liga = this.appFutbol.abrirLiga((String) 
					evt.getNewValue());
			this.vtnAdmin.agregarLiga(liga);
			this.vtnAdmin.actualizar();
			this.vtnAdmin.mostrar();
			break;
		case "out":
			this.vtnALiga.cerrar();
			this.vtnAdmin.mostrar();
			break;
		}
	}
	
	private void csCTemporada(PropertyChangeEvent evt)
	{
		String token = evt.getPropertyName();
		switch (token)
		{
		case "crear":
			ArrayList<File> datos = new ArrayList<File>(3);
			File[] seleccion = (File[]) evt.getNewValue();
			for(File path: seleccion)
			{
				datos.add(path);
			}
			int checkerCT = this.appFutbol.crearTemporada(datos, (Administrador) this.cuenta);
			switch (checkerCT)
			{
			case 0:
			{
				this.vtnCTemp.doneCarga();
				this.vtnAdmin.actualizar();
				break;
			}
			case 1:
			{
				this.vtnCTemp.errorCarga();
				break;
			}
			case 2:
			{
				this.vtnCTemp.errorTiempo();
				break;
			}
			}
			break;
		case "out":
			this.vtnALiga.cerrar();
			this.vtnAdmin.mostrar();
			break;
		}
	}
			
	private void csSubir(PropertyChangeEvent evt)
	{
		String token = evt.getPropertyName();
		switch (token)
		{
		case "cargar":
			File seleccion = (File) evt.getNewValue();
			int checkerCT = this.appFutbol.subirResultados(seleccion, (Administrador) this.cuenta);
			switch (checkerCT)
			{
			case 0:
			{
				this.vtnCTemp.doneCarga();
				this.vtnAdmin.actualizar();
				break;
			}
			case 1:
			{
				this.vtnCTemp.errorCarga();
				break;
			}
			case 2:
			{
				this.vtnCTemp.errorTiempo();
				break;
			}
			}
			break;
		case "out":
			this.vtnALiga.cerrar();
			this.vtnAdmin.mostrar();
			break;
		}
	}
	
	private void csCerrarS(PropertyChangeEvent evt)
	{
		this.vtnCerrarS.cerrar();
		this.vtnIngreso = new Ingreso();
		this.vtnIngreso.agregarPCL(this);
		this.vtnIngreso.mostrar();
	}
	
	private void nuevaCuenta()
	{
		this.vtnCCuenta = new CreadorCuenta();
		this.vtnCCuenta.agregarPCL(this);
		this.vtnIngreso.ocultar();
		this.vtnCCuenta.mostrar();
	}
	
	private void compararDatos(String usuario, String password)
	{
		Cuenta cuenta = this.appFutbol.ingresar(usuario, password);
		if (cuenta == null)
		{
			this.vtnIngreso.errorLogin();
		}
		else
		{
			this.vtnIngreso.cerrar();
			if (cuenta.isAdmin())
			{
				this.cuenta = (Administrador) cuenta;
				this.vtnAdmin = new IntAdmin(this.cuenta);
				this.vtnAdmin.agregarPCL(this);
				this.vtnAdmin.mostrar();
			}
			else 
			{
				this.cuenta = (Usuario) cuenta;
				//this.vtnUser = new IntUsuario(this.cuenta);
				this.vtnUser.agregarPCL(this);
				this.vtnUser.mostrar();
			}
		}
	}
	
	private void crearDatos(String usuario, String password)
	{
		Cuenta cuenta = this.appFutbol.crearCuenta(usuario, password);
		if (cuenta == null)
		{
			this.vtnCCuenta.errorCuenta();
		}
		else
		{
			this.vtnCCuenta.exitoso();
			this.vtnCEquipo = new CreadorEquipos();
			this.vtnCEquipo.agregarPCL(this);
		}
	}
	
		
	public static void main(String[] args) throws IOException, ParseException
	{
		new Controlador();
	}

}
