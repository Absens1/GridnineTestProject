import java.util.List;

public interface FlightFilter {
    void showAllFlights(List<Flight> flights);
    void showFlightsWithoutDepartingInThePast(List<Flight> flights);
    void showFlightsWithoutDepartsBeforeItArrives(List<Flight> flights);
    void showFlightsWithoutTransferMoreThanTwoHoursGroundTime(List<Flight> flights);
}
