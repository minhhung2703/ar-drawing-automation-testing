package ar_drawing.tests.TutorialScreen;

import ar_drawing.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreen.SplashScreen;
import pages.TutorialScreen.TutorialScreen;

public class TutorialScreenTest extends BaseTest {
    TutorialScreen tutorialScreen;
    SplashScreen splashScreen;

    @org.testng.annotations.BeforeClass
    public void initPage() {
        splashScreen = new SplashScreen(driver);
        tutorialScreen = new TutorialScreen(driver);
    }

    @Test(priority = 0, description = "Verify that the title header is displayed on the Tutorial Screen")
    public void TestTitleHeaderDisplay() {
        Assert.assertTrue(splashScreen.isDisplaySplashScreen());
        Assert.assertTrue(tutorialScreen.isHeaderDisplayed());
        Assert.assertEquals(tutorialScreen.getTitleHeaderTutorial(), "Tutorial");
    }

    @Test(priority = 1, description = "Verify that the Gif is displayed on the Tutorial Screen")
    public void TestGifDisplay() {
        Assert.assertTrue(tutorialScreen.isGifTutorialDisplayed());
    }

    @Test(priority = 2, description = "Verify that displayed Start Button on the Tutorial Screen")
    public void TestStartButtonDisplay() {
        Assert.assertTrue(tutorialScreen.isButtonDisplayed());
        Assert.assertEquals(tutorialScreen.getTitleButtonLocator(),"Start");
    }

    @Test(priority = 3, description = "Verify that clicking the Start button is successful, then check that the Ads screen is displayed")
    public void TestClickStartButton() {
        tutorialScreen.clickStartButton();
        Assert.assertTrue(tutorialScreen.isAdDisplayed(),"Test Ad is not displayed on the screen");
        tutorialScreen.handleAdIfPresent();
    }

    @Test(priority = 4, description = "Verify navigated to Home Screen")
    public void verifyHomeScreenDisplayed(){
        Assert.assertTrue(tutorialScreen.navigatedToHomeScreen(), "Navigation to Home Screen after dismissing the Interstitial Ad following a click on the Start button");
    }
}
