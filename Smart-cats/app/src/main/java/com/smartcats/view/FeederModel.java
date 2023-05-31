/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcats.view;

import com.smartcats.logic.HttpClient;
import com.smartcats.logic.SocketClient;
import com.smartcats.logic.model.Dish;
import com.smartcats.logic.model.Movement;
import com.smartcats.util.Constants;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 57313
 */
public class FeederModel {
    
    private Controller controller;
    
    private final double pesoGato = 5.0;

    private final double cantidadGramos = 20;
    
    private Timer timer;
    
    public FeederModel() {
    }

    public FeederModel(Controller controller) {
        this.controller = controller;
    }
    
    
    
    public Dish changeDish(Dish dish){
        if (dish.getGramos() == Constants.DISH_FULL){
                return Constants.getDish(Constants.DISH_80);
        }else if(dish.getGramos() == Constants.DISH_80){
                return Constants.getDish(Constants.DISH_60);
        }else if(dish.getGramos() == Constants.DISH_60){
                return Constants.getDish(Constants.DISH_40);
        }else if(dish.getGramos() == Constants.DISH_40){
                return Constants.getDish(Constants.DISH_20);
        }else if(dish.getGramos() == Constants.DISH_20){
                return Constants.getDish(Constants.DISH_EMPTY);
        }else if(dish.getGramos() == Constants.DISH_EMPTY){
        }
        return dish;
    }
    
    public void taskFillDish(){
        if(timer == null){
            Timer timerFill = new Timer();
             TimerTask taskEatCat = new TimerTask() {
                    @Override
                public void run() {
                    System.out.println("Llenar plato");
                    SocketClient.serverConnection().sendMessage("Llenar plato");
                    fillDish();
                }
            };

            timerFill.scheduleAtFixedRate(taskEatCat, 0, 40000);
        }

    }
    
    public void taskEatCat(){
        if(timer == null){
            timer = new Timer();
             TimerTask taskEatCat = new TimerTask() {
                    @Override
                public void run() {
                    System.out.println("El gato Esta comiendo, cantidad (gr) de plato: "+ controller.getDish().getGramos() );
                    SocketClient.serverConnection().sendMessage("El gato Esta comiendo, cantidad (gr) de plato: "+ controller.getDish().getGramos());
                    Dish dish = changeDish(controller.getDish());
                    controller.setDish(dish);
                    try {
                HttpClient.sendPostRequest(new Movement(1, "C"));
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                 
            };

            timer.scheduleAtFixedRate(taskEatCat, 0, 6000);
        }

    }
    
    public void cancelTimer(){
        if(timer != null){
            System.out.println("CIERRA TAREA");
            timer.cancel();
            timer = null;
        }
    }
    
    
    public void fillDish() {

        double cantidadComida = calculateAmountOfFood();
        Dish newDish = validateQuantityDish(cantidadComida);

        if (validateQuantityTank(cantidadComida)) {
            
            if(newDish.getGramos() != Constants.DISH_EMPTY){
                controller.setDish(newDish);
            }
        } else {
            System.out.println("NO HAY SUFICIENTE COMIDA EN EL TANQUE");
            SocketClient.serverConnection().sendMessage("NO HAY SUFICIENTE COMIDA EN EL TANQUE");
        }
    }

    private double calculateAmountOfFood() {
        return cantidadGramos * pesoGato;
    }

    public boolean validateQuantityTank(double cantidadComida) {
        return controller.getView().getTank().getValue() - cantidadComida > 0;
    }

    public Dish validateQuantityDish(double cantidadComida) {
        controller.setTank(cantidadComida - controller.getDish().getGramos());
        return Constants.whichDish(cantidadComida);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
}
