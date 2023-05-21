package com.isoft.apicar.controllers;

import java.util.List;
import java.util.ArrayList;

import com.isoft.apicar.models.Car;
import com.isoft.apicar.services.CarGenerator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * MainController
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080/")
public class MainController {

  private static CarGenerator gen = new CarGenerator();
  private List<Car> cars = new ArrayList<Car>();


  @RequestMapping("/generate")
  @ResponseBody
  public List<Car> listCars(@RequestParam("quantity") int quantity){
    cars = new ArrayList<Car>();

    for(int i = 1; i<=quantity; i++){
      cars.add(gen.generateCar((long)i));
    }
    return cars;
  }

  @RequestMapping("/list")
  @ResponseBody
  public List<Car> filtredCars(@RequestParam("color") String color,@RequestParam("type") String type,@RequestParam("price") double price){
   
    return gen.filtradoCar(cars,color , type, price);
  }
  

  
}
