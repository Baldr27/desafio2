package com.isoft.apicar.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Camioneta
 */
@Setter @Getter
public class Camioneta extends Car{

  private int cabinas;

  public Camioneta(Long id, String brand, int year, String color, double price, boolean turbo, String motor, int cabinas){
    super(id, brand, year, color, price, turbo, "Camioneta", motor);
    this.cabinas = cabinas;
  }
  public String getNombre(){
    return this.getNombre();
  }

  public String getType(){
    return this.getType();
  }
  public double getPrice(){
    return this.getPrice();
  }
}
