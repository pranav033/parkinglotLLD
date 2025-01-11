package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.modals.Gate;
import org.example.modals.Vehicle;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDto {

    private Vehicle vehicle;
    private int parkingLotId;
    private Gate gate;


}
