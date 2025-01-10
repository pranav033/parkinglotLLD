package org.example.repositories;

import org.example.modals.Gate;
import org.example.modals.GateType;
import org.example.modals.Operator;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    Map<Integer, Gate> gates = new TreeMap<>();

    public GateRepository() {
        Gate g1 = new Gate();
        g1.setId(1);
        g1.setGateType(GateType.ENTRY);
        g1.setOperator(new Operator());
        gates.put(1, g1);
    }
    public Optional<Gate>findGateById(int id)
    {
        if(gates.containsKey(id)) return Optional.of(gates.get(id));
        return Optional.empty();
    }
}
