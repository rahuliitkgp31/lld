package main.com.phonepe.models;

public class BookingSlot {
    int startTime;
    int endTime;
    public BookingSlot(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
