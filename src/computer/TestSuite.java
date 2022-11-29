package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

//1. Create class “TestSuite”
public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Click on Computer Menu
        clickOnElement(By.linkText("Computers"));
        //1.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByValueFromDropDown(By.id("products-orderby"), "6");

        //1.4 Verify the Product will arrange in Descending order.
        String expectedData = getTextFromElement(By.xpath(""));
        String actualData = getTextFromElement(By.xpath(""));

        //Assert.assertEquals("No matched data",By.xpath("//select[@id='products-orderby']"),By.xpath("//option[contains(text(),'Name: Z to A')]"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu
        clickOnElement(By.linkText("Computers"));
        //2.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.id("products-orderby"), "5");

        //2.4 Click on "Add To Cart"
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropDown(By.id("product_attribute_1"), "1");

        //2.7.Select "8GB [+$60.00]" using Select class
        selectByValueFromDropDown(By.id("product_attribute_2"), "5");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//li/input[@id='product_attribute_3_7']"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//li/input[@id='product_attribute_4_9']"));

        //2.10Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        driver.findElement(By.xpath("//input[@id='product_attribute_5_10']")).findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
        //clickOnElement(By.xpath("//li/input[@id='product_attribute_5_12']"));

        //2.11Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]"));
        Assert.assertEquals("No price matched", expectedPrice, actualPrice);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.cssSelector("#add-to-cart-button-1"));

        //2.13Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button
        String expectedText = "The product has been added to your shopping cart";
        String actualText = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Invalid data", expectedText, actualText);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.16Change the Qty to "2" and Click on "Update shopping cart"
        WebElement qty = driver.findElement(By.xpath("//td[@class='quantity']/child::input"));
        qty.clear();
        qty.sendKeys("2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17Verify the Total"$2,950.00"
        Thread.sleep(3000);
        verifyText(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$2,950.00");

        //2.18click on checkbox “I agree with the terms of service”
        Thread.sleep(5000);
        clickOnElement(By.id("termsofservice"));

        //2.19Click on “CHECKOUT”
        Thread.sleep(3000);
        clickOnElement(By.id("checkout"));

        //2.20Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22Fill the all mandatory field
        Thread.sleep(2000);
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Red"); //Enter first name
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Rose"); //Enter Last name
        sendTextToElement(By.id("BillingNewAddress_Email"), "redrose@gmail.com"); //Enter Email

        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "1");
        selectByValueFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "49");
        sendTextToElement(By.id("BillingNewAddress_City"), "New York");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "13 Kew Park");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "10005");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "101010101");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[1]/button[4]"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.25Click on “CONTINUE”
        clickOnElement(By.xpath("//form[1]/div[2]/button[1]"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));

        clickOnElement(By.xpath("//ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "MasterCard");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Red Rose");
        sendTextToElement(By.id("CardNumber"), "99922 22583 46663 6236");

        selectByValueFromDropDown(By.id("ExpireMonth"), "3");
        selectByValueFromDropDown(By.id("ExpireYear"), "2027");

        sendTextToElement(By.id("CardCode"), "3001");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");
        //2.32
        verifyText(By.xpath("//div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "Next Day Air");
        //2.33
        verifyText(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"), "$2,950.00");

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.35 Verify the Text “Thank You”
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
