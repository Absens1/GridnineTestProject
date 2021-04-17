import org.junit.Test;
import java.util.List;


public class TestFlightFilterImpl {

    FlightFilterImpl flightFilter;
    List<Flight> flightList;

    @Test(expected = NullPointerException.class)
    public void showAllFlights() {
        flightFilter.showAllFlights(flightList);
    }
}
