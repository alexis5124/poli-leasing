package formularios;

import Clases.Lista_Usuario;
import javax.swing.*;//Gráfico
import java.awt.*;//Funcionalidad
import javax.swing.table.*; 
import java.awt.event.*;//Funcionalidad
import java.util.*;
import java.util.regex.*;
import javax.swing.border.Border;//Bordes
import java.awt.event.ItemEvent;
import java.io.*;//Se encarga de las entradas y salidas del sistema por Archivos
import Clases.ValidarEmail;//Se valida de que el correo ingresado sea correcto
import Clases.Nodo_Usuario;//Se importa la clases Nodo_Usuario, para cargar las variables declaradas

public class form_usuarios implements ActionListener,KeyListener
{
	
	//CONSTRUCTOR		
	public form_usuarios(){
		initComponents();
	}
	
	private void initComponents() {
		lista=new Lista_Usuario("Usuario","Usuario.dat");//CONSTRUYO LA LISTA Y LOS ARCHIVOS
		lista.ingresarDatosIniciales();//CARGA LOS DATOS DEL ARCHIVO CUANDO SE ABRE LA GESTIÓN
		
		ventana=new JFrame("Gestión Usuarios");//TÍTULO DE LA VENTANA
		IcoGuardar=new ImageIcon ("IMAGENES\\ACEPTAR.png");//IMÁGEN DE BOTÓN
		IcoConsultar=new ImageIcon("IMAGENES\\BUSCAR.png");
		IcoModificar=new ImageIcon("IMAGENES\\modificar2.png");
		IcoCambios=new ImageIcon("IMAGENES\\guardar2.png");
		IcoEliminar=new ImageIcon("IMAGENES\\eliminar2.png");
		IcoSalir=new ImageIcon("IMAGENES\\SALIR.png");
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		//BORDE DE LOS DATOS
		jpdatos =new JPanel();
    	jpdatos.setBorder(BorderFactory.createTitledBorder ("Datos"));//TÍTULO DEL BORDE
		jpdatos.setLayout(null);
		
		//LABELS
		lblDoc=new JLabel("Documento *");
		jpdatos.add(lblDoc);
        lblDoc.reshape(10,20,90,25);//Ubicacios del label en la ventana
        lblDoc.setForeground(Color.BLACK);//COLOR DE LETRA
		
		lblusu=new JLabel("Usuario *");
		jpdatos.add(lblusu);
        lblusu.reshape(10,60,90,25);
        lblusu.setForeground(Color.BLACK);
		
		lblcorr=new JLabel("Correo *");
		jpdatos.add(lblcorr);
        lblcorr.reshape(10,100,90,25);
        lblcorr.setForeground(Color.BLACK);
		
		lblpre=new JLabel("<html>Pregunta<br>"+"Secreta *</html>");
        jpdatos.add(lblpre);
        lblpre.reshape(10,140,90,25);
        lblpre.setForeground(Color.BLACK);
        
        lblPre=new JLabel("Respuesta *");
        jpdatos.add(lblPre);
        lblPre.reshape(10,180,90,25);
        lblPre.setForeground(Color.BLACK);
        
        lblcontr=new JLabel("Contraseña *");
        jpdatos.add(lblcontr);
        lblcontr.reshape(10,220,90,25);
        lblcontr.setForeground(Color.BLACK);
        
        lblest=new JLabel("Estado *");
        jpdatos.add(lblest);
        lblest.reshape(10,265,90,25);
        lblest.setForeground(Color.BLACK);
        
        lblmen=new JLabel("(Sólo ingresar MAYÚSCULAS y minúsculas)");
		jpdatos.add(lblmen);
        lblmen.setForeground(Color.GRAY);
        
        lblmen2=new JLabel("(Sólo ingresar minúsculas)");
		jpdatos.add(lblmen2);
        lblmen2.setForeground(Color.GRAY);
        
        //TEXTFIELD
        txtDoc=new JTextField("");
        /////////////////////////////////////////////////////////////////////
    	//LIMITAR UN TEXTFIELD A UN DETERMINADO NÚMERO DE CARACTERES
    	txtDoc.addKeyListener(new KeyListener()
    	{
    		public void keyTyped(KeyEvent e)
    		{
    			if(txtDoc.getText().length()==10)//Solo se pueden ingresar 10 o menos caracteres
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
        jpdatos.add(txtDoc);
        txtDoc.reshape(100,20,210,25);
        txtDoc.addKeyListener(this);
        txtDoc.addActionListener(this);
        
        txtusu=new JTextField("");
        /////////////////////////////////////////////////////////////////////
    	//LIMITAR UN TEXTFIELD A UN DETERMINADO NÚMERO DE CARACTERES
    	txtusu.addKeyListener(new KeyListener()
    	{
    		public void keyTyped(KeyEvent e)
    		{
    			if(txtusu.getText().length()==12)
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
		//VALIDACIÓN PARA LEER SOLO LETRAS
		txtusu.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if((c<'a'||c>'z')&&(c<'A'|| c>'Z'))//Solo se pueden ingresar letras del 'a' hasta la 'z'
				{
					e.consume();//ANULA LAS ACCIONES DEL TECLADO
				}
			}
		});
		///////////////////////////////////////////////////
        jpdatos.add(txtusu);
        txtusu.reshape(100,60,210,25);
        lblmen.reshape(100,80,160,20);
        txtusu.addKeyListener(this);
        txtusu.addActionListener(this);
        
        txtcorr=new JTextField("");
        txtcorr.setInputVerifier(new ValidarEmail());//LLAMAMOS LA VALIDACIÓN DEL CORREO
        jpdatos.add(txtcorr);
        txtcorr.reshape(100,100,210,25);
        txtcorr.addActionListener(this);
        
        txtPre=new JTextField("");
        jpdatos.add(txtPre);
        txtPre.reshape(100,180,210,25);
        txtPre.addActionListener(this);
        
        txtcontr=new JTextField("");
        jpdatos.add(txtcontr);
        txtcontr.reshape(100,220,210,25);
        lblmen2.reshape(100,240,160,20);
        txtcontr.addActionListener(this);
        txtcontr.setToolTipText("Contraseña de 8 caracteres");//MENSAJE CUANDO SE PASA EL MOUSE POR TEXTFIELD
        /////////////////////////////////////////////////////////////////////
    	//LIMITAR UN TEXTFIELD A UN DETERMINADO NÚMERO DE CARACTERES
    	txtcontr.addKeyListener(new KeyListener()
    	{
    		public void keyTyped(KeyEvent e)
    		{
    			if(txtcontr.getText().length()==10)
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
		//VALIDACIÓN PARA LEER MINÚSCULAS Y NÚMEROS
		txtcontr.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if((c<'a'||c>'z')&&(c<'0'||c>'9'))//Solo permite ingresar letras minusculas y numeros
				{
					e.consume();//ANULA LAS ACCIONES DEL TECLADO
				}
			}
		});
		///////////////////////////////////////////////////
        
        //COMBO-BOX
        jcbpre=new JComboBox(pre);
        jpdatos.add(jcbpre);
        jcbpre.reshape(100,140,210,25);
        
        jcbest=new JComboBox(est);
        jpdatos.add(jcbest);
        jcbest.reshape(100,265,210,25);
        
        ventana.add(jpdatos);
        jpdatos.reshape(10,10,355,305);
        
        /////////////////////////////////////////////////////////////////////////////////////////////
        //BORDE DE LOS BOTONES
		jpbotones =new JPanel();
    	jpbotones.setBorder(BorderFactory.createTitledBorder (""));
		jpbotones.setLayout(null);
		
        //BOTONES
        btnguardar=new JButton("Crear",IcoGuardar);//Se crea el objeto del JButton, se nombra un texto y se manda la imagén creada
        btnguardar.addActionListener(this);
        jpbotones.add(btnguardar);
        btnguardar.reshape(15,10,120,25);
        
        btnconsultar=new JButton("Consultar",IcoConsultar);
        btnconsultar.addActionListener(this);
        jpbotones.add(btnconsultar);
        btnconsultar.reshape(15,43,120,25);
        btnconsultar.setEnabled(false);
        
        btnmodificar=new JButton("Modificar",IcoModificar);
        btnmodificar.addActionListener(this);
        jpbotones.add(btnmodificar);
        btnmodificar.reshape(15,76,120,25);
        btnmodificar.setEnabled(false);
        
        btnguardarcambios=new JButton("Guardar",IcoCambios);
        btnguardarcambios.addActionListener(this);
        jpbotones.add(btnguardarcambios);
        btnguardarcambios.reshape(15,109,120,25);
        btnguardarcambios.setEnabled(false);
        
        btneliminar=new JButton("Borrar",IcoEliminar);
        btneliminar.addActionListener(this);
        jpbotones.add(btneliminar);
        btneliminar.reshape(15,142,120,25);
        btneliminar.setEnabled(false);
        
        btnsalir=new JButton("Salir",IcoSalir);
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
  		// EL ENCARGADO DE CONTENER LOS DATOS A MOSTRAR AL USUARIO
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
	    panelBarra.reshape(5,370,525,140);
	  	/////////////////////////////////////////////////////////////////////////////////////////////        
        icocabecera=Toolkit.getDefaultToolkit().getImage("Imagenes\\Acceso.png");//RUTA IMÁGEN DE LA VENTANA
        ventana.setIconImage(icocabecera);
        
        ventana.resize(540,550);//TAMAÑO DE LA VENTANA
        ventana.setLayout(null);//NO DEJA CAMBIAR EL TAMAÑO DE LA VENTANA, SOLO DISEÑO YO
        ventana.setLocationRelativeTo(null);//CENTRO LA VENTANA
  		ventana.setResizable( false);//NO DEJA MAXIMIZAR LA VENTANA
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
		if(Ke.getSource()==txtDoc)
		{
			if(Numero==10)
			{
				txtDoc.requestFocus();
			}
				if(((Caracter<'0')||(Caracter>'9'))&&(Caracter!=KeyEvent.VK_BACK_SPACE))
				{
					Ke.consume();
				}
		}												
		//VALIDAR LETRAS										
		if(Ke.getSource()==txtusu)
		{
			if(Numero==10)
			{
				txtusu.requestFocus();
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
		new form_usuarios();
	}
	//ACCIONES DE BOTONES Y TEXTFIELD    
    public void actionPerformed(ActionEvent a)
    {
    	//TEXTFIELD
    	if(a.getSource()==txtDoc)
    	{
    		txtusu.requestFocus();
    	}
    	if(a.getSource()==txtusu)
    	{
    		txtcorr.requestFocus();
    	}
    	if(a.getSource()==txtcorr)
    	{
    		txtPre.requestFocus();
    	}
    	
    	if(a.getSource()==txtPre)
    	{
    		txtPre.requestFocus();
    	}
    	//BOTONES
    	if(a.getSource()==btnguardar)
    	{
    		String Docu=String.valueOf(Math.round(Math.random()*100));	
    		if(txtDoc.getText().equals(""))//Valido si el campo esta vacío " "
    		{
   				JOptionPane.showMessageDialog(null,"Docntificación requerida");//Imprimo un mensaje de atención si el campo esta vacío
    		}
   			else
   			{
   				if (txtusu.getText().equals(""))
   				{ 
   					JOptionPane.showMessageDialog(null,"Usuario requerido");
   				}  				
   				else
   				{ 
   					if(txtcorr.getText().equals(""))
   					{
   						JOptionPane.showMessageDialog(null,"Correo requerido");
   					}   							
   					else
   					{
   						String Pre=(String)jcbpre.getSelectedItem();
	   					if(Pre.equals(""))
	   					{
	   						JOptionPane.showMessageDialog(null,"Pregunta secreta requerida");
	   					}
	   					else
	   					{
	   						if(txtPre.getText().equals(""))
	   						{
	   							JOptionPane.showMessageDialog(null,"Respuesta requerida");
	   						}
	   						else
	   							
	   						if(txtcontr.getText().equals(""))
	   						{
	   							JOptionPane.showMessageDialog(null,"Contraseña requerida");
	   						}
	   						else
	   						{
	   							String Est=(String)jcbest.getSelectedItem();
			   					if(Est.equals(""))
			   					{
			   						JOptionPane.showMessageDialog(null,"Estado requerido");
			   					}
			   					else
			   					{
			   						//****************************************************
									// SE LEEN LOS DATOS INGRESADOS POR EL USUARIO DENTRO
									// DE LA LISTA. SE CONVIERTEN TODOS, SEGÚN SUS TIPOS
									//****************************************************
									int Documento=Integer.parseInt(txtDoc.getText());
									String usuario=txtusu.getText();
									String correo=txtcorr.getText();
									String pregunta=jcbpre.getSelectedItem().toString();
									String Pregunta=txtPre.getText();
									String contrasena=txtcontr.getText();
									String estado=jcbest.getSelectedItem().toString();
									//CREAMOS UN NODO Y LE MANDAMOS LOS PARAMETROS
									Nodo_Usuario x;
									x=new Nodo_Usuario(Documento,usuario,correo,pregunta,Pregunta,contrasena,estado);
									//LE ASIGNO EL NODO X CREADO, A LA LISTA POR MEDIO DE UN BOOLEANO
									boolean z=lista.InsertarOrdenado(x);
									//MUESTRO MENSAJE SI GRABA LOS DATOS O NO Y LIMPIO LOS CAMPOS
									if(z!=true)
									{
										JOptionPane.showMessageDialog(null,"La Docntificación ya existe","¡ERROR!",JOptionPane.ERROR_MESSAGE);//Si ya se ha ingresado un dato igual		
									}
									else
									{
										JOptionPane.showMessageDialog(null,"Información guardada con éxito");
									}								
									Limpiar();//Se limpian los campos ingresados
									lista.mostrarDatos(tabla,modelo);//Al limpiar los datos, se muestran en la tabla
				   					btnconsultar.setEnabled(true);//Se habilita el botón consultar
		   							btneliminar.setEnabled(false);//Se deshabilita el botón eliminar
		   							txtDoc.requestDefaultFocus();//Se da foco al textfield de documento
			   					}
	   						}
	   					}
		   			} 			
   				}
   			}  				
    	}
		if(a.getSource()==btnconsultar)
		{
			//CONVIERTO EL DOCUMENTO SOLICITADO DESDE EL JOPTION A NÚMERO
    		int ID=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento a consultar"));
    		//MANDO EL DOCUMENTO A BUSCAR, AL MÉTODO BUSCAR DE LA LISTA_NODO
    		Nodo_Usuario x=lista.Buscar(ID);
    		//VALIDO SI SE ENCONTRO LA DocNTIFICACIÓN
    		if(x==null)
    		{
    			JOptionPane.showMessageDialog(null,"El documento no existe","¡ERROR!",JOptionPane.ERROR_MESSAGE);//Se imprime un mensaje si el documento no existe
    			Limpiar();
    			ActivarTodo();   			
    		}
    		else
    		{
    			txtDoc.setText(""+x.getDocumento());
    			txtusu.setText(x.getusuario());
    			txtcorr.setText(x.getcorreo());
    			jcbpre.setSelectedItem(x.getpregunta());    			
    			txtPre.setText(x.getPregunta());
    			txtcontr.setText(x.getcontrasena());
    			jcbest.setSelectedItem(x.getestado());
    			//ACTIVO Y DESACTIVO LOS BOTONES
	    		btnmodificar.setEnabled(true);
	    		btneliminar.setEnabled(true);
	    		btnguardar.setEnabled(false);
	    		//DESACTIVO LOS TEXTFIELD PARA QUE SÓLO MUESTREN LA INFORMACIÓN
	    		txtDoc.setEnabled(false);
				txtDoc.setDisabledTextColor(Color.black);//SE LE DA COLOR A LOS TEXTFIELD DESACTIVADOS
				txtusu.setEnabled(false);
				txtusu.setDisabledTextColor(Color.black);
				txtPre.setEnabled(false);
				txtPre.setDisabledTextColor(Color.black);
				txtcontr.setEnabled(false);
				txtcontr.setDisabledTextColor(Color.black);
				UIManager.put("ComboBox.disabledForeground",Color.black);//SE LE DA COLOR A LOS COMBOBOX DESACTIVADOS
				jcbpre.setEnabled(false);
				jcbest.setEnabled(false);
    		}
		}	
		if(a.getSource()==btnmodificar)
		{
			JOptionPane.showMessageDialog(null,"Sólo puede Modificar los campos Usuario, Correo, Estado y Pregunta");
			btnguardarcambios.setEnabled(true);
			btneliminar.setEnabled(false);
			btnconsultar.setEnabled(false);
			txtDoc.setEnabled(false);
			txtusu.setEnabled(true);
			txtcorr.setEnabled(true);
			txtcontr.setEnabled(false);
			jcbpre.setEnabled(false);
			txtPre.setEnabled(true);
			jcbest.setEnabled(true);
			txtusu.requestDefaultFocus();
		}	
		if(a.getSource()==btnguardarcambios)
		{
			//****************************************************
			// SE LEEN LOS DATOS INGRESADOS POR EL USUARIO DENTRO
			// DE LA LISTA. SE CONVIERTEN TODOS, SEGÚN SUS TIPOS
			//****************************************************
			int Documento=Integer.parseInt(txtDoc.getText());
			String usuario=txtusu.getText();
			String correo=txtcorr.getText();
			String pregunta=jcbpre.getSelectedItem().toString();
			String Pregunta=txtPre.getText();
			String contrasena=txtcontr.getText();
			String estado=jcbest.getSelectedItem().toString();
			/*LLAMO EL MÉTODO MODIFICAR DE LA Lista_Usuario
				MANDANDOLE LOS CAMPOS QUE VOY MODIFICAR*/
			lista.Modificar(Documento,usuario,correo,pregunta,Pregunta,contrasena,estado);
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
			//CONVIERTO EL DOCUMENTO SOLICITADO DESDE EL JOPTION A NÚMERO
    		int ID=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento a eliminar"));
    		//MANDO EL DOCUMENTO A BUSCAR, AL MÉTODO BUSCAR DE LA LISTA_NODO_MÉDICO
    		Nodo_Usuario x=lista.Buscar(ID);//RECIBO LA INFORMACIÓN
    		//PREGUNTO SI NO SE ENCONTRÓ EL DOCUMENTO
    		if(x==null)
    		{
    			JOptionPane.showMessageDialog(null,"El documento no existe","¡ERROR!",JOptionPane.ERROR_MESSAGE);
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
			int dialogResult=JOptionPane.showConfirmDialog(null,"¿Desea Salir de Gestión Usuario?");
    		if(dialogResult==JOptionPane.YES_OPTION)
    		{
    			lista.guardar();
    			ventana.setVisible(false);	    		
    		}
    		if(dialogResult==JOptionPane.NO_OPTION)
    		{
    			txtDoc.requestDefaultFocus();	    		
    		}
    		if(dialogResult==JOptionPane.CANCEL_OPTION)
    		{
    			txtDoc.requestDefaultFocus();	    		
    		}
		}
    }
    //MÉTODOS
    public void ActivarTodo()
    {
    	txtDoc.setEnabled(true);
		txtusu.setEnabled(true);
		txtcorr.setEnabled(true);
		txtcontr.setEnabled(true);
		txtPre.setEnabled(true);
		jcbpre.setEnabled(true);
		jcbest.setEnabled(true);
		txtusu.requestDefaultFocus();
    }
    public void Limpiar()
    {
    	txtDoc.setText("");
    	txtusu.setText("");
    	txtcorr.setText("");
    	txtPre.setText("");
    	jcbpre.setSelectedItem("");
    	txtcontr.setText("");
    	jcbest.setSelectedItem("");
    }

    void show() {
        throw new UnsupportedOperationException();
    }
    
    private JTable tabla;//DECLARO LA TABLA DE LA LISTA
	private JScrollPane panelBarra;//MUESTRA EL CONTROL JTABLE Y COLOCA UNA BARRA SE SE NECESITA
	DefaultTableModel modelo;//CONTIENE LOS DATOS QUE SERÁN MOSTRADOS EN JTABLE
	Lista_Usuario lista;//DECLARO LA LISTA	
	JFrame ventana;
	Image icocabecera;//PARA PONER IMÁGEN DE CABECERA
	ImageIcon IcoGuardar,IcoConsultar,IcoModificar,IcoCambios,IcoEliminar,IcoSalir;//IMÁGENES PARA LOS BOTONES
	JLabel lblDoc,lblusu,lblcorr,lblpre,lblPre,lblcontr,lblest,lblmen,lblmen2;
	JTextField txtDoc,txtusu,txtPre,txtcorr,txtcontr;
	JComboBox jcbpre,jcbest;
	String[]pre={"","¿Su pasatiempo favorito?","¿Su color favorito?","¿Nombre de su Abuela materna?","¿Donde cursó la primaria?"};
	String[]est={"","Activo","Inactivo"};
	JButton btnguardar,btnconsultar,btnmodificar,btneliminar,btnguardarcambios,btnsalir;
	
	JPanel jpdatos,jpbotones;
}