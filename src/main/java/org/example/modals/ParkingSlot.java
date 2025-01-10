package org.example.modals;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlot extends BaseModel{
    private int slotNumber;
    private Vehicle vehicle;

    ParkingFloor parkingFloor;

    private ParkingSpotStatus parkingSpotStatus;

    private List<VehicleType> vehicleTypes;
}
