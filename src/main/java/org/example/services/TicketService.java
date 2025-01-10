package org.example.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.exceptions.ResourceNotFoundException;
import org.example.modals.*;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;
import org.example.strategies.RandomSpotAllocationStrategy;
import org.example.strategies.SpotAllocationStrategy;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;


@AllArgsConstructor
public class TicketService {


    private TicketRepository ticketRepository;
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private SpotAllocationStrategy spotAllocationStrategy;

    public Ticket issueTicket(Vehicle vehicle, int gateId, int parkingLotId) {

        Optional<Gate> gate = gateRepository.findGateById(gateId);
        if(gate.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        Gate g = gate.get();
        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotById(parkingLotId);
        if(parkingLot.isEmpty())
        {
            throw new ResourceNotFoundException();
        }
        ParkingLot p = parkingLot.get();
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleId(vehicle.getId());
        Vehicle v = null;
        if(vehicleOptional.isEmpty())
        {
            v = new Vehicle();
            v.setVehicleType(VehicleType.SEDAN);
            v.setRegistrationNumber(1122);
            vehicleRepository.save(v);
        }
        ParkingSlot parkingSlot = spotAllocationStrategy.getParkingSlot(v, p);
        if(parkingSlot == null)
        {
            throw new ResourceNotFoundException();
        }
        parkingSlot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingSlot.setVehicle(v);
        Ticket ticket = new Ticket();
        ticket.setVehicle(v);
        ticket.setParkingSlot(parkingSlot);
        ticket.setGate(g);
        ticket.setEntryTime(Date.from(Instant.now()));
        ticket.setOperator(g.getOperator());
        ticketRepository.saveTicket(ticket);
        return ticket;

    }

}
