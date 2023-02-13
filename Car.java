package ioc;

public class Car {
    private final Engine engine;
    private int fuel;
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void addFuel(int fuel) {
        if(fuel < 0) {
            throw new IllegalArgumentException("Can't add negative fuel");
        }
        this.fuel += fuel;
    }

    public void start() {
        if(fuel <= 0) {
            throw new RuntimeException("Empty tank!");
        }
        engine.start();
    }

    public static class Engine {
        public void start() {
            System.out.println("Engine start");
        }
    }
}
