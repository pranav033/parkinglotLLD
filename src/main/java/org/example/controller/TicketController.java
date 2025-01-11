package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dtos.TicketRequestDto;
import org.example.modals.*;
import org.example.services.TicketService;
import org.example.strategies.RandomSpotAllocationStrategy;
import org.example.strategies.SpotAllocationStrategy;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;


    public Ticket generateTicket(TicketRequestDto ticketRequestDto)
    {
        //1. spot allocation strategy to get a slot.
        //2. update slot details.
        ///3. create ticket with details
        if(ticketRequestDto.getGate() == null) throw new IllegalArgumentException("Gate is null");
        return ticketService.issueTicket(ticketRequestDto.getVehicle(),ticketRequestDto.getGate().getId(),ticketRequestDto.getParkingLotId());

    }
}
