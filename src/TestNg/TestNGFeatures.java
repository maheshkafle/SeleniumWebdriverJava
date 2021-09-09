package TestNg;

import org.testng.annotations.Test;

public class TestNGFeatures {

    @Test
    public void loginTest(){
        System.out.println("Login Test Method");
        // int i = 9/0; // for negative test scenario where loginTest method fails
    }

    @Test(dependsOnMethods="loginTest")
    public void HomePageTest(){
        System.out.println("HomePage Test Method");
    }

    @Test(dependsOnMethods="loginTest")
    public void SearchPageTest(){
        System.out.println("SearchPage Test Method");
    }

}
