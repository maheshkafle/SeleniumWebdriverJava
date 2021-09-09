package TestNg;

import org.testng.annotations.Test;

public class InvocationCountTest {

    // Famous Interview Question: How will you execute this method n no. of times
    // Answer: using "invocationCount" keyword
    @Test(invocationCount=10)
    public void Sum(){
        int i = 8;
        int j = 10;
        System.out.println(i+j);
    }

}
