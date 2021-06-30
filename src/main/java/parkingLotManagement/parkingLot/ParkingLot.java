package parkingLotManagement.parkingLot;

import javaslang.control.Option;
import parkingLotManagement.parkingLot.parking.Parking;
import parkingLotManagement.parkingLot.parking.ParkingCreator;
import parkingLotManagement.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private final int twCapacity;
    private final int fwCapacity;
    private final int[] twHourlyRate;
    private final int[] fwHourlyRate;
    private final int[] twDailyRate;
    private final int[] fwDailyRate;
    private final int parkingLotId;

    private int available2wCapacity;
    private int available4wCapacity;

    Map<String, Parking> activeTWParking = new HashMap<>();
    Map<String, Parking> activeFWParking = new HashMap<>();

    Map<String, List<Parking>> historicalTWParking = new HashMap<>();
    Map<String, List<Parking>> historicalFWParking = new HashMap<>();

    public ParkingLot(int twCapacity, int fwCapacity,
            int[] twHourlyRate, int[] fwHourlyRate,
            int[] twDailyRate, int[] fwDailyRate,
            int parkingLotId){
        this.twCapacity = twCapacity;
        this.fwCapacity = fwCapacity;
        this.twHourlyRate = twHourlyRate;
        this.fwHourlyRate = fwHourlyRate;
        this.twDailyRate = twDailyRate;
        this.fwDailyRate = fwDailyRate;
        this.parkingLotId = parkingLotId;

        setupCurrentCapacity();
    }

    private void setupCurrentCapacity(){
        available2wCapacity = this.twCapacity;
        available4wCapacity = this.fwCapacity;
    }

    public boolean park(String vehicleNo, String type){
        VehicleType vehicleType = "2W".equals(type) ? VehicleType.Two : VehicleType.Four;
        if(isAvailable(vehicleType)){
            Parking parking = ParkingCreator.createParking(vehicleNo, vehicleType, this.parkingLotId);
            updateCapacity(vehicleType, true);
            updateCurrentBooking(vehicleNo, vehicleType, true, Option.of(parking));
            return true;
        }
        return false;
    }

    public int exit(String vehicleNumber, String type){
        VehicleType vehicleType = "2W".equals(type) ? VehicleType.Two : VehicleType.Four;
        Parking parking = getParking(vehicleNumber, vehicleType);
        updateCurrentBooking(vehicleNumber, vehicleType, false, Option.none());
        updateCapacity(vehicleType, false);
        if(vehicleType == VehicleType.Two){
            return parking.calculateDue(twHourlyRate, twDailyRate);
        }
        return parking.calculateDue(fwHourlyRate, fwDailyRate);
    }

    public List<Parking> history(String vehicleNumber){
        if(historicalTWParking.containsKey(vehicleNumber))
            return historicalTWParking.get(vehicleNumber);
        else if(historicalFWParking.containsKey(vehicleNumber))
            return historicalFWParking.get(vehicleNumber);
        return new ArrayList<>();
    }

    private boolean isAvailable(VehicleType type){
        if(type == VehicleType.Two){
            return available2wCapacity>0;
        }
        return available4wCapacity>0;
    }

    private void updateCapacity(VehicleType type, boolean decrease){
        if(type == VehicleType.Two){
            if (decrease) {
                --available2wCapacity;
            } else {
                ++available2wCapacity;
            }
        }
        else{
            if (decrease) {
                --available4wCapacity;
            } else {
                ++available4wCapacity;
            }
        }
    }

    private void updateCurrentBooking(String vehicleNumber, VehicleType type,
            boolean isNew, Option<Parking> parking){
        if(type == VehicleType.Two){
            if(isNew) {
                activeTWParking.put(vehicleNumber, parking.get());
            }
            else{
                historicalTWParking.computeIfAbsent(vehicleNumber,
                        k -> new ArrayList<>()).add(activeTWParking.remove(vehicleNumber));
            }

        }
        else{
            if(isNew) {
                activeFWParking.put(vehicleNumber, parking.get());
            }
            else{
                historicalFWParking.computeIfAbsent(vehicleNumber,
                        k -> new ArrayList<>()).add(activeFWParking.remove(vehicleNumber));
            }
        }
    }

    private Parking getParking(String vehicleNumber, VehicleType type){
        if(type == VehicleType.Two)
            return activeTWParking.get(vehicleNumber);
        return activeFWParking.get(vehicleNumber);
    }
}
