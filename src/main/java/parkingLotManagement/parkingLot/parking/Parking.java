package parkingLotManagement.parkingLot.parking;

public interface Parking {
    int calculateDue(int[] hourlyRate, int[] dailyRate);
}
