package parkingLotManagement.parkingLot.parking;

import parkingLotManagement.vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class TwoWheelerParking implements Parking{

    private final VehicleType type;
    private final LocalDateTime startTime;
    private int totalDue;
    private final int parkingLotId;

    public TwoWheelerParking(LocalDateTime startTime, int parkingLotId){
        this.type = VehicleType.Two;
        this.startTime = startTime;
        this.parkingLotId = parkingLotId;
    }

    @Override public int calculateDue(int[] hourlyRate, int[] dailyRate) {
        LocalDateTime endTime = LocalDateTime.now();

        Duration d = Duration.between(this.startTime, endTime);

        return DueCalculator.dueCalculator(d, hourlyRate, dailyRate);
    }
}
