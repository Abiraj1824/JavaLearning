
package inheritance;

class Animal {

    String name;

    void eat() {
        System.out.println(name + " is eating");
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println(name + " is barking");
    }
}

class Cat extends Animal {

    void meow() {
        System.out.println(name + " is meowing");
    }
}

public class InheritanceDemo {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.name = "Tommy";

        dog.eat();
        dog.sleep();
        dog.bark();

        System.out.println();

        Cat cat = new Cat();
        cat.name = "Kitty";

        cat.eat();
        cat.sleep();
        cat.meow();
    }
}
