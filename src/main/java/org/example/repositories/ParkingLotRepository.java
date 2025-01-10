package org.example.repositories;

import org.example.modals.Gate;
import org.example.modals.ParkingFloor;
import org.example.modals.ParkingLot;
import org.example.modals.ParkingSlot;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    Map<Integer, ParkingLot> parkingLots = new TreeMap<>();

    public ParkingLotRepository() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingFloor parkingFloor1 = new ParkingFloor();
        ParkingFloor parkingFloor2 = new ParkingFloor();
        ParkingFloor parkingFloor3 = new ParkingFloor();
        parkingFloor1.setId(1);
        parkingFloor2.setId(2);
        parkingFloor3.setId(3);
        parkingFloor1.setFloorNo(1);
        parkingFloor2.setFloorNo(2);
        parkingFloor3.setFloorNo(3);
        parkingFloor1.setParkingSlots(List.of(new ParkingSlot(), new ParkingSlot()));
        parkingFloor2.setParkingSlots(List.of(new ParkingSlot()));
        parkingFloor3.setParkingSlots(List.of(new ParkingSlot()));
        parkingLot.setParkingFloors(List.of(parkingFloor1, parkingFloor2, parkingFloor3));
        parkingLot.setGates(List.of(new Gate(),new Gate()));
        parkingLots.put(1, parkingLot);
    }

    public Optional<ParkingLot> getParkingLotById(int id) {
        if(parkingLots.containsKey(id)) return Optional.of(parkingLots.get(id));
        return Optional.empty();
    }
}
