/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcats.util;

import com.google.gson.Gson;
import com.smartcats.logic.model.Dish;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 57313
 */
public class Constants {
    
    //Types dishes
    
    public static final Gson GSON = new Gson();
    
    public static final int PORT = 5000;
    public static final double DISH_FULL = 100;
    
    public static final double DISH_80 = 80;
    
    public static final double DISH_60 = 60;
    
    public static final double DISH_40 = 40;
    
    public static final double DISH_20 = 20;
    
    public static final double DISH_EMPTY = 0;
    
    //Img dishes
    
    public static final String IMG_DISH_FULL = "src/main/java/com/smartcats/img/05.png";
    
    public static final String IMG_DISH_80 = "src/main/java/com/smartcats/img/04.png";
    
    public static final String IMG_DISH_60 = "src/main/java/com/smartcats/img/03.png";
    
    public static final String IMG_DISH_40 = "src/main/java/com/smartcats/img/02.png";
    
    public static final String IMG_DISH_20 = "src/main/java/com/smartcats/img/01.png";
    
    public static final String IMG_DISH_EMPTY = "src/main/java/com/smartcats/img/00.png";
    
    private static final Map<Double, Dish> dishes = new HashMap();

    static {

        dishes.put(DISH_FULL,
            new Dish(IMG_DISH_FULL, DISH_FULL));
        dishes.put(DISH_80,
            new Dish(IMG_DISH_80, DISH_80));

        dishes.put(DISH_60,
            new Dish(IMG_DISH_60, DISH_60));
        
        dishes.put(DISH_40,
            new Dish(IMG_DISH_40, DISH_40));
        dishes.put(DISH_20,
            new Dish(IMG_DISH_20, DISH_20));

        dishes.put(DISH_EMPTY,
            new Dish(IMG_DISH_EMPTY, DISH_EMPTY));
    }

    private Constants() {
    }

    public static Dish getDish(double key) {
        return dishes.get(key);
    }
    
    public static Dish whichDish(double gramos){
        if(gramos > DISH_80){
            return getDish(DISH_FULL);
        }else if(gramos <= DISH_80 && gramos > DISH_60 ){
            return getDish(DISH_80);
        }else if(gramos <= DISH_60 && gramos > DISH_40 ){
            return getDish(DISH_60);
        }else if(gramos <= DISH_40 && gramos > DISH_20 ){
            return getDish(DISH_40);
        }else if(gramos <= DISH_20 && gramos > DISH_EMPTY){
            return getDish(DISH_20);
        }else{
            return getDish(DISH_EMPTY);
        }
    }
    
    
}
