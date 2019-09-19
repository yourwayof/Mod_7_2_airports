import com.skillbox.airport.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Calendar currentCalendar = new GregorianCalendar();
        Date date = currentCalendar.getTime();
        currentCalendar.add(Calendar.HOUR, 2);
        Date currentDate = currentCalendar.getTime();


        Airport svo = Airport.getInstance();
        //System.out.println(svo.getAllAircrafts());
        //System.out.println(svo.getTerminals());

        svo.getTerminals().stream()
                .forEach(e1 -> e1.getFlights().stream()
                .filter(o1 -> o1.getDate().after(date))
                .filter(o1 -> o1.getDate().before(currentDate))
                .filter(o1 -> o1.getType().equals(Flight.Type.DEPARTURE))
                .forEach(e2 -> System.out.println(e2.toString())));

    }
}
