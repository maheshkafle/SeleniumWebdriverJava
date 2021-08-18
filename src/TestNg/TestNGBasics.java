package TestNg;

import org.testng.annotations.*;

public class TestNGBasics {

    //TestNG annotations
    @BeforeSuite
    public void setup(){
        System.out.println("BeforeSuite--->");
    }

    @BeforeTest
    public void launchbrowser(){
        System.out.println("BeforeTest-->>");
    }

    @BeforeClass
    public void login(){
        System.out.println("BeforeClass-->>");
    }

    @BeforeMethod
    public void enterUrl(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void googleTestTitle(){
        System.out.println("Test");
    }

    @AfterTest
    public void deleteAllCookies(){
        System.out.println("AfterTest");
    }

    @AfterClass
    public void closeBrowser(){
        System.out.println("AfterClass");
    }

    @AfterSuite
    public void generateTestReport(){
        System.out.println("AfterSuite");
    }
}
