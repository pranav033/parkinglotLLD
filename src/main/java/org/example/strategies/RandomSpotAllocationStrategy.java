package org.example.strategies;

import org.example.modals.*;

import java.util.Optional;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSlot getParkingSlot(Vehicle vehicle, ParkingLot parkingLot) {
        for(ParkingFloor floor : parkingLot.getParkingFloors())
        {
            Optional<ParkingSlot> parkingSlot = floor.getParkingSlots().stream().filter(slot -> slot.getParkingSpotStatus().equals(ParkingSpotStatus.FREE) && slot.getVehicleTypes().contains(vehicle.getVehicleType())).findFirst();
            if(parkingSlot.isPresent()) return parkingSlot.get();
        }
        return null;
    }
}
