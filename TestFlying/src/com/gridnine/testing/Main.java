package com.gridnine.testing;

import java.util.List;
//

public class Main {
    public static void main(String[] args) {
        Filtering filtering = new Filtering(FlightBuilder.createFlights());
        FilterDefinitions filterDefinitions = new FilterDefinitions();

        List<Flight> filteringBeforeCurrentTime = filtering.filtration(filterDefinitions.filterBeforeCurrentTime);
        List<Flight> filteringArrivalAfterDeparture = filtering.filtration(filterDefinitions.filterArrivalAfterDeparture);
        List<Flight> filteringTransferExceedTwoHours = filtering.filtration(filterDefinitions.filterTransferExceedTwoHours);

        displayFlights(filteringBeforeCurrentTime);
        displayFlights(filteringArrivalAfterDeparture);
        displayFlights(filteringTransferExceedTwoHours);
    }

    static void displayFlights(List<Flight> flights){
        for (Flight flight : flights)
            System.out.println(flight);
        System.out.println("*****");
    }
}
