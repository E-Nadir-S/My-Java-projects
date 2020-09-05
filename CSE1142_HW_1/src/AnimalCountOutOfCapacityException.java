public class AnimalCountOutOfCapacityException extends Exception {

    public AnimalCountOutOfCapacityException() {
        super("Farm Capacity is full, you can't add new animals!!");
    }
}
