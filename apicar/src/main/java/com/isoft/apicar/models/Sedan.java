package com.isoft.apicar.models;

/**
 * Sedan
 */
public class Sedan extends Car{

  public Sedan(Long id, String brand, int year, String color, double price, boolean turbo, String motor){
    super(id, brand, year, color, price, turbo, "Sedan", motor);
  }

}
