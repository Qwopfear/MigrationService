package com.example.datamigration.entity.enums;

public enum Source {
    OLX,
    OTODOM;


    public static Source defineByPrefix(String prefix) {
        if (prefix.contains("olx"))
            return OLX;
        else
            return OTODOM;
    }
}
