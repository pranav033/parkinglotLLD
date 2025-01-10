package org.example.strategies;

import org.example.modals.ParkingLot;
import org.example.modals.ParkingSlot;
import org.example.modals.Vehicle;

public interface SpotAllocationStrategy {

    ParkingSlot getParkingSlot(Vehicle vehicle, ParkingLot parkingLot);
}
