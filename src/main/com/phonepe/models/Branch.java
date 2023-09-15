package main.com.phonepe.models;

import java.util.List;
import java.util.Map;

public class Branch {
    Map<VehicleType, List<Vehicle> > vehicleTypeToVehicleListMap;
    String branchName;

    public Branch(Map<VehicleType, List<Vehicle>> vehicleTypeToVehicleListMap, String branchName) {
        this.vehicleTypeToVehicleListMap = vehicleTypeToVehicleListMap;
        this.branchName = branchName;
    }

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public Map<VehicleType, List<Vehicle>> getVehicleTypeToVehicleListMap() {
        return vehicleTypeToVehicleListMap;
    }

    public void setVehicleTypeToVehicleListMap(Map<VehicleType, List<Vehicle>> vehicleTypeToVehicleListMap) {
        this.vehicleTypeToVehicleListMap = vehicleTypeToVehicleListMap;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
