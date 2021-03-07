package workshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day {
    SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
    int dayDifference;
    //Calculates the diff between two Dates as soon as the object is created
    public Day(String first, String last) throws ParseException {
        try {
            Date dateBefore = myFormat.parse(first);
            Date dateAfter = myFormat.parse(last);
            long difference = dateAfter.getTime() - dateBefore.getTime();
            float daysBetween = (difference / (1000*60*60*24));
            /* You can also convert the milliseconds to days using this method
             * float daysBetween =
             *         TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
             */
            dayDifference = (int) daysBetween;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Returns the Difference between two dates
    public int getDifference() {
        return dayDifference;
    }
}
