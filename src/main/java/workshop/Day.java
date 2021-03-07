package workshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Day {
    SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
    int dayDifference;
    //Calculates the diff between two Dates as soon as the object is created
    public Day(String first, String last) throws ParseException {
        Date dateBefore = myFormat.parse(first);
        Date dateAfter = myFormat.parse(last);
        long difference = dateAfter.getTime() - dateBefore.getTime();
        float daysBetween = (difference / (1000*60*60*24));
        dayDifference = (int) daysBetween;
    }
    //Returns the Difference between two dates
    public int getDifference() {
        return dayDifference;
    }

    public boolean calcWeekdayWeekend(String first) throws ParseException {
        Date dateBefore = myFormat.parse(first);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(dateBefore);
        //System.out.println(c1.get(Calendar.DAY_OF_WEEK));
        if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {  //or sunday
            //System.out.println("WEEKEND PRICE");
            return true;
        }else {
            //System.out.println("WEEKDAY");
            return false;
        }
    }
}
