package Tests;

import PageObjects.BasePage;
import PageObjects.HomePage;
import org.junit.Before;
import org.junit.Test;

import static Tests.LoginTest.loginToBuyMe_Test_01;

public class HomeTest extends BaseTest{
    @Before
    public void setUp() {
        driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();
    }

  //  @Test
  //  public void choosen() throws Exception {
        //loginTest.loginToBuyMe_Test_01();
        //BaseTest.choose(randomNum(7));
       // HomePage.select();
       // HomePage.click2();
        //basePage.selectByIndex(HomePage.combo,(randomNum(4)+1));
   // }
}
