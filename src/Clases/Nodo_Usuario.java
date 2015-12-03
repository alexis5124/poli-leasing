package Clases;


//SE DECLARAN LOS CAMPOS DEL NODO
public class Nodo_Usuario 
{
	private int Documento;//Se declara un tipo de dato entero 'Int'
	private String usuario;//Se declara un tipo de dato alfanumerico 'String'
	private String correo;
	private String pregunta;
	private String Pregunta;
	private String contrasena;
	private String estado;
	Nodo_Usuario liga;
	//SE RECIBEN LOS DATOS
	public Nodo_Usuario(int Documento,String usuario,String correo,String pregunta,String Pregunta, String contrasena,String estado)
	{
		this.Documento=Documento;
		this.usuario=usuario;
		this.correo=correo;
		this.pregunta=pregunta;
		this.Pregunta=Pregunta;
		this.contrasena=contrasena;
		this.estado=estado;
		this.liga=null;//La liga del nodo se hace igual a null '0'	
    }
    //SE CREA EL NODO VACIO
    public Nodo_Usuario()
    {
    	this.Documento=0;//Documento se hace igual a '0' ya que es un tipo de dato entero
    	this.usuario="";
    	this.correo="";
    	this.pregunta="";
    	this.Pregunta="";
    	this.contrasena="";
    	this.estado="";
    	this.liga=null;
    }
    //******************************************************
  	// MÉTODOS OBTENER QUE REGRESAN EL VALOR DE UN ATRIBUTO
  	//******************************************************
  	public int getDocumento()//Obtengo 'get' el dato de tipo entero 'Documento'
  	{
  		return Documento;//Retorno el dato Documento
  	}
  	public String getusuario()
  	{
  		return usuario;
  	}
  	public String getcorreo()
  	{
  		return correo;
  	}
  	public String getpregunta()
  	{
  		return pregunta;
  	}
  	
  	public String getPregunta()
  	{
  		return Pregunta;
  	}
  	public String getcontrasena()
  	{
  		return contrasena;
  	}
  	public String getestado()
  	{
  		return estado;
  	}
  	public Nodo_Usuario getliga()
  	{
  		return liga;
  	}
  	////////////////////////////////////////////////////////////////////////////////////////////////
	//************************************************
  	// MÉTODOS QUE ASIGNAN UN NUEVO VALOR AL ATRIBUTO
  	//************************************************
  	public void setDocumento(int Documento)//Asigno o mando 'set' el nuevo valor del entero 'Documento'
  	{
  		this.Documento=Documento;
  	}
  	public void setusuario(String usuario)
  	{
  		this.usuario=usuario;
  	}
  	public void setcorreo(String correo)
  	{
  		this.correo=correo;
  	}
  	public void setpregunta(String pregunta)
  	{
  		this.pregunta=pregunta;
  	}
  	
  	public void setPregunta(String Pregunta)
  	{
  		this.Pregunta=Pregunta;
  	}
  	public void setcontrasena(String contrasena)
  	{
  		this.contrasena=contrasena;
  	}
  	public void setestado(String estado)
  	{
  		this.estado=estado;
  	}
  	public void setLiga(Nodo_Usuario liga)
  	{
  		this.liga=liga;
  	}
}
