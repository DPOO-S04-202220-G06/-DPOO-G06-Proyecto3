package Interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CerrarSesion extends InterfazBase {
		
	public CerrarSesion()
	{	
		this.interfaz = new JFrame();
		interfaz.setTitle("Cerrar Sesión");
		interfaz.setSize(400,120);
		interfaz.setLayout(new GridBagLayout());
		interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
				
		JLabel nombre = new JLabel("Sesión cerrada con éxito.");
		gbc.gridx = 0;
		gbc.gridy = 0;		
		interfaz.add(nombre, gbc);
		
		JButton aceptar = new JButton("Aceptar");
		gbc.gridx = 0;
		gbc.gridy = 1;		
		interfaz.add(aceptar, gbc);
		
		aceptar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				trigger.firePropertyChange("out", null, null);			
			}

		});
		
		interfaz.setVisible(true);
		trigger = new PropertyChangeSupport(this);
	}
}
