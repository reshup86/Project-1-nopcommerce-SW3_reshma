package utility;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by){
        WebElement clickElement = driver.findElement(by);
        clickElement.click();
        //driver.findElement(by).click();
    }
    //This method will send text on element
    public void sendTextToElement(By by, String text){
        WebElement textField = driver.findElement(by);
        textField.sendKeys(text);
        //driver.findElement(by).sendKeys(text);
    }
    //This method will get text from element
    public String getTextFromElement(By by){
        WebElement actualTextElement = driver.findElement(by);
        return actualTextElement.getText();
        //return driver.findElement(by).getText();
    }
    //Verify the message from elements
    public void verifyText(By by, String text) {
        String expectedMessage = text;
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);
    }
    //************************************** Alert Methods *****************************************//

    //This method will switch to alert
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    //This method will accept the alert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //This method will dismiss the alert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    //This method will get text from alert
    public String getTextFromAlert(){
        String alertText = driver.switchTo().alert().getText();
        return alertText;
    }
    //This method will send text to alert
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //************************************* Class Methods **********************************

    //This method will select options by visible text
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    //This method will select options by value
    public void selectByValueFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
    //This method will select options by Index number
    public void selectByIndexFromDropDown(By by, int indexNum){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNum);
    }
  /*  //This method will select contains text
    public void selectByContainsText(By by, String text){
        WebElement containsText = driver.findElement(by);
        Select select = new Select(containsText);
        select.getFirstSelectedOption().getText();
    }
     public void selectByContainsText(By by, String text){
        WebElement containsText = driver.findElement(by);
        Select select = new Select(containsText);
        select.getFirstSelectedOption();
    */


    //***************************** Action Class *************************************
    // This method will mouse hover on elements mouseHoverToElement(By by)
    public void mouseHoverToElement (By by){
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        actions.moveToElement(mouseHover).build().perform();
    }
    // mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick (By by){
        Actions actions = new Actions(driver);
        WebElement mouseClick = driver.findElement(by);
        actions.moveToElement(mouseClick).click().build().perform();
    }

    //***************************** Window Handle *************************************
}
