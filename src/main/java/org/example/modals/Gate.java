package org.example.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gate extends BaseModel{

    private int gateNumber;

    private Operator operator;

     private GateType gateType;

     private ParkingLot parkingLot;

}
