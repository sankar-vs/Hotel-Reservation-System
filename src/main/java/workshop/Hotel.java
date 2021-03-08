package workshop;

public class Hotel {
    public String name;
    public int weekdayRate;
    public int weekendRate;
    public int rating;
    public int totalRate;
    public int rewardedWeekdayRate;
    public int rewardedWeekendRate;

    public Hotel(String name, int weekdayRate, int weekendRate, int rewardedWeekdayRate, int rewardedWeekendRate, int rating) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rewardedWeekdayRate = rewardedWeekdayRate;
        this.rewardedWeekendRate = rewardedWeekendRate;
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Hotel: " + name + "  Rating: " + rating + "  Total Rate: " + totalRate;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public int getRewardedWeekdayRate() {
        return rewardedWeekdayRate;
    }

    public int getRewardedWeekendRate() {
        return rewardedWeekendRate;
    }

    public int getRating() {
        return rating;
    }

    public void setTotalRate(int rate) {
        this.totalRate = rate;
    }

    public int getTotalRate() {
        return totalRate;
    }
}
