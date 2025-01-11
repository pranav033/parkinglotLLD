package org.example;

import org.example.controller.TicketController;
import org.example.dtos.TicketRequestDto;
import org.example.modals.*;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;
import org.example.services.TicketService;
import org.example.strategies.RandomSpotAllocationStrategy;
import org.example.strategies.SpotAllocationStrategy;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SpotAllocationStrategy spotAllocationStrategy = new RandomSpotAllocationStrategy();

        TicketService ticketService = new TicketService(ticketRepository,gateRepository,vehicleRepository,parkingLotRepository,spotAllocationStrategy);

        TicketController ticketController = new TicketController(ticketService);

        TicketRequestDto ticketRequestDto = new TicketRequestDto();
        Vehicle v1 = new Vehicle();
        v1.setId(1);
        v1.setRegistrationNumber(1122);
        v1.setVehicleType(VehicleType.SUV);
        Optional<Gate> gateOptional = gateRepository.findGateById(1);
        Gate gate = gateOptional.get();
        ticketRequestDto.setVehicle(v1);
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotById(1);
        ParkingLot parkingLot = parkingLotOptional.get();
        ticketRequestDto.setGate(gate);
        ticketRequestDto.setParkingLotId(parkingLot.getId());
        Ticket ticket = ticketController.generateTicket(ticketRequestDto);
        System.out.println("Slot number --> "+ticket.getParkingSlot().getSlotNumber());


        TicketRequestDto ticketRequestDto1 = new TicketRequestDto();
        Vehicle v2 = new Vehicle();
        v2.setId(2);
        v2.setRegistrationNumber(2233);
        v2.setVehicleType(VehicleType.HATCHBACK);
        Optional<Gate> gateOptional1 = gateRepository.findGateById(1);
        Gate gate1 = gateOptional.get();
        ticketRequestDto.setVehicle(v2);
        Optional<ParkingLot> parkingLotOptional1 = parkingLotRepository.getParkingLotById(1);
        ParkingLot parkingLot1 = parkingLotOptional1.get();
        ticketRequestDto.setGate(gate1);
        ticketRequestDto.setParkingLotId(parkingLot1.getId());
        Ticket ticket1 = ticketController.generateTicket(ticketRequestDto);
        System.out.println("Slot number --> "+ticket1.getParkingSlot().getSlotNumber());



    }
}
