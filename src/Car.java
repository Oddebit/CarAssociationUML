public class Car {

    private String brand;
    private int speed;
    private CarColor color;
    private Engine engine;
    private Person driver;
    private Person[] passengers;


    public Car(String brand, CarColor color, int fuel, Person driver, int seats) {

        this.brand = brand;
        this.color = color;
        this.engine = new Engine();
        this.engine.reFuel(fuel);
        this.driver = driver;
        this.passengers = new Person[seats];
    }


    @Override
    public String toString() {
        return "Car {" +
                "brand = '" + brand + '\'' +
                ", speed = " + speed +
                ", color = " + color.getName() +
                ", engine = " + engine.getFuel() +
                ", driver = " + driver.getName() +
                '}';
    }

    public void accelerate(int amount) {

        if (this.driver != null && this.engine.getFuel() != 0) {
            this.speed += amount;
            this.engine.burnFuel(amount);
        }
    }

    public int repaint(CarColor color) {

        this.color = color;
        return color.getRed() + color.getGreen() + color.getBlue();
    }

    public void setPassengers(Person[] passengers) {

        if (passengers.length <= this.passengers.length) {

            for (int i = 0; i < passengers.length; i++) {

                this.passengers[i] = passengers[i];
            }

            sortPassengers();
        }
    }

    public void addPassengers(Person[] passengers) {

        int seatsLeft = seatsLeft();
        if (passengers.length <= seatsLeft) {

            for (int i = 0; i < passengers.length; i++) {

                this.passengers[this.passengers.length - seatsLeft + i] = passengers[i];
            }

            sortPassengers();
        }
    }

    private int seatsLeft() {

        int seatsLeft = this.passengers.length;

        for (Person passenger : passengers) {

            if (passenger != null) seatsLeft--;
        }

        return seatsLeft;
    }

    private void sortPassengers() {

        for (int i = 1; i < this.passengers.length - seatsLeft(); i++) {

            if (passengers[i].getAge() > passengers[i - 1].getAge()) {

                Person temp = passengers[i];
                passengers[i] = passengers[i - 1];
                passengers[i - 1] = new Person(temp);

                if (i > 1) i -= 2;
            }
        }
    }

    public void printPassengers() {

        System.out.println("Passengers in " + driver.getName() + "'s car : ");

        for (int i = 0; i < passengers.length - seatsLeft(); i++) {

            System.out.println(passengers[i].toString());
        }
    }
}
