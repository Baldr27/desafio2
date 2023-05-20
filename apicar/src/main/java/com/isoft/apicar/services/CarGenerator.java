package com.isoft.apicar.services;

import com.isoft.apicar.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CarGenerator
 */
public class CarGenerator {
//rng es una variable random
  private Random rng = new Random();

  String[] brands = {"Toyota", "Honda", "Audi", "BMW", "Hyundai"};
  String[] colors = {"Red", "Blue", "Green", "Yellow", "Black"};
  String[] sedanMotors = {"1.4cc", "1.6cc", "2.0cc"};
  String[] camionetaMotors = {"2.4cc", "3.0cc", "4.0cc"};
  String[] suvMotors = {"1.8cc", "2.2cc", "2.8cc"};

  public Sedan generateSedan(Long id){
        return new Sedan(id,
                         brands[rng.nextInt(brands.length)],
                         (rng.nextInt(9) + 2015),
                         colors[rng.nextInt(colors.length)],
                         rng.nextInt(22000000) + 8000000,
                         rng.nextBoolean(),
                         sedanMotors[rng.nextInt(sedanMotors.length)]
                         );
    }

    public Camioneta generateCamioneta(Long id){
        return new Camioneta(id,
                         brands[rng.nextInt(brands.length)],
                         (rng.nextInt(9) + 2015),
                         colors[rng.nextInt(colors.length)],
                         rng.nextInt(22000000) + 8000000,
                         rng.nextBoolean(),
                         camionetaMotors[rng.nextInt(camionetaMotors.length)],
                         rng.nextInt(2)+1
                         );
    }

    public SUV generateSUV(Long id){
        return new SUV(id,
                         brands[rng.nextInt(brands.length)],
                         rng.nextInt(9) + 2015,
                         colors[rng.nextInt(colors.length)],
                         rng.nextInt(22000000) + 8000000,
                         rng.nextBoolean(),
                         suvMotors[rng.nextInt(suvMotors.length)],
                         rng.nextBoolean()
                         );
    }

    public Car generateCar(Long id){
        int type = rng.nextInt(3)+1;

        if (type == 1){
            return generateSedan(id);
        }else if(type == 2){
            return generateCamioneta(id);
        }else if(type == 3){
            return generateSUV(id);
        }else{
            return null;
        }
    }

    public List<Car> StringFiltro(){
        List<Car> cars = new ArrayList<Car>();

        return cars;
    }

    public List<Car> filtroTipo(List<Car> cars){

        return cars;
    }
    public List<Car> filtroPrecio(List<Car> cars){

        return cars;
    }
    public List<Car> filtroColor(List<Car> cars){


        return cars;
    }
  
}
