package interfazUser;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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

public class transaccionesJugadores extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public transaccionesJugadores(){
		this.setTitle("Transacciones jugadores");
		this.setSize(900,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		gbc.anchor = GridBagConstraints.LINE_START;
	
	
		JPanel vender = new JPanel(new GridBagLayout());
	
		JLabel seleccion = new JLabel("Seleccione el jugador que desea vender: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		vender.add(seleccion, gbc);
		
		JCheckBox venderJugador = new JCheckBox ("Jugador1");
		gbc.gridx = 0;
		gbc.gridy = 1;
		vender.add(venderJugador, gbc);
		
		JPanel info1 = new JPanel(new GridBagLayout());
		
		JLabel balance = new JLabel("Balance: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		info1.add(balance, gbc);
		
		JLabel numero = new JLabel ("#");
		gbc.gridx = 1;
		gbc.gridy = 0;
		info1.add(numero, gbc);
		
		JPanel info2 = new JPanel(new GridBagLayout());
		
		JLabel nuevoPresupuesto = new JLabel("Nuevo presupuesto");
		gbc.gridx = 0;
		gbc.gridy = 1;
		info2.add(nuevoPresupuesto, gbc);
		
		JPanel info3 = new JPanel(new GridBagLayout());
		
		JButton confirmar = new JButton("Confirmar transaccion");
		gbc.gridx = 0;
		gbc.gridy = 0;
		info3.add(confirmar,gbc);
		
		JButton cancelar = new JButton("Cancelar transaccion");
		gbc.gridx = 0;
		gbc.gridy = 1;
		info3.add(cancelar,gbc);
		
		
		
		JPanel comprar = new JPanel(new GridBagLayout());
		
		JLabel eleccion = new JLabel("Seleccione el jugador\n que desea comprar: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		comprar.add(eleccion, gbc);
		
		JCheckBox comprarJugador = new JCheckBox ("Jugador1");
		gbc.gridx = 0;
		gbc.gridy = 1;
		comprar.add(comprarJugador, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.getContentPane().add(vender, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.getContentPane().add(info1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.getContentPane().add(info2, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.getContentPane().add(info3, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.getContentPane().add(comprar, gbc);
		
		
		vender.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Vender Jugador"));
		info1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Balance Operacion"));
		info2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Presupuesto"));
		comprar.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Comprar Jugador"));
		
	}
	
}
