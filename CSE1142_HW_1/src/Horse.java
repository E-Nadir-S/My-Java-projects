public class Horse extends Mammal {

    private static int count;

    public Horse(String name, int age) {
        super(name, age);
        setLegNumber(4);
        setNumberOfOffSprings(1);
        setPregnancyPerYear(1);
        setAnimalName(AnimalName.HORSE);
        setAnimalKind(AnimalKind.MAMMAL);
        count++;
    }

    @Override
    public void sayGreeting() {
        System.out.println("I will work harder!");
    }

    public static int getCount() { return count; }

    public static void decrementCount() { count--; }
}
