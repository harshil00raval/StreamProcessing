package parkingLotManagement.registry;

import parkingLotManagement.parkingLot.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRegistry {

    static Map<Integer, ParkingLot> parkingLotRegistry = new HashMap<>();

    public static boolean registerParkingLot(int twCapacity, int fwCapacity,
            int[] twHourlyRate, int[] fwHourlyRate,
            int[] twDailyRate, int[] fwDailyRate){

        int id = parkingLotRegistry.size();

        ParkingLot parkingLot = new ParkingLot(twCapacity, fwCapacity,
                twHourlyRate, fwHourlyRate,
                twDailyRate, fwDailyRate,
                ++id );

        parkingLotRegistry.put(id, parkingLot);

        return true;
    }
}
