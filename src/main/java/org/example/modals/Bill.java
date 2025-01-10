package org.example.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill extends BaseModel{

    private Ticket ticket;
    private Double amount;
    private Gate gate;
    private Operator operator;
}
