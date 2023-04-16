package Flows;
import static Tests.HomeTest.checkCategory;
import static Tests.LoginTest.loginToBuyMe_Test_01;


public class HomeFlow {

    public static void HomeFlow() throws Exception {
        loginToBuyMe_Test_01();
        checkCategory();
    }

}
