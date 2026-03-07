package ar_drawing.tests.HomeScreen;

import ar_drawing.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomeScreen.HomeScreen;
import pages.TutorialScreen.TutorialScreen;

public class HomeScreenTest extends BaseTest {
    TutorialScreen tutorialScreen;
    HomeScreen homeScreen;

    @org.testng.annotations.BeforeClass
    public void initPage(){
        tutorialScreen = new TutorialScreen(driver);
        homeScreen = new HomeScreen(driver);

        tutorialScreen.clickStartButton();
        tutorialScreen.handleAdIfPresent();
    }

    @Test()
    public void TestElementsDisplay(){
        Assert.assertTrue(homeScreen.isHeaderDisplayed(),"Header is not displayed on the Home Screen");
        Assert.assertTrue(homeScreen.isMusicIconDisplayed(),"Music Icon is not displayed on the Home Screen");
        Assert.assertTrue(homeScreen.isHelpIconDisplayed(),"Help Icon is not displayed on the Home Screen");
        Assert.assertTrue(homeScreen.isProButtonDisplayed(),"Pro Button is not displayed on the Home Screen");
        Assert.assertTrue(homeScreen.isgalleryTabDisplayed(),"Gallery Tab is not displayed on the Home Screen");
        Assert.assertTrue(homeScreen.isCameraTabDisplayed(),"Camera Tab is not displayed on the Home Screen");
    }

    @Test
    public void TestDescriptionDisplay(){
        Assert.assertEquals(homeScreen.getTextGalleryTab(),"From Gallery");
        Assert.assertEquals(homeScreen.getTextCameraTab(),"From Camera");
    }


    @Test()
    public void TestClickStartButton() {

    }
}
