package parkingLotManagement.parkingLot.parking;

import parkingLotManagement.vehicle.VehicleType;

import java.time.LocalDateTime;

public class ParkingCreator {

    public static Parking createParking(String vehicleNo, VehicleType type, int parkingLotId){
        if(type == VehicleType.Two)
            return new TwoWheelerParking(LocalDateTime.now(), parkingLotId);
        return new FourWheelerParking(LocalDateTime.now(), parkingLotId);
    }
}
