package com.Module2.Lesson1.task3;

/*Написать класс «автомобиль», который должен уметь заводится,
 глушить мотор, ехать и держать необходимую скорость.
 */
public class Car {
    private String name;
    private int speed;

    public void setName(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void switchOn() {
        System.out.println(name + " завелся.");
    }

    public void switchOff() {
        System.out.println(name + " заглушил мотор.");
    }

    public void go() {
        System.out.println(name + " поехал.");
    }

    public void keepSpeed(int x) {
        speed += x;
        System.out.println(name + " едет со скоростью " + speed + " км в час.");
    }
}
