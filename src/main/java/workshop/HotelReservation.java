package workshop;

import java.text.ParseException;
import java.util.*;
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
                for (Hotel hotel : hotelList) {
                    int rate = 0;
                    rate += (day.calcWeekend(startDate, endDate) * hotel.getWeekendRate());
                    rate += (day.calcWeekday(startDate, endDate) * hotel.getWeekdayRate());
                    hotel.setTotalRate(rate);
                }
                break;
            case REWARDED:
                for (Hotel hotel : hotelList) {
                    int rate = 0;
                    rate += (day.calcWeekend(startDate, endDate) * hotel.getRewardedWeekendRate());
                    rate += (day.calcWeekday(startDate, endDate) * hotel.getRewardedWeekdayRate());
                    hotel.setTotalRate(rate);
                }
                break;
        }
    }
    //Returns the cheapest Hotel
    public Hotel getCheapestHotel() {
        Hotel cheapestPrice = hotelList.stream().min(Comparator.comparing(Hotel::getTotalRate)).orElseThrow(NoSuchElementException::new);
        return cheapestPrice;
    }

    public Hotel getCheapestHotelAndBestRated() {
        Hotel cheapestPrice = hotelList.stream().min(Comparator.comparing(Hotel::getTotalRate)).orElseThrow(NoSuchElementException::new);
        int cheapestRate = cheapestPrice.getTotalRate();
        Predicate<Hotel> isMinimum = n -> n.getTotalRate()==cheapestRate;
        List<Hotel> list = hotelList.stream().filter(isMinimum).collect(Collectors.toList());
        Hotel cheapestPriceRating = list.stream().max(Comparator.comparing(Hotel::getRating)).orElseThrow(NoSuchElementException::new);
        return cheapestPriceRating;
    }

    public Hotel getBestRatedHotel() {
        Hotel bestRatedPrice = hotelList.stream().max(Comparator.comparing(Hotel::getTotalRate)).orElseThrow(NoSuchElementException::new);
        int cheapestRate = bestRatedPrice.getTotalRate();
        Predicate<Hotel> isMaximum = n -> n.getTotalRate()==cheapestRate;
        List<Hotel> list = hotelList.stream().filter(isMaximum).collect(Collectors.toList());
        Hotel bestPriceRating = list.stream().max(Comparator.comparing(Hotel::getRating)).orElseThrow(NoSuchElementException::new);
        return bestPriceRating;
    }
}
