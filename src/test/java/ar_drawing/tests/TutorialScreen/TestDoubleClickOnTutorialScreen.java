package ar_drawing.tests.TutorialScreen;

import ar_drawing.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreen.SplashScreen;
import pages.TutorialScreen.TutorialScreen;

public class TestDoubleClickOnTutorialScreen extends BaseTest {
    TutorialScreen tutorialScreen;
    SplashScreen splashScreen;

    @org.testng.annotations.BeforeClass
    public void initPage(){
        splashScreen = new SplashScreen(driver);
        tutorialScreen = new TutorialScreen(driver);
    }
    @Test(priority = 0, description = "Verify double click Start button after displaying the Interstitial Ad, then navigating to Home Screen")
    public void doubleClickStartButton() {
        // Verify that the title Header displayed
        Assert.assertTrue(splashScreen.isDisplaySplashScreen());
        Assert.assertTrue(tutorialScreen.isHeaderDisplayed());
        Assert.assertEquals(tutorialScreen.getTitleHeaderTutorial(), "Tutorial");

        // Verify that the Gif displayed on the Tutorial Screen
        Assert.assertTrue(tutorialScreen.isGifTutorialDisplayed());

        // Verify that displayed Start Button on the Tutorial Screen
        Assert.assertTrue(tutorialScreen.isButtonDisplayed());
        Assert.assertEquals(tutorialScreen.getTitleButtonLocator(),"Start");

        // Verify that double-click
        tutorialScreen.doubleClick();
        Assert.assertTrue(tutorialScreen.isAdDisplayed(),"Test Ad is not displayed on the screen");
        tutorialScreen.handleAdIfPresent();

        // Verify navigated to Home Screen
        Assert.assertTrue(tutorialScreen.navigatedToHomeScreen(), "Navigation to Home Screen after dismissing the Interstitial Ad following a click on the Start button");
    }
}
