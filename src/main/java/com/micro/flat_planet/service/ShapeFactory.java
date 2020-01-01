package com.micro.flat_planet.service;

import com.micro.flat_planet.model.ShapeType;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class ShapeFactory {

    private final ApplicationContext context;

    private final Map<ShapeType, ShapeService> factory;

  public ShapeFactory(ApplicationContext context, Map<ShapeType, ShapeService> factory) {
    this.context = context;
    this.factory = factory;
  }

  }