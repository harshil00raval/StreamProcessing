package parkingLotManagement.parkingLot.parking;

import java.time.Duration;

public class DueCalculator {

    public static int dueCalculator(Duration duration, int[] hourlyRate, int[] dailyRate){
        long days  = duration.toDays();
        if(days <=0){
            long hours = duration.toHours();
            if(hours <=0){
                return hourlyRate[0];
            }
            else{
                return hourlyRate[(int)hours];
            }
        }
        return dailyRate[(int) days];

    }
}
