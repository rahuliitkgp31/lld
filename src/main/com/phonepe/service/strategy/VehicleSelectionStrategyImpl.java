package main.com.phonepe.service.strategy;

import main.com.phonepe.models.Branch;
import main.com.phonepe.models.Car;
import main.com.phonepe.models.Vehicle;
import main.com.phonepe.models.VehicleType;
import main.com.phonepe.repository.Repository;
import java.util.List;
import java.util.Map;

public class VehicleSelectionStrategyImpl implements VehicleSelectionStrategy {
    private final Repository repository;

    public VehicleSelectionStrategyImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle getVehicleUsingStrategy(VehicleType vehicleType, int startTime, int EndTime) {
        Vehicle selectedVehicle=null;
        int minPriceVehicle = Integer.MAX_VALUE;
        for(Map.Entry<String, Branch> entry: repository.getBranchMap().entrySet()) {
            Branch branch = entry.getValue();
            for(Map.Entry<VehicleType, List<Vehicle>> entry1: branch.getVehicleTypeToVehicleListMap().entrySet()) {
                for(Vehicle vehicle: entry1.getValue()) {
                    if(vehicle instanceof Car){
                        if(((Car) vehicle).getCarType()==vehicleType) {
                            if(((Car) vehicle).getPricePerHour()<minPriceVehicle) {
                                minPriceVehicle = ((Car) vehicle).getPricePerHour();
                                selectedVehicle = vehicle;
                            }
                        }
                    }
                }
            }
        }
        return selectedVehicle;
    }
}
