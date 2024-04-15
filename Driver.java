// Driver class for Grazioso Animal Intake program
// CS 499 - CS Capstone Enhancement project
// Benjamin Leanna
//
// 2024-03-29 Enhancements made are:
// 1)
// Error Handling: Robust error handling mechanisms have been implemented throughout the program, 
// aligning with the course objective of developing a security mindset and employing strategies for building collaborative environments. 
// By incorporating try-catch blocks to handle exceptions gracefully and providing informative error messages to the user, the program enhances its 
// reliability and usability. Additionally, logging has been incorporated using the Logger class to capture errors and events for later analysis. 
// This aligns with the objective of developing professional-quality communications by providing a record of program execution, aiding in debugging, 
// auditing processes, and tracking system behavior.
//
// 2)
// Logging: The program now logs events and errors to a file named "log.txt", which aligns with the course objective of developing 
// professional-quality communications and employing strategies for building collaborative environments. This logging functionality enhances 
// the program's reliability by providing a comprehensive record of program execution, aiding in debugging and auditing processes. It also facilitates 
// collaboration among developers by providing a centralized location for tracking system behavior and identifying potential issues.
// 
// 3)
// Sorting Functionality: A new feature has been added to allow sorting of animals by different criteria such as name, age, and acquisition date, 
// aligning with the course objective of designing and evaluating computing solutions using algorithmic principles and computer science practices. 
// By enhancing the usability of the program, users can now organize and view animal data in a structured manner, demonstrating proficiency in algorithmic 
// problem-solving and software design best practices. This feature contributes to the overall refinement of the artifact and enhances the user experience.

import java.util.ArrayList;
import java.util.Scanner;
// additional imports needed for enhancements
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.sql.*;
import java.util.List;

//Benjamin Leanna 2024-06-04
// Enhancement: took out in memory array/lists and putting directly into 
//              database.
//
public class Driver {
    // now connecting to database
    private static AnimalRepository animalRepository = new AnimalRepository();
    //additional functionality added for enhancements
    // need scanner for user input
    private static Scanner scanner = new Scanner(System.in);

    // THIS IS THE ORIGINAL MAIN FUCTION
    // 
    // public static void main(String[] args) {
    //     initializeDogList();
    //     initializeMonkeyList();
    //     //starting menu
    //     boolean acceptingInput = true;
    //     Scanner input = new Scanner(System.in);
    //     /**
    //      * @see public static void displayMenu() for order of cases
    //      */
    //     do {
    //         displayMenu();
    //         String option = input.nextLine().trim().toLowerCase(); //get everything in lowercase
    //         switch(option) {
    //             case "1":
    //                 intakeNewDog(input);
    //                 break;
    //             case "2":
    //                 intakeNewMonkey(input);
    //                 break;
    //             case "3":
    //                 reserveAnimal(input);
    //                 break;
    //             case "4":
    //                 printAnimals("dog");
    //                 break;
    //             case "5":
    //                 printAnimals("monkey");
    //                 break;
    //             case "6":
    //                 printAnimals("available");
    //                 break;
    //             case "q":
    //                 acceptingInput = false;
    //                 break;
    //             default:
    //                 System.out.println("Invalid option, try again.");
    //                 break;
    //         }
    //     } while(acceptingInput);

    //     System.out.println("Goodbye");
    // }

