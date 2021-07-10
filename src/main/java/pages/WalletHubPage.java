package pages;

import locators.WalletHubLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.CommonMethods;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WalletHubPage implements WalletHubLocators {

    private WebDriver driver;
    public CommonMethods commonMethods;
    WebDriverWait wait;
    Actions action;
    TouchActions touchActions;
    Robot robot;
    public WalletHubPage(WebDriver driver) throws AWTException {
        this.driver=driver;
        commonMethods= new CommonMethods();
        wait = new WebDriverWait(driver,30);
        action = new Actions(driver);
        robot = new Robot();
        touchActions=new TouchActions(driver);
    }

    public void clickOnLoginButtonOnHomePage(){
        WebElement elementLogin= driver.findElement(WalletHubLocators.loginButtonOnHomePage);
        commonMethods.clickOnButton(elementLogin);
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletHubLocators.loginHeader));

    }

    public void loginToWalletHub(String username,String password){
        WebElement elementPageHeader= driver.findElement(WalletHubLocators.loginHeader);
        WebElement elementEmail= driver.findElement(WalletHubLocators.loginEmailAddress);
        WebElement elementPassword= driver.findElement(WalletHubLocators.loginPassword);
        WebElement elementLoginButton= driver.findElement(WalletHubLocators.loginButton);
        if(elementPageHeader.isDisplayed()) {
            commonMethods.typeDataInField(elementEmail, username);
            commonMethods.typeDataInField(elementPassword, password);
            commonMethods.clickOnButton(elementLoginButton);

        }
        else{
            System.out.println("Login page is not displayed");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletHubLocators.walletHubProfile));
    }

    public void writeAReview(String reviewMessage,int stars,String policy){

        clickOnReviewsTabOnHomePage();
        reviewStarsForWalletHub(stars);
      //  verifyClickingOnBackButton();
        writeYourReviewMessage(reviewMessage);
        choosePolicyToReview(policy);
        clickOnSubmit();
        verifyReviewSubmissionConfirmation();

    }

    public void clickOnReviewsTabOnHomePage(){
        WebElement elementReviews=driver.findElement(WalletHubLocators.reviewsTab);
        commonMethods.clickOnButton(elementReviews);
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletHubLocators.reviewsSection));
    }

    public void reviewStarsForWalletHub(int stars) {
        WebElement elementReviewsSection = driver.findElement(WalletHubLocators.reviewsSection);
        if (elementReviewsSection.isDisplayed()) {
            elementReviewsSection.click();

            WebElement requiredStar = driver.findElement(By.xpath("//h3[contains(text(),'Your Rating')]/following-sibling::review-star//*[name()='svg']" + "[" + stars + "]"));

            action.moveToElement(requiredStar).click().perform();

            wait.until(ExpectedConditions.presenceOfElementLocated(WalletHubLocators.submitButton));
        } else {
            System.out.println("Reviews section is not showing up, you might have already reviewd this");
        }
    }


    public void writeYourReviewMessage(String reviewMessage){
        wait.until(ExpectedConditions.elementToBeClickable(WalletHubLocators.reviewTextBox));
        WebElement elementReviewTextBox= driver.findElement(WalletHubLocators.reviewTextBox);
        commonMethods.typeDataInField(elementReviewTextBox,reviewMessage);
    }

    public void choosePolicyToReview(String policy){
        WebElement elementSelectPolicy= driver.findElement(WalletHubLocators.policyDropdown);
        commonMethods.clickOnButton(elementSelectPolicy);

        List<WebElement> optionsList=driver.findElements(WalletHubLocators.policyOptions);
        for(WebElement option:optionsList){
            String optionToselect=option.getText();
            if(optionToselect.equalsIgnoreCase(policy)){
                option.click();
                break;
            }
            else {
                continue;
            }
        }

    }

    public void clickOnSubmit(){
        try {
            WebElement elemetD = driver.findElement(By.className("sub-nav-ct"));
            driver.switchTo().activeElement().click();
            WebElement elementSubmitButton = driver.findElement(WalletHubLocators.submitButton);
            Thread.sleep(5000);
            Point location = elementSubmitButton.getLocation();

            int x = location.getX();
            int y = location.getY();
            System.out.println("co-ordinates are x: " + x + " ,Y: " + y);
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        // touchActions.singleTap(elementSubmitButton);
        /*  commonMethods.highlightElement(driver,elementSubmitButton);
        commonMethods.clickOnButton(elementSubmitButton);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",elementSubmitButton); */
        //action.moveToElement(elementSubmitButton).click().perform();
    }

    public void verifyReviewSubmissionConfirmation(){
        wait.until(ExpectedConditions.presenceOfElementLocated(reviewConfirmation));
        WebElement elementConfirmation=driver.findElement(reviewConfirmation);
        if (elementConfirmation.isDisplayed()){
            System.out.println("Review has been posted successfully");
        }
        else{
            System.out.println("Review isn't submitted, might have some processing issues.");
        }

    }

    public void verifyYourReviewOnProfile(String profileUrl){
        driver.navigate().to(profileUrl);
        wait.until(ExpectedConditions.presenceOfElementLocated(RecommendThroughReview));
        WebElement elementRecommendNote=driver.findElement(RecommendThroughReview);
        Assert.assertTrue(elementRecommendNote.isDisplayed());
        WebElement elementReview=driver.findElement(reviewOnProfile);
        Assert.assertTrue(elementReview.isDisplayed());

    }

    public void verifyClickingOnBackButton(){
        WebElement elementBackButton=driver.findElement(backButton);
        commonMethods.clickOnButton(elementBackButton);
    }


}
