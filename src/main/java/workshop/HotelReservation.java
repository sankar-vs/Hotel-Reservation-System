package workshop;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelReservation {
    Scanner sc = new Scanner(System.in);
    ArrayList<Hotel> hotelList = new ArrayList();
    //Adds Hotel to hotelList
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }
    //Returns the cheapest Hotel
    public Hotel getCheapestHotel(String startDate, String endDate) throws ParseException {
        Day day = new Day(startDate, endDate);
        for (Hotel hotel : hotelList) {
            int rate = 0;
            LocalDate dateBefore = LocalDate.parse(startDate);
            LocalDate dateAfter = LocalDate.parse(endDate);
            while (!dateBefore.toString().equals(dateAfter.toString())) {
                dateBefore = dateBefore.plusDays(1);
                if (day.calcWeekdayWeekend(dateBefore.toString()))
                    rate += hotel.getWeekendRate();
                else
                    rate += hotel.getWeekdayRate();
            }
            hotel.setTotalRate(rate);
        }
        Hotel cheapestPrice = hotelList.stream()
                              .min(Comparator.comparing(Hotel::getTotalRate))
                              .orElseThrow(NoSuchElementException::new);
        int cheapestRate = cheapestPrice.getTotalRate();
        Predicate<Hotel> isMinimum = n -> n.getTotalRate()==cheapestRate;
        List<Hotel> list = hotelList.stream().filter(isMinimum).collect(Collectors.toList());
        //list.stream().forEach(System.out::println);
        Hotel cheapestPriceRating = list.stream()
                                    .max(Comparator.comparing(Hotel::getRating))
                                    .orElseThrow(NoSuchElementException::new);
        return cheapestPriceRating;
    }
}
