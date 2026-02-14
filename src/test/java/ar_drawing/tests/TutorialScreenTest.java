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

        Assert.assertTrue(splashScreen.isDisplaySplashScreen());
    }

    @Test(priority = 0, description = "Verify that the title header is displayed on the Tutorial Screen")
    public void TestTitleHeaderDisplay() {
        Assert.assertTrue(tutorialPage.isHeaderDisplayed());
        Assert.assertEquals(tutorialPage.getTitleHeaderTutorial(), "Tutorial");
    }

    @Test(priority = 1, description = "Verify that the Gif is displayed on the Tutorial Screen")
    public void TestGifDisplay() {
        Assert.assertTrue(tutorialPage.isGifTutorialDisplayed());
    }

    @Test(priority = 2, description = "")
    public void TestStartButtonDisplay() {
        Assert.assertTrue(tutorialPage.isButtonDisplayed());
    }

    @Test(priority = 3, description = "Verify clicking the Start button")
    public void TestClickStartButton() {
        tutorialPage.clickStartButton();
    }

    //@Test(description = "Verify double click Start button")
    public void doubleClickStartButton() {
        tutorialPage.doubleClick();
    }
}
