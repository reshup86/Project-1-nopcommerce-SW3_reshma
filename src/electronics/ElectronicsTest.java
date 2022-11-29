package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        // 1.3 Verify the text “Cell phones”
        verifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        // 2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        // 2.3 Verify the text “Cell phones”
        verifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");
        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//h2/a[contains(text(),'Nokia Lumia 1020')]"));
        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");
        // 2.7 Verify the price “$349.00”
        verifyText(By.xpath("//span[@id='price-value-20']"), "$349.00");
        // 2.8 Change quantity to 2
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#product_enteredQuantity_20")).clear();
        sendTextToElement(By.cssSelector("#product_enteredQuantity_20"), "2");
        // 2.9 Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("#add-to-cart-button-20"));
        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        // 2.12 Verify the message "Shopping cart"
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        // 2.13 Verify the quantity is 2
        Thread.sleep(2000);
        //verifyText(By.xpath("//td[@class='quantity']/child::input"),"2");

        // 2.14 Verify the Total $698.00
        verifyText(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$698.00");
        // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // 2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        // 2.19 Verify the text “Register”
        verifyText(By.xpath("//h1[contains(text(),'Register')]"), "Register");
        // 2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Jane");
        sendTextToElement(By.id("LastName"), "Taylor");
        sendTextToElement(By.id("Email"), "jant64@gmail.com");
        sendTextToElement(By.id("Password"), "jant321");
        sendTextToElement(By.id("ConfirmPassword"), "jant321");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        //2.22 Verify the message “Your registration completed”
        verifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");
        // 2.23
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        // 2.24 Verify the text “Shopping cart”
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.26
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.27 Fill the Mandatory fields
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "1");
        selectByValueFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "49");
        sendTextToElement(By.id("BillingNewAddress_City"), "New York");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "A Park Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "10006");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "2056892");
        // 2.28
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        // 2.30 Click on "CONTINUE"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        // 2.31 Select Radio Button “Credit Card”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "visa");
        // 2.33
        Thread.sleep(3000);
        sendTextToElement(By.id("CardholderName"), "Jane Taylor");
        sendTextToElement(By.id("CardNumber"), "4222222222222");
        selectByValueFromDropDown(By.id("ExpireMonth"), "6");
        selectByValueFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "222");
        // 2.34
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.35
        verifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");
        // 2.36
        verifyText(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "2nd Day Air");
        // 2.37
        verifyText(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"), "$698.00");
        // 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        // 2.39 Verify the Text “Thank You”
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");
        // 2.40 Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");
        // 2.41 Click on "CONTINUE"
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        verifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Invalid URL", baseUrl,currentUrl);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
