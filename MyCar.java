public class MyCar {
    public static void main(String[] args) {

        Car ford = new Car();
        ford.setName("Ford");
        System.out.println("Мой новый автомобиль - " + ford.getName() + "!");

        ford.switchOn();
        ford.go();
        ford.keepSpeed(60);
        ford.switchOff();

        System.out.println("");

        Car toyota = new Car();
        toyota.setName("Toyota");
        System.out.println("Мой новый автомобиль - " + toyota.getName() + "!");

        toyota.switchOn();
        toyota.go();
        toyota.keepSpeed(120);
        toyota.switchOff();
    }
}