    // Enhanced main fuction
    public static void main(String[] args) {
        try {
            // configure file handler for logging
            FileHandler fh = new FileHandler("log.txt");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
 
            //initialize variable for accepting user's input
            boolean acceptingInput = true;

            // main loop to display menu and process user input
            do {
                displayMenu();
                String option = scanner.nextLine().trim().toLowerCase();
                AnimalRepository animalRepository = new AnimalRepository();

                switch (option) {
                    case "1":
                        intakeNewDog(scanner, animalRepository);
                        break;
                    case "2":
                        intakeNewMonkey(scanner, animalRepository);
                        break;
                    case "3":
                        reserveAnimal(scanner, animalRepository);
                        break;
                    case "4":
                        Driver.getAllDogs(animalRepository);
                        break;
                    case "5":
                        Driver.getAllMonkeys(animalRepository);
                        break;
                    case "6":
                        updateDog(scanner, animalRepository);
                        break;
                    case "7":
                        updateMonkey(scanner, animalRepository);
                        break;
                    case "8":
                        deleteDog(scanner, animalRepository);
                        break;
                    case "9":
                        deleteMonkey(scanner, animalRepository);
                        break;
                    case "10":
                        sortAnimals(scanner, animalRepository);
                        break;
                    case "q":
                        acceptingInput = false;
                        break;
                    default:
                        System.out.println("Invalid option, try again.");
                        break;
                }
            } while (acceptingInput);

            System.out.println("Goodbye");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void displayMenu() {
        System.out.println("Rescue Animal System Menu:");
        System.out.println("1) Intake a new dog.");
        System.out.println("2) Intake a new monkey.");
        System.out.println("3) Reserve an animal.");
        System.out.println("4) List all dogs.");
        System.out.println("5) List all monkeys.");
        System.out.println("6) Update a dog.");
        System.out.println("7) Update a monkey.");
        System.out.println("8) Delete a dog.");
        System.out.println("8) Delete a monkey.");
        System.out.println("10) Sort animals.");
        System.out.println("q) Quit.");
        System.out.println();
        System.out.println("Enter selection: ");
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner, AnimalRepository animalRepository) {
        //get info on dog
        System.out.println("What is the dog's name?");
        String name = Driver.scanner.nextLine().trim();

        System.out.println("What is " + name + "'s breed?");
        String breed = Driver.scanner.nextLine().trim();

        System.out.println("What is " + name + "'s gender? (male or female)");
        String gender = Driver.scanner.nextLine().trim().toLowerCase();

        System.out.println("What is " + name + "'s age?");
        int age = Integer.parseInt(Driver.scanner.nextLine().trim());

        System.out.println("What is " + name + "'s weight? (in pounds)");
        String weight = Driver.scanner.nextLine().trim();

        System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
        String acquisitionDate = Driver.scanner.nextLine().trim();

        System.out.println("Where was " + name + "'s acquired? (country)");
        String acquisitionLocation = Driver.scanner.nextLine().trim();

        System.out.println("What is " + name + "'s training status?");
        String trainingStatus = Driver.scanner.nextLine().trim();

        System.out.println("Is " + name + " reserved? (Y/N)");
        boolean reserved = Driver.scanner.nextLine().trim().equalsIgnoreCase("Y");

        System.out.println("What is " + name + "'s service country?");
        String inServiceLocation = Driver.scanner.nextLine().trim();

        System.out.println("Is " + name + " vaccinated? (Y/N)");
        boolean vaccinated = Driver.scanner.nextLine().trim().equalsIgnoreCase("Y");

        System.out.println("What is " + name + "'s temperament?");
        String temperament = Driver.scanner.nextLine().trim();

        System.out.println("Does " + name + " have any special needs?");
        String specialNeeds = Driver.scanner.nextLine().trim();

        // Provide default values for hold-related arguments
        boolean onHold = false;
        String holdPlacedBy = null;
        String holdPlacedDate = null;

        // Create a new Dog object
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus, reserved, inServiceLocation, vaccinated, temperament, specialNeeds);


        // Insert the new dog into the database
        animalRepository.createDog(newDog);
    }

    // Complete intakeNewMonkey
    // Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner, AnimalRepository animalRepository) {
        //get info on monkey's name
        System.out.println("What is the monkey's name?");
        String name = Driver.scanner.nextLine().trim();

        // Create a new Monkey object
        Monkey newMonkey;

        //checking to see if species type
        boolean invalidBreed = true;
        String breed;
        do {
            System.out.println("What is " + name + "'s breed?");
            breed = Driver.scanner.nextLine().trim();

            for(String validBreed : Monkey.MONKEY_BREEDS)
                if(breed.equalsIgnoreCase(validBreed))
                    invalidBreed = false;

            if(invalidBreed)
                System.out.println("Invalid breed option");
        } while(invalidBreed);

        //get info on monkey
        System.out.println("What is " + name + "'s gender? (male or female)");
        String gender = Driver.scanner.nextLine().trim().toLowerCase();

        System.out.println("What is " + name + "'s age?");
        int age = Integer.parseInt(Driver.scanner.nextLine().trim());

        System.out.println("What is " + name + "'s weight? (in pounds)");
        String weight = Driver.scanner.nextLine().trim();

        System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
        String acquisitionDate = Driver.scanner.nextLine().trim();

        System.out.println("Where was " + name + "'s acquired? (country)");
        String acquisitionLocation = Driver.scanner.nextLine().trim();

        System.out.println("What is " + name + "'s training status?");
        String trainingStatus = Driver.scanner.nextLine().trim();

        System.out.println("Is " + name + " reserved? (Y/N)");
        boolean reserved = Driver.scanner.nextLine().trim().equalsIgnoreCase("Y");

        System.out.println("What is " + name + "'s service country?");
        String inServiceLocation = Driver.scanner.nextLine().trim();

        System.out.println("Is " + name + " vaccinated? (Y/N)");
        boolean vaccinated = Driver.scanner.nextLine().trim().equalsIgnoreCase("Y");

        System.out.println("What is " + name + "'s temperament?");
        String temperament = Driver.scanner.nextLine().trim();

        System.out.println("Does " + name + " have any special needs?");
        String specialNeeds = Driver.scanner.nextLine().trim();

        // Provide default values for hold-related arguments
        boolean onHold = false;
        String holdPlacedBy = null;
        String holdPlacedDate = null;

        // Create a new Monkey object
        newMonkey = new Monkey(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus, reserved, inServiceLocation, vaccinated, temperament, specialNeeds);

        // Insert the new monkey into the database
        animalRepository.createMonkey(newMonkey);
    }

