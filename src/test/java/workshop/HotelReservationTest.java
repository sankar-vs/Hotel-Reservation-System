package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

public class HotelReservationTest {
    @Test
    public void givenHotel_whenInvoked_addHotel_shouldBeAbleToAdd() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
        Assertions.assertEquals("Bridgewood", bridgewood.name);
        Assertions.assertEquals(110, bridgewood.weekdayRate);
        hotelReservation.addHotel(bridgewood);
        Assertions.assertTrue(hotelReservation.hotelList.contains(bridgewood));
    }
    @Test
    public void givenDateRange_shouldReturnCheapestHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        Hotel result = hotelReservation.getCheapestHotel("10-09-2020", "12-09-2020");
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
    @Test
    public void givenWeekdaysAndWeekendRates_shouldBeAddedToHotel() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        Assertions.assertTrue(hotelReservation.hotelList.contains(lakewood));
        Assertions.assertTrue(hotelReservation.hotelList.contains(bridgewood));
        Assertions.assertTrue(hotelReservation.hotelList.contains(ridgewood));
    }
    @Test
    public void givenDates_shouldDiffWeekendAndWeekday_andReturnCheapestHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        Hotel result = hotelReservation.getCheapestHotel("2020-09-10", "2020-09-12");
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
}
