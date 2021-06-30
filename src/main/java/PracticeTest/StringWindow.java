package PracticeTest;

import java.util.Objects;

public class StringWindow {

    // function to give max size window without repeating characters
    // Assume only capitol letters
    // A = 65
    public Integer longestNonRepeatingCharSeqInString(String str){
        if(Objects.isNull(str) || str.length() == 0)
            return 0;
        if(str.length() == 1)
            return 1;


        char charStr[] = str.toCharArray();

        int arr[] = new int[26];
        for(int i=0 ; i< 26;i++)
            arr[i] = -1;

        int s=0;
        int e=0;
        int maxlength =0;
        int length = 0 ;
        while (s<str.length()){
            int t = arr[charStr[s]-65];
            if(t==-1){
                arr[charStr[s]-65] = s;
            }

            if(t != -1 && e!=s){
                e = t+1;
            }

            length = s-e+1;
            maxlength = length >maxlength ? length : maxlength;

            ++s;
        }

        return maxlength;

    }

    public String printLongestNonRepeatingCharSeqInString(String str){
        if(Objects.isNull(str) || str.length() == 0)
            return "";
        if(str.length() == 1)
            return str;


        char charStr[] = str.toCharArray();

        int arr[] = new int[26];
        for(int i=0 ; i< 26;i++)
            arr[i] = -1;

        int s=0;
        int e=0;
        int maxlength =0;
        int length = 0 ;

        int ms = 0;
        int me = 0;
        while (s<str.length()){
            int t = arr[charStr[s]-65];
            if(t==-1){
                arr[charStr[s]-65] = s;
            }

            if(t != -1 && e!=s){
                e = t+1;
            }

            length = s-e+1;
            if(length >maxlength){
                maxlength = length;
                ms = s;
                me = e;
            }

            ++s;
        }

        return str.substring(me,ms+1);

    }
}
