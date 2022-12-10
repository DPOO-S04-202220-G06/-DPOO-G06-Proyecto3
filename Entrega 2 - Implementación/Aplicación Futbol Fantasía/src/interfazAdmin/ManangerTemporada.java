package interfazAdmin;

import javax.swing.JOptionPane;

import Interfaz.InterfazBase;

public class ManangerTemporada extends InterfazBase{
	
	private final String comenzar = "Comenzar Temporada";
	private final String terminar = "Terminar Temporada";
	private final String exito = "Se realizo la acción con éxito.";
	private final String error = "Error al intentar la acción deseada.";
		
	public void comenzarT()
	{
		JOptionPane.showMessageDialog(this.interfaz, exito, comenzar,
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void errorComenzarT()
	{
		JOptionPane.showMessageDialog(this.interfaz, exito, comenzar,
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void terminarT()
	{
		JOptionPane.showMessageDialog(this.interfaz, error, terminar,
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void errorTerminarT()
	{
		JOptionPane.showMessageDialog(this.interfaz, error, terminar,
				JOptionPane.ERROR_MESSAGE);
	}	
	
}
