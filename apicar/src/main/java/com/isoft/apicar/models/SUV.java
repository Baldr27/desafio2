package com.isoft.apicar.models;

import lombok.Getter;
import lombok.Setter;

/**
 * SUV
 */
@Getter @Setter
public class SUV extends Car{

  private boolean sunroof;

  public SUV(Long id, String brand, int year, String color, double price, boolean turbo, String motor, boolean sunroof){
    super(id, brand, year, color, price, turbo, "SUV", motor);
    this.sunroof = sunroof;
  }

}
