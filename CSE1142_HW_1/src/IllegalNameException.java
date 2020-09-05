public class IllegalNameException extends Exception {

    public IllegalNameException(String animalName) {
        super("The name " + animalName + " is already created!!");
    }
}
