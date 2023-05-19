package com.isoft.apicar.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Car
 */
@Setter @Getter
public class Car {

  private Long id;
  private String brand;
  private int year;
  private String color;
  private double price;
  private boolean turbo;
  private String type;
  private String motor;
  private int popularity;

  public Car(Long id, String brand, int year, String color, double price, boolean turbo, String type, String motor){
    this.id = id;
    this.brand = brand;
    this.year = year;
    this.color = color;
    this.price = price;
    this.turbo = turbo;
    this.type = type;
    this.motor = motor;
    this.popularity = 0;
  }
}
