package aplicacion;

import fantasia.EquipoFantasia;

public class Usuario extends Cuenta {
	public EquipoFantasia equipo;
	
	public Usuario(String nombreCuenta, String passwordCuenta) 
	{
		super(nombreCuenta, passwordCuenta, false);
	}
	
	public void guardarEquipo(EquipoFantasia nuevoEquipo)
	{
		this.equipo = nuevoEquipo;
	}
	
	public EquipoFantasia getEFantasia()
	{
		return equipo;
	}
}
