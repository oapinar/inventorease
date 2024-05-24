package com.gnineieceng.model;

import com.gnineieceng.model.ZChartTableLookUp.ZEntry;

public class InventorEaseModel {

    // INPUTS
    private double unitCost;
    private double orderingCost; //setup cost
    private double penaltyCost; //stockout cost
    private double interestRate;
    private double leadTime;    //IN MONTHS
    private double leadTimeDemand; //Selling average
    private double leadTimeStandardDeviation;


    public InventorEaseModel(double unitCost, double orderingCost, double penaltyCost, double interestRate, double leadTime, double leadTimeDemand, double leadTimeStandardDeviation) {
        this.unitCost = unitCost; 
        this.orderingCost = orderingCost;
        this.penaltyCost = penaltyCost;
        this.interestRate = interestRate; 
        this.leadTime = leadTime; 
        this.leadTimeDemand = leadTimeDemand;
        this.leadTimeStandardDeviation = leadTimeStandardDeviation;
    }

    public String calculate() {
        // Input values
        double c = unitCost;
        double t = leadTime;
        double interest = interestRate;
        double p = penaltyCost;
        double k = orderingCost;
        double sellAvg = leadTimeDemand;
        double demDev = leadTimeStandardDeviation;
        
        double[] Q = new double[2];
        double[] FR = new double[2];
        double[] R = new double[2];

        // Calculations
        double h = interest * c;
        double annDem = sellAvg * (12 / t);
        Q[0] = Math.sqrt(2 * k * annDem / h);
        Q[1] = Q[0];
        R[0] = 0;
        R[1] = 1;

        double n_R = 0, L_Z, Z;

        ZChartTableLookUp lookup = new ZChartTableLookUp();
        lookup.initializeZTable();

        while (Math.abs(R[1] - R[0]) > 0.001)  {
            //Move previous values
            FR[0] = FR[1];
            R[0] = R[1];
            Q[0] = Q[1];

            FR[1] = 1 - ((Q[1] * h) / (p * annDem));

            ZEntry zEnt = lookup.findClosestZFromFZ(FR[1]);
            Z = zEnt.z; 
            R[1] = sellAvg + demDev * Z;
            L_Z = zEnt.lZ; 
            n_R = demDev * L_Z;
            Q[1] = Math.sqrt(2 * annDem * ((k + p * n_R) / h));
        } 
    
        // Final values
        double safetyStock = R[1] - sellAvg;
        double holdCost = h * (Q[1] / 2 + R[1] - sellAvg);
        double orderCost = k * annDem / Q[1];
        double penaltyCost = p * annDem * n_R / Q[1];
        double avgTimeBetweenOrders = Q[1] / annDem;
        double notMetDemands = n_R / Q[1];

        // Output
        return String.format("Optimal Values:"
        +"\nSafety Stock: %s"
        +"\nHolding Cost: %s"
        +"\nOrdering Cost: %s"
        +"\nPenalty Cost: %s"
        +"\nAverage Time Between Orders: %s"
        +"\nProportion of Demands Not Met: %s", safetyStock, holdCost, orderCost, penaltyCost, avgTimeBetweenOrders, notMetDemands);
    }

    public String outcomesToString() {

        return calculate();

    }
}