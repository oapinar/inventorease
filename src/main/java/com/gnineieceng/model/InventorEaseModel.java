package com.gnineieceng.model;


public class InventorEaseModel {

    // INPUTS
    private double unitCost;
    private double orderingCost;
    private double penaltyCost;
    private double interestRate;
    private double leadTime;
    private double leadTimeDemand;
    private double leadTimeStandardDeviation;

    // TO CALCULATE

    private double holdingCost = 0;
    private double annualDemand = 1;
    private double optimalLotSize = 2;
    private double reorderPoint = 3;
    private int numberOfIterationsToFindOptimals = 4;
    private double safetyStock = 5;
    private double averageAnnualHoldingCost = 6;
    private double averageSetupCost = 7;
    private double averagePenaltyCost = 8; // Safety stock, average annual holding, setup, and penalty costs. -- Average or not???
    private int averageTimeBetweenOrderPlacements = 9; // Days? Hours?
    private double pOOCWS = 10; // The proportion of order cycles without stockouts
    private double pOUD = 11; //The proportion of unmet demands


    public InventorEaseModel(double unitCost, double orderingCost, double penaltyCost, double interestRate, double leadTime, double leadTimeDemand, double leadTimeStandardDeviation) {
        this.unitCost = unitCost;
        this.orderingCost = orderingCost;
        this.penaltyCost = penaltyCost;
        this.interestRate = interestRate;
        this.leadTime = leadTime;
        this.leadTimeDemand = leadTimeDemand;
        this.leadTimeStandardDeviation = leadTimeStandardDeviation;
    }

    //Method to calculate holding cost

    public void calculateHoldingCost() {
        this.holdingCost = holdingCost;
    }

    //Method to calculate annual demand

    public void calculateAnnualDemand() {
        this.annualDemand = annualDemand;
    }

    //Method to calculate optimal lot size

    public void calculateOptimalLotSize() {
        this.optimalLotSize = optimalLotSize;
    }

    //Method to calculate reorderPoint

    public void calculateReorderPoint() {
        this.reorderPoint = reorderPoint;
    }

    //Method to calculate Number Of Iterations To Find Optimals

    public void calculateNumberOfIterationsToFindOptimals() {
        this.numberOfIterationsToFindOptimals = numberOfIterationsToFindOptimals;
    }

    //Method to calculate safety stock
    public void calculateSafetyStock() {
        this.safetyStock = safetyStock;
    }

    //Method to calculate average annual holding cost
    public void calculateAverageAnnualHoldingCost() {
        this.averageAnnualHoldingCost = averageAnnualHoldingCost;
    }

    //Method to calculate average setup cost

    public void calculateAverageSetupCost() {
        this.averageSetupCost = averageSetupCost;
    }

    //Method to calculate average penalty cost

    public void calculateAveragePenaltyCost() {
        this.averagePenaltyCost = averagePenaltyCost;
    }

    //Method to calculate average Time Between Order Placements

    public void calculateAverageTimeBetweenOrderPlacements() {
        this.averageTimeBetweenOrderPlacements = averageTimeBetweenOrderPlacements;
    }

    //Method to calculate The proportion of order cycles without stockouts

    public void calculatePOOCWS() {
        this.pOOCWS = pOOCWS;
    }

    //Method to calculate The proportion of unmet demands

    public void calculatePOUD() {
        this.pOUD = pOUD;
    }

    public String outcomesToString() {
        return "Optimal Lot Size: " + optimalLotSize + "\nReorder Point: " + reorderPoint + "\nNumber of Iterations Needed to Find the Optimal Values: " + numberOfIterationsToFindOptimals + "\nSafety Stock: " + safetyStock + "\nAverage Annual Holding Cost: " + averageAnnualHoldingCost + "\nAverage Setup Cost: " + averageSetupCost + "\nAverage Penalty Cost: " + averagePenaltyCost + "\nAverage Time Between Order Placements: " + averageTimeBetweenOrderPlacements + "\nProportion of Order Cycles Without Stockouts: " + pOOCWS + "\nProportion of Unmet Demands" + pOUD;
    }
}