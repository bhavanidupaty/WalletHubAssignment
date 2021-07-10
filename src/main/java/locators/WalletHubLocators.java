package locators;

import org.openqa.selenium.By;

public interface WalletHubLocators {
By loginButtonOnHomePage= By.cssSelector("span.brgm-button.brgm-signup.brgm-signup-login");
By loginHeader=By.xpath("//h1[text()='Login']");
By loginEmailAddress=By.cssSelector("input#email");
By loginPassword=By.id("password");
By loginButton=By.xpath("//span[contains(text(),'Login')]");
By homePageLogo=By.className("logo-anchor-text");
By walletHubProfile=By.className("profile-name");
By reviewsTab=By.xpath("//span[text()='Reviews' and @class='nav-txt']");
By reviewsSection=By.xpath("//h3[contains(text(),'Your Rating')]");
By reviewStarsSection=By.xpath("//h3[contains(text(),'Your Rating')]/following-sibling::review-star");
By reviewStars=By.xpath(reviewStarsSection+"//*[name()='svg']");
By policyDropdown=By.xpath("//span[contains(text(),'Select')]");
By submitButton=By.xpath("//*[text()='Submit']"); // //div[@role='dialog']
By reviewTextBox=By.xpath("//textarea[@placeholder='Write your review...']");
By starsGivenOnReview=By.xpath("//*[@class='md-write-a-review']//*[name()='svg']//*[local-name()='path' and @fill='#4ae0e1']");
By policyOptions= By.xpath("//*[name()='ng-dropdown' and @class='wrev-drp']//ul/li");
By reviewConfirmation=By.xpath("//h4[text()='Your review has been posted.']");
By reviewOnProfile=By.xpath("//div[@class='pr-rec-container']//review-star");
By RecommendThroughReview=By.xpath("//h2[text()='I RECOMMEND']");
By backButton=By.className("sbn-back");

}
