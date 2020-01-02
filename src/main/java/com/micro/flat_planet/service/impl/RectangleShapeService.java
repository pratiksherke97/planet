package com.micro.flat_planet.service.impl;

import com.google.common.collect.Sets;
import com.micro.flat_planet.model.Point;
import com.micro.flat_planet.model.ShapeResponse;
import com.micro.flat_planet.service.ShapeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RectangleShapeService implements ShapeService {

  private static final int RECTANGLE_VERTICES = 4;

  @Override
  public Set<Set<Point>> getShapeFromPoints(List<Point> points) {

    return Sets.combinations(Sets.newHashSet(points), 4).stream()
        .filter(RectangleShapeService::isRectangle).collect(Collectors.toSet());
  }

  @Override
  public boolean checkCoordinateCount(List<Point> points) {

    return points.size() >= RECTANGLE_VERTICES;

  }

  @Override
  public ShapeResponse getCountAndPointsForShape(List<Point> points) {

    if(!checkCoordinateCount(points)){
      throw new RuntimeException("Points provided are not sufficient to form a rectangle");
    }

    final Set<Set<Point>> shapeCount = getShapeFromPoints(points);
    final int count = shapeCount.size();

    return ShapeResponse.builder().count(count).points(shapeCount).build();
  }

  private static boolean isRectangle(Set<Point> points) {

    final double centerX = points.stream().mapToDouble(Point::getX).sum() / RECTANGLE_VERTICES;
    final double centerY = points.stream().mapToDouble(Point::getY).sum() / RECTANGLE_VERTICES;

    return points.stream().map(point -> calculateDistance(centerX, centerY, point))
        .distinct().count() == 1;

  }

  private static double calculateDistance(double centreX, double centreY, Point point) {
    return Math.sqrt(Math.pow((point.getY() - centreY), 2) + Math.pow((point.getX() - centreX), 2));
  }
}
