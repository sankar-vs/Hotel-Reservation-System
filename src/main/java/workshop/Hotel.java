package workshop;

public class Hotel {
    public String name;
    public int regRate;
    public int rating;

    public Hotel(String name, int rate, int rating) {
        this.name = name;
        this.regRate = rate;
        this.rating = rating;
    }

    public String toString() {
        return "Hotel: " + name + "  Rate: " + regRate + "  Rating: " + rating;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return regRate;
    }

    public void calculatePrice(int difference) {
        regRate = regRate * difference;
    }
}
