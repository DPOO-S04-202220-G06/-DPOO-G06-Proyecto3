package interfazUser;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

public class eliminarEquipo extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public eliminarEquipo(){
		this.setTitle("eliminarEquipo");
		this.setSize(300,150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		gbc.anchor = GridBagConstraints.LINE_START;

		JPanel eliminar = new JPanel(new GridBagLayout()); {
			
			
			JLabel elimEquipo = new JLabel("Esta seguro que desea eliminar su equipo? ");
			gbc.gridx = 0;
			gbc.gridy = 0;
			eliminar.add(elimEquipo, gbc);
			
		JPanel seleccion = new JPanel(new GridBagLayout());
		
		JButton confirmar = new JButton("Confirmar");
		gbc.gridx = 1;
		gbc.gridy = 1;
		seleccion.add(confirmar,gbc);
		
		JButton cancelar = new JButton("Cancelar");
		gbc.gridx = 0;
		gbc.gridy = 1;
		seleccion.add(cancelar,gbc);
			
		
		
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.getContentPane().add(elimEquipo, gbc);
			
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.getContentPane().add(seleccion, gbc);
			
			
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
	
	
	private void btnConfirmar()
    {
		JFrame eliminar = new JFrame();
		eliminar.setTitle("Eliminar equipo");
		eliminar.setSize(400,120);
		eliminar.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JLabel elim = new JLabel("Equipo eliminado. Ahora será enviado a crear un nuevo equipo.");
		gbc.gridx = 0;
		gbc.gridy = 1;
		eliminar.add(elim,gbc);

    }
    private void btnCancelar()
    {
 
    	this.dispose();

    }
}
