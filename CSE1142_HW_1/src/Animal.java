public class Animal {

    private String name;
    private int legNumber;
    private int age;
    private int pregnancyPerYear;
    private int numberOfOffSprings;
    private AnimalName animalName;
    private AnimalKind animalKind;

    public enum AnimalName {
        CHICKEN,
        DONKEY,
        HORSE,
        PIG,
        RAVEN,
        SHEEP
    }

    public enum AnimalKind {
        MAMMAL,
        BIRD
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayGreeting() { System.out.println("Have nothing to say!"); }

    public void reproduce() { System.out.println("None of your business!!"); }

    public String getName() { return name; }

    public int getLegNumber() { return legNumber; }

    public int getAge() { return age; }

    public int getPregnancyPerYear() { return pregnancyPerYear; }

    public int getNumberOfOffSprings() { return numberOfOffSprings; }

    public AnimalName getAnimalName() { return animalName; }

    public AnimalKind getAnimalKind() { return animalKind; }

    public void setName(String name) { this.name = name; }

    public void setLegNumber(int legNumber) { this.legNumber = legNumber; }

    public void setAge(int age) { this.age = age; }

    public void setPregnancyPerYear(int pregnancyPerYear) { this.pregnancyPerYear = pregnancyPerYear; }

    public void setNumberOfOffSprings(int numberOfOffSprings) { this.numberOfOffSprings = numberOfOffSprings; }

    public void setAnimalName(AnimalName animalName) { this.animalName = animalName; }

    public void setAnimalKind(AnimalKind animalKind) { this.animalKind = animalKind; }

    public String toString() {
        return String.
                format(
                        "My Name is %s!\n" +
                        "I am %d years old!\n" +
                        "I have %d legs!",
                        name, age, legNumber);
    }
}
