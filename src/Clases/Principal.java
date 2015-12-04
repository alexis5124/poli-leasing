package Clases;

import Clases.frmSplash;
import formularios.form_login;

public class Principal {
	

	public static void main(String[] args) {
		Datos misDatos = new Datos();
		form_login miLogin = new form_login();
		miLogin.setLocationRelativeTo(null);
		miLogin.setDatos(misDatos);
		miLogin.setVisible(true);
		
	}	
}
