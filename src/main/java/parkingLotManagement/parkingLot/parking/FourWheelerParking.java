package parkingLotManagement.parkingLot.parking;

import lombok.SneakyThrows;
import parkingLotManagement.vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class FourWheelerParking implements Parking{

    private final VehicleType type;
    private final LocalDateTime startTime;
    private int totalDue;
    private final int parkingLotId;

    public FourWheelerParking(LocalDateTime startTime, int parkingLotId){
        this.type = VehicleType.Four;
        this.startTime = startTime;
        this.parkingLotId = parkingLotId;
    }

    @Override public int calculateDue(int[] hourlyRate, int[] dailyRate) {
        LocalDateTime endTime = LocalDateTime.now();

        Duration d = Duration.between(this.startTime, endTime);

        return DueCalculator.dueCalculator(d, hourlyRate, dailyRate);
    }

//    @SneakyThrows public static void main(String[] args) {
//        LocalDateTime s = LocalDateTime.now();
//        Thread.sleep(2000);
//        LocalDateTime e = LocalDateTime.now();
//
//        Duration d = Duration.between(s,e);
//        System.out.println(d.getSeconds());
//        System.out.println(d.toDays());
//        System.out.println(d.toHours());
//    }
}
