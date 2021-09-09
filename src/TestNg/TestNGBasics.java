package TestNg;

import org.testng.annotations.*;

public class TestNGBasics {

    //TestNG annotations: Interview Question
    // Order of Annotations
    // 1. BeforeSuite
    // 2. BeforeTest
    // 3. BeforeClass
    // 4. BeforeMethod
    // 5. Test
    // 6. After Method
    // 7. AfterClass
    // 8. AfterTest
    // 9. AfterSuite
    // We never use main() in TestNG project
    // Annotations starting with @Before keyword are Prerequisites Annotations
    // Annotations starting with @After keyword are Postrequisites Annotations
    // Annotations starting with @Test keyword are Test Cases
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

    @AfterMethod
    public void afterMethod(){ System.out.println("After Method"); }

    @AfterClass
    public void closeBrowser(){
        System.out.println("AfterClass");
    }

    @AfterTest
    public void deleteAllCookies(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void generateTestReport(){
        System.out.println("AfterSuite");
    }
}
