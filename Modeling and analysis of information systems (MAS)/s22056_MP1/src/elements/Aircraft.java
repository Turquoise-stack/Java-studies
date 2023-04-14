package elements;

import java.io.*;
import java.util.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aircraft implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final List<Aircraft> extent = new ArrayList<>();
    private static final double AVERAGE_FUEL_COEFFICIENT = 7.5; // Km per Liter
    private double fuelTank;
    private License license;
    private List<String> crew = new ArrayList<>();

    public Aircraft(double fuelTank, License license) {
        this.fuelTank = fuelTank;
        this.license = license;
        extent.add(this);
    }

    public double getRange(double fuelType) {
        return fuelType * fuelTank;
    }

    public double getRange() {
        return AVERAGE_FUEL_COEFFICIENT * fuelTank;
    }

    public static int getSize() {
        return extent.size();
    }

    @Override
    public String toString() {
        return "Aircraft{ " +
                "tank volume: " + this.fuelTank +
                ", license: " + this.license.toString() +
                ", crew: " + this.crew +
                " }";
    }

    public void addCrew(String name, String specialty, double kilos) {
        String person = String.format("%s (%s, %.2f kg)", name, specialty, kilos);
        crew.add(person);
    }

    public static List<Aircraft> getExtent() {
        return new ArrayList<>(extent);
    }

    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        Object obj = stream.readObject();
        if (obj instanceof List<?>) {
            extent.clear();
            extent.addAll((List<Aircraft>) obj);
        } else {
            throw new ClassNotFoundException("Invalid object type");
        }
    }

}


