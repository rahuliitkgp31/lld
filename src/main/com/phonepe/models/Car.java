package main.com.phonepe.models;

import java.util.List;

public class Car implements Vehicle {
    VehicleType carType;
    String branchName;
    String vehicleId;
    int pricePerHour;
    boolean isBooked;
    List<BookingSlot> bookingSlotList;

    public Car(VehicleType carType, String branchName, String vehicleId, int pricePerHour, boolean isBooked, List<BookingSlot> bookingSlotList) {
        this.carType = carType;
        this.branchName = branchName;
        this.vehicleId = vehicleId;
        this.pricePerHour = pricePerHour;
        this.isBooked = isBooked;
        this.bookingSlotList = bookingSlotList;
    }

    public VehicleType getCarType() {
        return carType;
    }

    public void setCarType(VehicleType carType) {
        this.carType = carType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public List<BookingSlot> getBookingSlotList() {
        return bookingSlotList;
    }

    public void setBookingSlotList(List<BookingSlot> bookingSlotList) {
        this.bookingSlotList = bookingSlotList;
    }
}
