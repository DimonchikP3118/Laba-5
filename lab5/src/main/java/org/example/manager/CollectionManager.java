package org.example.manager;

import org.example.model.Ticket;

import java.util.Vector;

public class CollectionManager {
    private Vector<Ticket> tickets = new Vector<>();

    public Vector<Ticket> getTickets() {
        return tickets;
    }
}
