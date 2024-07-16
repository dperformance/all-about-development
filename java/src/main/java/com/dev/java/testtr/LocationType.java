package com.dev.java.testtr;

public enum LocationType {
    ON_STREET, // Parking in public space.  // S15001, 15004
    PARKING_GARAGE, // Multi storey car park.   // S15005, S15009
    UNDERGROUND_GARAGE, // Multi storey car park, mainly underground.
    PARKING_LOT, // A cleared area that is intended for parking vehicles, i.e. at super markets, bars, etc.
    OTHER, // None of the given possibilities.
    UNKNOWN //Parking location type is not known by the operator (default).
}
