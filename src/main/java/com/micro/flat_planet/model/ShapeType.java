package com.micro.flat_planet.model;

public enum ShapeType {

  RECTANGLE("rectangle");

  private final String value;

  ShapeType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
