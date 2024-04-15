// Enhancements added March 24th 2024
// Benjamin Leanna 499 - CS Capstone
// SNHU
// Enhancements added 2024-03-24 to add new attribues to provide additional information on each anmial
// modified the constructor to include the new parameters for the new attribues
// implemented getter and setter methods for new attribues (allows access and modifications)
// added in the logger object to enable logging of events or errors in the class
// added the logEvent method to facilitate logging

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RescueAnimal {

    // Instance variables
    private String name;
    private String animalType;
    private String gender;
    private int age; // Changed to int
    private String weight;
    private String acquisitionDate;
    private String acquisitionLocation;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceLocation;
    // New variables for enhancements
    private boolean vaccinated;
    private String temperament;
    private String specialNeeds;

    // Empty Constructor
    public RescueAnimal() {
    }

    // Constructor with enhancements
    public RescueAnimal(String name, String animalType, String gender, int age, String weight,
                        String acquisitionDate, String acquisitionLocation,
                        String trainingStatus, boolean reserved, String inServiceLocation,
                        boolean vaccinated, String temperament, String specialNeeds) {
        this.name = name;
        this.animalType = animalType;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.acquisitionDate = acquisitionDate;
        this.acquisitionLocation = acquisitionLocation;
        this.trainingStatus = trainingStatus;
        this.reserved = reserved;
        this.inServiceLocation = inServiceLocation;
        this.vaccinated = vaccinated;
        this.temperament = temperament;
        this.specialNeeds = specialNeeds;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() { // Changed return type to int
        return age;
    }

    public void setAge(int age) { // Changed parameter type to int
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getAcquisitionLocation() {
        return acquisitionLocation;
    }

    public void setAcquisitionLocation(String acquisitionLocation) {
        this.acquisitionLocation = acquisitionLocation;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public boolean isReserved() { // Changed method name to follow Java convention
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getInServiceLocation() {
        return inServiceLocation;
    }

    public void setInServiceLocation(String inServiceLocation) {
        this.inServiceLocation = inServiceLocation;
    }

    public boolean isVaccinated() { // Changed method name to follow Java convention
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }
}
