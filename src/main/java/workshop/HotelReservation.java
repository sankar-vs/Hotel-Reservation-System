package workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
    Scanner sc = new Scanner(System.in);
    ArrayList<Hotel> hotelList = new ArrayList();

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }
}
