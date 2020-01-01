package com.micro.flat_planet.controller;

import com.micro.flat_planet.model.Point;
import com.micro.flat_planet.model.ShapeResponse;
import com.micro.flat_planet.service.impl.RectangleShapeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ShapeController {

  @Autowired
  private RectangleShapeService rectangleShapeService;

  @Autowired
  private ApplicationContext context;

  @PostMapping(path = "/planet/{shape}")
  public ResponseEntity<ShapeResponse> postShapeCoordinates(@PathVariable String shape, @RequestBody List<Point> request) {
    log.info("shape :: {}, points :: {}", shape, request);

    return ResponseEntity.ok(rectangleShapeService.getCountAndPointsForShape(request));

  }

}
