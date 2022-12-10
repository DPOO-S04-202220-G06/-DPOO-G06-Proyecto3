package interfazAdmin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Interfaz.InterfazBase;

public class AbridorLiga extends InterfazBase{
	
	
	public AbridorLiga(ArrayList<String> Ligas){
		this.interfaz = new JFrame();
		this.interfaz.setTitle("Abrir una liga");
		this.interfaz.setSize(240,260);
		this.interfaz.setLayout(new GridBagLayout());
		this.interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,100,6);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel nombre = new JLabel("Ligas: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(nombre, gbc);
								
		JComboBox<String> comboBox = new JComboBox<String>();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		for (String liga: Ligas)
		{
			comboBox.addItem(liga);
		}
		panel.add(comboBox, gbc);
				
		JButton cancelar = new JButton("Cancelar");
		gbc.insets = new Insets(6,3,5,6);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		interfaz.add(cancelar, gbc);
		
		JButton abrir = new JButton("Siguiente");
		gbc.gridx = 2;
		gbc.gridy = 1;
		interfaz.add(abrir, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		this.interfaz.getContentPane().add(panel, gbc);
		
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
		
		abrir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnAbrir(comboBox);
			}

		});
		this.trigger = new PropertyChangeSupport(this);
	}
	
	public void btnAbrir(JComboBox<String> comboBox)
	{
		String seleccion = (String) comboBox.getSelectedItem();
		trigger.firePropertyChange("abrir", null, seleccion);
		cerrar();
	}
}
