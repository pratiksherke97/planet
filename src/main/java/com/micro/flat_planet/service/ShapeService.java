package com.micro.flat_planet.service;

import com.micro.flat_planet.model.Point;
import com.micro.flat_planet.model.ShapeResponse;

import java.util.List;
import java.util.Set;

public interface ShapeService {

  Set<Set<Point>> getShapeCount(List<Point> points);

  boolean checkCoordinateCount(List<Point> points);

  ShapeResponse getCountAndPointsForShape(List<Point> points);

}
