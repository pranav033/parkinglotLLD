package org.example.modals;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BaseModel{

    private int registrationNumber;

    private VehicleType vehicleType;
}
