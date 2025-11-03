package com.utgaming.jcc.Service;

import com.utgaming.jcc.System.EquipmentSystem.entity.Equipments;

import java.util.List;

public interface EquipService {
    List<Equipments> getEquipments(String userId);
}
