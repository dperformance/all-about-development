package com.dev.java.testtr;

public enum PoiStatus {
    AVAILABLE("Available"),         // The Evse/Connector is able to start a new charging session.
    BLOCKED("Blocked"),              // The Evse/Connector is not accessible because of a physical barrier, i.e. a car.
    CHARGING("Charging"),           // The Evse/Connector is in use.
    INOPERATIVE("Inoperative"),     // The Evse/Connector is not yet active or it is no longer available (deleted).
    OUTOFORDER("Out of order"),     // The Evse/Connector is currently out of order.
    PLANNED("Planned"),             // The Evse/Connector is planned, will be operating soon
    REMOVED("Removed"),             // The Evse/Connector/charge point is discontinued/removed.
    RESERVED("Reserved"),           // The Evse/Connector is reserved for a particular EV driver and is unavailable for other drivers.
    UNKNOWN("Unknown"),             // No status information available. (Also used when offline)
    CLOSED("Closed"),
    RESTED("Rested");

    private String label;

    PoiStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
