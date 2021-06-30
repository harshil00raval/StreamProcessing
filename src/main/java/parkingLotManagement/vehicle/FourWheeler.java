package parkingLotManagement.vehicle;

public class FourWheeler implements Vehicle{

    private final String vehicleNumber;
    private final VehicleType type;

    public FourWheeler(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
        this.type = VehicleType.Four;
    }
}
