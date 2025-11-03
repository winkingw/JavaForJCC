package com.utgaming.jcc.System.EquipmentSystem.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEquipment extends Equipments{
    List<AdvancedEquipment> advancedEquipments;
}
