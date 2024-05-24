package com.gnineieceng.controller;

import com.gnineieceng.model.InventorEaseModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InventorEaseController {

    @FXML
    private TextField unitCostField;
    @FXML
    private TextField orderingCostField;
    @FXML
    private TextField penaltyCostField;
    @FXML
    private TextField interestRateField;
    @FXML
    private TextField leadTimeField;
    @FXML
    private TextField leadTimeDemandField;
    @FXML
    private TextField leadTimeStandardDeviationField;
    @FXML
    private TextArea outputArea;

    // Method to handle the calculate button action
    public void onCalculateButtonClick() {
        double unitCost = Double.parseDouble(unitCostField.getText());
        double orderingCost = Double.parseDouble(orderingCostField.getText());
        double penaltyCost = Double.parseDouble(penaltyCostField.getText());
        double interestRate = Double.parseDouble(interestRateField.getText());
        double leadTime = Double.parseDouble(leadTimeField.getText());
        double leadTimeDemand = Double.parseDouble(leadTimeDemandField.getText());
        double leadTimeStandardDeviation = Double.parseDouble(leadTimeStandardDeviationField.getText());

        // Create an inventory object
        InventorEaseModel inventory = new InventorEaseModel(unitCost, orderingCost, penaltyCost, interestRate, leadTime, leadTimeDemand, leadTimeStandardDeviation);

        // Perform the calculations based on the provided pseudo code
        inventory.calculate();

        // Update the UI with the results
        outputArea.setText(inventory.outcomesToString());
    }

    @FXML
    private void initialize() {
        // Initialization logic (if needed)
        // For example, setting default values or configurations
    }
}

