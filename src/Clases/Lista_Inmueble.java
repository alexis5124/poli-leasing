package Clases;

import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;
import java.io.*; 

public class Lista_Inmueble
{
	private String nombreArchivo;//ATRIBUTO QUE TIENE EL NOMBRE DEL ARCHIVO DONDE SE GUARDARÁN LOS DATOS
	private String nombre;
	//LISTA
	private Nodo_Inmueble cabeza;
	/*****************************************************/
  	// CONSTRUCTOR  QUE RECIBE EL NOMBRE DE LA LISTA Y EL
  	// NOMBRE DEL ARCHIVO DONDE ESTAN LOS DATOS
  	//****************************************************/
  	public  Lista_Inmueble(String nombre,String nombreArchivo)
  	{
  		this.nombre=nombre;
  		this.nombreArchivo=nombreArchivo;
  		cabeza=null;  		
  	}	
	public  Lista_Inmueble() 
	{
		this.cabeza=null;
    }
    //MÉTODO QUE DEVUELVE UNA RESPUESTA SI LA LISTA ESTA VACIA O NO
	public boolean estaVacia()
	{
		boolean Respuesta=false;
		//SI LA CABEZA NO ESTA VACIA
		if(cabeza!=null)
		{
			//SE CONVIERTE LA RESPUESTA
			Respuesta=true;
		}
		return Respuesta;
	}
    //*******************************************
	// MÉTODO QUE RECIBE EL NODO X DEL BOTÓN
	// Y GUARDAR SI EL DOCUMENTO NO EXISTE
	//*******************************************
 	public boolean InsertarOrdenado(Nodo_Inmueble N)
    {
    	boolean Respuesta=false;
    	//SE HACE LA CONDICIÓN PARA SABER QUE EL DOCUMENTO NO ESTÉ INGRESADO EN LA LISTA
    	if(BuscarID(N.getidinmueble())==false)
    	{  
    		Respuesta=true;  
	    	Nodo_Inmueble A;
	    	//SI LISTA ESTA VACIA
	       	if(cabeza==null)
			{
				//EL NODO QUE INGRESO, SE VUELVE LA CABEZA
				cabeza=N;
			}
			else
			{
				//BUSCO EL DOCUMENTO ANTERIOR
	            A=BuscarAnterior(N.getidinmueble());
	            //SI EL NODO RECIBIDO ESTA LLENO
	            if(A!=null)
				{
					//NODO APUNTA A LA LIGA DE A
					N.setLiga(A.getliga());
					//'A' SE COLOCA ANTES DE 'N'
		            A.setLiga(N);
	            }
				else
				{
					//NODO QUE APUNTA A LIGA, SE VUELVE LA CABEZA
					N.setLiga(cabeza);
					//CABEZA SE VUELVE 'N'
	                this.cabeza=N;
				}
			}			
		}
		return Respuesta;	
	}
	//MÉTODO PARA BUSCAR QUE EL DOCUMENTO NO ESTE EN LA LISTA
	public boolean BuscarID(int Documento)
	{
		boolean Respuesta=false;
		Nodo_Inmueble P=cabeza;
		while(P!=null)
		{
			//SI EL DOCUMENTO ESTÁ EN LA LISTA, ME CAMBIA LA RESPUESTA
			if(P.getidinmueble()==Documento)
			{
				Respuesta=true;
			}
			//SINO ESTÁ, SIGUE RECORRIENDO LA LISTA
			P=P.getliga();
		}		
		return Respuesta;
	}	
	//*******************************************************
	// MÉTODO QUE ME BUSCA SI EL DOCUMENTO INGRESADO
	// ES MENOR QUE LOS DATOS QUE YA ESTABAN INGRESADOS
	//*******************************************************
	public Nodo_Inmueble BuscarAnterior(int Documento)
	{
		Nodo_Inmueble A=null,P=cabeza;
        while(P!=null)
		{
			//SI EL DOC ES MENOR
			if(P.getidinmueble()<Documento)
			{
				//ANTERIOR ME GUARDA P
        		A=P;
        		//P ESTA AVANZANDO
        		P=P.getliga();
			}
			else
			{
				//RETORNA EL NUEVO NODO VACIO
				return A;
			}
		}
		//RETORNA EL NODO LLENO
        return A;
	}
	//*********************************************
	// MÉTODO QUE ME BUSCA EL DOCUMENTO
	// RETORNA UN NODO CON LA INFORMACIÓN SI LA ENCUENTRA
	// SINO, RETORNA NULL '0'
	//*********************************************
	public Nodo_Inmueble Buscar(int Documento)
	{
		Nodo_Inmueble B=null,P=cabeza;
        while(P!=null)
		{
			//B AVANZA IGUAL QUE P
			B=P;
			//PREGUNTO SI EL DOCUMENTO ES IGUAL A EL DOC DEL NODO
            if(P.getidinmueble()!=Documento)
			{
				//SIGUE RECORRIENDO LA LISTA
				P=P.getliga();
			}
			else
			{
				//RETORNA EL NODO CON LA INFORMACIÓN
				return B;
            }
        }
        //RETORNA NULL SINO ENCUENTRA EL DOCUMENTO
        return null;
	}
	//**********************************************************
	// MÉTODO PARA MODIFICAR LOS DATOS, MENOS EL DOCUMENTO 
	//**********************************************************
	public void Modificar(int Documento,String usuario,String correo,String pregunta,String Pregunta,String valor)
	{
		//BUSCO EL DOCUMENTO
		Nodo_Inmueble N=Buscar(Documento);
		//MODIFICO LOS DATOS
        N.setidpropietario(usuario);
		N.setMunicipio(correo);
		N.setBarrio(pregunta);		
		N.setDireccion(Pregunta);		
        N.setvalor(valor);
        
	}
	//MÉTODO ELIMINAR INFORMACIÓN
	//RECIBE EL DOCUMENTO
	public Nodo_Inmueble Eliminar(int Documento)
	{
		Nodo_Inmueble A=null,P=cabeza,Z=null;
		boolean Bandera=false;
		//RECORRO LA LISTA
		while(P!=null&&Bandera==false)
		{
			//SE HACE LA CONDICIÓN PARA LA BUSQUEDA
			if(P.getidinmueble()==Documento)
			{
				//SI ESTÁ AL PRINCIPIO
				if(P==cabeza)
				{
					//LA CABEZA AVANZA A LA LIGA
					cabeza=P.getliga();
				}
				else
				{
					//EL NODO AUXILIAR APUNTA A LA LIGA DE P
					A.setLiga(P.getliga());
				}
				//Z TOMA LOS DATOS DE P
				Z=P;
				//P AVANZA A LA LIGA
				P=P.getliga();
				//CAMBIO BANDERA
				Bandera=true;				
			}
			else
			{
				//A ME AYUDA A GUARDAR EL DATO ANTERIOR
				A=P;
				//P AVANZA A LA LIGA
				P=P.getliga();
			}
		}
		return Z;
	}
    //OBTENER Y ASIGNAR LA CABEZA
	public Nodo_Inmueble getCabeza()
	{
        return cabeza;
    }
    public void setCabeza(Nodo_Inmueble cabeza)
	{
        this.cabeza=cabeza;
    }
    //***************************************************
  	// MÉTODO ENCARGADO DE MOSTRAR LOS DATOS DE LA LISTA
  	// EN EL JTABLE Y MODELO RECIBIDOS COMO PARAMETROS
  	//***************************************************
  	public void mostrarDatos(JTable tabla,DefaultTableModel modelo)
    {
    	//SE CREAN LOS TÍTULOS DE LAS COLUMNAS
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
    	modelo.addColumn("Id Inmueble");
   		modelo.addColumn("Id Propietario");
   		modelo.addColumn("Municipio");
		modelo.addColumn("Barrio");		
		modelo.addColumn("Valor");
		
  		tabla.setRowHeight(20);//ALTURA DE LA FILA DE LOS TÍTULOS
	   	//**********************
	  	//ANCHO DE LAS COLUMNAS
	  	//**********************
	 	tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(60);
		
		//SE CREA LA CADENA   
	   	String datos[]=new String[6];
	   	Nodo_Inmueble P=cabeza;
	   	//SE EMPIEZA A RECORRER LA LISTA
   		while(P!=null)
    	{
    		//A CADA POSICIÓN DE DATO, LE DECIMOS QUE OBTENGA UN CAMPO DEL NODO
    		datos[0]=""+P.getidinmueble();
	   		datos[1]=P.getidpropietario();
	   		datos[2]=P.getMunicipio();
	   		datos[3]=P.getDireccion();	   			
	   		datos[4]=P.getvalor();
	   		modelo.addRow(datos); 
     		P=P.getliga();  	
     	}
    }
    //************************************************************
	// MÉTODO QUE INGRESA LOS USUARIOS INICIALES PARA QUE LA LISTA
	// NO INICIE VACIA. SE TOMAN LOS DATOS DEL ACHIVO 
	//************************************************************
   public void ingresarDatosIniciales()
   {
   	  DataInputStream entrada=null;//PARA ENTRAR INFORMACIÓN-LEER
   	  DataOutputStream salida=null;//PARA COPIAR INFORMACIÓN-ESCRIBIR
   	  try
	  {
	  	//ABRO EL ARCHIVO
	  	salida=new DataOutputStream(new FileOutputStream(nombreArchivo,true));
	    entrada=new DataInputStream(new FileInputStream(nombreArchivo));
	  }
	  catch(IOException e)
	  {
	  	//EXCEPCIÓN CUANDO HAY PROBLEMA DE LECTURA
	  	System.out.println("No se pudo abrir el archivo para lectura");
	  	System.exit(1);
	  }
	  try
      {
      	//AQUÍ LEO EL ARCHIVO
      	while(true)
      	{
      		Nodo_Inmueble P;
      		int Documento=entrada.readInt();
      		String usuario=entrada.readUTF();
      		String correo=entrada.readUTF();
      		String pregunta=entrada.readUTF();
      		String respuesta=entrada.readUTF();
      		String valor=entrada.readUTF();
      		P=new Nodo_Inmueble(Documento,usuario,correo,pregunta,respuesta,valor);
      		InsertarOrdenado(P);
      	}
      }
      //EXCEPCIÓN PARA CUANDO TERMINA DE LEERLO
      catch(EOFException e)
      {
      	//SE DISPARA CUANDO SE TERMINA DE LEER EL ARCHIVO
      }
      //EXCEPCIÓN SI HAY PROBLEMAS CON EL ARCHIVO
      catch(IOException e)
      {
      	System.out.println("Error al listar el archivo");
      	System.exit(1);
      }
   }    
   //*******************************************
   // GUARDA EN EL ARCHIVO TODOS LA INFORMACIÓN
   // QUE ESTÁ EN LA LISTA
   //*******************************************
   public void guardar()
   {
		DataOutputStream salida=null;
		//ABRÓ EL ARCHIVO
      	try
	  	{
	  		//SE ABRE EL ARCHIVO PARA ESCRIBIR EN EL BORRADOR TODO EL CONTENIDO QUE SE TIENE EN EL MOMENTO.  
	    	salida=new DataOutputStream(new FileOutputStream("Usuario.txt"));
	  	}
	  	//EXCEPCIÓN SI HAY PROBLEMAS PARA ESCRIBIR
	  	catch(IOException e)
	  	{
	    	System.out.println("No se pudo abrir el archivo para escritura");
	    	System.exit(1);
	  	}
	  	//ESCRIBO EN EL ARCHIVO
	  	try
	  	{
	  		//SE GUARDA EN EL ARCHIVO TODO EL USUARIO DEL BUFETE QUE HAY EN LA LISTA 
	  		Nodo_Inmueble P=cabeza;
			while (P!=null)
		    {
		    	salida.writeInt(P.getidinmueble());
		     	salida.writeUTF(P.getidpropietario());
		     	salida.writeUTF(P.getMunicipio());
		        salida.writeUTF(P.getBarrio());		        
		        salida.writeUTF(P.getDireccion());		        
		        salida.writeUTF(P.getvalor());
		        P=P.getliga();
		    }	  	
	  	}
	  	catch(IOException e)
	  	{
	  		//EXCEPCIÓN SI HAY PROBLEMAS PARA ESCRIBIR
	  		System.out.println("Error al escribir en el archivo");
	   		System.exit(1);
	  	}
   }
}