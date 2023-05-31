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
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 57313
 */
public class Controller extends MouseAdapter {

    private View view;

    private final FeederModel feederModel;

    private boolean boxDirty;
    
    private boolean catDrink = true;

    private Dish dish;

    public Controller(FeederModel feederModel) {
        this.feederModel = feederModel;
        dish = Constants.getDish(Constants.DISH_EMPTY);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        var log = Logger.getLogger(Controller.class.getName());

        int x = e.getX() + view.getCat().getX() - view.getCat().getWidth() / 2;
        int y = e.getY() + view.getCat().getY() - view.getCat().getHeight() / 2;

        view.getContentPane().setComponentZOrder(view.getCat(), 0);
        view.getCat().setLocation(x, y);

        if (checkCatIn(view.getBox()) && !boxDirty) {
            log.info("ENTRA GATO A BOX");
            SocketClient.serverConnection().sendMessage("El gato esta en el arenero");
            try {
                HttpClient.sendPostRequest(new Movement(1, "A"));
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            boxDirty = true;
            setImageLabel(view.getBox(), "src/main/java/com/smartcats/img/dirty-box.png");

        } else if (!checkCatIn(view.getBox()) && boxDirty) {
            boxDirty = false;
            
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    setImageLabel(view.getBox(), "src/main/java/com/smartcats/img/clean-box.png");
                    SocketClient.serverConnection().sendMessage("Limpiar arenero");
                    log.info("Limpiar");
                }
            }).start();

            

        } else if (checkCatIn(view.getFeeder())) {
            feederModel.taskEatCat();
        } else if (checkCatIn(view.getDrinker()) && catDrink) {
            //TODO: logica bebedero
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SocketClient.serverConnection().sendMessage("El gato esta tomando agua");
                    try {
                HttpClient.sendPostRequest(new Movement(1, "B"));
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("GATO TOMANDO AGUA");
                    
                    catDrink = true; 
                }
            }).start();
            
            catDrink = false; 
        } else {
            feederModel.cancelTimer();
        }

    }

    private boolean checkCatIn(JLabel label) {

        var x1 = view.getCat().getX();
        var y1 = view.getCat().getY();

        var width1 = view.getCat().getWidth();
        var height1 = view.getCat().getHeight();

        var x2 = label.getX();
        var y2 = label.getY();

        var width2 = label.getWidth();
        var height2 = label.getHeight();

        return x1 <= x2 + width2 && x1 + width1 >= x2 && y1 <= y2 + height2 && y1 + height1 >= y2;

    }

    /**
     *
     * @param cantidadParaLlenarPlato
     */
    public void setTank(double cantidadParaLlenarPlato) {
        int cantiddadActual = this.view.getTank().getValue();
        this.view.getTank().setValue((int) (cantiddadActual - cantidadParaLlenarPlato));
        SocketClient.serverConnection().sendMessage("En el tanque de comida queda: " + this.view.getTank().getValue() + "gr");
        
    }

    public void setImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        labelName.repaint();
        this.view.repaint();
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
        setImageLabel(this.view.getFeeder(), this.dish.getImg());
    }

}
