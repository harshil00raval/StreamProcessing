package PracticeTest;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringWindowTest {

    StringWindow stringWindow;

    public StringWindowTest(){
//        System.out.println(Integer.valueOf('A'));
        stringWindow = new StringWindow();
    }

    @Test
    public void lengthOfLargestNonRepeatingSeq1(){
        assertEquals(3,stringWindow.longestNonRepeatingCharSeqInString("TEST"));
    }

    @Test
    public void lengthOfLargestNonRepeatingSeq2(){
        assertEquals(0,stringWindow.longestNonRepeatingCharSeqInString(""));
    }


    @Test
    public void lengthOfLargestNonRepeatingSeq3(){
        assertEquals(0,stringWindow.longestNonRepeatingCharSeqInString(null));
    }

    @Test
    public void lengthOfLargestNonRepeatingSeq4(){
        assertEquals(1,stringWindow.longestNonRepeatingCharSeqInString("A"));
    }

    @Test
    public void lengthOfLargestNonRepeatingSeq5(){
        assertEquals(6,stringWindow.longestNonRepeatingCharSeqInString("ABDEFGABEF"));
    }


    @Test
    public void printLongestNonRepeatingCharSeqInString1(){
        assertEquals("TES",stringWindow.printLongestNonRepeatingCharSeqInString("TEST"));
    }

    @Test
    public void printLongestNonRepeatingCharSeqInString2(){
        assertEquals("",stringWindow.printLongestNonRepeatingCharSeqInString(""));
    }


    @Test
    public void printLongestNonRepeatingCharSeqInString3(){
        assertEquals("",stringWindow.printLongestNonRepeatingCharSeqInString(null));
    }

    @Test
    public void printLongestNonRepeatingCharSeqInString4(){
        assertEquals("A",stringWindow.printLongestNonRepeatingCharSeqInString("A"));
    }

    @Test
    public void printLongestNonRepeatingCharSeqInString5(){
        assertEquals("ABDEFG",stringWindow.printLongestNonRepeatingCharSeqInString("ABDEFGABEF"));
    }

}
