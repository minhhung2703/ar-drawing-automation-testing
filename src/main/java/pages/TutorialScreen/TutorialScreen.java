package pages.TutorialScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.baseScreen.BaseScreen;

public class TutorialScreen extends BaseScreen {
    private By headerTitleTutorialLocator = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/tv_tutorial");
    private By gifTutorialLocator = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/exo_subtitles\"]/android.view.View");
    private By buttonStartLocator = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/tv_got_it\"]");
    private By homeScreenLocator = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/cl_bg\").instance(0)");

    public TutorialScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return waitForElementVisible(headerTitleTutorialLocator).isDisplayed();
    }

    public boolean isGifTutorialDisplayed() {
        return waitForElementVisible(gifTutorialLocator).isDisplayed();
    }

    public boolean isButtonDisplayed() {
        return waitForElementVisible(buttonStartLocator).isDisplayed();
    }

    public String getTitleHeaderTutorial() {
        return waitForElementVisible(headerTitleTutorialLocator).getText();
    }

    public String getTitleButtonLocator() {
        return waitForElementVisible(buttonStartLocator).getText();
    }

    public void clickStartButton() {
        waitForElementVisible(buttonStartLocator).click();
    }

    public void doubleClick() {
        doubleTap(waitForElementVisible(buttonStartLocator));
    }

    public boolean navigatedToHomeScreen(){
        return waitForElementVisible(homeScreenLocator).isDisplayed();
    }
}