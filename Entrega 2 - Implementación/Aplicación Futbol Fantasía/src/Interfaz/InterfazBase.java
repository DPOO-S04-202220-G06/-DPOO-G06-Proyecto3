package Interfaz;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JFrame;

public abstract class InterfazBase{
	protected JFrame interfaz;
	protected PropertyChangeSupport trigger;
	
	public void mostrar()
	{
		this.interfaz.setVisible(true);
	}
	
	public void ocultar()
	{
		this.interfaz.setVisible(false);
	}
	
	public void cerrar()
	{
		this.interfaz.dispose();
	}
	
    public void agregarPCL(PropertyChangeListener pcl) {
        this.trigger.addPropertyChangeListener(pcl);
    }
    
    public void quitarPCL(PropertyChangeListener pcl) {
        this.trigger.removePropertyChangeListener(pcl);
    }
}
