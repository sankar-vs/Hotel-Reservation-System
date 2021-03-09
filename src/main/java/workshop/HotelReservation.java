package workshop;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelReservation {
    public enum CustomerType {REGULAR, REWARDED}
    ArrayList<Hotel> hotelList = new ArrayList<>();
    //Adds Hotel to hotelList
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }
    //Calculate Total Price
    public void calcTotalPrice(String startDate, String endDate, CustomerType type) {
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
        return hotelList.stream().min(Comparator.comparing(Hotel::getTotalRate)).orElseThrow(NoSuchElementException::new);
    }
    //Returns Best rated cheapest hotel
    public Hotel getCheapestHotelAndBestRated() {
        Predicate<Hotel> isMinimum = n -> n.getTotalRate() == getCheapestHotel().getTotalRate();
        List<Hotel> list = hotelList.stream().filter(isMinimum).collect(Collectors.toList());
        return list.stream().max(Comparator.comparing(Hotel::getRating)).orElseThrow(NoSuchElementException::new);
    }
    //Returns Best rated Hotel
    public Hotel getBestRatedHotel() {
        Hotel bestRatedPrice = hotelList.stream().max(Comparator.comparing(Hotel::getTotalRate)).orElseThrow(NoSuchElementException::new);
        Predicate<Hotel> isMaximum = n -> n.getTotalRate() == bestRatedPrice.getTotalRate();
        List<Hotel> list = hotelList.stream().filter(isMaximum).collect(Collectors.toList());
        return list.stream().max(Comparator.comparing(Hotel::getRating)).orElseThrow(NoSuchElementException::new);
    }
}