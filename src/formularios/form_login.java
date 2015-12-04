package formularios;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Clases.Datos;
import java.awt.Image;
import Clases.frmSplash;
import Clases.Datos;

public class form_login extends JFrame {
			
	//Atributos
	private Datos misDatos;
	
	public void setDatos(Datos datos) {
		misDatos = datos;
	}
	
		
	public form_login() {
		initComponents();
	}
	
	private void initComponents() {	
		//propiedades del formulario
		
		setTitle( "Ingreso al Sistema");//Coloca un titulo a la ventana
		setLayout(null);//Para colocar objetos en el formulario y luego se organiza por tamaño
		setSize( 400 , 300 );//Crea la ventana de 390px X 180px
		setResizable( false ); //Para que la ventana no pueda maximizarse
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Para cuando se cierre el formulario de login, se cierra toda la aplicacion
		
		//creacion de iconos
		ImageIcon icoAceptar = new ImageIcon("images\\ACEPTAR2.PNG");
		ImageIcon icoSalir = new ImageIcon("images\\Cancelar.png");
		ImageIcon fondo = new ImageIcon("images\\fondoinmo.png");
		
		//creacion de objetos
		lblUsuario = new JLabel( "Usuario: ");
		txtUsuario = new JTextField(10);
		txtUsuario.setToolTipText("El usuario no puede contener Caracteres Especiales");
    	//El textfield se limita a un determinado numero de caracteres
    	txtUsuario.addKeyListener(new KeyListener()
    	{
    		public void keyTyped(KeyEvent e)
    		{
    			if(txtUsuario.getText().length()==12)
    			{
    				e.consume();//El teclado queda anulado
    			}
    		}
    		public void keyPressed(KeyEvent arg0)
    		{
    		}
    		public void keyReleased(KeyEvent arg0)
    		{
    		}
    	});
    	
    	//Validacion para ingresar  solo minusculas y numeros
		txtUsuario.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent Ke)
			{
				char c=Ke.getKeyChar();
				if((c<'A'||c>'Z')&&(c<'a'||c>'z')&&(c<'0'||c>'9')&& (c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_ENTER))
				{
					Ke.consume();
					JOptionPane.showMessageDialog(null,"Solo son permitidos Letras y Números","Advertencia",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
    		
	    lblContraseña = new JLabel( "Contraseña: ");
		pswContraseña = new JPasswordField(10);
		pswContraseña.setToolTipText("La contraseña puede contener Mayúsculas, Minusculas, Números. Excepto Caracteres Especiales");
    	//El textfield se limita a un determinado numero de caracteres
    	pswContraseña.addKeyListener(new KeyListener()
    	{
    		public void keyTyped(KeyEvent e)
    		{
    			if(pswContraseña.getText().length()==12)
    			{
    				e.consume();//El teclado queda anulado
    			}
    		}
    		public void keyPressed(KeyEvent arg0)
    		{
    		}
    		public void keyReleased(KeyEvent arg0)
    		{
    		}
    	});
    	
    	//Validacion para ingresar  solo minusculas y numeros
		pswContraseña.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent Ke)
			{
				char c=Ke.getKeyChar();
				if((c<'a'||c>'z')&&(c<'0'||c>'9')&& (c != KeyEvent.VK_BACK_SPACE)&&(c != KeyEvent.VK_ENTER))
				{
					Ke.consume();
					JOptionPane.showMessageDialog(null,"Solo son permitidos Letras Minúsculas y Números","Advertencia",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnAceptar = new JButton("Ingresar", icoAceptar );
		btnSalir = new JButton("Salir",icoSalir );
		
			//COLOR DE LOS BOTONES
		                                                  
		//btnAceptar.setBackground( new Color(204, 204, 255));
		//btnSalir.setBackground( Color.GRAY);
		           
			//CAMBIAR COLOR DE LETRA
		
		//Usuario.setForeground( new Color( 0 , 0 , 255));
		//Contraseña.setForeground( new Color( 0 , 0 , 255));
		                 //ó
		lblUsuario.setForeground( Color.BLACK);
		lblContraseña.setForeground( Color.BLACK);
		
		//Cambiar tamaño de letra
		lblUsuario.setFont( new Font ("Arial" , Font.BOLD , 20));
		lblContraseña.setFont( new Font ("Arial" , Font.BOLD , 20));
		
	     btnAceptar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
         btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/A2.png"))); // NOI18N
         btnAceptar.setText("Ingresar");
         btnAceptar.setBorder(null);
         btnAceptar.setBorderPainted(false);
         btnAceptar.setContentAreaFilled(false);
         btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
         btnAceptar.setIconTextGap(-3);
         btnAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/A3.png"))); // NOI18N
         btnAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/A.png"))); // NOI18N
         btnAceptar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
         btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		
	     btnSalir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
         btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar2.png"))); // NOI18N
         btnSalir.setText("Cancelar");
         btnSalir.setBorder(null);
         btnSalir.setBorderPainted(false);
         btnSalir.setContentAreaFilled(false);
         btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
         btnSalir.setIconTextGap(-3);
         btnSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar3.png"))); // NOI18N
         btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar.png"))); // NOI18N
         btnSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
         btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		
		//Adicionar objetos al formulario
		icocabecera=Toolkit.getDefaultToolkit().getImage("images\\Logo1.png");//Icono De Cabecera
        setIconImage(icocabecera);
		
		add(lblUsuario);
		add(txtUsuario);
		add(lblContraseña);
		add(pswContraseña);
		add(btnAceptar);
		add(btnSalir);
		
		//Propiedades de los objetos
		btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAceptar.setToolTipText("Ingresa al sistema");
		
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setToolTipText("Sale del sistema");
		
	  	//Colocar los objetos en el formulario
		lblUsuario.reshape  (110,150,120,25);
		txtUsuario.reshape  (230,150,120,25);
		
		lblContraseña.reshape    (110,180,150,25);
		pswContraseña.reshape    (230,180,120,25);
		
	    btnAceptar.reshape  (200,200,80,98);
		btnSalir.reshape (265,200,80,98);	
		
		Jlfondo = new JLabel(fondo);
     	Jlfondo.reshape(0,0,400,300);
	    add(Jlfondo);
		
		
		//Eventos de los botones
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAceptarActionPerformed(evt);
			}
		});
	 	
	    btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSalirActionPerformed(evt);
			}
	    });
	}
	
	private void btnAceptarActionPerformed(ActionEvent evt) {
		if(txtUsuario.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese un usuario",
			 "Advertencia", JOptionPane.ERROR_MESSAGE);
			txtUsuario.requestFocusInWindow();
			return;
		}

        if (new String(pswContraseña.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Por favor ingrese una contraseña",
             "Advertencia", JOptionPane.ERROR_MESSAGE);
            pswContraseña.requestFocusInWindow();
            return;
        }
	
		//Validar usuario
	
	   		if(!misDatos.validarUsuario(txtUsuario.getText(), new String(pswContraseña.getPassword()))) {
			JOptionPane.showMessageDialog(this, "Usuario o Contraseña Incorrectas", "Advertencia", JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			pswContraseña.setText("");
			txtUsuario.requestFocusInWindow();
			return;
		}
	    
		 //Define propiedades del formulario
		setVisible(false);
		form_principal miPrincipal = new form_principal();
	    miPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		miPrincipal.setLocationRelativeTo(null);
	    miPrincipal.setDatos(misDatos);
		miPrincipal.setVisible(true);
		

		
	}
	
	private void btnSalirActionPerformed(ActionEvent evt) {
		
        if(evt.getSource()==btnSalir)
    	{
    		int dialogResult=JOptionPane.showConfirmDialog(null,"¿Desea Salir del Sistema?", "Advertencia", JOptionPane.ERROR_MESSAGE);
    		if(dialogResult==JOptionPane.YES_OPTION)
    		{
    			System.exit(0);	    		
    		}
    		if(dialogResult==JOptionPane.NO_OPTION)
    		{
    			txtUsuario.requestDefaultFocus();
    			txtUsuario.setText("");
    			pswContraseña.setText("");	    		
    		}
    			
    	}
		
	}
	
		//Componentes de la ventana
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JLabel lblCargo;
	private JLabel Jlfondo;
	private ImageIcon Icofondo, fondo;
	private JTextField txtUsuario;
	private JPasswordField pswContraseña;
	JButton btnAceptar;
	private JButton btnSalir;
	private Image icocabecera;
		
}