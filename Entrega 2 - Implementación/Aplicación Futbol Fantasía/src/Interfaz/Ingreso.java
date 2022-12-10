package Interfaz;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ingreso extends InterfazBase{
	private JTextField nombre;
	private JTextField password;
	private ArrayList<String> resultado;
	
	public Ingreso(){
		this.interfaz = new JFrame();
		this.interfaz.setTitle("Inicio de sesión");
		this.interfaz.setSize(450,320);
		this.interfaz.setLayout(new BorderLayout());
		this.interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JPanel login = new JPanel(new GridBagLayout());
		
		JLabel nombre = new JLabel("Nombre de usuario: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		login.add(nombre, gbc);
						
		JLabel password = new JLabel("Contraseña: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		login.add(password, gbc);
		
		JTextField nombreText = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		login.add(nombreText, gbc);
		
		JTextField passwordText = new JPasswordField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		login.add(passwordText, gbc);
		
		JButton ingresar = new JButton("Ingresar");
		gbc.gridx = 1;
		gbc.gridy = 2;
		login.add(ingresar, gbc);
		
		JPanel nuevo = new JPanel(new GridBagLayout());

		JButton crearCuenta = new JButton("Crear cuenta");
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		nuevo.add(crearCuenta, gbc);
		this.interfaz.getContentPane().add(login, BorderLayout.CENTER);
		this.interfaz.getContentPane().add(nuevo, BorderLayout.PAGE_END);
		this.nombre = nombreText;
		this.password = passwordText;
		
		ingresar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
					btnIngresar();
			}

		});
		
		crearCuenta.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnCrearCuenta();
				
			}

		});
		
		
		this.trigger = new PropertyChangeSupport(this);
	} 

	private void btnIngresar()
	{
		String nombreIngresado = this.nombre.getText();
		String passwordIngresado = this.password.getText();
		if (nombreIngresado.length()== 0 || passwordIngresado.length()== 0)
		{
			JOptionPane.showMessageDialog(this.interfaz, "Existen campos vacíos", "Error ingreso",
					JOptionPane.ERROR_MESSAGE);
		}
		else
		{
		this.resultado = new ArrayList<String>(3);
		this.resultado.add("old");
		this.resultado.add(nombreIngresado);
		this.resultado.add(passwordIngresado);
		this.trigger.firePropertyChange("resultado", null, this.resultado);
		}
	}
	
	private void btnCrearCuenta()
	{
		this.resultado = new ArrayList<String>(1);
		this.resultado.add("new");
		this.trigger.firePropertyChange("resultado", null, this.resultado);
	}
	
	public void errorLogin()
	{
		JOptionPane.showMessageDialog(this.interfaz, "Cuenta no encontrada. "
				+ "Por favor verifique los datos ingresados.", "Error ingreso",
				JOptionPane.ERROR_MESSAGE);
	}
	
}

