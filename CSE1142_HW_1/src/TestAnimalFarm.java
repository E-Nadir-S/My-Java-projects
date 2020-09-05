import java.util.Scanner;

public class TestAnimalFarm {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome To Animal Farm Simulation Program!");

        System.out.print("Please enter the capacity of the animal farm: ");
        int capacity = input.nextInt();

        AnimalFarm farmOfEnes = new AnimalFarm(capacity);

        while (true) {
            int choice;

            System.out.println(
                    "0 - Exit the program\n" +
                    "1 - Add animal\n" +
                    "2 - Remove animal\n" +
                    "3 - Search animal\n" +
                    "4 - Sort animals\n" +
                    "5 - Calculate next year's population estimate\n" +
                    "6 - Print all animal's movements\n" +
                    "7 - Print all animal's eating habits\n" +
                    "8 - Print report");
            System.out.print("Please Enter Your Choice: ");
            choice = input.nextInt();

            if (choice == 0){
                System.out.println("Simulation is closing...");
                break;
            }

            switch (choice) {

                case 1:
                    System.out.println("1 - Chicken\n2 - Donkey\n3 - Horse\n4 - Pig\n5 - Raven\n6 - Sheep");

                    System.out.print("Select animal type: ");
                    int type = input.nextInt();
                    System.out.print("Enter the name: ");
                    String name = input.next();
                    System.out.print("Enter the age: ");
                    int age = input.nextInt();

                    switch (type) {
                        case 1:
                            farmOfEnes.addAnimal(new Chicken(name, age));
                            break;
                        case 2:
                            farmOfEnes.addAnimal(new Donkey(name, age));
                            break;
                        case 3:
                            farmOfEnes.addAnimal(new Horse(name, age));
                            break;
                        case 4:
                            farmOfEnes.addAnimal(new Pig(name, age));
                            break;
                        case 5:
                            farmOfEnes.addAnimal(new Raven(name, age));
                            break;
                        case 6:
                            farmOfEnes.addAnimal(new Sheep(name, age));
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Enter the name: ");
                    String removingName = input.next();
                    farmOfEnes.removeAnimal(removingName);
                    break;
                case 3:
                    System.out.println("1 - Searched based on name\n2 - Searched based on age");
                    int searchType = input.nextInt();
                    if(searchType == 1){
                        System.out.print("Enter the name: ");
                        String searchName = input.next();
                        farmOfEnes.searchBasedOnName(searchName);
                    }else if (searchType == 2){
                        System.out.print("Enter the age: ");
                        int searchAge = input.nextInt();
                        farmOfEnes.searchBasedOnAge(searchAge);
                    }
                    break;
                case 4:
                    System.out.println("1 - Sort based on name\n2 - Sort based on leg number\n3 - Sort based on age");
                    int sortChoice = input.nextInt();
                    switch (sortChoice) {
                        case 1:
                            farmOfEnes.sortAlphabetically();
                            break;
                        case 2:
                            farmOfEnes.sortBasedOnLegNumber();
                            break;
                        case 3:
                            farmOfEnes.sortBasedOnAge();
                            break;
                    }
                    break;
                case 5:
                    System.out.printf("Next Year Population Forecast: %d\n", farmOfEnes.nextYearPopulationForecast());
                    break;
                case 6:
                    farmOfEnes.animalMovements();
                    break;
                case 7:
                    farmOfEnes.eatingHabits();
                    break;
                case 8:
                    System.out.print("Enter the file name: ");
                    String fileName = input.next();
                    farmOfEnes.printReport(fileName);
                    break;
            }
        }
    }
}
