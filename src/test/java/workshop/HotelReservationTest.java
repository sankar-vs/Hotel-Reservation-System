package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {
    HotelReservation hotelReservation = new HotelReservation();
    Hotel lakewood = new Hotel("Lakewood", 110, 90, 80,80,3);
    Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 110,50,4);
    Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 100,40,5);
    @Test
    public void givenHotel_whenInvoked_addHotel_shouldBeAbleToAdd() {
        Assertions.assertEquals("Bridgewood", bridgewood.name);
        Assertions.assertEquals(150, bridgewood.weekdayRate);
        hotelReservation.addHotel(bridgewood);
        Assertions.assertTrue(hotelReservation.hotelList.contains(bridgewood));
    }
    @Test
    public void givenDateRange_shouldReturnCheapestHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        hotelReservation.calcTotalPrice("2020-09-10", "2020-09-12", HotelReservation.CustomerType.REGULAR);
        Hotel result = hotelReservation.getCheapestHotel();
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
    @Test
    public void givenWeekdaysAndWeekendRates_shouldBeAddedToHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        Assertions.assertTrue(hotelReservation.hotelList.contains(lakewood));
        Assertions.assertTrue(hotelReservation.hotelList.contains(bridgewood));
        Assertions.assertTrue(hotelReservation.hotelList.contains(ridgewood));
    }
    @Test
    public void givenDates_shouldDiffWeekendAndWeekday_andReturnCheapestHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        hotelReservation.calcTotalPrice("2020-09-11", "2020-09-13", HotelReservation.CustomerType.REGULAR);
        Hotel result = hotelReservation.getCheapestHotel();
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
    @Test
    public void givenRatings_shouldBeAddedToHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        Assertions.assertTrue(hotelReservation.hotelList.contains(lakewood));
        Assertions.assertTrue(hotelReservation.hotelList.contains(bridgewood));
        Assertions.assertTrue(hotelReservation.hotelList.contains(ridgewood));
    }
    @Test
    public void givenDates_shouldDiffWeekendAndWeekday_andReturnCheapestHotelOnRatings() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        hotelReservation.calcTotalPrice("2020-09-11", "2020-09-13", HotelReservation.CustomerType.REGULAR);
        Hotel result = hotelReservation.getCheapestHotelAndBestRated();
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
    @Test
    public void givenDateRange_shouldReturnBestRatedHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        hotelReservation.calcTotalPrice("2020-09-11", "2020-09-13", HotelReservation.CustomerType.REGULAR);
        Hotel result = hotelReservation.getBestRatedHotel();
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
    @Test
    public void givenRewardedCustomerRate_shouldBeAddedToHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        Assertions.assertTrue(hotelReservation.hotelList.contains(lakewood));
        Assertions.assertTrue(hotelReservation.hotelList.contains(bridgewood));
        Assertions.assertTrue(hotelReservation.hotelList.contains(ridgewood));
    }
    @Test
    public void givenDateRangeForRewardedCust_shouldReturnCheapestHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        hotelReservation.calcTotalPrice("2020-09-11", "2020-09-13", HotelReservation.CustomerType.REWARDED);
        Hotel result = hotelReservation.getCheapestHotel();
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
    @Test
    public void givenDateRangeForRewardedCust_shouldReturnCheapestBestRatedHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        hotelReservation.calcTotalPrice("2020-09-11", "2020-09-13", HotelReservation.CustomerType.REWARDED);
        Hotel result = hotelReservation.getCheapestHotelAndBestRated();
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
    @Test
    public void givenDateRangeForRegularCust_shouldReturnCheapestBestRatedHotel() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        hotelReservation.calcTotalPrice("2020-09-11", "2020-09-13", HotelReservation.CustomerType.REGULAR)  ;
        Hotel result = hotelReservation.getCheapestHotelAndBestRated();
        Assertions.assertTrue(hotelReservation.hotelList.contains(result));
    }
}