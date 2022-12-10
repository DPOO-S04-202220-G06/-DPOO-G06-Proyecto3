package aplicacion;

public abstract class Cuenta {
	private String nombre;
	private String password;
	private boolean admin;
	
	public Cuenta (String nombreCuenta, String passwordCuenta, boolean acceso) 
	{
		this.nombre = nombreCuenta;
		this.password = passwordCuenta;
		this.admin = acceso;			
	}
	
	public boolean verificarCredenciales(String intento) 
	{
		boolean verificador = false;
		if (this.password.equals(intento)) 
		{
			verificador = true;
		}
		return verificador;
	}
	public boolean isAdmin()
	{
		return this.admin;
	}
	public String getNombre()
	{
		return this.nombre;
	}
}

