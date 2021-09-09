package TestNg;

import org.testng.annotations.Test;

public class ExceptionTimeoutTest {

    // Famous Interview Question
    // WHen some infiniteLoop occurs
    // then we can use invocationTimeOut keyword
    // to run that test for timeout miliseconds and end the execution of that test
    @Test(invocationTimeOut = 2000)
    public void infinityLoop(){
        int i=1;
        while (i==1){
            System.out.println(i);
        }
    }

    // Famous Interview QUestion: How will you handle exceptions in TestNg without using try catch block
    // Answer: Using expectedExceptions keyword, after that this will consider that test case as passed
    @Test(expectedExceptions = NumberFormatException.class)
    public void test1(){
        String x="100A";
        Integer.parseInt(x);
    }

}
