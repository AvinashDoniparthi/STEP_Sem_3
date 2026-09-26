package encapsulation.assigment_problems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("TL-9");
        System.out.println(light.getColor());
        System.out.println(light.next());
        System.out.println(light.next());
        System.out.println(light.next());
    }
}