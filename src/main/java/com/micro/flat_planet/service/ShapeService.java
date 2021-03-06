package com.micro.flat_planet.service;

import com.micro.flat_planet.model.Point;
import com.micro.flat_planet.model.ShapeResponse;

import java.util.List;
import java.util.Set;

public interface ShapeService {

  Set<Set<Point>> getShapeFromPoints(List<Point> points);

  boolean checkSufficientNumberOfPoints(List<Point> points);

  ShapeResponse getCountAndPointsForShape(List<Point> points);

}
