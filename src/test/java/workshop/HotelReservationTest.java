package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {
    @Test
    public void givenHotel_whenInvoked_addHotel_shouldBeAbleToAdd() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel bridgewood = new Hotel("Bridgewood", 110);
        Assertions.assertEquals("Bridgewood", bridgewood.name);
        Assertions.assertEquals(110, bridgewood.regRate);
        hotelReservation.addHotel(bridgewood);
        Assertions.assertTrue(hotelReservation.hotelList.contains(bridgewood));
    }
}
