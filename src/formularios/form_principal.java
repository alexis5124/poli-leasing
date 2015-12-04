package formularios;

import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu.*;
import javax.swing.JDesktopPane;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Clases.DesktopConFondo;
import Clases.Datos;
import java.io.*;
import java.util.*;
import java.awt.Image;
import javax.swing.KeyStroke;
import Clases.Lista_Proceso;
import formularios.form_expedientes;


public class form_principal extends JFrame {

	
		//Atributos
	private Datos misDatos;
	
	public void setDatos(Datos datos) {
		misDatos = datos;
	}
		
	public form_principal() {
		initComponents();
	}
	
	private void initComponents() {
		//Propiedades del formulario
		setTitle( "Sistema Inmobiliario Poli-leasing" );
		setLayout( new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		
		//Definicion de iconos
		ImageIcon icoUsuario = new ImageIcon( "images\\usuarios.png");
		ImageIcon icoAgenda = new ImageIcon( "images\\house.png");
		ImageIcon icoGestionAgenda = new ImageIcon( "images\\home2.png");
		ImageIcon icoMaestros = new ImageIcon( "images\\Productos.png");
		ImageIcon icoReportes = new ImageIcon( "images\\Reporte.png");
		ImageIcon icoHerramientas = new ImageIcon( "images\\Herramienta.png");
		ImageIcon icoAyuda = new ImageIcon( "images\\Ayuda.png");
		ImageIcon icoGestionPerfil = new ImageIcon( "images\\Archivo.png");
		ImageIcon icoPermisosPorPerfil = new ImageIcon( "images\\Clientes.png");
		ImageIcon icoGestionContacto = new ImageIcon( "images\\Contacto.png");
		ImageIcon icoSalir = new ImageIcon( "images\\Salir.png");
		ImageIcon icoProceso = new ImageIcon( "images\\CambiarUsuario.png");
		ImageIcon icoEstadisticas = new ImageIcon( "images\\Estadisticas.png");
		ImageIcon icoGenerarCopiaDeSeguridad = new ImageIcon( "images\\Seguridad.png");
		ImageIcon icoManualDeUsuario = new ImageIcon( "images\\Manual.png");
		ImageIcon icoDiccionarioJuridico = new ImageIcon( "images\\Diccionario.png");
		ImageIcon icoAcercaDe = new ImageIcon( "images\\AcercaDE.png");
		ImageIcon fondo = new ImageIcon("images\\gestioninmobiliaria.jpg");		
     	ImageIcon icoExpediente = new ImageIcon("images\\Expediente32.png");
	    ImageIcon icoExpediente2 = new ImageIcon("images\\Expediente2_32.png");
	    ImageIcon icoEconomia= new ImageIcon("images\\Moneda_32.png");
	    ImageIcon icoAccion= new ImageIcon("images\\Accion_32.png");
	    ImageIcon icoContato= new ImageIcon("images\\Contato_32.png");
	    
		
		//Definicion de los menus y sus eventos
        dpnEscritorio = new DesktopConFondo();
        dpnEscritorio.setBackground(new java.awt.Color(0, 0, 0));
        dpnEscritorio.setBorder(javax.swing.BorderFactory.createMatteBorder(11, 11, 11, 11, new java.awt.Color(0, 0, 0)));
                
		mnbMenu = new JMenuBar();
		mnbMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)));
		
		mnuUsuario = new JMenu( "Usuario" );
		mnuUsuario.setIcon(icoUsuario); 
			
		mnuInmueble = new JMenu( "Inmueble" );
		mnuInmueble.setIcon(icoAgenda);
			
		mnuVisitas = new JMenu( "Visitas" );
		mnuVisitas.setIcon(icoMaestros); 	
			
		mnuMaestros = new JMenu( "Maestros" );
		mnuMaestros.setIcon(icoReportes); 	
			
		mnuContrato = new JMenu( "Contratos" );
		mnuContrato.setIcon(icoHerramientas);
		
		mnuAcerca = new JMenu ( "Acerca de..." );
		mnuAcerca.setIcon(icoExpediente);
		
				
	
		
		
     	mnuUsuarioGestionPerfil = new JMenuItem( "Gestion Usuario" );
     	
		mnuUsuarioGestionPerfil.setIcon(icoGestionPerfil);
		mnuUsuarioGestionPerfil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		mnuUsuarioGestionPerfil.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent evt) {
					mnuUsuarioGestionPerfilActionPerformed(evt);
			}
		});
		
		

		mnuUsuarioSalir = new JMenuItem( "Salir" );
		mnuUsuarioSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		mnuUsuarioSalir.setIcon(icoSalir);
		mnuUsuarioSalir.addActionListener(new ActionListener() {
		   public void actionPerformed (ActionEvent evt) {
		           mnuUsuarioSalirActionPerformed(evt);
			}
		});
		
		mnuInmuebleGestionAgenda = new JMenuItem( "Gestion Inmueble " );
		mnuInmuebleGestionAgenda.setIcon(icoGestionAgenda);
		mnuInmuebleGestionAgenda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		mnuInmuebleGestionAgenda.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed (ActionEvent evt) {
						mnuInmuebleGestionAgendaActionPerformed(evt);
			}
		});
		
	
		
	
		
		
		
		
		mnuSeparador1 = new Separator();
		mnuSeparador2 = new Separator();
		mnuSeparador3 = new Separator();
		mnuSeparador4 = new Separator();
		mnuSeparador5 = new Separator();
		mnuSeparador6 = new Separator();
				 	
		//Armar menus
		icocabecera=Toolkit.getDefaultToolkit().getImage("images\\Logo1.png");//Icono De Cabecera
        setIconImage(icocabecera);
        
		mnuUsuario.add(mnuUsuarioGestionPerfil);
		mnuUsuario.add(mnuSeparador1);
		mnuUsuario.add(mnuUsuarioSalir);
		mnbMenu.add(mnuUsuario);
		
		mnuInmueble.add(mnuInmuebleGestionAgenda);
		mnbMenu.add(mnuInmueble);
		
	    mnbMenu.add(mnuUsuario);
	    mnbMenu.add(mnuInmueble);
	    mnbMenu.add(mnuVisitas);
	    mnbMenu.add(mnuMaestros);
	    mnbMenu.add(mnuContrato);
	    mnbMenu.add(mnuAcerca);
	    

				
	
		//Se establece el menu del formulario
		setJMenuBar(mnbMenu);
		
		//Crear el DesktopPane
		dpnEscritorio = new DesktopConFondo();
		((DesktopConFondo) dpnEscritorio).setImagen("");
		setContentPane(dpnEscritorio);
		Jlfondo = new JLabel(fondo);
     	Jlfondo.reshape(0,0,1380,800);
	    add(Jlfondo);
	    
	}	
	
		private void mnuUsuarioGestionPerfilActionPerformed (ActionEvent evt) {
			form_usuarios Lista_Usuario = new form_usuarios();
			Lista_Usuario.show();
		
	}
		
        private void mnuUsuarioSalirActionPerformed(ActionEvent evt) {
        	if(evt.getSource()==mnuUsuarioSalir)
    	   	{
    		int dialogResult=JOptionPane.showConfirmDialog(null,"¿Desea Salir del Sistema de Poli-Leasing?", "Advertencia", 
    			                                          JOptionPane.ERROR_MESSAGE);
    		if(dialogResult==JOptionPane.YES_OPTION)
    		{	
    			new form_login();
    			setVisible(false);
    			System.exit(0);   		
    		}
    		
    	}

    }
    
    	private void mnuInmuebleGestionAgendaActionPerformed (java.awt.event.ActionEvent evt) {
            form_inmueble inmueble = new form_inmueble ();
			inmueble.show();
		
	}
    
    


    	
    		//Se definen los objetos
	private JMenuBar mnbMenu;
	private JMenu mnuUsuario; 
	private JMenu mnuInmueble; 
	private JMenu mnuVisitas; 
	private JMenu mnuMaestros; 
	private JMenu mnuContrato; 
	private JMenu mnuInternalFrame;
    private JMenu mnuAcerca;
	private JMenuItem mnuUsuarioGestionPerfil;
	private Separator mnuSeparador1; 
 	private Separator mnuSeparador2;
	private Separator mnuSeparador3;
	private JMenuItem mnuUsuarioSalir;
	private JMenuItem mnuInmuebleGestionAgenda;
	private Separator mnuSeparador6; 
	private Separator mnuSeparador4;	
	private Separator mnuSeparador5; 
	private	JDesktopPane dpnEscritorio; 
   	private JPanel jpanel;
   	private JPanel dpnPanel;
   	private	JLabel Jlfondo;
   	private	JLabel JlFondo;
   	private	ImageIcon Icofondo;
   	private ImageIcon fondo;
   	private Image icocabecera;
		
}
