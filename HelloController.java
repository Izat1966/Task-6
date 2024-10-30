package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField WeightInput;

    @FXML
    private TextField HeightInput;

    @FXML
    private Label bmiResultLabel;

    @FXML
    private Label bmiStatus;

    @FXML
    protected void onCalculateBMI() {
        try {
            double weight = Double.parseDouble(WeightInput.getText());
            double height = Double.parseDouble(HeightInput.getText());
            double bmi = weight / (height * height) * 10000;
            bmiResultLabel.setText(String.format("BMI:%2f", bmi));
            String status = getBMIStatus(bmi);
            bmiStatus.setText("Status:" + status);
        } catch (NumberFormatException e) {
            bmiResultLabel.setText("Invalid input");
        }
    }

    private String getBMIStatus(double BMI) {
        if (BMI < 18.5) {
            return "Underweight";
        } else if (BMI >= 18.5 && BMI < 24.9) {
            return "Normal";
        } else if (BMI >= 25 && BMI < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    @FXML
    protected void onClearFields() {
        WeightInput.clear();
        HeightInput.clear();
        bmiResultLabel.setText("BMI: ");
        bmiStatus.setText("Status: ");
    }
}
