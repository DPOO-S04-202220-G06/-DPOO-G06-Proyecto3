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

import Interfaz.InterfazBase;

public class CreadorTemporada extends InterfazBase{
	
	public CreadorTemporada(){
		this.interfaz = new JFrame();
		this.interfaz.setTitle("Crear nueva temporada");
		this.interfaz.setSize(400,100);
		this.interfaz.setLayout(new GridBagLayout());
		this.interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
				
		JLabel label = new JLabel("Cargue los archivos con los datos de la nueva temporada de la liga.");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		interfaz.add(label, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		interfaz.add(Box.createHorizontalStrut(150), gbc);
		
		JButton abrirSelector = new JButton("Buscar");
		gbc.gridx = 1;
		gbc.gridy = 1;
		interfaz.add(abrirSelector, gbc);
			
		abrirSelector.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnAbrirS();		
			}

		});
		this.interfaz.setVisible(true);
		this.trigger = new PropertyChangeSupport(this);
	} 
	
	private void btnAbrirS()
	{
		ocultar();
		JFileChooser selector = new JFileChooser("./data/");
		selector.setMultiSelectionEnabled(true);
		int checker = selector.showOpenDialog(this.interfaz);
		if (checker == JFileChooser.APPROVE_OPTION)
		{
			File[] seleccion = selector.getSelectedFiles();
			trigger.firePropertyChange("crear", null, seleccion);
		}
		if (checker == JFileChooser.CANCEL_OPTION)
		{
			trigger.firePropertyChange("out", null, null);
		}

	}
	public void doneCarga()
	{
		JOptionPane.showMessageDialog(this.interfaz, "Archivos cargados con éxito.", "Carga datos Temporada",
				JOptionPane.INFORMATION_MESSAGE);
		trigger.firePropertyChange("out", null, null);
	}
	public void errorCarga()
	{
		JOptionPane.showMessageDialog(this.interfaz, "Error en la carga del archivo.", "Carga datos Temporada",
				JOptionPane.ERROR_MESSAGE);
		trigger.firePropertyChange("out", null, null);
	}
	public void errorTiempo()
	{
		JOptionPane.showMessageDialog(this.interfaz, "Existe una temporada en curso.", "Carga datos Temporada",
				JOptionPane.ERROR_MESSAGE);
		trigger.firePropertyChange("out", null, null);
	}
}

