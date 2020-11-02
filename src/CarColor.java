import java.util.Arrays;

public class CarColor {

    private String name;
    private int[] rgb = new int[3];

    public CarColor(java.awt.Color color) {

        this.rgb[0] = color.getRed();
        this.rgb[1] = color.getGreen();
        this.rgb[2] = color.getBlue();

        this.name = color.toString();
    }


    public CarColor(String name, int r, int g, int b) {

        this.rgb[0] = r;
        this.rgb[1] = g;
        this.rgb[2] = b;

        this.name = name;
    }


    public String getName() {
        return name;
    }

    public int getRed() {
        return this.rgb[0];
    }

    public int getGreen() {
        return this.rgb[1];
    }

    public int getBlue() {
        return this.rgb[2];
    }


}
