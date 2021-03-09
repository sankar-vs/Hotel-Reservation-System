package workshop;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.Set;

public class Day {
    //Returns the difference between two dates
    public int diffDays(String first, String last) {
        LocalDate dateBefore = LocalDate.parse(first);
        LocalDate dateAfter = LocalDate.parse(last);
        return (int) ChronoUnit.DAYS.between(dateBefore,dateAfter);
    }
    //Returns total number of weekends
    public int calcWeekend(String first, String last) {
        int count = 0;
        LocalDate dateBefore = LocalDate.parse(first);
        LocalDate dateAfter = LocalDate.parse(last);
        Set< DayOfWeek > weekend = EnumSet.of( DayOfWeek.SATURDAY , DayOfWeek.SUNDAY );
        while ( dateBefore.isBefore( dateAfter ) ) {
            if ( weekend.contains( dateBefore.getDayOfWeek() ) ) { // If weekend, count this LocalDate.
                count++;
            }
            dateBefore = dateBefore.plusDays( 1 ); // Increment to next day.
        }
        return count;
    }
    //Returns total number of weekdays
    public int calcWeekday(String first, String last) {
        int count = 0;
        LocalDate dateBefore = LocalDate.parse(first);
        LocalDate dateAfter = LocalDate.parse(last);
        Set< DayOfWeek > weekday = EnumSet.of( DayOfWeek.MONDAY , DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY , DayOfWeek.FRIDAY );
        while ( dateBefore.isBefore( dateAfter ) ) {
            if ( weekday.contains( dateBefore.getDayOfWeek() ) ) { // If not weekday, count this LocalDate.
                count++;
            }
            dateBefore = dateBefore.plusDays( 1 ); // Increment to next day.
        }
        return count;
    }
}
