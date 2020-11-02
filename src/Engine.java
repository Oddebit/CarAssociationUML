public class Engine {

    private int fuel = 0;

    public void burnFuel(int amount) {
        this.fuel -= amount;
    }

    public void reFuel(int amount) {
        this.fuel += amount;
    }

    public int getFuel() {
        return fuel;
    }
}