    //reserve the animal
    public static void reserveAnimal(Scanner scanner, AnimalRepository animalRepository) {
        System.out.println("What type of animal will be needed? (dog or monkey)");
        String animalType = Driver.scanner.nextLine().trim();

        System.out.println("Where will the animal be serving? (country)");
        String animalServiceCountry = Driver.scanner.nextLine().trim();

        // Check if the animal of the specified type and service country can be reserved
        boolean reserved = animalRepository.reserveAnimal(animalType, animalServiceCountry);

        if (reserved) {
            System.out.println("Animal reserved successfully.");
        } else {
            System.out.println("Unable to reserve the animal at this time.");
        }
    }

    public static void updateDog(Scanner scanner, AnimalRepository animalRepository) {
        // Get new information
        System.out.println("Enter the new name:");
        String animalName = scanner.nextLine().trim();
        System.out.println("Enter the new breed:");
        String newBreed = scanner.nextLine().trim();
        System.out.println("Enter the new gender:");
        String newGender = scanner.nextLine().trim();
        System.out.println("Enter the new age:");
        int newAge = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Enter the new weight:");
        String newWeight = scanner.nextLine().trim();
        System.out.println("Enter the new acquisition date:");
        String newAcquisitionDate = scanner.nextLine().trim();
        System.out.println("Enter the new acquisition location:");
        String newAcquisitionLocation = scanner.nextLine().trim();
        System.out.println("Enter the new training status:");
        String newTrainingStatus = scanner.nextLine().trim();
        System.out.println("Is the dog reserved? (true/false)");
        boolean newReserved = Boolean.parseBoolean(scanner.nextLine().trim());
        System.out.println("Enter the new service location:");
        String newServiceLocation = scanner.nextLine().trim();

        // Call update method
        animalRepository.updateDog(new Dog(animalName, newBreed, newGender, newAge, newWeight, newAcquisitionDate, newAcquisitionLocation, newTrainingStatus, newReserved, newServiceLocation, false, "", ""));
        System.out.println("Dog updated successfully.");
    }

    public static void updateMonkey(Scanner scanner, AnimalRepository animalRepository) {
        // Get new information
        System.out.println("Enter the new name:");
        String animalName = scanner.nextLine().trim();
        System.out.println("Enter the new breed:");
        String newBreed = scanner.nextLine().trim();
        System.out.println("Enter the new gender:");
        String newGender = scanner.nextLine().trim();
        System.out.println("Enter the new age:");
        int newAge = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Enter the new weight:");
        String newWeight = scanner.nextLine().trim();
        System.out.println("Enter the new acquisition date:");
        String newAcquisitionDate = scanner.nextLine().trim();
        System.out.println("Enter the new acquisition location:");
        String newAcquisitionLocation = scanner.nextLine().trim();
        System.out.println("Enter the new training status:");
        String newTrainingStatus = scanner.nextLine().trim();
        System.out.println("Is the monkey reserved? (true/false)");
        boolean newReserved = Boolean.parseBoolean(scanner.nextLine().trim());
        System.out.println("Enter the new service location:");
        String newServiceLocation = scanner.nextLine().trim();

        // Call update method
        animalRepository.updateMonkey(new Monkey(animalName, newBreed, newGender, newAge, newWeight, newAcquisitionDate, newAcquisitionLocation, newTrainingStatus, newReserved, newServiceLocation, false, "", ""));
        System.out.println("Monkey updated successfully.");
    }


    public static void deleteDog(Scanner scanner, AnimalRepository animalRepository) {
        System.out.println("Enter the name of the dog to delete:");
        String dogName = scanner.nextLine().trim();
        animalRepository.deleteDog(dogName);
        System.out.println("Dog deleted successfully.");
    }

