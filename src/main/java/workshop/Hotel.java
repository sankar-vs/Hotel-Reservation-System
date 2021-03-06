package workshop;

public class Hotel {
    public String name;
    public int regRate;

    public Hotel(String name, int rate) {
        this.name = name;
        this.regRate = rate;
    }

    public String toString() {
        return "Hotel: " + name + "  Rate: " + regRate;
    }
}
