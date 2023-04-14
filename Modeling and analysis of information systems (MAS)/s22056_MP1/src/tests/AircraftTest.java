package tests;

import elements.Aircraft;
import elements.License;

import java.io.*;
import java.time.LocalDate;

public class AircraftTest {

    public static void main(String[] args) {
        License license1 = new License("FAA", 31963000, "Federal authority approval", LocalDate.of(2023, 12, 31));
        License license2 = new License("ACME Inc.", 31961800, "Professional Nuclear Bomb carriage license", LocalDate.of(2022, 6, 30));
        License license3 = new License("Secret Moon base authority", 31961871, "Certification and Access", LocalDate.of(2074, 9, 30));

        Aircraft aircraft1 = new Aircraft(100, license1);
        Aircraft aircraft2 = new Aircraft(200, license2);
        Aircraft aircraft3 = new Aircraft(300, license3);

        aircraft1.addCrew("Pop Smoke", "Pilot", 80);
        aircraft1.addCrew("Bubbles Bubbles", "Flight Attendant", 60);

        aircraft2.addCrew("Garry Jerry", "Pilot", 85);
        aircraft2.addCrew("Mary Jane", "Flight Attendant", 65);

        aircraft3.addCrew("Don Tom", "Pilot", 90);
        aircraft3.addCrew("Walter White", "Flight Attendant", 70);

        System.out.println(aircraft1);
        System.out.println(aircraft2);
        System.out.println(aircraft3);

        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("aircrafts.dat"))) {
            Aircraft.save(stream);
            System.out.println("Aircrafts saved to file");
        } catch (IOException e) {
            System.out.println("Error saving aircrafts to file: " + e.getMessage());
        }

        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("aircrafts.dat"))) {
            Aircraft.load(stream);
            System.out.println("Aircrafts loaded from file");
            System.out.println("Aircrafts extent: " + Aircraft.getSize());
            for (Aircraft aircraft : Aircraft.getExtent()) {
                System.out.println(aircraft);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading aircrafts from file: " + e.getMessage());
        }
    }
}
