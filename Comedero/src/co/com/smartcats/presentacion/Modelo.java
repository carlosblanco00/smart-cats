package co.com.smartcats.presentacion;

import co.com.smartcats.logica.util.Constants;
import co.com.smartcats.logica.util.Dish;

public class Modelo {

    private Controlador controlador;

    private final double pesoGato = 5.0;

    private final double cantidadGramos = 20;

    public void llenarPlato() {

        double cantidadComida = calcularCantidadDeComida();
        Dish newDish = validarCantidadPlato(cantidadComida);

        if (validarCantidadTanque(cantidadComida)) {
            
            if(newDish.getGramos() != Constants.DISH_EMPTY){
                controlador.setDish(newDish);
            }


        } else {

        }
    }

    private double calcularCantidadDeComida() {
        return cantidadGramos * pesoGato;
    }

    public boolean validarCantidadTanque(double cantidadComida) {
        return controlador.getVentana().getTanque().getValue() - cantidadComida > 0;
    }

    public Dish validarCantidadPlato(double cantidadComida) {
        controlador.setTanque(cantidadComida - controlador.getDish().getGramos());
        return Constants.whichDish(cantidadComida);
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    

}
