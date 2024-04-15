// Enhancements added March 24th 2024
// Benjamin Leanna 499 - CS Capstone
// SNHU
// Enhancements added 2024-03-24 to add new attribues
// modified the constructor to include new parameters and call the superclass
// and implemented getter and setter methods for the new attribues.
//
// Cleaned up messy code on 2024-04-06 (ben leanna)
// 
//

import java.util.logging.Level;
import java.util.logging.Logger;

public class Monkey extends RescueAnimal {
    // List of valid monkey breeds
    public static final String[] MONKEY_BREEDS = {"Marmoset", "Macaque", "Tamarin"};
    // Instance variables for holding information about hold status
    private boolean onHold;
    private String holdPlacedBy;
    private String holdPlacedDate;
    private String breed;
    
    // Constructor
    public Monkey(String name, String animalType, String gender, int age, String weight,
           String acquisitionDate, String acquisitionLocation, String trainingStatus,
           boolean reserved, String inServiceLocation, boolean vaccinated,
           String temperament, String specialNeeds) {
        super(name, animalType, gender, age, weight, acquisitionDate, acquisitionLocation,
              trainingStatus, reserved, inServiceLocation, vaccinated, temperament, specialNeeds);
    }
    public String getBreed() {
        return breed;
    }
    // Getter and Setter for Monkey specific attributes

    public boolean isOnHold() {
        return onHold;
    }

    public void setOnHold(boolean onHold) {
        this.onHold = onHold;
    }

    public String getHoldPlacedBy() {
        return holdPlacedBy;
    }

    public void setHoldPlacedBy(String holdPlacedBy) {
        this.holdPlacedBy = holdPlacedBy;
    }

    public String getHoldPlacedDate() {
        return holdPlacedDate;
    }

    public void setHoldPlacedDate(String holdPlacedDate) {
        this.holdPlacedDate = holdPlacedDate;
    }

    // Method to validate Monkey breed
    private boolean isValidMonkeyBreed(String breed) {
        for (String validBreed : MONKEY_BREEDS) {
            if (validBreed.equalsIgnoreCase(breed)) {
                return true;
            }
        }
        return false;
    }
}