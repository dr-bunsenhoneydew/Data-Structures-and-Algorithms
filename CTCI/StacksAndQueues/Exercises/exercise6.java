package StacksAndQueues.Exercises;

import java.util.LinkedList;

// An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure.

public class exercise6 {
    
    public static class Animal {
        private int order;
        private String name;

        public Animal(String n) {
            this.name = n;
        }
        public void setOrder(int ord) {
            this.order = ord;
        }

        public int getOrder() {
            return this.order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    public static class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }
    }

    public static class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }
    }

    public static class AnimalQueue {
        public LinkedList<Dog> dogs = new LinkedList<Dog>();
        public LinkedList<Cat> cats = new LinkedList<Cat>();
        private int order = 0;

        public void enqueue(Animal a) {
            a.setOrder(order);
            order++;

            if (a instanceof Dog) {
                dogs.addLast((Dog) a);
            }
            else if (a instanceof Cat) {
                cats.addLast((Cat) a);
            }
        }

        public Animal dequeueDog() {
            Animal first = dogs.peek();
            System.out.println(first.name);
            return dogs.poll();
        }

        public Animal dequeueCat() {
            Animal first = cats.peek();
            System.out.println(first.name);
            return cats.poll();
        }

        public Animal dequeueAny() {
            if (dogs.size() == 0 && cats.size() == 0) {
                System.out.println("Both lists are empty");
            }
            
            else if (dogs.size() == 0) {
                return dequeueCat();
            }
            else if (cats.size() == 0) {
                return dequeueDog();
            }

            else {
                Animal dogTest = dogs.peek();
                Animal catTest = cats.peek();
                if (dogTest.isOlderThan(catTest)) {
                    return dequeueDog();
                }
                else {
                    return dequeueCat();
                }
            }
            return null;
        }
    }


    public static void main(String[] args) {
        AnimalQueue myq = new AnimalQueue();
        Dog dog1 = new Dog("DogOne");
        Dog dog2 = new Dog("DogTwo");
        Dog dog3 = new Dog("DogThree");
        Cat cat1 = new Cat("CatOne");
        Cat cat2 = new Cat("CatTwo");
        Cat cat3 = new Cat("CatThree");

        myq.enqueue(dog1);
        myq.enqueue(cat1);
        myq.enqueue(dog2);
        myq.enqueue(dog3);
        myq.enqueue(cat2);
        myq.enqueue(cat3);

        myq.dequeueAny(); // returns DogOne
        myq.dequeueCat(); // returns CatOne
        myq.dequeueDog(); // returns DogTwo
        myq.dequeueAny(); // returns DogThree
    }

}
