package Clases;

import formularios.form_principal;
import javax.swing.JOptionPane;
import java.util.Date;

public class Datos {
	
	private int maxUsu = 100;
	private Usuario misUsuarios[] = new Usuario[maxUsu];
	private int contUsu = 0;
	
	
	
	
	//Constructor de la clase datos
	public Datos() {
		cargarUsuarios();

		
       
	}
	
	public boolean validarUsuario(String usuario, String clave) {
		for(int i = 0; i < contUsu; i++) {
			if(misUsuarios[i].getUsuario().equalsIgnoreCase(usuario)
				&& misUsuarios[i].getClave().equals(clave)) {
				{
    			JOptionPane.showMessageDialog(null,"Bienvenido a la inmobiliaria Poli-Leasing");
    			new form_principal();
    			return true;
    		    } 
		}
	}
	return false;				
}

    public int posicionUsuario(String usuario) {
    	for(int i = 0; i < contUsu; i++) {
    		if(misUsuarios[i].getDocumento().equalsIgnoreCase(usuario)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
  
    
    public String agregarUsuario(Usuario miUsuario) {
    	if(contUsu == maxUsu) {
    		return "Se ha alcanzado el número máximo de usuarios. ¡elimina usuarios ya no activos!";
    	}
    	
    	misUsuarios[contUsu] = miUsuario;
    	contUsu++;
    	return "Usuario agregado correctamente";
    }
    
    
    
  
	

	
	public String modificarUsuario(Usuario miUsuario, int pos) {
		misUsuarios[pos].setUsuario(miUsuario.getUsuario());
		misUsuarios[pos].setPregunta(miUsuario.getPregunta());
		misUsuarios[pos].setCorreo(miUsuario.getCorreo());
		misUsuarios[pos].setClave(miUsuario.getClave());
		misUsuarios[pos].setTipoDoc(miUsuario.getTipoDoc());
    	return "Usuario modificado correctamente";
	}
	
	/*public String modificarProceso(Proceso miProceso, int pos) {
		Lista_Proceso.get(pos).setIdProceso(miProceso.getIdProceso());
		Lista_Proceso.get(pos).setIdProceso(miProceso.getNombreProceso());
    	return "Proceso modificado correctamente";
	}*/
	
	public String borrarUsuario(int pos) {
		for(int i = pos; i < contUsu -1; i++) {
			misUsuarios[i] = misUsuarios[i + 1];
		}
		contUsu--;
    	return "Usuario borrado correctamente";
	}
	

        
	
	private void cargarUsuarios() {
		Usuario miUsuario;
		
		miUsuario = new Usuario("14343", 0, "alexis", "ajhj@hotmail.com",  2, "123");
		misUsuarios[contUsu] = miUsuario;
		contUsu++;
		
		miUsuario = new Usuario("2434", 1,"ana", "jag11@gmail.com", 3, "123");
		misUsuarios[contUsu] = miUsuario;
		contUsu++;
		
		miUsuario = new Usuario("439483843", 1,"santiago", "risgs22@hotmail.com", 0, "123");
		misUsuarios[contUsu] = miUsuario;
		contUsu++;
	}
	


	
	/*private void cargarProcesos() {
		Proceso miProceso;
		
		miProceso = new Proceso("14343", "XXXX");
                Lista_Proceso.add(miProceso);
                
		miProceso = new Proceso("2434", "XXXX");
		Lista_Proceso.add(miProceso);
                
		miProceso = new Proceso("439483843", "XXXX");
		Lista_Proceso.add(miProceso);
        }*/
	
	public int numeroUsuarios() {
		return contUsu;
	}
	

	
	
	public Usuario[] getUsuarios() {
		return misUsuarios;
	}
	

	
	
}
