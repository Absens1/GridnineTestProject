import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FlightFilterImpl implements FlightFilter {

    @Override
    final public void showAllFlights(List<Flight> flights) {
        flights.forEach(System.out::println);
    }

    @Override
    public void showFlightsWithoutDepartingInThePast(List<Flight> flights) {
        flight:
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                if (LocalDateTime.now().isAfter(segment.getDepartureDate())) {
                    continue flight;
                }
            }
            System.out.println(flight);
        }
    }

    @Override
    public void showFlightsWithoutDepartsBeforeItArrives(List<Flight> flights) {
        flight:
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                LocalDateTime dep = segment.getDepartureDate();
                LocalDateTime arr = segment.getArrivalDate();
                if (dep.isAfter(arr)) {
                    continue flight;
                }
            }
            System.out.println(flight);
        }
    }

    @Override
    public void showFlightsWithoutTransferMoreThanTwoHoursGroundTime(List<Flight> flights) {
        flight:
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            long hours = 0;
            if (segments.size() < 2) {
                System.out.println(flight);
                continue;
            }
            for (int i = 0; i < segments.size() - 1; i++) {
                Segment segment = segments.get(i);
                Segment nextSegment = segments.get(i + 1);
                hours += ChronoUnit.HOURS.between(segment.getArrivalDate(), nextSegment.getDepartureDate());
                if (hours > 2) {
                    continue flight;
                }
            }
            System.out.println(flight);
        }
    }

}
