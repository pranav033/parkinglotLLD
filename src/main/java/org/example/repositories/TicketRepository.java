package org.example.repositories;

import org.example.modals.Ticket;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TicketRepository {
    Map<Integer, Ticket> tickets = new TreeMap<>();

    public static int previousCounter = 0;

    public Optional<Ticket> findTicketById(int id) {
        if(tickets.containsKey(id)) {
            return Optional.of(tickets.get(id));
        }
        return Optional.empty();
    }

    public Ticket saveTicket(Ticket ticket) {
        ticket.setId(previousCounter++);
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }
}
