import java.util.Random;

public class CarApp {

    public static void main(String[] args) {

        Person jeanjean = new Person("Jean-Jean", 25);
        Person tomtom = new Person("Tom-Tom", 56);

        CarColor yellow = new CarColor("yellow", 255, 227,0);
        CarColor red = new CarColor("red",255, 4, 0);

        Car carJJ = new Car("Peugeot", red, 0, jeanjean, 3);
        Car carTT = new Car("VW", yellow, 0, tomtom, 10);

        Random random = new Random();
        carJJ.accelerate(random.nextInt(120));
        carTT.accelerate(random.nextInt(80));

        System.out.println(carJJ.toString());
        System.out.println(carTT.toString());

        Person[] initialPassengers = new Person[6];
        initialPassengers[0] = new Person("Jean", 75 + random.nextInt(25));
        initialPassengers[1] = new Person("Marie", 75 + random.nextInt(25));
        initialPassengers[2] = new Person("Robert", 75 + random.nextInt(25));
        initialPassengers[3] = new Person("Roger", 75 + random.nextInt(25));
        initialPassengers[4] = new Person("Lucien", 75 + random.nextInt(25));
        initialPassengers[5] = new Person("Nicole", 75 + random.nextInt(25));

        Person[] addedPassengers = new Person[4];
        addedPassengers[0] = new Person("Gisèle", 75 + random.nextInt(25));
        addedPassengers[1] = new Person("Ferdinand", 75 + random.nextInt(25));
        addedPassengers[2] = new Person("Gertrude", 75 + random.nextInt(25));
        addedPassengers[3] = new Person("Rosa Parks", 107);

        carTT.setPassengers(initialPassengers);
        carTT.addPassengers(addedPassengers);
        carTT.printPassengers();
    }
}
