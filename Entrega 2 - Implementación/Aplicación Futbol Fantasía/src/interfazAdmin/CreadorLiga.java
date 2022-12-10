package interfazAdmin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;
import java.io.File;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import Interfaz.InterfazBase;

public class CreadorLiga extends InterfazBase{
	
	private JFrame interfazB;
	private String nombre;
	
	public CreadorLiga(){
		this.interfaz = new JFrame();
		this.interfaz.setTitle("Crear nueva liga");
		this.interfaz.setSize(250,160);
		this.interfaz.setLayout(new GridBagLayout());
		this.interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;

		JLabel nombre = new JLabel("Nombre de la nueva Liga: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		interfaz.add(nombre, gbc);
								
		JTextField nombreText = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 1;
		interfaz.add(nombreText, gbc);
				
		JButton cancelar = new JButton("Cancelar");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		interfaz.add(cancelar, gbc);
		
		JButton siguiente = new JButton("Siguiente");
		gbc.gridx = 2;
		gbc.gridy = 2;
		interfaz.add(siguiente, gbc);
		
		this.interfaz.setVisible(true);
		
		cancelar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				trigger.firePropertyChange("out", null, null);
				cerrar();
			}

		});
		
		siguiente.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnSiguiente(nombreText);
			}

		});
		this.trigger = new PropertyChangeSupport(this);
	} 
	
	private void btnSiguiente(JTextField nombreText)
	{
		String nombre = nombreText.getText();
		if (nombre.length() == 0)
		{
			JOptionPane.showMessageDialog(this.interfaz, "Nombre de liga vacío.", "Error nombre",
					JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			this.nombre = nombre;
			trigger.firePropertyChange("nombre", null, nombre);
		}
	}
	
	public void errorNombre()
	{
		JOptionPane.showMessageDialog(this.interfaz, "Liga ya existente.", "Error nombre Liga",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void errorCarga()
	{
		JOptionPane.showMessageDialog(this.interfaz, "Error en la carga del archivo.", "Carga datos Liga",
				JOptionPane.ERROR_MESSAGE);
		trigger.firePropertyChange("out", null, null);
	}
	
	public void doneCarga()
	{
		JOptionPane.showMessageDialog(this.interfaz, "Archivos cargados con éxito.", "Carga datos Liga",
				JOptionPane.INFORMATION_MESSAGE);
		trigger.firePropertyChange("out", null, null);
	}
	
	public void agregarArchivos()
	{
		ocultar();
		interfazB = new JFrame();
		this.interfazB.setTitle("Crear nueva liga");
		this.interfazB.setSize(400,100);
		this.interfazB.setLayout(new GridBagLayout());
		this.interfazB.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
				
		JLabel label = new JLabel("Cargue los archivos con los datos de la primera temporada de la liga.");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		interfazB.add(label, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		interfazB.add(Box.createHorizontalStrut(150), gbc);
		
		JButton abrirSelector = new JButton("Buscar");
		gbc.gridx = 1;
		gbc.gridy = 1;
		interfazB.add(abrirSelector, gbc);
			
		abrirSelector.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnAbrirS();		
			}

		});
		this.interfazB.setVisible(true);
		
				
	}

	private void btnAbrirS()
	{
		this.interfazB.dispose();
		JFileChooser selector = new JFileChooser("./data/");
		selector.setMultiSelectionEnabled(true);
		int checker = selector.showOpenDialog(this.interfazB);
		if (checker == JFileChooser.APPROVE_OPTION)
		{
			File[] seleccion = selector.getSelectedFiles();
			trigger.firePropertyChange("files", this.nombre, seleccion);
		}
		if (checker == JFileChooser.CANCEL_OPTION)
		{
			trigger.firePropertyChange("out", null, null);
		}

	}
	
}
