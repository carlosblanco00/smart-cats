package co.com.smartcats.presentacion;

import co.com.smartcats.logica.util.Constants;
import co.com.smartcats.logica.util.Dish;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author cablanco
 */
public class Controlador implements MouseListener{
    
    private Vista ventana;
    private Modelo modelo;
    
    private Dish dish; 
    
    public Controlador(Modelo modelo){
        this.modelo = modelo;
        this.modelo.setControlador(this);
        dish = Constants.getDish(Constants.DISH_EMPTY);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        
        if (dish.getGramos() == Constants.DISH_FULL){
                dish = Constants.getDish(Constants.DISH_80);
                setImageLabel(ventana.getPlato(), dish.getImg());
        }else if(dish.getGramos() == Constants.DISH_80){
                dish = Constants.getDish(Constants.DISH_60);
                setImageLabel(ventana.getPlato(), dish.getImg());
        }else if(dish.getGramos() == Constants.DISH_60){
                dish = Constants.getDish(Constants.DISH_40);
                setImageLabel(ventana.getPlato(), dish.getImg());
        }else if(dish.getGramos() == Constants.DISH_40){
                dish = Constants.getDish(Constants.DISH_20);
                setImageLabel(ventana.getPlato(), dish.getImg());
        }else if(dish.getGramos() == Constants.DISH_20){
                dish = Constants.getDish(Constants.DISH_EMPTY);
                setImageLabel(ventana.getPlato(),dish.getImg());
        }else if(dish.getGramos() == Constants.DISH_EMPTY){
                setImageLabel(ventana.getPlato(), dish.getImg());
        }
    }
    
    public void setImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon); 
        
        this.ventana.repaint();
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }
    
    public Vista getVentana() {
        return ventana;
    }

    public void setVentana(Vista ventana) {
        this.ventana = ventana;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }   

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
        setImageLabel(ventana.getPlato(), dish.getImg());
    }
    
    public void setTanque(double cantidadParaLlenarPlato) {
        int cantiddadActual = this.ventana.getTanque().getValue();
        this.ventana.getTanque().setValue((int)(cantiddadActual - cantidadParaLlenarPlato));
    }
    
    

}
