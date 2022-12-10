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
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class consultarRanking extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public consultarRanking(){
		this.setTitle("Consultar ranking");
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JPanel seleccion = new JPanel(new GridBagLayout());
		
		JLabel criterio = new JLabel("Eliga el criterio por el que desea rankear:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		seleccion.add(criterio, gbc);
		
		JComboBox<String> tipoRanking = new JComboBox<String>();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		tipoRanking.addItem("Equipos por puntos acumulados");
		tipoRanking.addItem("Jugadores por puntos acumulados");
		tipoRanking.addItem("Mejor equipo por fecha");
		seleccion.add(tipoRanking, gbc);
		
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
		this.getContentPane().add(seleccion, gbc);
		
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
		
		confirmar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnConfirmar(tipoRanking);
			}

		});
		

	}
	private void btnCancelar()
    {
 
    	this.dispose();

    }
	private void btnConfirmar(JComboBox<String> tipoRanking)
    {
		this.dispose();
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		frame.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		gbc.anchor = GridBagConstraints.LINE_START;
		String tipo = (String) tipoRanking.getSelectedItem();
		JPanel seleccion = new JPanel(new GridBagLayout());
		JButton cancelar = new JButton("Cancelar");
		gbc.gridx = 0;
		gbc.gridy = 0;
		seleccion.add(cancelar,gbc);
		
		switch(tipo) {
		case "Equipos por puntos acumulados":
			frame.setTitle("Ranking Equipos");
			JLabel equiposPorPuntos = new JLabel("Equipos por puntos acumulados");
			gbc.gridx = 0;
			gbc.gridy = 0;
			seleccion.add(equiposPorPuntos, gbc);
			
			JLabel listaEquipos = new JLabel("Lista de los equipos por puntos acumulados");
			gbc.gridx = 0;
			gbc.gridy = 0;
			seleccion.add(listaEquipos, gbc);
			
		
		case "Jugadores por puntos acumulados":
			frame.setTitle("Ranking Jugadores");
			JLabel jugadoresPorPuntos = new JLabel("Jugadores por puntos acumulados");
			gbc.gridx = 0;
			gbc.gridy = 0;
			seleccion.add(jugadoresPorPuntos, gbc);
			
			JLabel listaJugadores = new JLabel("Lista de los equipos por puntos acumulados");
			gbc.gridx = 0;
			gbc.gridy = 0;
			seleccion.add(listaJugadores, gbc); 	

    }
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.getContentPane().add(seleccion, gbc);	
    }
}