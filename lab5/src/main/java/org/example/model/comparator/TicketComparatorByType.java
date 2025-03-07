package org.example.model.comparator;

import org.example.model.Ticket;

import java.util.Comparator;

public class TicketComparatorByType implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getType().getChisl() - o2.getType().getChisl();
    }
}
