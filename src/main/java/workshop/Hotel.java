package workshop;

public class Hotel {
    public String name;
    public int regRate;
    public int rating;
    public int totalRate;

    public Hotel(String name, int rate, int rating) {
        this.name = name;
        this.regRate = rate;
        this.rating = rating;
    }

    public String toString() {
        return "Hotel: " + name + "  Rate: " + totalRate + "  Rating: " + rating;
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

    public int getWeekdayRate() {
        return regRate;
    }

    public void setTotalRate(int rate) {
        totalRate = rate;
    }

    public int getTotalRate() {
        return totalRate;
    }
}
