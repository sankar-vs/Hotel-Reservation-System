package workshop;

public class Hotel {
    public String name;
    public int weekdayRate;
    public int weekendRate;
    public int rating;

    public Hotel(String name, int weekdayRate, int weekendRate, int rating) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
    }

    public String toString() {
        return "Hotel: " + name + "  WeekdayRate: " + weekdayRate +
                "  WeekendRate: " + weekdayRate + "  Rating: " + rating;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return weekdayRate;
    }

    public void calculatePrice(int difference) {
        weekdayRate = weekdayRate * difference;
    }
}
