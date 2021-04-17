import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList = flightBuilder.createFlights();
        FlightFilterImpl flightFilter = new FlightFilterImpl();
        System.out.println("Базовый набор полетов");
        flightFilter.showAllFlights(flightList);
        System.out.println("\n1. Фильтр исключает вылет до текущего момента даты/времени");
        flightFilter.showFlightsWithoutDepartingInThePast(flightList);
        System.out.println("\n2. Фильтр исключает сегменты с датой прилёта раньше даты вылета");
        flightFilter.showFlightsWithoutDepartsBeforeItArrives(flightList);
        System.out.println("\n3. Фильтр исключает перелеты, где общее время, проведённое на земле превышает два");
        flightFilter.showFlightsWithoutTransferMoreThanTwoHoursGroundTime(flightList);
    }
}