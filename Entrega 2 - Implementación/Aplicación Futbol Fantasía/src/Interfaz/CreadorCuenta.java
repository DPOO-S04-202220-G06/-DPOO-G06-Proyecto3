package Interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.beans.PropertyChangeSupport;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreadorCuenta extends InterfazBase{
	private JTextField nombre;
	private JTextField password;
	private ArrayList<String> resultado;
	
	public CreadorCuenta(){
		this.interfaz = new JFrame();
		this.interfaz.setTitle("Crear cuenta");
		this.interfaz.setSize(365,180);
		this.interfaz.setLayout(new GridBagLayout());
		this.interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
				
		JLabel nombre = new JLabel("Nombre de usuario: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.interfaz.add(nombre, gbc);
		
		JTextField nombreText = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		this.interfaz.add(nombreText, gbc);
						
		JLabel password = new JLabel("Contraseña: ");
		gbc.insets = new Insets(6,3,5,6);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		this.interfaz.add(password, gbc);
		
		JTextField passwordText = new JPasswordField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		this.interfaz.add(passwordText, gbc);
		
		JButton cancelar = new JButton("Cancelar");
		gbc.insets = new Insets(20,3,5,6);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		this.interfaz.add(cancelar, gbc);

		JButton siguiente = new JButton("Siguiente");
		gbc.insets = new Insets(20,120,5,6);
		gbc.gridx = 2;
		gbc.gridy = 2;
		
		this.interfaz.add(siguiente, gbc);
		
		this.nombre = nombreText;
		this.password = passwordText;

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
		
		
		trigger = new PropertyChangeSupport(this);
	}
	
    private void btnCancelar()
    {
		cerrar();
		this.resultado = new ArrayList<String>(1);
		this.resultado.add("out");
		trigger.firePropertyChange("resultado", null, this.resultado);
    }
    
	private void btnSiguiente()
	{
		String nombreIngresado = this.nombre.getText();
		String passwordIngresado = this.password.getText();
		this.resultado = new ArrayList<String>(3);
		this.resultado.add("new");
		this.resultado.add(nombreIngresado);
		this.resultado.add(passwordIngresado);
		trigger.firePropertyChange("resultado", null, this.resultado);
	}
		
	public void errorCuenta()
	{
		JFrame eCuenta = new JFrame();
		eCuenta.setTitle("Crear cuenta");
		eCuenta.setSize(400,120);
		eCuenta.setLayout(new GridBagLayout());
		eCuenta.setLocationRelativeTo(this.interfaz);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
				
		JLabel nombre = new JLabel("Usuario ya existente. Por favor intente un nuevo nombre.");
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
			}

		});
		
		eCuenta.setVisible(true);		
	}
	
	public void exitoso()
	{
		JFrame eCuenta = new JFrame();
		eCuenta.setTitle("Crear cuenta");
		eCuenta.setSize(400,120);
		eCuenta.setLayout(new GridBagLayout());
		eCuenta.setLocationRelativeTo(this.interfaz);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
				
		JLabel nombre = new JLabel("Cuenta creada con éxito. Ahora se dirigirá al creador de equipo.");
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
		
}


