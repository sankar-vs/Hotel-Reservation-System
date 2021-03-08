package workshop;

public class Hotel {
    public String name;
    public int weekdayRate;
    public int weekendRate;
    public int rating;
    public int totalRate;

    public Hotel(String name, int weekdayRate, int weekendRate, int rating) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
    }

    public String toString() {
        return "Hotel: " + name + "  Rating: " + rating + "  Total Rate: " + totalRate;
    }

    public String getName() {
        return name;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public int getRating() {
        return rating;
    }

    public void setTotalRate(int rate) {
        totalRate = rate;
    }

    public int getTotalRate() {
        return totalRate;
    }
}
