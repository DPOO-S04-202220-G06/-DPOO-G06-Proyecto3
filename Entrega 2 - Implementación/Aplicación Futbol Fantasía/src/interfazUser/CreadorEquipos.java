package interfazUser;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Interfaz.InterfazBase;
import controlador.Controlador;

public class CreadorEquipos extends InterfazBase{
	private JComboBox<String> comboBox;
	private JTextField nombreEquipo;
	
	public CreadorEquipos(){
		this.interfaz = new JFrame();
		this.interfaz.setTitle("Crear equipo");
		this.interfaz.setSize(300,200);
		this.interfaz.setLayout(new GridBagLayout());
		this.interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,40,6);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel ligas = new JLabel("Ligas: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(ligas, gbc);
								
		JComboBox<String> comboBox = new JComboBox<String>();
		gbc.gridx = 1;
		gbc.gridy = 0;
		comboBox.addItem("Liga Santander 22-23");
		panel.add(comboBox, gbc);
		
		JLabel nombre = new JLabel("Nombre del equipo: ");
		gbc.insets = new Insets(6,3,5,6);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(nombre, gbc);
		
		JTextField nombreText = new JTextField(14);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(nombreText, gbc);
				
		JButton cancelar = new JButton("Cancelar");
		gbc.gridx = 0;
		gbc.gridy = 1;
		interfaz.add(cancelar, gbc);
		
		JButton siguiente = new JButton("Siguiente");
		gbc.insets = new Insets(6,90,5,6);
		gbc.gridx = 2;
		gbc.gridy = 1;
		interfaz.add(siguiente, gbc);
		
		gbc.insets = new Insets(6,3,5,6);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		this.interfaz.getContentPane().add(panel, gbc);
		
		cancelar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnCancelar();
			}

		});
		
		siguiente.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnSiguiente();
				
			}

		});
		
		this.comboBox = comboBox;
		this.nombreEquipo = nombreText;
		trigger = new PropertyChangeSupport(this);
	}
    private void btnCancelar()
    {
		cerrar();
		JFrame eCuenta = new JFrame();
		eCuenta.setTitle("Crear equipo");
		eCuenta.setSize(400,120);
		eCuenta.setLayout(new GridBagLayout());
		eCuenta.setLocationRelativeTo(this.interfaz);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
				
		JLabel nombre = new JLabel("Operación cancelada por el usuario.");
		gbc.gridx = 0;
		gbc.gridy = 0;		
		eCuenta.add(nombre, gbc);
		
		JButton aceptar = new JButton("Aceptar");
		gbc.gridx = 0;
		gbc.gridy = 1;		
		eCuenta.add(aceptar, gbc);
		
		aceptar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				eCuenta.dispose();
				trigger.firePropertyChange("resultado", null, null);
			}

		});
		
		eCuenta.setVisible(true);
    }
    
	private void btnSiguiente()
	{
		String selLiga = String.valueOf(this.comboBox.getSelectedItem());
		String nombreIngresado = this.nombreEquipo.getText();
	}
}

