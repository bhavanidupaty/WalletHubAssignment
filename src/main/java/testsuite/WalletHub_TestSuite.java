package testsuite;

import org.testng.annotations.Test;


public class WalletHub_TestSuite extends BrowserInitialization{

/*
1. Clicks Login button on Homepage
2. Login to WalletHub with valid light user credentials
3. On Test Insurance Company, Clicking on reviews -> Writing a Review for Health Insurance policy
4. Verifying review on userProfile on successful submission
*/

    @Test(description = "Writing a review for WalletHub")
    public void walletHubReview() {
        walletHubPage.clickOnLoginButtonOnHomePage();
        walletHubPage.loginToWalletHub(testData.getData("userMailId"), testData.getData("password"));
        walletHubPage.writeAReview(testData.getData("reviewMessage"), Integer.parseInt(testData.getData("stars")), testData.getData("policy"));
        walletHubPage.verifyYourReviewOnProfile(testData.getData("profileURL"));
    }


}
