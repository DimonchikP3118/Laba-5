package org.example.model.comparator;

import org.example.model.Ticket;

import java.util.Comparator;

public class TicketComparatorByName implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        // если this > o - вернем больше 0
        // если this < o - вернем меньше 0
        // если this == 0 - вернем 0
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
