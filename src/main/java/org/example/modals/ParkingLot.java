package org.example.modals;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot extends BaseModel{


    List<ParkingFloor> parkingFloors;
    List<Gate> gates;
    List<VehicleType> vehicleTypes;
    String name;
}
