package parkingLotManagement.vehicle;

public class TwoWheeler implements Vehicle{

    private final String vehicleNumber;
    private final VehicleType type;

    public TwoWheeler(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
        this.type = VehicleType.Two;
    }
}
