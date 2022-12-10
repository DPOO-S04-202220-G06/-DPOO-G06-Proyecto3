package aplicacion;

public class Administrador extends Cuenta{
	private int ligasCreadas;
	private int temporadasCreadas;
	private int resultadosCargados;
	
	public Administrador(String nombreCuenta, String passwordCuenta) 
	{
		super(nombreCuenta, passwordCuenta, true);
		this.ligasCreadas = 0;
		this.temporadasCreadas = 0;
		this.resultadosCargados = 0;
	}
	
	public void ligaCreada()
	{
		this.ligasCreadas += 1;
	}
	
	public void temporadaCreada()
	{
		this.temporadasCreadas += 1;
	}
	
	public void resultadoCargado()
	{
		this.resultadosCargados += 1;
	}
	
	public int getLigas()
	{
		return this.ligasCreadas;
	}
	
	public int getTemporadas()
	{
		return this.temporadasCreadas;
	}
	
	public int getResultados()
	{
		return this.resultadosCargados;
	}
}