    public static void deleteMonkey(Scanner scanner, AnimalRepository animalRepository) {
        System.out.println("Enter the name of the monkey to delete:");
        String monkeyName = scanner.nextLine().trim();
        animalRepository.deleteMonkey(monkeyName);
        System.out.println("Monkey deleted successfully.");
    }

    public static void getAllDogs(AnimalRepository animalRepository) {
        // Get all dogs from the database
        List<Dog> dogs = animalRepository.getAllDogs();
        // Print all dogs
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }

    public static void getAllMonkeys(AnimalRepository animalRepository) {
        // Get all monkeys from the database
        List<Monkey> monkeys = animalRepository.getAllMonkeys();
        // Print all monkeys
        for (Monkey monkey : monkeys) {
            System.out.println(monkey);
        }
    }
    
    ////////////////////////////////////////////////
    // Adding in SORTING MECHANISM for enhancment //
    // Added 2024-03-29 by Benjamin Leanna        //
    ////////////////////////////////////////////////
    // Changing SORTING MECHANISM for enhancment  //
    // on 2024-04-06 by Benjamin Leanna           //
    ////////////////////////////////////////////////
public static void sortAnimals(Scanner scanner, AnimalRepository animalRepository) {
    try {
        // Prompt user to select the sorting criteria
        System.out.println("Sort animals by:");
        System.out.println("1) Name");
        System.out.println("2) Age");
        System.out.println("3) Acquisition Date");
        System.out.println("Enter selection: ");
        // get user input
        String option = Driver.scanner.nextLine().trim();
        // sort based on criteria
        switch (option) {
            case "1":
                ResultSet dogsSortedByName = animalRepository.getAllDogsSortedBy("name");
                ResultSet monkeysSortedByName = animalRepository.getAllMonkeysSortedBy("name");
                // Print sorted results
                printSortedResults(dogsSortedByName, monkeysSortedByName);
                break;
            case "2":
                ResultSet dogsSortedByAge = animalRepository.getAllDogsSortedBy("age");
                ResultSet monkeysSortedByAge = animalRepository.getAllMonkeysSortedBy("age");
                // Print sorted results
                printSortedResults(dogsSortedByAge, monkeysSortedByAge);
                break;
            case "3":
                ResultSet dogsSortedByAcquisitionDate = animalRepository.getAllDogsSortedBy("acquisition_date");
                ResultSet monkeysSortedByAcquisitionDate = animalRepository.getAllMonkeysSortedBy("acquisition_date");
                // Print sorted results
                printSortedResults(dogsSortedByAcquisitionDate, monkeysSortedByAcquisitionDate);
                break;
            default:
                // handle invalid sorting options
                System.out.println("Invalid option.");
                System.out.println("Invalid sorting option selected.");
                return;
        }

        System.out.println("Animals sorted successfully.");
    } catch (SQLException e) {
        System.out.println("An error occurred while sorting animals: " + e.getMessage());
    }
}

// Method to print sorted results
private static void printSortedResults(ResultSet dogsResultSet, ResultSet monkeysResultSet) throws SQLException {
    System.out.println("Name\t\t| Breed\t\t| Gender\t| Age\t| Weight\t| Acquisition Date\t| Acquisition Country\t| Training Status\t| Reserved\t| In-Service Country");
    // Print sorted dogs
    while (dogsResultSet.next()) {
        System.out.println(dogsResultSet.getString("name") + "\t\t| " + dogsResultSet.getString("breed") + "\t\t| " + dogsResultSet.getString("gender") + "\t\t| "
                + dogsResultSet.getInt("age") + "\t| " + dogsResultSet.getDouble("weight") + "\t| " + dogsResultSet.getString("acquisition_date") + "\t| "
                + dogsResultSet.getString("acquisition_country") + "\t\t| " + dogsResultSet.getString("training_status") + "\t\t| "
                + dogsResultSet.getBoolean("reserved") + "\t\t| " + dogsResultSet.getString("in_service_country"));
    }
    // Print sorted monkeys
    while (monkeysResultSet.next()) {
        System.out.println(monkeysResultSet.getString("name") + "\t\t| " + monkeysResultSet.getString("breed") + "\t\t| " + monkeysResultSet.getString("gender") + "\t\t| "
                + monkeysResultSet.getInt("age") + "\t| " + monkeysResultSet.getDouble("weight") + "\t| " + monkeysResultSet.getString("acquisition_date") + "\t| "
                + monkeysResultSet.getString("acquisition_country") + "\t\t| " + monkeysResultSet.getString("training_status") + "\t\t| "
                + monkeysResultSet.getBoolean("reserved") + "\t\t| " + monkeysResultSet.getString("in_service_country"));
    }
}
}
