package org.example.modals;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket extends BaseModel{

    private Vehicle vehicle;
    private Operator operator;
    private Gate gate;
    private ParkingSlot parkingSlot;
    private Date entryTime;
}
