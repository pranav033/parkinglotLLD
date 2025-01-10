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
public class ParkingFloor extends BaseModel{
    private int floorNo;
    private List<ParkingSlot> parkingSlots;
    private int availableSlots;
}
