package com.isoft.apicar.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

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

  List<Car> cars = new ArrayList<Car>();
  private static CarGenerator gen = new CarGenerator();

  @RequestMapping("/generate")
  @ResponseBody
  public List<Car> generateCars(@RequestParam("quantity") int quantity){
    cars = new ArrayList<Car>();

    for(int i = 1; i<=quantity; i++){
      cars.add(gen.generateCar((long)i));
    }
    return cars;
  }

  @RequestMapping("/list")
  @ResponseBody
  public List<Car> listCars(@RequestParam(required = false) Double price, @RequestParam(required = false) String type, @RequestParam(required = false) String color){
    List<Car> filteredCars = cars;
    if(price!=null){
      filteredCars = filteredCars.stream()
        .filter(c -> c.getPrice() <= price).collect(Collectors.toList());
    }
    if(type!=null){
      filteredCars = filteredCars.stream()
        .filter(c -> c.getType().equals(type)).collect(Collectors.toList());
    }
    if(color!=null){
      filteredCars = filteredCars.stream()
        .filter(c -> c.getColor().equals(color)).collect(Collectors.toList());
    }

    return filteredCars;
  }
  
}

