import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;


public class AnimalFarm {

    ArrayList<Animal> animalList = new ArrayList<>();
    ArrayList<String> animalNames = new ArrayList<>();

    private final int CAPACITY;
    private static int numberOfAnimals;

    public AnimalFarm(int capacity) {
        CAPACITY = capacity;
    }

    public static int getNumberOfAnimals() { return numberOfAnimals; }

    public boolean addAnimal(Animal animal) {
        try {
            if (numberOfAnimals < CAPACITY && !checkSameNameExists(animal.getName())) {
                animalList.add(animal);
                animalNames.add(animal.getName());
                numberOfAnimals++;
                System.out.printf("%s named animal added!\n", animal.getName());
                return true;
            }
            else if(numberOfAnimals+1 >= CAPACITY){
                throw new AnimalCountOutOfCapacityException();
            }
            else {
                throw new IllegalNameException(animal.getName());
            }
        }
        catch (AnimalCountOutOfCapacityException | IllegalNameException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean removeAnimal(String name) {

        int indexOfRemovableAnimal = animalNames.indexOf(name);

        if (checkSameNameExists(name)){
            animalNames.remove(name);
            switch ( animalList.get(indexOfRemovableAnimal).getAnimalName() ) {
                case CHICKEN:
                    Chicken.decrementCount();
                    break;
                case DONKEY:
                    Donkey.decrementCount();
                    break;
                case HORSE:
                    Horse.decrementCount();
                    break;
                case PIG:
                    Pig.decrementCount();
                    break;
                case RAVEN:
                    Raven.decrementCount();
                    break;
                case SHEEP:
                    Sheep.decrementCount();
                    break;
            }
            System.out.printf("%s named animal removed!", animalList.get(indexOfRemovableAnimal).getName());
            animalList.remove(indexOfRemovableAnimal);
            numberOfAnimals--;
            return true;
        }
        else {
            System.out.printf("There is no animal with name %s in the Farm!!\n", name);
            return false;
        }
    }

    public void printAllAnimalGreetings() {
        for(Animal animal : animalList) {
            printOneAnimalGreeting(animal);
        }
    }

    public void printOneAnimalGreeting(Animal animal) {
        animal.sayGreeting();
    }

    public void printAllAnimalNames() {
        for(Animal animal : animalList) {
            printOneAnimalName(animal);
        }
    }

    public void printOneAnimalName(Animal animal) {
        System.out.println(animal.getName());
    }

    public void printAllAnimals() {
        for(Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }

    public int nextYearPopulationForecast() {
        int forecast = 0;
        for(Animal animal : animalList) {
            forecast += animal.getNumberOfOffSprings()*animal.getPregnancyPerYear();
        }
        return forecast;
    }

    public void animalMovements() {
        for(Animal animal : animalList) {
            System.out.printf("My name is %s and ", animal.getName());
            switch (animal.getAnimalKind()) {
                case BIRD:
                    ((Bird) animal).fly();
                    break;
                case MAMMAL:
                    ((Mammal) animal).walk();
                    break;
            }
        }
    }

    public void eatingHabits() {
        for(Animal animal : animalList) {
            System.out.printf("My name is %s and ", animal.getName());
            switch (animal.getAnimalKind()) {
                case BIRD:
                    ((Bird) animal).omnivore();
                    break;
                case MAMMAL:
                    ((Mammal) animal).herbivore();
                    break;
            }
        }
    }

    public void sortAlphabetically() {
        ArrayList<Animal> sortedName = new ArrayList<>(animalList);
        sortedName.sort(Comparator.comparing(Animal::getName));
        for(Animal nameSortedAnimal : sortedName) {
            System.out.printf("My name is %s!\n", nameSortedAnimal.getName());
        }
    }

    public void sortBasedOnLegNumber() {
        ArrayList<Animal> sortedLeg = new ArrayList<>(animalList);
        sortedLeg.sort(Comparator.comparing(Animal::getLegNumber));
        for(Animal legSortedAnimal : sortedLeg) {
            System.out.printf("My name is %s and Leg number is %d!\n", legSortedAnimal.getName(), legSortedAnimal.getLegNumber());
        }
    }

    public void sortBasedOnAge() {
        ArrayList<Animal> sortedAge = new ArrayList<>(animalList);
        sortedAge.sort(Comparator.comparing(Animal::getAge));
        for(Animal ageSortedAnimal : sortedAge) {
            System.out.printf("%s is %d years old!\n", ageSortedAnimal.getName(), ageSortedAnimal.getAge());
        }
    }

    public void searchBasedOnName(String name) {
        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                System.out.println(animal.toString());
            }
        }
    }


    public void searchBasedOnAge(int age) {
        for (Animal animal : animalList) {
            if (animal.getAge() == age) {
                System.out.println(animal.toString());
            }
        }
    }

    public void printReport(String fileName) {

        int chickenCount=0, donkeyCount=0, horseCount=0, pigCount=0, ravenCount=0, sheepCount=0;

        for (Animal animal : animalList) {
            switch (animal.getAnimalName()) {
                case CHICKEN:
                    chickenCount++;
                    break;
                case DONKEY:
                    donkeyCount++;
                    break;
                case HORSE:
                    horseCount++;
                    break;
                case PIG:
                    pigCount++;
                    break;
                case RAVEN:
                    ravenCount++;
                    break;
                case SHEEP:
                    sheepCount++;
                    break;
            }
        }

        try {
            PrintWriter output = new PrintWriter(new File(fileName));

            output.printf("We have a total of %d animals in the farm.\n\n", numberOfAnimals);

            if (chickenCount > 0) {
                writeCommonThings(output, Animal.AnimalName.CHICKEN, chickenCount);
            }
            if (donkeyCount > 0) {
                writeCommonThings(output, Animal.AnimalName.DONKEY, donkeyCount);
            }
            if (horseCount > 0) {
                writeCommonThings(output, Animal.AnimalName.HORSE, horseCount);
            }
            if (pigCount > 0) {
                writeCommonThings(output, Animal.AnimalName.PIG, pigCount);
            }
            if (ravenCount > 0) {
                writeCommonThings(output, Animal.AnimalName.RAVEN, ravenCount);
            }
            if (sheepCount > 0) {
                writeCommonThings(output, Animal.AnimalName.SHEEP, sheepCount);
            }
            output.close();
            System.out.printf("File named %s created and reports are written", fileName);
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkSameNameExists(String name) {
        return animalNames.contains(name);
    }

    private void writeCommonThings(PrintWriter output, Animal.AnimalName animalName, int animalCount) {
        output.printf("\t%d of them are %s. Those are:\n", animalCount, animalName);
        output.printf("\t\t%-15s%-15s%-15s", "Name", "Age", "Leg Number\n");
        for (Animal animal : animalList){
            if (animal.getAnimalName().equals(animalName))
                output.printf("\t\t%-15s%-15d%-15d\n", animal.getName(), animal.getAge(), animal.getLegNumber());
        }
    }
}