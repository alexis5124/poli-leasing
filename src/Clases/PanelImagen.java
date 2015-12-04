package Clases;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{
    private Image imagen;
    
    public PanelImagen(){
        imagen = null;
    }
    
    public PanelImagen(String nombreImagen){
        if(nombreImagen != null){
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        }
    }
    
    public void setImage(String nombreImagen){
        if (nombreImagen != null) {
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        } else {
            imagen = null;
        }
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            this.setOpaque(false);
            
        } else {
            setOpaque(true);
        }
        super.paint(g);
        
    }
    
}
