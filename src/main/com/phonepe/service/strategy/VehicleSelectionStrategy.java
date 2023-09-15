package main.com.phonepe.service.strategy;

import main.com.phonepe.models.Vehicle;
import main.com.phonepe.models.VehicleType;

public interface VehicleSelectionStrategy {
    public Vehicle getVehicleUsingStrategy(VehicleType vehicleType, int startTime, int EndTime);
}
