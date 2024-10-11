package com.cgvsu.rasterizationfxapp;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

import java.util.Random;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        Rasterization.fillTriangle(canvas.getGraphicsContext2D(),
                new int[]{10, 50, 10},
                new int[]{10, 10, 50},
                new Color[]{Color.BLACK, new Color(0.96, 0.5, 0, 1), Color.BLUE});
        Rasterization.fillTriangle(canvas.getGraphicsContext2D(),
                new int[]{790, 790, 700},
                new int[]{600, 500, 600},
                new Color[]{Color.BLACK, new Color(0.96, 0.5, 0, 1), Color.BLUE});
        Rasterization.fillTriangle(canvas.getGraphicsContext2D(),
                new int[]{10, 10, 60},
                new int[]{550, 600, 600},
                new Color[]{Color.BLACK, new Color(0.96, 0.5, 0, 1), Color.BLUE});
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                Rasterization.fillTriangle(canvas.getGraphicsContext2D(),
                        new int[]{10, 50, 10},
                        new int[]{10, 10, 50},
                        new Color[]{Color.BLACK, new Color(0.96, 0.5, 0, 1), Color.BLUE});
                Rasterization.fillTriangle(canvas.getGraphicsContext2D(),
                        new int[]{790, 790, 700},
                        new int[]{600, 500, 600},
                        new Color[]{Color.BLACK, new Color(0.96, 0.5, 0, 1), Color.BLUE});
                Rasterization.fillTriangle(canvas.getGraphicsContext2D(),
                        new int[]{10, 10, 60},
                        new int[]{550, 600, 600},
                        new Color[]{Color.BLACK, new Color(0.96, 0.5, 0, 1), Color.BLUE});

                Rasterization.fillTriangle(canvas.getGraphicsContext2D(),
                        new int[]{200, 500, (int)mouseEvent.getX()},
                        new int[]{300, 300, (int)mouseEvent.getY()},
                        new Color[]{Color.RED, Color.GREEN, Color.BLUE});
            }
        });


    }

}