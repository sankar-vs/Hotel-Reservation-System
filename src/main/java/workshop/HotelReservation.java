package workshop;

import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelReservation {
    public enum CustomerType {REGULAR, REWARDED};
    public CustomerType type;
    Scanner sc = new Scanner(System.in);
    ArrayList<Hotel> hotelList = new ArrayList();
    //Adds Hotel to hotelList
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }
    //Calculate Total Price
    public void calcTotalPrice(String startDate, String endDate, CustomerType type) throws ParseException {
        Day day = new Day();
        switch (type) {
            case REGULAR:
                hotelList.stream().map(n -> { n.setTotalRate((day.calcWeekend(startDate, endDate) * n.getWeekendRate())
                            + (day.calcWeekday(startDate, endDate) * n.getWeekdayRate()));
                            return n.getTotalRate();}).collect(Collectors.toList());
                break;
            case REWARDED:
                hotelList.stream().map(n -> { n.setTotalRate((day.calcWeekend(startDate, endDate) * n.getRewardedWeekendRate())
                            + (day.calcWeekday(startDate, endDate) * n.getRewardedWeekdayRate()));
                            return n.getTotalRate();}).collect(Collectors.toList());
                break;
        }
    }
    //Returns the cheapest Hotel
    public Hotel getCheapestHotel() {
        Hotel cheapestPrice = hotelList.stream().min(Comparator.comparing(Hotel::getTotalRate)).orElseThrow(NoSuchElementException::new);
        return cheapestPrice;
    }
    //Returns Best rated cheapest hotel
    public Hotel getCheapestHotelAndBestRated() {
        int cheapestRate = getCheapestHotel().getTotalRate();
        Predicate<Hotel> isMinimum = n -> n.getTotalRate()==cheapestRate;
        List<Hotel> list = hotelList.stream().filter(isMinimum).collect(Collectors.toList());
        Hotel cheapestPriceRating = list.stream().max(Comparator.comparing(Hotel::getRating)).orElseThrow(NoSuchElementException::new);
        return cheapestPriceRating;
    }
    //Returns Best rated Hotel
    public Hotel getBestRatedHotel() {
        Hotel bestRatedPrice = hotelList.stream().max(Comparator.comparing(Hotel::getTotalRate)).orElseThrow(NoSuchElementException::new);
        int maxRate = bestRatedPrice.getTotalRate();
        Predicate<Hotel> isMaximum = n -> n.getTotalRate()==maxRate;
        List<Hotel> list = hotelList.stream().filter(isMaximum).collect(Collectors.toList());
        Hotel bestPriceRating = list.stream().max(Comparator.comparing(Hotel::getRating)).orElseThrow(NoSuchElementException::new);
        return bestPriceRating;
    }
}