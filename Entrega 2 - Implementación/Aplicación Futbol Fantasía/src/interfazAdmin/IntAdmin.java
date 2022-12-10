package interfazAdmin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Interfaz.InterfazBase;
import aplicacion.Administrador;
import aplicacion.Cuenta;
import liga.Liga;

public class IntAdmin extends InterfazBase{
	
	private Administrador admin;
	private Liga liga;
	private JLabel name;
	private JLabel num_ligas;
	private JLabel num_temporadas;
	private JLabel num_resultados;
	private JLabel val_liga;
	
	public IntAdmin(Cuenta cuenta){
		Administrador admin = (Administrador) cuenta;
		this.admin = admin;		
		this.interfaz = new JFrame();
		this.interfaz.setTitle("Administrador");
		this.interfaz.setSize(565,330);
		this.interfaz.setLayout(new GridBagLayout());
		this.interfaz.setLocationRelativeTo(null);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6,3,5,6);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		JPanel opciones = new JPanel(new GridBagLayout());
		
		JButton crearLiga = new JButton("Crear Liga");
		gbc.gridx = 0;
		gbc.gridy = 0;
		opciones.add(crearLiga,gbc);
		
		JButton abrirLiga = new JButton("Abrir Liga");
		gbc.gridx = 1;
		gbc.gridy = 0;
		opciones.add(abrirLiga,gbc);
				
		JPanel estadisticas = new JPanel(new GridBagLayout());
				
		JLabel nombre = new JLabel("Nombre: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		estadisticas.add(nombre, gbc);
		this.name = nombre;
		
		JLabel nombreAdmin = new JLabel(admin.getNombre());
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		estadisticas.add(nombreAdmin, gbc);
		
		JLabel ligasCreadas = new JLabel("Ligas creadas: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		estadisticas.add(ligasCreadas, gbc);
		
		JLabel num_ligasCreadas = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 1;
		estadisticas.add(num_ligasCreadas, gbc);
		this.num_ligas = num_ligasCreadas;
		
		JLabel temporadasCreadas = new JLabel("Temporadas creadas: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		estadisticas.add(temporadasCreadas, gbc);
		
		JLabel num_temporadasCreadas = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 2;
		estadisticas.add(num_temporadasCreadas, gbc);
		this.num_temporadas = num_temporadasCreadas;
		
		JLabel resultadosSubidos = new JLabel("Resultados subidos: ");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		estadisticas.add(resultadosSubidos, gbc);
		
		JLabel num_resultadosSubidos = new JLabel("");
		gbc.gridx = 3;
		gbc.gridy = 1;
		estadisticas.add(num_resultadosSubidos, gbc);
		this.num_resultados = num_resultadosSubidos;
		
		JPanel temporada = new JPanel(new GridBagLayout());
		
		JLabel modificaciones = new JLabel("Modificaciones realizadas en: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		temporada.add(modificaciones, gbc);
		
		JLabel val_modificaciones = new JLabel("--------");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		temporada.add(val_modificaciones, gbc);
		this.val_liga = val_modificaciones;
		
		JButton crearTemporada = new JButton("Crear Temporada");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		temporada.add(crearTemporada,gbc);
		
		JButton reportes = new JButton("Reportes");
		gbc.gridx = 0;
		gbc.gridy = 2;
		temporada.add(reportes,gbc);	
		
		JButton comenzarTemporada = new JButton("Comenzar Temporada");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		temporada.add(comenzarTemporada,gbc);	
		
		JButton terminarTemporada = new JButton("Terminar Temporada");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		temporada.add(terminarTemporada,gbc);
		
		JButton subirResultados = new JButton("Subir Resultados");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		temporada.add(subirResultados,gbc);	
				
		JButton cerrarSesion = new JButton("Cerrar sesión");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.interfaz.add(cerrarSesion,gbc);
		
		opciones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Opciones de Liga"));
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.interfaz.getContentPane().add(opciones, gbc);
		
		estadisticas.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Mis estadísticas"));
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.interfaz.getContentPane().add(estadisticas, gbc);
		
		temporada.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Opciones de Temporada"));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		this.interfaz.getContentPane().add(temporada, gbc);
		
		this.actualizar();
		
		this.interfaz.setVisible(true);

		crearLiga.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnCLiga();
			}
		});
		
		abrirLiga.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnALiga();
				
			}
		});
		
		crearTemporada.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnCTemp();
				
			}
		});
		
		comenzarTemporada.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnBTemp();
				
			}
		});
		
		terminarTemporada.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnETemp();
				
			}
		});
		
		subirResultados.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnSubir();
				
			}
		});
				
		cerrarSesion.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				btnCerrar();
				
			}
		});
		
		this.trigger = new PropertyChangeSupport(this);
	}
	
	private void errorLigaCarga()
	{
		JOptionPane.showMessageDialog(this.interfaz, "No se ha cargado ninguna liga, "
				+ "no se puede modificar esto.", "Error temporada",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void btnCLiga()
	{
		trigger.firePropertyChange("token", null, "cLiga");
	}
	
	public void btnALiga()
	{
		trigger.firePropertyChange("token", null, "aLiga");
	}
	
	public void btnCTemp()
	{
		if (liga == null)
		{
			errorLigaCarga();
		}
		else
		{
		trigger.firePropertyChange("token", null, "cTemporada");
		}
	}

	public void btnBTemp()
	{
		if (liga == null)
		{
			errorLigaCarga();
		}
		else
		{
		trigger.firePropertyChange("token", null, "bTemporada");
		}
	}
	
	public void btnETemp()
	{
		if (liga == null)
		{
			errorLigaCarga();
		}
		else
		{
		trigger.firePropertyChange("token", null, "eTemporada");
		}
	}
	
	public void btnSubir()
	{
		if (liga == null)
		{
			errorLigaCarga();
		}
		else
		{
		trigger.firePropertyChange("token", null, "subir");
		}
	}
		
	public void btnCerrar()
	{
		trigger.firePropertyChange("token", null, "out");
	}
	
	public void actualizar()
	{
		name.setText(admin.getNombre());
		num_ligas.setText(Integer.toString(admin.getLigas()));
		num_temporadas.setText(Integer.toString(admin.getTemporadas()));
		num_resultados.setText(Integer.toString(admin.getResultados()));
		if (liga != null)
		{
			val_liga.setText(liga.getNombre() + " en la temporada " + liga.getNumTemporada());
		}
		
	}
	
	public void errorLigas()
	{
		JOptionPane.showMessageDialog(this.interfaz, "No se han cargado ligas.", "Abrir ligas",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void agregarLiga(Liga liga)
	{
		this.liga = liga;
	}
}


