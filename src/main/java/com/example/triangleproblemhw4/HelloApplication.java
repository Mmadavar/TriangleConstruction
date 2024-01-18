package com.example.triangleproblemhw4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();
        TextField orderField = new TextField();
        orderField.setOnAction(e -> {
            pane.getChildren().clear(); // Clear previous triangles
            pane.getChildren().add(orderField); // Re-add the text field
            int order = Integer.parseInt(orderField.getText());
            pane.getChildren().add(drawTriangle(order, 400, 20, 20, 380, 780, 380));
        });

        orderField.setTranslateX(20); // Position the text field
        orderField.setTranslateY(380);
        pane.getChildren().add(orderField);

        Scene scene = new Scene(pane, 800, 400);
        stage.setTitle("Sierpinski Triangle");
        stage.setScene(scene);
        stage.show();
    }

    private Pane drawTriangle(int order, double x1, double y1, double x2, double y2, double x3, double y3) {
        Pane pane = new Pane();
        if (order == 0) {
            Polygon triangle = new Polygon();
            triangle.getPoints().addAll(x1, y1, x2, y2, x3, y3);
            triangle.setStroke(Color.BLACK);
            triangle.setFill(Color.TRANSPARENT);
            pane.getChildren().add(triangle);
        } else {
            double midpointX1 = (x1 + x2) / 2;
            double midpointY1 = (y1 + y2) / 2;
            double midpointX2 = (x2 + x3) / 2;
            double midpointY2 = (y2 + y3) / 2;
            double midpointX3 = (x1 + x3) / 2;
            double midpointY3 = (y1 + y3) / 2;

            pane.getChildren().add(drawTriangle(order - 1, x1, y1, midpointX1, midpointY1, midpointX3, midpointY3));
            pane.getChildren().add(drawTriangle(order - 1, midpointX1, midpointY1, x2, y2, midpointX2, midpointY2));
            pane.getChildren().add(drawTriangle(order - 1, midpointX3, midpointY3, x3, y3, midpointX2, midpointY2));
        }
        return pane;
    }


    public static void main(String[] args) {

        launch();
    }
}