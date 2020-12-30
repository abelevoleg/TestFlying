package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

class Filtering {
    private List<Flight> flights;

    Filtering(List<Flight> flights){
        this.flights = flights;
    }

    List<Flight> filtration(Filter filter){
        List<Flight> afterFiltrationFlights = new ArrayList<>();
        for (Flight flight : flights){
            List<Segment> segments = flight.getSegments();

            if (filter.filterType(segments)){
                afterFiltrationFlights.add(flight);
            }
        }
        return afterFiltrationFlights;
    }
}
