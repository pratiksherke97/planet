package com.micro.flat_planet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {

  private double x;
  private double y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

}
