package interfazUser;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class modificarTitulares extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public modificarTitulares(){
		this.setTitle("Modificar titulares");
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		
		JPanel titulares = new JPanel(new GridBagLayout()); {
			
			
		JLabel seleccion = new JLabel("Seleccione los jugadores que desea sean titulares: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		titulares.add(seleccion, gbc);
		
		JPanel opciones = new JPanel(new GridBagLayout()); 
		
		JCheckBox jugadoresTitulares = new JCheckBox ("Jugador1");
		gbc.gridx = 0;
		gbc.gridy = 1;
		titulares.add(jugadoresTitulares, gbc);
		
		JButton cancelar = new JButton("Cancelar");
		gbc.gridx = 0;
		gbc.gridy = 0;
		opciones.add(cancelar,gbc);
		
		JButton confirmar = new JButton("Confirmar");
		gbc.gridx = 1;
		gbc.gridy = 0;
		opciones.add(confirmar,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.getContentPane().add(titulares, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.getContentPane().add(opciones, gbc);
		
		
		cancelar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnCancelar();
			}

		});
		confirmar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnConfirmar();
			}

		});
	
	
		}
	
	}
	
	private void btnCancelar()
    {
 
    	this.dispose();
    }
	private void btnConfirmar()
    {
		this.dispose();
    	JFrame frame = new JFrame();
    	frame.setTitle("Modificar titulares");
    	frame.setSize(300,300);
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	frame.setLayout(new GridBagLayout());
    	frame.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JPanel titulares = new JPanel(new GridBagLayout()); {
			
			
		JLabel seleccion = new JLabel("Sus titulares han sido actualizados!");
		gbc.gridx = 0;
		gbc.gridy = 0;
		titulares.add(seleccion, gbc);
		
		}
    }
}



