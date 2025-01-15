package com.example.datamigration.entity.vo;

import com.example.datamigration.entity.enums.RoomElementType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomElement {
    private String value;
    private RoomElementType type;
}
