package testsuite;

import browser.BrowserActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.WalletHubPage;
import utilities.TestData;

import java.awt.*;

public class BrowserInitialization {
    BrowserActions browserActions;
    TestData testData;
    WalletHubPage walletHubPage;

    
    @Parameters("browser")
    @BeforeClass
    public void initializeBrowser(String browserName) {

        browserActions = new BrowserActions();
        testData = new TestData();
        if (browserName.equalsIgnoreCase("Chrome")) {
            browserActions.launchChrome();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            browserActions.launchFirefox();
        } else {
            System.out.println("Invalid browser specified");
        }

    }

    @BeforeMethod
    public void applicationLaunch() throws AWTException {
        browserActions.launchApplication(testData.getData("appUrl"));
        walletHubPage = new WalletHubPage(browserActions.driver);

    }
}
