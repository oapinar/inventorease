package com.gnineieceng.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class ZChartTableLookUp {

    public class ZEntry {
        public double z;
        public double fZ;
        public double lZ;

        public ZEntry(double z, double fZ, double lZ) {
            this.z = z;
            this.fZ = fZ;
            this.lZ = lZ;
        }
    }
    private TreeMap<Double, ZEntry> zMap = new TreeMap<>();

    public void initializeZTable() {
        //loadZTableFromFile("com/gnineieceng/model/zchart.csv");
        loadZTableFromFile("C:\\Users\\clour\\OneDrive\\Desktop\\uni sources\\3 Prog\\New folder\\inventorease\\src\\main\\java\\com\\gnineieceng\\model\\zchart.csv");
    }
    private void loadZTableFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                scanner.nextLine(); //Skip header line
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                double z = Double.parseDouble(values[0].replace(",", "."));
                double fZ = Double.parseDouble(values[1].replace(",", "."));
                double lZ = Double.parseDouble(values[2].replace(",", "."));

                zMap.put(z, new ZEntry(z, fZ, lZ));
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured while reading file.");
            e.printStackTrace();
        }
    }

    public ZEntry findClosestZ(double targetZ) {
        if(zMap.containsKey(targetZ)) {
            return zMap.get(targetZ);
        } else {
            double lowerDiff = Math.abs(zMap.floorKey(targetZ) - targetZ);
            double higherDiff = Math.abs(zMap.higherKey(targetZ) - targetZ);
            return zMap.get(lowerDiff < higherDiff ? zMap.floorKey(targetZ): zMap.higherKey(targetZ));
        }
    }

    public ZEntry findClosestZFromFZ(double fZ) {
        double z = -3;
        double fz;
        ZEntry zEnt;


        do {
            zEnt = findClosestZ(z);
            fz = zEnt.fZ;
            z += 0.03;
        } while (fz < fZ && z <= 3);

        return zEnt;
    }

    public static void main(String[] args) {
        ZChartTableLookUp test = new ZChartTableLookUp();
        test.initializeZTable();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter fz value: ");
        Double z = myObj.nextDouble();
        ZEntry ent = test.findClosestZFromFZ(z);
        System.out.println("Z:    " + ent.z + "\nF(Z): " + ent.fZ + "\nL(Z): " + ent.lZ);
    }
}
