package formularios;

import Clases.Lista_Proceso;
import javax.swing.*;//Gráfico
import java.awt.*;//Funcionalidad
import javax.swing.table.*; 
import java.awt.event.*;//Funcionalidad
import java.util.*;
import java.util.regex.*;
import javax.swing.border.Border;//Bordes
import java.awt.event.ItemEvent;
import java.io.*;//Se encarga de las entradas y salidas del sistema por Archivos
import Clases.ValidarEmail;
import Clases.Nodo_Proceso;

public class Proceso implements ActionListener,KeyListener
{
	
	//CONSTRUCTOR		
	public Proceso(){
		initComponents();
	}
	
	private void initComponents() {
		lista=new Lista_Proceso("Nombre","Nombre.dat");//CONSTRUYO LA LISTA Y LOS ARCHIVOS
		lista.ingresarDatosIniciales();//CARGA LOS DATOS DEL ARCHIVO CUANDO SE ABRE LA GESTIÓN
		
		ventana=new JFrame("Gestión Inmueble");//TÍTULO DE LA VENTANA
		ImgGuardar=new ImageIcon("IMAGENES\\ACEPTAR.png");//IMÁGEN DE BOTÓN
		ImgConsultar=new ImageIcon("IMAGENES\\BUSCAR.png");
		ImgModificar=new ImageIcon("IMAGENES\\modificar2.png");
		ImgCambios=new ImageIcon("IMAGENES\\guardar2.png");
		ImgEliminar=new ImageIcon("IMAGENES\\eliminar2.png");
		ImgSalir=new ImageIcon("IMAGENES\\SALIR.png");
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		//BORDE DE LOS DATOS
		/*jpdatos =new JPanel();
    	jpdatos.setBorder(BorderFactory.createTitledBorder ("Datos"));//TÍTULO DEL BORDE
		jpdatos.setLayout(null);*/
		
		//LABELS
		lblID=new JLabel("ID_Inmueble *");
		ventana.add(lblID);
        lblID.reshape(10,20,90,25);
        lblID.setForeground(Color.BLACK);//COLOR DE LETRA
		
		lblidpropietario =new JLabel("ID_Propietario*");
    	ventana.add(lblidpropietario);
        lblidpropietario.reshape(10,60,90,25);
        lblidpropietario.setForeground(Color.BLACK);
        
        lblmunicipio =new JLabel("Municipio");
		ventana.add(lblmunicipio);
        lblidpropietario.reshape(10,100,90,25);
        lblidpropietario.setForeground(Color.BLACK);
        
        //TEXTFIELD
        txtID=new JTextField("");
        /////////////////////////////////////////////////////////////////////
    	//LIMITAR UN TEXTFIELD A UN DETERMINADO NÚMERO DE CARACTERES
    	txtID.addKeyListener(new KeyListener()
    	{
    		public void keyTyped(KeyEvent e)
    		{
    			if(txtID.getText().length()==10)
    			{
    				e.consume();//ANULA LOS EVENTOS DEL TECLADO
    			}
    		}
    		public void keyPressed(KeyEvent arg0)
    		{
    		}
    		public void keyReleased(KeyEvent arg0)
    		{
    		}
    	});
    	/////////////////////////////////////////////////////////////////////
       	ventana.add(txtID);
        txtID.reshape(110,20,210,25);
        txtID.addKeyListener(this);
        txtID.addActionListener(this);
        
        txtidpropietario=new JTextField("");
        /////////////////////////////////////////////////////////////////////
    	//LIMITAR UN TEXTFIELD A UN DETERMINADO NÚMERO DE CARACTERES
    	txtidpropietario.addKeyListener(new KeyListener()
    	{
    		public void keyTyped(KeyEvent e)
    		{
    			if(txtidpropietario.getText().length()==12)
    			{
    				e.consume();//ANULA LAS ACCIONES DEL TECLADO
    			}
    		}
    		public void keyPressed(KeyEvent arg0)
    		{
    		}
    		public void keyReleased(KeyEvent arg0)
    		{
    		}
    	});
    	/////////////////////////////////////////////////////////////////////
		//VALIDACIÓN PARA NO LEER MAYÚSCULAS
		txtidpropietario.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if(c<'a'||c>'z')
				{
					e.consume();//ANULA LAS ACCIONES DEL TECLADO
				}
			}
		});
		///////////////////////////////////////////////////
   	    ventana.add(txtidpropietario);
        txtidpropietario.reshape(110,60,210,25);
        txtidpropietario.addKeyListener(this);
        txtidpropietario.addActionListener(this);
        
        
        	//ventana.add(jpdatos);
       	// jpdatos.reshape(10,10,325,300);
        
        /////////////////////////////////////////////////////////////////////////////////////////////
        //BORDE DE LOS BOTONES
		jpbotones =new JPanel();
    	jpbotones.setBorder(BorderFactory.createTitledBorder (""));
		jpbotones.setLayout(null);
		
        //BOTONES
        btnguardar=new JButton("Crear",ImgGuardar);
        btnguardar.addActionListener(this);
        jpbotones.add(btnguardar);
        btnguardar.reshape(15,10,120,25);
        
        btnconsultar=new JButton("Consultar",ImgConsultar);
        btnconsultar.addActionListener(this);
        jpbotones.add(btnconsultar);
        btnconsultar.reshape(15,43,120,25);
        btnconsultar.setEnabled(false);
        
        btnmodificar=new JButton("Modificar",ImgModificar);
        btnmodificar.addActionListener(this);
        jpbotones.add(btnmodificar);
        btnmodificar.reshape(15,76,120,25);
        btnmodificar.setEnabled(false);
        
        btnguardarcambios=new JButton("Guardar",ImgCambios);
        btnguardarcambios.addActionListener(this);
        jpbotones.add(btnguardarcambios);
        btnguardarcambios.reshape(15,109,120,25);
        btnguardarcambios.setEnabled(false);
        
        btneliminar=new JButton("Borrar",ImgEliminar);
        btneliminar.addActionListener(this);
        jpbotones.add(btneliminar);
        btneliminar.reshape(15,142,120,25);
        btneliminar.setEnabled(false);
        
        btnsalir=new JButton("Salir",ImgSalir);
        btnsalir.addActionListener(this);
        jpbotones.add(btnsalir);
        btnsalir.reshape(15,175,120,25);
        
        ventana.add(jpbotones);
        jpbotones.reshape(360,18,150,225);
        //PREGUNTO SI LA LISTA TIENE DATOS
		if(lista.estaVacia()==false)
		{
			btnconsultar.setEnabled(false);
			btneliminar.setEnabled(false);
			btnmodificar.setEnabled(false);
		}
		else
		{
			btnconsultar.setEnabled(true);
			btneliminar.setEnabled(false);
			btnmodificar.setEnabled(false);
		}
        
        /////////////////////////////////////////////////////////////////////////////////////////////
  		/**********************************************************/
  		// SE CREA EL OBJETO DE LA CLASE DEFAULTTABLEMODEL QUE SERÁ 
  		// EL ENCARGADO DE CONTENER LOS DATOS A MOSTRAR AL Nombre
  		//*********************************************************/
  		modelo=new DefaultTableModel();
  		
  		//***************************************************************
  		// SE CREA EL OBJETO TABLA QUE SE ENCARGARA DE MOSTRAR LOS DATOS 
  		// QUE CONTIENE EL OBJETO MODELO
  		//***************************************************************
  		tabla=new JTable(modelo);
  		
  		//SE LLAMA EL METODO MOSTRAR DATOS QUE RECIBE LA TABLA Y EL MODELO
    	lista.mostrarDatos(tabla,modelo);
    	
    	//*************************************************************
  		// SE CREA EL OBJETO JSCROLLPANE QUE SE LE ENTREGA COMO
  		// PARAMÉTRO EL JTABLE QUE VA A MOSTRAR,SE ADICIONA Y SE PINTA
  		//*************************************************************
	  	panelBarra=new JScrollPane(tabla);
	    ventana.add(panelBarra);
	    panelBarra.reshape(10,320,325,140);
	  	/////////////////////////////////////////////////////////////////////////////////////////////        
        icocabecera=Toolkit.getDefaultToolkit().getImage("Imagenes\\Acceso.png");//RUTA IMÁGEN DE LA VENTANA
        ventana.setIconImage(icocabecera);
        
        ventana.resize(540,550);//TAMAÑO DE LA VENTANA
        ventana.setLayout(null);//NO DEJA CAMBIAR EL TAMAÑO DE LA VENTANA, SOLO DISEÑO YO
        ventana.setLocationRelativeTo(null);//CENTRO LA VENTANA
  		ventana.setResizable( false);//BLOQUEA EL TAMAÑO DE LA VENTANA
  		ventana.show();//MUESTRA LA VENTANA
    }    
    //VALIDAR CAMPOS
	public void keyPressed(KeyEvent Ke)
	{
	}						
	public  void keyReleased(KeyEvent Ke)
	{
	}
	public void keyTyped(KeyEvent Ke)
	{
		String Letras = "abcdefghijklmnñopqrstuvwxyzç -";		
		//LEE EL CARACTER CORRESPONDIENTE A LA TECLA		
		char Caracter=Ke.getKeyChar();
		int Numero=(int)(Caracter);		
		//VALIDAR NÚMEROS						
		if(Ke.getSource()==txtID)
		{
			if(Numero==10)
			{
				txtID.requestFocus();
			}
				if(((Caracter<'0')||(Caracter>'9'))&&(Caracter!=KeyEvent.VK_BACK_SPACE))
				{
					Ke.consume();
				}
		}												
		//VALIDAR LETRAS										
		if(Ke.getSource()==txtidpropietario)
		{
			if(Numero==10)
			{
				txtidpropietario.requestFocus();
			}
			String X=""+Caracter;
	    	if(Letras.indexOf(X.toLowerCase())==-1)
			{
				Ke.consume();
			}
		}
	}
	//MÉTODO MAIN    
    public static void main (String[] args)
	{
		new Proceso();
	}
	//ACCIONES DE BOTONES Y TEXTFIELD    
    public void actionPerformed(ActionEvent a)
    {
    	//TEXTFIELD
    	if(a.getSource()==txtID)
    	{
    		txtidpropietario.requestFocus();
    	}
    	if(a.getSource()==txtidpropietario)
    	{
    		txtidpropietario.requestFocus();
    	}
    	//BOTONES
    	if(a.getSource()==btnguardar)
    	{
    		String id_proceso=String.valueOf(Math.round(Math.random()*100));	
    		if(txtID.getText().equals(""))
    		{
   				JOptionPane.showMessageDialog(null,"ID_Proceso requerido");
    		}
   			else
   			{
   				if (txtidpropietario.getText().equals(""))
   				{ 
   					JOptionPane.showMessageDialog(null,"Nombre requerido");
   				}  				
			   					else
			   					{
			   						//****************************************************
									// SE LEEN LOS DATOS INGRESADOS POR EL USUARIO DENTRO
									// DE LA LISTA. SE CONVIERTEN TODOS, SEGÚN SUS TIPOS
									//****************************************************
									int ID_Proceso=Integer.parseInt(txtID.getText());
									String Nombre=txtidpropietario.getText();
									//CREAMOS UN NODO Y LE MANDAMOS LOS PARAMETROS
									Nodo_Proceso x;
									x=new Nodo_Proceso(ID_Proceso,Nombre);
									//LE ASIGNO EL NODO X CREADO, A LA LISTA POR MEDIO DE UN BOOLEANO
									boolean z=lista.InsertarOrdenado(x);
									//MUESTRO MENSAJE SI GRABA LOS DATOS O NO Y LIMPIO LOS CAMPOS
									if(z!=true)
									{
										JOptionPane.showMessageDialog(null,"La ID_Proceso ya existe ya existe","¡ERROR!",JOptionPane.ERROR_MESSAGE);		
									}
									else
									{
										JOptionPane.showMessageDialog(null,"Información guardada con éxito");
									}								
									Limpiar();
									lista.mostrarDatos(tabla,modelo);
				   					btnconsultar.setEnabled(true);
		   							btneliminar.setEnabled(false);
		   							txtID.requestDefaultFocus();
			   					}
	   						}
	   					}
		if(a.getSource()==btnconsultar)
		{
			//CONVIERTO LA ID_Proceso SOLICITADA DESDE EL JOPTION A NÚMERO
    		int ID=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la ID_Proceso a Consultar"));
    		//MANDO LA ID_Proceso A BUSCAR, AL MÉTODO BUSCAR DE LA LISTA_NODO
    		Nodo_Proceso x=lista.Buscar(ID);
    		//VALIDO SI SE ENCONTRO LA ID_Proceso
    		if(x==null)
    		{
    			JOptionPane.showMessageDialog(null,"La ID_Proceso no existe","¡ERROR!",JOptionPane.ERROR_MESSAGE);
    			Limpiar();
    			ActivarTodo();   			
    		}
    		else
    		{
    			txtID.setText(""+x.getID_Proceso());
    			txtidpropietario.setText(x.getNombre());
    			//ACTIVO Y DESACTIVO LOS BOTONES
	    		btnmodificar.setEnabled(true);
	    		btneliminar.setEnabled(true);
	    		btnguardar.setEnabled(false);
	    		//DESACTIVO LOS TEXTFIELD PARA QUE SÓLO MUESTREN LA INFORMACIÓN
	    		txtID.setEnabled(false);
				txtID.setDisabledTextColor(Color.black);//PONGO COLOR A LOS TEXTFIELD DESACTIVADOS
				txtidpropietario.setEnabled(false);
				txtidpropietario.setDisabledTextColor(Color.black);
    		}
		}	
		if(a.getSource()==btnmodificar)
		{
			JOptionPane.showMessageDialog(null,"Solo se puede modificar el Nombre del proceso");
			btnguardarcambios.setEnabled(true);
			btneliminar.setEnabled(false);
			btnconsultar.setEnabled(false);
			txtID.setEnabled(false);
			txtidpropietario.setEnabled(true);
			txtID.requestDefaultFocus();
		}	
		if(a.getSource()==btnguardarcambios)
		{
			//****************************************************
			// SE LEEN LOS DATOS INGRESADOS POR EL ID_PROCESO DENTRO
			// DE LA LISTA. SE CONVIERTEN TODOS, SEGÚN SUS TIPOS
			//****************************************************
			int ID_Proceso=Integer.parseInt(txtID.getText());
			String nombre=txtidpropietario.getText();
			/*LLAMÓ EL MÉTODO MODIFICAR DE LA Lista_Proceso
				MANDANDOLE LOS CAMPOS QUE VOY MODIFICAR*/
			lista.Modificar(ID_Proceso,nombre);
			//ACTUALIZO LOS DATOS
			lista.mostrarDatos(tabla,modelo);
			Limpiar();
			ActivarTodo();
			//INACTIVO Y ACTIVO
			btnmodificar.setEnabled(false);
			btneliminar.setEnabled(false);
			btnguardarcambios.setEnabled(false);
			btnguardar.setEnabled(true);
			btnconsultar.setEnabled(true);
		}
		if(a.getSource()==btneliminar)
		{
			//CONVIERTO LA ID_Proceso SOLICITADA DESDE EL JOPTION A NÚMERO
    		int ID=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la ID_Proceso a Eliminar"));
    		//MANDO LA ID_Proceso A BUSCAR, AL MÉTODO BUSCAR DE LA LISTA_NODO_MÉDICO
    		Nodo_Proceso x=lista.Buscar(ID);//RECIBO LA INFORMACIÓN
    		//PREGUNTO SI NO SE ENCONTRÓ LA ID_Proceso
    		if(x==null)
    		{
    			JOptionPane.showMessageDialog(null,"La ID_Proceso no existe","¡ERROR!",JOptionPane.ERROR_MESSAGE);
    			Limpiar();
    			ActivarTodo();
    			btnguardar.setEnabled(true);
    			btneliminar.setEnabled(false);
    			btnmodificar.setEnabled(false);    			
    		}
    		//SI SE ENCONTRÓ
    		else
    		{
    			int dialogResult=JOptionPane.showConfirmDialog(null,"¿Desea Eliminar la información?");
				//CONFIRMACIÓN DE LA RESPUESTA
				if(dialogResult==JOptionPane.YES_OPTION)
				{
					//LLAMAMOS EL MÉTODO ELIMINAR
					lista.Eliminar(ID);
					//ACTUALIZAMOS LOS DATOS
					lista.mostrarDatos(tabla,modelo);
					Limpiar();
					ActivarTodo();
					btneliminar.setEnabled(false);
					btnmodificar.setEnabled(false);
					btnguardar.setEnabled(true);
				}
				if(dialogResult==JOptionPane.NO_OPTION)
				{
					ActivarTodo();
					Limpiar();
					btneliminar.setEnabled(false);
					btnmodificar.setEnabled(false);
					btnguardar.setEnabled(true);
				}
				if(dialogResult==JOptionPane.CANCEL_OPTION)
				{
					JOptionPane.showMessageDialog(null,"La operación ha sido Cancelada");
					ActivarTodo();
					Limpiar();
					btneliminar.setEnabled(false);
					btnmodificar.setEnabled(false);
					btnguardar.setEnabled(true);
				}    			
    		}
		}
		if(a.getSource()==btnsalir)
		{
			int dialogResult=JOptionPane.showConfirmDialog(null,"¿Desea Salir de Gestión Proceso?");
    		if(dialogResult==JOptionPane.YES_OPTION)
    		{
    			lista.guardar();
    			ventana.setVisible(false);	    		
    		}
    		if(dialogResult==JOptionPane.NO_OPTION)
    		{
    			txtID.requestDefaultFocus();	    		
    		}
    		if(dialogResult==JOptionPane.CANCEL_OPTION)
    		{
    			txtID.requestDefaultFocus();	    		
    		}
		}
    }
    //MÉTODOS
    public void ActivarTodo()
    {
    	txtID.setEnabled(true);
		txtidpropietario.setEnabled(true);
		txtID.requestDefaultFocus();
    }
    public void Limpiar()
    {
    	txtID.setText("");
    	txtidpropietario.setText("");
    }

    void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private JTable tabla;//DECLARO LA TABLA DE LA LISTA
	private JScrollPane panelBarra;//MUESTRA EL CONTROL JTABLE Y COLOCA UNA BARRA SE SE NECESITA
	DefaultTableModel modelo;//CONTIENE LOS DATOS QUE SERÁN MOSTRADOS EN JTABLE
	Lista_Proceso lista;//DECLARO LA LISTA
	
	JFrame ventana;
	Image icocabecera;//PARA PONER IMÁGEN DE CABEZERA
	ImageIcon ImgGuardar,ImgConsultar,ImgModificar,ImgCambios,ImgEliminar,ImgSalir;//IMÁGENES PARA LOS BOTONES
	JLabel lblID,lblidpropietario,lblmen,lblmen2,lblmunicipio,lblbarrio,lbldescripcion,lblvalor;
	JTextField txtID,txtidpropietario,txtmunicipio,txtbarrio,txtdescripcion,txtvalor;
	JButton btnguardar,btnconsultar,btnmodificar,btneliminar,btnguardarcambios,btnsalir;
	
	JPanel jpdatos,jpbotones;
}