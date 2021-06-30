package com.example.testTesco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
* 3200 stores
* each store has 800 + colleague
* department store
* colleagues can work in multiple dept
*
* shifts for colleague (schedule for all colleagues)
*
* [10:17] K, Santhosh Kumar

Bakery 8-10
Checkout 10-12
Diary dept - 14 19
*
* Shift timings 8-12, 14-19
*
* (Any multiple of the 15 minutes)
* (end tie of first shft and start time of next shift must be overlapp to merge the shifts)
* Data validation ? : no
* Data is coming for only 1 day
*
* Bakery 8-10
* Checkout 9-12   =>
Shift timings 8-12, 14-19

*
* */
public class TestDriver {

    public static void main(String[] args) {
        List<List<Integer>> shiftsA  = new ArrayList<>();
        List<Integer> shift1 = Arrays.asList(8,10);
        List<Integer> shift2 = Arrays.asList(10,12);
        List<Integer> shift3 = Arrays.asList(14,19);
        List<Integer> shift4 = Arrays.asList(18,22);

        shiftsA.add(shift1);
        shiftsA.add(shift2);
        shiftsA.add(shift3);
        shiftsA.add(shift4);

        List<List<Integer>> mergedShifts = mergeShifts(shiftsA);

        System.out.println(mergedShifts);


        //no Overlapp
        List<List<Integer>> shiftsB  = new ArrayList<>();
        List<Integer> shift1b = Arrays.asList(8,9);
        List<Integer> shift2b = Arrays.asList(10,11);
        List<Integer> shift3b = Arrays.asList(12,13);
        List<Integer> shift4b = Arrays.asList(18,22);

        shiftsB.add(shift1b);
        shiftsB.add(shift2b);
        shiftsB.add(shift3b);
        shiftsB.add(shift4b);

        List<List<Integer>> mergedShiftsb = mergeShifts(shiftsB);

        System.out.println(mergedShiftsb);


        List<List<Integer>> shiftsC  = new ArrayList<>();
        List<Integer> shift1c = Arrays.asList(8,23);
        shiftsC.add(shift1c);

        List<List<Integer>> mergedShiftsc = mergeShifts(shiftsC);

        System.out.println(mergedShiftsc);


        List<List<Integer>> shiftsD  = new ArrayList<>();
        List<Integer> shift1d = Arrays.asList(8,23);
        List<Integer> shift2d = Arrays.asList(8,12);
        shiftsD.add(shift1d);
        shiftsD.add(shift2d);

        List<List<Integer>> mergedShiftsd = mergeShifts(shiftsD);

        System.out.println(mergedShiftsd);

        List<List<Integer>> shiftsE  = new ArrayList<>();

        List<List<Integer>> mergedShiftse = mergeShifts(shiftsE);

        System.out.println(mergedShiftse);

        List<List<Integer>> shiftsF  = new ArrayList<>();
        List<Integer> shift1f = Arrays.asList(8,8);
        shiftsC.add(shift1f);

        List<List<Integer>> mergedShiftsf = mergeShifts(shiftsF);

        System.out.println(mergedShiftsf);


    }


    public static List<List<Integer>> mergeShifts(List<List<Integer>> shifts){

        int slots[] = new int[24];

        if(Objects.isNull(shifts) || shifts.isEmpty()){
            return new ArrayList<>();
        }

        for(List<Integer> shift : shifts){
            int start = shift.get(0);
            int end = shift.get(1);
            slots[start] = 1;

            for(int i=start; i<end ;++i){
                slots[i] = 1;
            }
        }

        List<List<Integer>> mergedShifts = new ArrayList<>();
        for(int i=0;i<slots.length;){
            int start = i;
            int end = i;
            for(int j=i;j<slots.length;++j){

                if(slots[j] == 1){
                    end = j;
                }
                else{
                    i = j+1;
                    break;
                }
            }

            if(slots[start] == 1){
                List<Integer> shift = new ArrayList<>();
                shift.add(start);
                shift.add(end+1);
                mergedShifts.add(shift);
            }
        }

        return mergedShifts;
    }

}
