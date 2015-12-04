package Clases;


//SE DECLARAN LOS CAMPOS DEL NODO
public class Nodo_Inmueble 
{
	private int idinmueble;//Se declara un tipo de dato entero 'Int'
	private String idpropietario;//Se declara un tipo de dato alfanumerico 'String'
	private String Municipio;
	private String Barrio;
	private String Direccion;
	private String valor;

	Nodo_Inmueble liga;
	//SE RECIBEN LOS DATOS
	public Nodo_Inmueble(int idinmueble,String idpropietario,String Municipio,String Barrio,String Direccion, String valor)
	{
		this.idinmueble=idinmueble;
		this.idpropietario=idpropietario;
		this.Municipio=Municipio;
		this.Barrio=Barrio;
		this.Direccion=Direccion;
		this.valor=valor;
		
		this.liga=null;//La liga del nodo se hace igual a null '0'	
    }
    //SE CREA EL NODO VACIO
    public Nodo_Inmueble()
    {
    	this.idinmueble=0;//idinmueble se hace igual a '0' ya que es un tipo de dato entero
    	this.idpropietario="";
    	this.Municipio="";
    	this.Barrio="";
    	this.Barrio="";
    	this.valor="";
    	
    	this.liga=null;
    }
    //******************************************************
  	// MÉTODOS OBTENER QUE REGRESAN EL VALOR DE UN ATRIBUTO
  	//******************************************************
  	public int getidinmueble()//Obtengo 'get' el dato de tipo entero 'idinmueble'
  	{
  		return idinmueble;//Retorno el dato idinmueble
  	}
  	public String getidpropietario()
  	{
  		return idpropietario;
  	}
  	public String getMunicipio()
  	{
  		return Municipio;
  	}
  	public String getBarrio()
  	{
  		return Barrio;
  	}
  	
  	public String getDireccion()
  	{
  		return Direccion;
  	}
  	public String getvalor()
  	{
  		return valor;
  	}
  
  	public Nodo_Inmueble getliga()
  	{
  		return liga;
  	}
  	////////////////////////////////////////////////////////////////////////////////////////////////
	//************************************************
  	// MÉTODOS QUE ASIGNAN UN NUEVO VALOR AL ATRIBUTO
  	//************************************************
  	public void setidinmueble(int idinmueble)//Asigno o mando 'set' el nuevo valor del entero 'idinmueble'
  	{
  		this.idinmueble=idinmueble;
  	}
  	public void setidpropietario(String idpropietario)
  	{
  		this.idpropietario=idpropietario;
  	}
  	public void setMunicipio(String Municipio)
  	{
  		this.Municipio=Municipio;
  	}
  	public void setBarrio(String Barrio)
  	{
  		this.Barrio=Barrio;
  	}
  	
  	  	public void setDireccion(String Direccion)
  	{
  		this.Direccion=Direccion;
  	}
  	public void setvalor(String valor)
  	{
  		this.valor=valor;
  	}

  	public void setLiga(Nodo_Inmueble liga)
  	{
  		this.liga=liga;
  	}
}

