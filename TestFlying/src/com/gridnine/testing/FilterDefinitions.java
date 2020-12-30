package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FilterDefinitions {
    Filter filterBeforeCurrentTime = segments -> {
        LocalDateTime now = LocalDateTime.now();

        for (Segment segment : segments) {
            if (segment.getDepartureDate().isBefore(now))
                return false;
        }
        return true;
    };

    Filter filterArrivalAfterDeparture = segments -> {
        for (Segment segment : segments) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                return false;
        }
        return true;
    };

    Filter filterTransferExceedTwoHours = segments -> {
        Segment[] segmentsForFilter = segments.toArray(new Segment[0]);
        for (int i = 0; i < segmentsForFilter.length - 1; i++) {
            long hours = segmentsForFilter[i].getArrivalDate().until(segmentsForFilter[i + 1].getDepartureDate(), ChronoUnit.HOURS);
            if (hours > 2)
                return false;
        }
        return true;
    };
}
