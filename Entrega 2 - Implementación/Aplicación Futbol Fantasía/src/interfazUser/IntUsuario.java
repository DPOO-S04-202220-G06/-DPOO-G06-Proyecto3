package interfazUser;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Interfaz.InterfazBase;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IntUsuario extends InterfazBase {
	
	public IntUsuario(){
		interfaz = new JFrame();
		interfaz.setTitle("Usuario");
		interfaz.setSize(600,600);
		interfaz.setLayout(new GridBagLayout());
		interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JPanel opciones = new JPanel(new GridBagLayout()); {
			
		
		JButton cambiarCapitan = new JButton("Cambiar Capitan");
		gbc.gridx = 0;
		gbc.gridy = 1;
		opciones.add(cambiarCapitan,gbc);
		
		JButton modificarTitulares = new JButton("Modificar titulares");
		gbc.gridx = 1;
		gbc.gridy = 1;
		opciones.add(modificarTitulares,gbc);
		
		JButton transaccionesJugadores = new JButton("Transaccion jugadores");
		gbc.gridx = 0;
		gbc.gridy = 2;
		opciones.add(transaccionesJugadores,gbc);
		
		JButton eliminarEquipo = new JButton("Eliminar equipo");
		gbc.gridx = 1;
		gbc.gridy = 2;
		opciones.add(eliminarEquipo,gbc);
		
		
		JPanel estadisticas = new JPanel(new GridBagLayout());
		
		JLabel nombre = new JLabel("Nombre: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		estadisticas.add(nombre, gbc);
		
		JLabel puntos = new JLabel("Puntos: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		estadisticas.add(puntos, gbc);
		
		JLabel num_puntos = new JLabel("#");
		gbc.gridx = 1;
		gbc.gridy = 1;
		estadisticas.add(num_puntos, gbc);
		
		JLabel puntosUltJornada = new JLabel("Puntos ultima jornada: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		estadisticas.add(puntosUltJornada, gbc);
		
		JLabel puntUltJornada = new JLabel("#");
		gbc.gridx = 1;
		gbc.gridy = 2;
		estadisticas.add(puntUltJornada, gbc);
		
		JLabel presupuesto = new JLabel("Presupuesto: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		estadisticas.add(presupuesto, gbc);
		
		JLabel presupuestoAct = new JLabel("#");
		gbc.gridx = 1;
		gbc.gridy = 3;
		estadisticas.add(presupuestoAct, gbc);
		
		JLabel mejorJugador = new JLabel("Mejor jugador: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		estadisticas.add(mejorJugador, gbc);
		
		JLabel nomMejorJugador = new JLabel("´Jugador´");
		gbc.gridx = 1;
		gbc.gridy = 4;
		estadisticas.add(nomMejorJugador, gbc);
		
		JLabel ranking = new JLabel("Ranking: ");
		gbc.gridx = 0;
		gbc.gridy = 5;
		estadisticas.add(ranking, gbc);
		
		JLabel rankingEquipo = new JLabel("#");
		gbc.gridx = 1;
		gbc.gridy = 5;
		estadisticas.add(rankingEquipo, gbc);
		
		JButton desempeñoJugadores = new JButton("Desempeño Jugaodres");
		gbc.gridx = 0;
		gbc.gridy = 6;
		opciones.add(desempeñoJugadores,gbc);
		
		JButton consultarRankings = new JButton("Consultar Rankings");
		gbc.gridx = 1;
		gbc.gridy = 6;
		opciones.add(consultarRankings,gbc);
		
		JPanel info = new JPanel(new GridBagLayout());
		
		
		JLabel nombreEquipo = new JLabel("Nombre equipo fantasia");
		gbc.gridx = 0;
		gbc.gridy = 0;
		info.add(nombreEquipo, gbc);
		
		JLabel listaJugadores = new JLabel("Lista jugadores del equipo");
		gbc.gridx = 0;
		gbc.gridy = 3;
		info.add(listaJugadores, gbc);
		
		
		opciones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Opciones de Equipo"));
		estadisticas.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Mis Estadisticas"));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.interfaz.getContentPane().add(info);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.interfaz.getContentPane().add(opciones, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.interfaz.getContentPane().add(estadisticas, gbc);

		this.trigger = new PropertyChangeSupport(this);
		}
	
	}	
}

