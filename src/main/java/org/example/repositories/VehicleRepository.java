package org.example.repositories;

import org.example.modals.Vehicle;
import org.example.modals.VehicleType;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    Map<Integer, Vehicle> vehicles = new TreeMap<>();
    private static int previousCount = 0;

    public Optional<Vehicle> findByVehicleId(int vehicleId) {
        if(vehicles.containsKey(vehicleId)) {
            return Optional.of(vehicles.get(vehicleId));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        previousCount++;
        vehicle.setId(previousCount);
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }
}
