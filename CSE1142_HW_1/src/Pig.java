public class Pig extends Mammal {

    private static int count;

    public Pig(String name, int age) {
        super(name, age);
        setLegNumber(4);
        setNumberOfOffSprings(12);
        setPregnancyPerYear(2);
        setAnimalName(AnimalName.PIG);
        setAnimalKind(AnimalKind.MAMMAL);
        count++;
    }

    @Override
    public void sayGreeting() {
        System.out.println("All animals are equal, but some animals are more equal than others!");
    }

    public static int getCount() { return count; }

    public static void decrementCount() { count--; }
}
