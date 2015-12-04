package Clases;

import javax.swing.JInternalFrame;
import formularios.form_principal;

public class InternalFrameImagen extends JInternalFrame{
    private PanelImagen pi = new PanelImagen();
    
    public InternalFrameImagen(){
        setContentPane( pi );
    }
    
    public void setImage(String nombreImagen){
        pi.setImage(nombreImagen);
    }
}
