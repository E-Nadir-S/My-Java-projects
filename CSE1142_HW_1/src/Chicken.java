public class Chicken extends Bird {

    private static int count;

    public Chicken(String name, int age) {
        super(name, age);
        setLegNumber(2);
        setNumberOfOffSprings(1);
        setPregnancyPerYear(200);
        setAnimalName(AnimalName.CHICKEN);
        setAnimalKind(AnimalKind.BIRD);
        count++;
    }

    @Override
    public void sayGreeting() {
        System.out.println("I have nothing to say other than I am against Pigs!");
    }

    public static int getCount() { return count; }

    public static void decrementCount() { count--; }
}
