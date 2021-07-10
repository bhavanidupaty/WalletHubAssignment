package testsuite;

import org.testng.annotations.Test;


public class WalletHub_TestSuite extends BrowserInitialization{

/*
*/

    @Test(description = "Writing a review for WalletHub")
    public void walletHubReview() {
        walletHubPage.clickOnLoginButtonOnHomePage();
        walletHubPage.loginToWalletHub(testData.getData("userMailId"), testData.getData("password"));
        walletHubPage.writeAReview(testData.getData("reviewMessage"), Integer.parseInt(testData.getData("stars")), testData.getData("policy"));
        walletHubPage.verifyYourReviewOnProfile(testData.getData("profileURL"));
    }


}
