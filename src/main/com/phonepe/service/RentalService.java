package main.com.phonepe.service;

import main.com.phonepe.models.*;
import main.com.phonepe.repository.Repository;
import main.com.phonepe.service.strategy.VehicleSelectionStrategy;

import java.util.*;

public class RentalService {

    VehicleSelectionStrategy vehicleSelectionStrategy;

    Repository repository;

    public RentalService(VehicleSelectionStrategy vehicleSelectionStrategy, Repository repository) {
        this.vehicleSelectionStrategy = vehicleSelectionStrategy;
        this.repository = repository;
    }

    public VehicleSelectionStrategy getVehicleSelectionStrategy() {
        return vehicleSelectionStrategy;
    }

    public void setVehicleSelectionStrategy(VehicleSelectionStrategy vehicleSelectionStrategy) {
        this.vehicleSelectionStrategy = vehicleSelectionStrategy;
    }

    public void addBranch(String branchName) {
        repository.getBranchMap().put(branchName, new Branch(branchName));
    }

    public void allocatePrice(String vehicleId, VehicleType vehicleType, String branchName, int pricePerHour) {
        repository.getBranchMap().get(branchName).getVehicleTypeToVehicleListMap().get(vehicleType)
                .add(new Car(vehicleType, branchName, vehicleId, pricePerHour, false, Collections.emptyList()));
    }

    public void bookVehicle(VehicleType vehicleType, int startTime, int endTime) {
        Vehicle vehicleSelected = vehicleSelectionStrategy.getVehicleUsingStrategy(vehicleType, startTime, endTime);
        if(vehicleSelected instanceof Car){
            ((Car) vehicleSelected).getBookingSlotList().add(new BookingSlot(startTime, endTime));
        }
    }

    public void viewVehicleInventory(int startTime, int endTime) {
        Map<VehicleType, List<Vehicle> > availableVehicle = new HashMap<>();
        Map<VehicleType, List<Vehicle> > unavailableVehicle = new HashMap<>();

        for(Map.Entry<String, Branch> entry: repository.getBranchMap().entrySet()){
            Branch branch = entry.getValue();
            for(Map.Entry<VehicleType, List<Vehicle> > entry1: branch.getVehicleTypeToVehicleListMap().entrySet()){
                VehicleType vehicleType = entry1.getKey();
                List<Vehicle> vehicleList = entry1.getValue();
                for(Vehicle vehicle: vehicleList) {
                    if(vehicle instanceof Car){
                        boolean isAvailable = true;
                        for(BookingSlot bookingSlot: ((Car) vehicle).getBookingSlotList()) {
                            if(Math.min(bookingSlot.getEndTime(), endTime)-Math.max(bookingSlot.getStartTime(), startTime)>=0) {
                                isAvailable = false;
                                break;
                            }
                        }
                        if(isAvailable) {
                            if(availableVehicle.containsKey(vehicleType)) {
                                availableVehicle.get(vehicleType).add(vehicle);
                            } else{
                                availableVehicle.put(vehicleType, List.of(vehicle));
                            }
                        } else{
                            if(unavailableVehicle.containsKey(vehicleType)) {
                                unavailableVehicle.get(vehicleType).add(vehicle);
                            } else{
                                unavailableVehicle.put(vehicleType, List.of(vehicle));
                            }
                        }
                    }
                }
            }
        }
        System.out.println("availableVehicles");
        for(Map.Entry<VehicleType, List<Vehicle> > entry: availableVehicle.entrySet()) {
            System.out.println("Vehicle type "+ entry.getKey());
            for(Vehicle vehicle: entry.getValue()){
                if(vehicle instanceof Car) {
                    System.out.println(((Car) vehicle).getVehicleId());
                }
            }
        }

        System.out.println("unAvailableVehicles");
        for(Map.Entry<VehicleType, List<Vehicle> > entry: unavailableVehicle.entrySet()) {
            System.out.println("Vehicle type "+ entry.getKey());
            for(Vehicle vehicle: entry.getValue()){
                if(vehicle instanceof Car) {
                    System.out.println(((Car) vehicle).getVehicleId());
                }
            }
        }
    }
}
