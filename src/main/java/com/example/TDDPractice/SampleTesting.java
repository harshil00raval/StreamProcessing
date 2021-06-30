package com.example.TDDPractice;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class SampleTesting {

    public static void main(String[] args) {
//        String s = "ab+ef";
//
//        String str[] = s.split("\\+");
//
//        String st1[] = s.split(",");
//
//        Arrays.stream(str).forEach(sl -> System.out.println(sl));
//        Arrays.stream(st1).forEach(sl -> System.out.println(sl));
//
//        String st2[] = s.split("a");
//
//        Arrays.stream(st2).forEach(sl -> System.out.println(sl));

        String emails1[] = {};
        Assert.assertEquals(0,numUniqueEmails(emails1));

        String emails2[] = {"test.email+alex@leetcode.com"};
        Assert.assertEquals(1,numUniqueEmails(emails2));

        String emails3[] = {"test.email+alex@leetcode.com", "test@leetcode.com"};
        Assert.assertEquals(2,numUniqueEmails(emails3));

//        String emails8[] = {"abc@abv@leetcode.com"};
//        Assert.assertEquals(0,numUniqueEmails(emails8));

        String emails4[] = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        Assert.assertEquals(1,numUniqueEmails(emails4));

        String emails5[] = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Assert.assertEquals(2,numUniqueEmails(emails5));

        String emails6[] = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        Assert.assertEquals(3,numUniqueEmails(emails6));

        String emails7[] = {"@leetcode.com"};
        Assert.assertEquals(0,numUniqueEmails(emails7));
    }

    private static boolean validEmail(String email){
        if(email.charAt(0) == '+' || email.charAt(0) == '@' || email.charAt(email.length()-1) == '@' )
            return false;
        return true;
    }

    public static int numUniqueEmails(String[] emails){
        Set<String> uniqueEmails = new HashSet<>();
        for(String addr : emails){
            StringBuilder sbr = new StringBuilder();
            for(int i=0; i< addr.length(); ++i){
                char c = addr.charAt(i);{
                    if(c != '.' && c!= '+' && c != '@'){
                        sbr.append(c);
                    }
                    if(c=='+'){
                        sbr.append(addr.substring(addr.indexOf('@')));
                        break;
                    }
                    if(c=='@'){
                        sbr.append(addr.substring(i));
                        break;
                    }
                }
            }
            uniqueEmails.add(sbr.toString());
        }
        return uniqueEmails.size();
    }

    public static int numUniqueEmails1(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for(String addr : emails){
            String str[] = addr.split("@");
            if(validEmail(addr) && str.length  == 2){
                String strName[] = str[0].split("\\+");

                String finalName = strName.length > 0 ? strName[0].replaceAll("\\.","") : str[0].replaceAll("\\.", "");

                uniqueEmails.add(finalName+"@"+str[1]);
            }
        }
        return uniqueEmails.size();
    }
}
