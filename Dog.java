// Enhancements added March 24th 2024                                                                  //
// Benjamin Leanna 499 - CS Capstone                                                                   //
// SNHU                                                                                                //
// 2024-03-24 additional attributes added, setter methods to enhance validation logic for input data   //
// and a method to calculate the dogs age.                                                             //
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Cleaned up messy code on 2024-04-06 (ben leanna)
// 
//

import java.util.logging.Level;
import java.util.logging.Logger;

public class Dog extends RescueAnimal {

    // New variables specific to Dog
    private static final String[] DOG_BREEDS = {"Labrador Retriever", "German Shepherd", "Golden Retriever", "Bulldog", "Beagle"};
    // Instance variables for holding information about hold status
    private boolean onHold;
    private String holdPlacedBy;
    private String holdPlacedDate;
    private String breed;

    public Dog(String name, String breed, String gender, int age, String weight,
               String acquisitionDate, String acquisitionLocation, String trainingStatus,
               boolean reserved, String inServiceLocation, boolean vaccinated,
               String temperament, String specialNeeds) {
        super(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation,
                trainingStatus, reserved, inServiceLocation, vaccinated, temperament, specialNeeds);
    }

    public String getBreed() {
        return breed;
    }
    // Getter and Setter for Dog specific attributes

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

    public String[] getDogBreeds() {
        return DOG_BREEDS;
    }

    // Method to validate Dog breed
    public boolean isValidDogBreed(String breed) {
        for (String validBreed : DOG_BREEDS) {
            if (validBreed.equalsIgnoreCase(breed)) {
                return true;
            }
        }
        return false;
    }
}
