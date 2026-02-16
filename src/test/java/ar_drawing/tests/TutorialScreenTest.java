package ar_drawing.tests;

import ar_drawing.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreen.SplashScreen;
import pages.TutorialPage.TutorialPage;

public class TutorialScreenTest extends BaseTest {
    TutorialPage tutorialPage;
    SplashScreen splashScreen;

    @org.testng.annotations.BeforeClass
    public void initPage() {
        splashScreen = new SplashScreen(driver);
        tutorialPage = new TutorialPage(driver);
    }

    @Test(priority = 0, description = "Verify that the title header is displayed on the Tutorial Screen")
    public void TestTitleHeaderDisplay() {
        Assert.assertTrue(splashScreen.isDisplaySplashScreen());
        Assert.assertTrue(tutorialPage.isHeaderDisplayed());
        Assert.assertEquals(tutorialPage.getTitleHeaderTutorial(), "Tutorial");
    }

    @Test(priority = 1, description = "Verify that the Gif is displayed on the Tutorial Screen")
    public void TestGifDisplay() {
        Assert.assertTrue(tutorialPage.isGifTutorialDisplayed());
    }

    @Test(priority = 2, description = "Verify displayed Start Button on the Tutorial Screen")
    public void TestStartButtonDisplay() {
        Assert.assertTrue(tutorialPage.isButtonDisplayed());
    }

    @Test(priority = 3, description = "Verify that clicking the Start button is successful, then check that the Ads screen is displayed")
    public void TestClickStartButton() {
        tutorialPage.clickStartButton();
        tutorialPage.handleAdIfPresent();
    }

//    @Test(priority = 4, description = "Verify displayed the Ads Screen")
//    public void TestAdsDisplayed(){
//
//    }

    //@Test(description = "Verify double click Start button")
    public void doubleClickStartButton() {
        tutorialPage.doubleClick();
    }
}
