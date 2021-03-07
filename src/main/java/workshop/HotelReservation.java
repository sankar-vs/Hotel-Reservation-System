package workshop;

import java.text.ParseException;
import java.util.*;
import java.util.function.Function;

public class HotelReservation {
    Scanner sc = new Scanner(System.in);
    ArrayList<Hotel> hotelList = new ArrayList();

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    public Hotel getCheapestHotel(String startDate, String endDate) throws ParseException {
        Day day = new Day(startDate, endDate);
        for (Hotel hotel : hotelList) {
            int rate = 0;
            for (int i = 1 ; i <= day.getDifference() ; i++) {
                rate += hotel.getWeekdayRate();
            }
            hotel.setTotalRate(rate);
        }
        Hotel cheapestPrice = hotelList.stream()
                .min(Comparator.comparing(Hotel::getTotalRate))
                .orElseThrow(NoSuchElementException::new);
        return cheapestPrice;
    }
}
