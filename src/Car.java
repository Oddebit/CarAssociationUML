public class Car {

    private String brand;
    private int speed;
    private CarColor color;
    private Engine engine;
    private Person driver;
    private Person[] passengers;


    public Car(String brand, CarColor color, int seats) {

        this.brand = brand;
        this.color = color;
        this.engine = new Engine();
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

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public void accelerate(int acc) {

        if (-acc > this.speed) {
            acc = -this.speed;
        }
        // Say speed = 50. If i decelerate by 70 (acc = -70) -> reset deceleration on 50 (acc = -50)

        if (this.driver != null && acc <= this.engine.getFuel()) {

            this.speed += acc; // So it makes the car stop (speed = speed (50) + acc (-50) = 0)

            if(acc > 0) {
                this.engine.burnFuel(acc); // So only 50 are burnt
            }
        }
    }

    public void repaint(CarColor color) {

        this.color = color;

        int price = color.getRgb()[0] + color.getRgb()[1] + color.getRgb()[2];
        System.out.println(this.driver + "'s car has been repainted. Price : " + price + "€.");
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
