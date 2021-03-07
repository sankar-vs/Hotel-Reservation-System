package workshop;

import java.text.ParseException;
import java.util.*;

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
            hotel.calculatePrice(day.getDifference());
        }
        Hotel cheapestPrice  = hotelList.stream()
                        .min(Comparator.comparing(Hotel :: getPrice))
                        .orElseThrow(NoSuchElementException::new);
        return cheapestPrice;
    }
}
