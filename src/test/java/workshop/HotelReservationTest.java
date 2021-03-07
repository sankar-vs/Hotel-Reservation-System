package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Optional;

public class HotelReservationTest {
    @Test
    public void givenHotel_whenInvoked_addHotel_shouldBeAbleToAdd() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel bridgewood = new Hotel("Bridgewood", 110, 4);
        Assertions.assertEquals("Bridgewood", bridgewood.name);
        Assertions.assertEquals(110, bridgewood.regRate);
        hotelReservation.addHotel(bridgewood);
        Assertions.assertTrue(hotelReservation.hotelList.contains(bridgewood));
    }
    @Test
    public void givenDateRange_shouldReturnCheapestHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel lakewood = new Hotel("Lakewood", 110, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 160, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 5);
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        Hotel result = hotelReservation.getCheapestHotel("10-09-2020", "12-09-2020");
        System.out.println(result);
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
}
