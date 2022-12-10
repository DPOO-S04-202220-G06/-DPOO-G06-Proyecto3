package interfazUser;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class cambiarCapitan extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public cambiarCapitan(){
		this.setTitle("Cambiar capitan");
		this.setSize(400,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JPanel capitan = new JPanel(new GridBagLayout()); {
			
			
			JLabel seleccion = new JLabel("Seleccione el jugador que desea designar como capitan: ");
			gbc.gridx = 0;
			gbc.gridy = 0;
			capitan.add(seleccion, gbc);
			
			JComboBox<String> jugTitulares = new JComboBox<String>();
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 2;
			jugTitulares.addItem("Jugador1");
			capitan.add(jugTitulares, gbc);
			
			JPanel opciones = new JPanel(new GridBagLayout());
			
			JButton cancelar = new JButton("Cancelar");
			gbc.gridx = 0;
			gbc.gridy = 0;
			opciones.add(cancelar,gbc);
			
			JButton confirmar = new JButton("Confirmar");
			gbc.gridx = 2;
			gbc.gridy = 0;
			opciones.add(confirmar,gbc);
			
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.getContentPane().add(capitan, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.getContentPane().add(opciones,gbc);
			
			cancelar.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					btnCancelar();
				}

			});
		}
	}
	private void btnCancelar()
    {
 
    	this.dispose();

    }
}
