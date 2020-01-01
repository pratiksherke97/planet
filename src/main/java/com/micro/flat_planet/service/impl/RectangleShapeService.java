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

  @Override
  public Set<Set<Point>> getShapeCount(List<Point> points) {
    return  Sets.combinations(Sets.newHashSet(points), 4).stream()
        .filter(this::isRectangle).collect(Collectors.toSet());
  }

  @Override
  public boolean checkCoordinateCount(List<Point> points) {
    return false;
  }

  @Override
  public ShapeResponse getCountAndPointsForShape(List<Point> points) {

    final Set<Set<Point>> shapeCount = getShapeCount(points);
    final long count = shapeCount.stream().count();
    return ShapeResponse.builder().count(count).points(shapeCount).build();
  }

  private boolean isRectangle(Set<Point> points) {

    final double centerX = points.stream().mapToDouble(Point::getX).sum() / 4.0;
    final double centerY = points.stream().mapToDouble(Point::getY).sum() / 4.0;

    return points.stream().map(point -> calculateDistance(centerX, centerY, point))
        .distinct().count() == 1;

  }

  private static double calculateDistance(double centreX, double centreY, Point point) {
    return Math.sqrt(Math.pow((point.getY() - centreY), 2) + Math.pow((point.getX() - centreX), 2));
  }
}
