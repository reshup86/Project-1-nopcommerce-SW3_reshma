package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

//1. create class "TopMenuTest"

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    //1.2 This method should click on the menu whatever name is passed as parameter
    //concate with two paths

    public void selectMenu(String menu) {
        String mainmenu = menu.toLowerCase();
        String expression = "//a[@href ='/" + mainmenu + "']";
        driver.findElement(By.xpath(expression)).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Navigated successfully", currentUrl, baseUrl + menu);
    }

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /*1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
    select the Menu and click on it and verify the page navigation.*/

    @Test
    public void verifyPageNavigation() {
     // mouseHoverToElement(By.xpath("//a[@href='/computers']"));
        selectMenu("computers");
    }

    @After
    public void tearDown() {
        // closeBrowser();
    }
}